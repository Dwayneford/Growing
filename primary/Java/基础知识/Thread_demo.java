package com.yc123.test;
/**
 * �̵߳ı�����
 * 		���̣�������е�ÿһ������ִ�еĳ������һ�����̣�һ��������һ�� ���߶���̣߳�
 * 			ÿ��Ӧ���е��߳� ����ͬʱִ�ж����ͬ������
 * 
 * ���磺
 * 	�������ߣ�myEclipse��
 * 		
 * 
 * 
 * Java���̵߳�ʵ�ַ�ʽ:
 * 		���֣�
 * 		��һ�֣��̳�therad�� ��д run() �����������������ʵ���̵߳���
 * 			  eg��new Thread ����������󣬿�ʼ�̣߳�����.start();
 * 		
 * 		�ڶ��֣�ʵ�� Runnable�ӿ�();
 * 			�����߳� ���� start();
 * 
 * 		�̵߳� ���ԣ�
 * 			ԭ���ԣ�
 * 			�ɼ��ԣ�
 * 			�����ԣ�
 * 			�������
 * 
 * @author direct
 */

public class Thread_demo {
	public static void main(String[] args) {
		//��������
		Booking bk1 = new Booking("һ�Ŵ���");
		Booking bk2 = new Booking("�����˴���");
		Booking bk3 = new Booking("���˴���");
		Booking bk4 = new Booking("VIP����");
		
		//��ʼ�����߳�
		bk1.start();
		bk2.start();
		bk3.start();
		bk4.start();
	}
}

/**
 * ��Ʊ����
 * @author direct
 */
class Booking extends Thread{
	//���� ����
	public Booking(String name){
		super(name);
	}
	//�������
	static int pices=100;
	// ����һ��ͬ������
	Object ob="aa";
	
	//��д run��������Ʊ
	@Override
	public void run() {
		while(pices>0){
			//ִ�� �������
			synchronized (ob) {
				if(pices>0){
					System.out.println(super.getName()+"---> ����˵�"+pices+"��Ʊ");
					pices--;
				}else{
					System.out.println("Ʊ������������");
				}
				
				//�߳���Ϣ 10����
				try {
					this.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
		}				
		//super.run();
	}
	
	
}
























