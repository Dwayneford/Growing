package com.yc123.demo;

public class GoodsInfo {
	//��ͨ����
	private String goodsName;
	private double goodsPrice;
	
	//��̬����
	public static String goodsAddress="���ݹ�ҵ԰�� ���� һ��Ԫ 15-8��";
	
	//���巽��
	public void goodsTodo(){
		
		System.out.println("��Ʒ �Ĺ���.....");
		
	}
	//��̬����
	public static void goodsMeth(){
		System.out.println("��Ʒ�ľ�̬����....");
	}
	
	
	//��̬ �����
	static{
		System.out.println("������Ʒ���� ����ִ�е����ݣ���ʼ������.......");
	}
}
