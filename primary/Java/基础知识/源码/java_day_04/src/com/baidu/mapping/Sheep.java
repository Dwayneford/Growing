package com.baidu.mapping;

public class Sheep extends EatGrassAnimal{
	
	public Sheep(){
		super();
		System.out.println("这是 Sheep类的无参构造函数...");
	}
	
	//行为
	public void  sheepShout(){
		System.out.println("羊的咩咩叫的 行为....");
	}
	
	/**
	 * 静态代码块
	 */
	static{
		System.out.println("这是 Sheep 类的静态代码块！！！");
	}
	
}
