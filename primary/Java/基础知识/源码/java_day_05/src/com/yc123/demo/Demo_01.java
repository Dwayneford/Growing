package com.yc123.demo;

public class Demo_01 {
	/**
	 * java �еĶ�̬��
	 * 		һ������� ���ֱ�����̬��
	 *      ������ʽ����������д  �� ���أ�
	 *      
	 *    ����⣺��ͬ�������й�������Ϊ����Ϊ�ľ�����ָ�����ͬ��
	 *    		eg��è  ��  ��...
	 *    			��()
	 *    			˯��()
	 *    			����()
	 */
	public static void main(String[] args) {
		//���� ��̬��ʽ ��� ��ͬ�������ͬ��Ϊ�Ĳ�ͬ���֣�
		 Cat catEnt =  new Cat();
		 Pig pitEnt = new Pig();
		 //���� ���� ���� �������ʵ��
		 Animal an_cat = new Cat();
		 Animal an_pig = new Pig();
		 //��̬����
		 an_cat.eat();
		 an_cat.sleep();
		 
		 an_pig.eat();
		 an_pig.sleep();
		 
		 
		 //�������صķ��� ʵ�� ҵ����
		 Demo_01 doEnt = new Demo_01();
		 int intSum =  doEnt.sum(25, 36);
		 
		 float floatSum = doEnt.sum(32.36f, 52, 158.36f);
		 
		 System.out.println("���Ϊ��"+intSum+"=="+floatSum);
		 
	}
	
	
	/**
	 * ���� �ķ�ʽ ʵ�ֶ�̬��
	 * ���صĶ��壺
	 * 	   ��ͬһ�����У�������ͬ���Ƶķ�������ͬ�Ĳ������� ���� ���� ���ɲ����� ��ͬ���÷���ʵ��,��Ϊ���أ�
	 */
	public int sum(int num1,int num2){
		return num1+num2;
	}
	
	public float sum(float num1,int num2){
		return num1 + num2;
	}
	
	public float sum(float num1,float num2){
		return num1 + num2;
	}
	
	public float sum(float num1,int num2,float num3){
		return num1 + num2+ num3;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
