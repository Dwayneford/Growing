package com.yc123.dao;

import com.yc123.demo.GoodsInfo;

public class GoodsTest {
	
	public static void main(String[] args) {
		//ֱ�ӵ��� ��̬����
		String gdAddress = GoodsInfo.goodsAddress;
		System.out.println("gdAddress===>"+gdAddress);
		GoodsInfo.goodsMeth();
		
		/*��Ͷ���Ĺ�ϵ��
			���Ƕ����ģ��
			���������һ��ʵ��*/
		//��ȡ goodsInfo����
		GoodsInfo gdEnt = new GoodsInfo();
		gdEnt.goodsTodo();
		
		GoodsInfo.goodsAddress="����ʳƷ ��ҵ԰��";
		System.out.println("gdEnt.goodsAddress==>"+gdEnt.goodsAddress);;
		
		
		GoodsInfo youyou = new GoodsInfo();
		System.out.println("youyou.goodsAddress==>"+youyou.goodsAddress);;
	
		
	}
	
}
