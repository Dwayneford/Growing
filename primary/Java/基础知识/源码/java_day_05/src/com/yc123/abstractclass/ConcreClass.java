package com.yc123.abstractclass;

public class ConcreClass extends AbstractDemo{

	public ConcreClass(){
		super();
		System.out.println(" ʵ�� ������� ���� ���캯��");
	}
	
	@Override
	protected String fly() {
		String  str ="��Ҫ�����....";
		return str;
	}
	@Override
	public void eatSome(){
		System.out.println("������ȫϯ  ������������");
	}
	
	//��ں���
	public static void main(String[] args) {
		ConcreClass cc = new ConcreClass();
		
		cc.fly();
		cc.eatSome();
	}
}
