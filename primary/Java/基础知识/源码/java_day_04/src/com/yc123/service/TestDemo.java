package com.yc123.service;

import java.util.Date;

public class TestDemo {
	public static void main(String[] args) {
		
		System.out.println( new Date().getDay());;
		System.out.println( new Date().getHours());;
		System.out.println( new Date().getMinutes());;
		System.out.println( new Date().getSeconds());;
		/** 
		 * 创建子类对象 调用 方法，
		 * 		通过子类方法 使用父类的 属性 和 方法；
		 */
		BambooDragonfly bdf = new BambooDragonfly();
		//bdf  对象 可以 直接使用 父类的 属性 方法(非私有的)
		//bdf.aircraftWork();
		//调用 子类方法
		bdf.palyGoods();
		
		/**
		 *  创建 大疆飞行器 对象
		 */
		XinjiangAircraft xaf = new XinjiangAircraft();
		//调用子类 本身方法
		xaf.intelligent_following();
		
		//调用父类方法:被重写的方法 无法再次 调用
		xaf.aircraftWork(1);
		
	}
}
