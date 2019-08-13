
/**
 * 使用线程模拟 银行存取钱：
 * 		银行 存取 
 * 		ATM取钱
 * 		使用实现接口的方式
 * 
 *  实现思路：
 *  	银行类：实现方法 saveMoney(); z注意 必须 进行 线程 或者同步控制
 *  	ATM类：实现方法getMoney();
 *    
 *      创建对象 启动线程操作同一个 变量(存款);
 * @author direct
 */
public class Thread_01 {
	public static void main(String[] args) {
		//创建对象 ATM对象
		Atm am = new Atm();
		//创建线程 对象,将 Atm 放入线程中
		Thread t0 = new Thread(am);
		Thread t1 = new Thread(am);
		Thread t2 = new Thread(am);
		Thread t3 = new Thread(am);
		//启动线程
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		
		AtmTwo amTwo = new AtmTwo();
		//创建线程 对象,将 Atm 放入线程中
		Thread t4 = new Thread(amTwo);
		Thread t5 = new Thread(amTwo);
		Thread t6 = new Thread(amTwo);
		Thread t7 = new Thread(amTwo);
		//启动线程
		t4.start();
		t5.start();
		t6.start();
		t7.start();
	}
}

class Bank{
	//定义金额
	private static int sumMoney=2000;
	//创建对象
	Object ob = "aa";
	//存款
	public void saveMoney(int n){
		synchronized (ob) {
			sumMoney =sumMoney+n;
			System.out.println(Thread.currentThread().getName()+"存入===>"+(n));
			//线程 睡眠
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//取款
	public void getMoney(int n){
		synchronized (ob) {
			if(sumMoney<=0){  
		           System.out.println("余额不足");  
		    }else{
		    	System.out.println(Thread.currentThread().getName()+"取出===>"+(n));
		    	sumMoney =sumMoney-n;
		    }
			//线程 睡眠
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//查询 总金额 
    public void showMoney(){
        System.out.println("账户总金额："+sumMoney);  
    }  
}

class Atm implements Runnable {
	//得到银行对象 调用 方法
	Bank bk = new Bank();
	//取钱
	@Override
	public void run() {
		int money = 100;
		for (int i = 0; i < 3; i++) {
			bk.saveMoney(money);
			bk.showMoney();
		}
	}
}

class AtmTwo implements Runnable {
	//得到银行对象 调用 方法
	Bank bk = new Bank();
	//取钱
	@Override
	public void run() {
		int money = 100;
		for (int i = 0; i < 3; i++) {
			bk.getMoney(money);
			bk.showMoney();
		}
	}
}


