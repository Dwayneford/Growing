package com.yc123.abstractTemp;
//����һ����Ա��
public class Employee extends Template {

	@Override
	protected void start() {
		System.out.println("��Ҫ���� ���ϰ�....");
		System.out.println("���緹.");
	}

	@Override
	protected void work() {
		System.out.println("1.����˾��");
		System.out.println("2.��Ŀ������䵱ǰ ����");
		System.out.println("3.�����ԣ���ʼд����");
		System.out.println("4.���Գ��� �޸�����");
		
		System.out.println("5.�������� �㱨����");
	}

	@Override
	protected void end() {
		System.out.println("�رյ���");
		System.out.println("���°�...");
	}
}
