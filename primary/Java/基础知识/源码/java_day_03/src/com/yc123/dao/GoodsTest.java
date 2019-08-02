package com.yc123.dao;

import com.yc123.demo.GoodsInfo;

public class GoodsTest {
	
	public static void main(String[] args) {
		//直接调用 静态类容
		String gdAddress = GoodsInfo.goodsAddress;
		System.out.println("gdAddress===>"+gdAddress);
		GoodsInfo.goodsMeth();
		
		/*类和对象的关系：
			类是对象的模板
			对象是类的一个实例*/
		//获取 goodsInfo对象
		GoodsInfo gdEnt = new GoodsInfo();
		gdEnt.goodsTodo();
		
		GoodsInfo.goodsAddress="重庆食品 工业园区";
		System.out.println("gdEnt.goodsAddress==>"+gdEnt.goodsAddress);;
		
		
		GoodsInfo youyou = new GoodsInfo();
		System.out.println("youyou.goodsAddress==>"+youyou.goodsAddress);;
	
		
	}
	
}
