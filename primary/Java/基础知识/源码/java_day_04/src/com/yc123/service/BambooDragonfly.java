package com.yc123.service;

public class BambooDragonfly extends Aerocraft {
	//���� ��Ļ�����Ϣ ����
	
	//���� ������; ����
	
	
	//���������ѷ�����
	public void palyGoods(){
		//�˽����������; ��������Ϣ
		setName("������");
		setPrice("��1Ԫ");
		setSize("200MM");
		
		String bambooInfo= "��Ʒ������Ϣ��"+getName()+"(����)==="+getPrice()
							+"(�۸�)==="+getSize()+"(�ߴ�)";
		System.out.println(bambooInfo);
		
		super.aircraftWork(2);
	}
}
