
/**
 * ʹ���߳�ģ�� ���д�ȡǮ��
 * 		���� ��ȡ 
 * 		ATMȡǮ
 * 		ʹ��ʵ�ֽӿڵķ�ʽ
 * 
 *  ʵ��˼·��
 *  	�����ࣺʵ�ַ��� saveMoney(); zע�� ���� ���� �߳� ����ͬ������
 *  	ATM�ࣺʵ�ַ���getMoney();
 *    
 *      �������� �����̲߳���ͬһ�� ����(���);
 * @author direct
 */
public class Thread_01 {
	public static void main(String[] args) {
		//�������� ATM����
		Atm am = new Atm();
		//�����߳� ����,�� Atm �����߳���
		Thread t0 = new Thread(am);
		Thread t1 = new Thread(am);
		Thread t2 = new Thread(am);
		Thread t3 = new Thread(am);
		//�����߳�
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		
		AtmTwo amTwo = new AtmTwo();
		//�����߳� ����,�� Atm �����߳���
		Thread t4 = new Thread(amTwo);
		Thread t5 = new Thread(amTwo);
		Thread t6 = new Thread(amTwo);
		Thread t7 = new Thread(amTwo);
		//�����߳�
		t4.start();
		t5.start();
		t6.start();
		t7.start();
	}
}

class Bank{
	//������
	private static int sumMoney=2000;
	//��������
	Object ob = "aa";
	//���
	public void saveMoney(int n){
		synchronized (ob) {
			sumMoney =sumMoney+n;
			System.out.println(Thread.currentThread().getName()+"����===>"+(n));
			//�߳� ˯��
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//ȡ��
	public void getMoney(int n){
		synchronized (ob) {
			if(sumMoney<=0){  
		           System.out.println("����");  
		    }else{
		    	System.out.println(Thread.currentThread().getName()+"ȡ��===>"+(n));
		    	sumMoney =sumMoney-n;
		    }
			//�߳� ˯��
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//��ѯ �ܽ�� 
    public void showMoney(){
        System.out.println("�˻��ܽ�"+sumMoney);  
    }  
}

class Atm implements Runnable {
	//�õ����ж��� ���� ����
	Bank bk = new Bank();
	//ȡǮ
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
	//�õ����ж��� ���� ����
	Bank bk = new Bank();
	//ȡǮ
	@Override
	public void run() {
		int money = 100;
		for (int i = 0; i < 3; i++) {
			bk.getMoney(money);
			bk.showMoney();
		}
	}
}


