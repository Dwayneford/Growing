package com.yc123.demo;

public class Animal {
	public void eat(){
		System.out.println("����ĳ� ����Ϊ....");
	}
	
	public void sleep(){
		System.out.println("�����˯�� ��Ϊ");
	}
	
	public void run(){
		System.out.println("������� ��Ϊ");
	}
	//���� run ��������̬��һ������
	public void run(int towFoot){
		System.out.println("������� ��Ϊ��ͨ����ֻ��...");
	}
	
}
