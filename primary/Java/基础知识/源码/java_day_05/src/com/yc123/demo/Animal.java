package com.yc123.demo;

public class Animal {
	public void eat(){
		System.out.println("动物的吃 的行为....");
	}
	
	public void sleep(){
		System.out.println("动物的睡觉 行为");
	}
	
	public void run(){
		System.out.println("动物的跑 行为");
	}
	//重载 run 方法，多态的一种体现
	public void run(int towFoot){
		System.out.println("动物的跑 行为，通过两只脚...");
	}
	
}
