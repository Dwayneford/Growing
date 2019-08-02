package com.yc123.demo;

public class Cat extends Animal {

	//从写 父类方法 权限修饰 符 必须 大于 等于 父类方法的 修饰符
	public void eat(){
		System.out.println("小猫 爱吃 小鱼！！");
	}
	public void sleep(){
		System.out.println("小猫 喜欢 蜷缩着 在房梁上睡觉！！");
	}
	
	
	
}
