package com.yc123.abstractclass;

public class ConcreClass extends AbstractDemo{

	public ConcreClass(){
		super();
		System.out.println(" 实现 抽象类的 子类 构造函数");
	}
	
	@Override
	protected String fly() {
		String  str ="我要起飞了....";
		return str;
	}
	@Override
	public void eatSome(){
		System.out.println("吃满汉全席  。。。。。。");
	}
	
	//入口函数
	public static void main(String[] args) {
		ConcreClass cc = new ConcreClass();
		
		cc.fly();
		cc.eatSome();
	}
}
