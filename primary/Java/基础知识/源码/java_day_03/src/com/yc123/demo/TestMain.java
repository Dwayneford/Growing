package com.yc123.demo;

public class TestMain {
	//��ں���
	public static void main(String[] args) {
		
		//ͨ�� PeopleClass �������ʵ�����
		PeopleClass zs = new PeopleClass();
		
		//�������� ���� ����
		zs.age= 100;
		zs.weight=150;
		
		//ʹ��˽�л� ���� ����ֵ
		zs.setName("���»�");
		zs.setGender('M');
		zs.setJob("����");
		zs.setTall(175.00);
		
		
		//ȡֵ
		String peoInfo = zs.getName()+"=="+zs.getGender()+"=="+zs.age+"=="+
						 zs.getTall()+"=="+zs.weight+"=="+zs.getJob();
		System.out.println("��Ա������Ϣ��"+peoInfo);
		
		//���� ����ķ���
		String retStr = zs.learning();
		
		System.out.println("retStr==>"+retStr);
		
		zs.walk();
		
		//����һ��Ա������
		EmpClass empent = new EmpClass();
		empent.setEmpName("����");
		empent.setEmpAge(25);
		empent.setEmpEducation("����");
		empent.setEmpPost("��Ŀ����");
		empent.setEmpSex("��");
		empent.setEmpSpec("��ȭ��");
		empent.setEmpWrokYear(5);
		
		double totalMoney = empent.paymentWages(empent);
		
		System.out.println("Ա����ϢΪ��"+empent.toString());
		System.out.println("�ܹ���Ϊ��"+totalMoney);
		
		
		/************************/
		Teacher tent = new Teacher();
		tent.setName("�˹����ܿ�����ʦ");
		
		System.out.println("tent.getName()==>"+tent.getName());
		
		//ʹ�ó���
		String finalAddress = tent.ADDRESS_CODE;
		
		String finalClass =Teacher.ADDRESS_CODE;
		//������ڶ��θ�ֵ
		//Teacher.ADDRESS_CODE="AD_21053_USA";
		System.out.println("finalAddress==>"+finalAddress+",finalClass==>"+finalClass);
		
		
	}
	
}
