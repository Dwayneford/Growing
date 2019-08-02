package com.yc123.service;

public class BambooDragonfly extends Aerocraft {
	//定义 类的基本信息 属性
	
	//定义 飞行用途 方法
	
	
	//购买竹蜻蜓飞行器
	public void palyGoods(){
		//了解飞行器的用途 ，基本信息
		setName("竹蜻蜓");
		setPrice("￥1元");
		setSize("200MM");
		
		String bambooInfo= "产品基本信息："+getName()+"(名称)==="+getPrice()
							+"(价格)==="+getSize()+"(尺寸)";
		System.out.println(bambooInfo);
		
		super.aircraftWork(2);
	}
}
