package ATM;

public class TestATM {
	public static void main(String[] args) {
//		Bank b1=new Bank();
//		Bank b2=new Bank();
//		Bank b3=new Bank();
		
		ATM b1=new ATM();
		ATM b2=new ATM();
		ATM b3=new ATM();
		ATM b4=new ATM();
		Thread t1=new Thread(b1);
		Thread t2=new Thread(b2);
		Thread t3=new Thread(b3);
		Thread t4=new Thread(b4);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}


class Bank{
	protected static int money=1000;
	
	
	public static int getMoney() {
		return money;
	}

	public static void setMoney(int money) {
		Bank.money = money;
	}

	public void saveMoney(int n) {
		Object mutex="a";
		synchronized (mutex) {
			System.out.println(Thread.currentThread().getName()+
					"´æÇ®£¬Óà¶îÎª£º"+(money+=n));
		}	
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	
	public void getMoney(int n) {
		Object mutex="a";
		synchronized (mutex) {
			if (money<300) {
				System.out.println("Óà¶î²»×ã£¡");
//				return;
			}else {
				System.out.println(Thread.currentThread().getName()+
						"È¡Ç®£¬Óà¶îÎª£º"+(money-=n));
			}			
		}	
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ATM implements Runnable{

	Bank b1=new Bank();
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			b1.saveMoney(100);
			
		}
		for (int i = 0; i < 3; i++) {
			
			b1.getMoney(300);
		}
//			do {
//				b1.getMoney(300);
//			} while (b1.money<300);
//				
//			System.out.println("Óà¶î²»×ã£¡£¡£¡");	
//		
		
			
		
		
	}
	
}



