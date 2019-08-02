package com.baidu.mapping;

public class EatGrassAnimal extends Animal {
	//子类属性
	private String grass_horn;
	
	
	public String getGrass_horn() {
		return grass_horn;
	}
	public void setGrass_horn(String grass_horn) {
		this.grass_horn = grass_horn;
	}

	//构造函数
	public EatGrassAnimal() {
		super();
		System.out.println("这是EatGarss 类的无参构造函数！！！");
		
	}
	public EatGrassAnimal(String grass_horn) {
		super();
		this.grass_horn = grass_horn;
	}
	
	
	// 重写 吃的 方法
	public void anEat(){
		System.out.println("我是食草 动物，食的食草 和 饲料....");
	}
	
	
	// 重写 跑的 方法:被重写的 方法 子类修饰符权限范围 应该 大于 等于 父类； 
	/*
	public void run(){
		System.out.println("子类重写 父类的 run行为。。。。");
	} */

	/**
	 * 静态代码块
	 */
	static{
		System.out.println("这是 EatGrass...类的静态代码块！！！");
	}
}
