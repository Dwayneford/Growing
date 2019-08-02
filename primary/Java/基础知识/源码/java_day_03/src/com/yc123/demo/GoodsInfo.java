package com.yc123.demo;

public class GoodsInfo {
	//普通属性
	private String goodsName;
	private double goodsPrice;
	
	//静态属性
	public static String goodsAddress="广州工业园区 二期 一单元 15-8号";
	
	//定义方法
	public void goodsTodo(){
		
		System.out.println("商品 的功能.....");
		
	}
	//静态方法
	public static void goodsMeth(){
		System.out.println("商品的静态方法....");
	}
	
	
	//静态 代码块
	static{
		System.out.println("加载商品类是 优先执行的内容，初始化内容.......");
	}
}
