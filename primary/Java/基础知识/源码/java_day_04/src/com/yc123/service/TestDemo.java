package com.yc123.service;

import java.util.Date;

public class TestDemo {
	public static void main(String[] args) {
		
		System.out.println( new Date().getDay());;
		System.out.println( new Date().getHours());;
		System.out.println( new Date().getMinutes());;
		System.out.println( new Date().getSeconds());;
		/** 
		 * ����������� ���� ������
		 * 		ͨ�����෽�� ʹ�ø���� ���� �� ������
		 */
		BambooDragonfly bdf = new BambooDragonfly();
		//bdf  ���� ���� ֱ��ʹ�� ����� ���� ����(��˽�е�)
		//bdf.aircraftWork();
		//���� ���෽��
		bdf.palyGoods();
		
		/**
		 *  ���� �󽮷����� ����
		 */
		XinjiangAircraft xaf = new XinjiangAircraft();
		//�������� ������
		xaf.intelligent_following();
		
		//���ø��෽��:����д�ķ��� �޷��ٴ� ����
		xaf.aircraftWork(1);
		
	}
}
