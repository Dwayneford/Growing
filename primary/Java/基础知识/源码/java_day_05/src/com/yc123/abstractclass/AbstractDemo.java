package com.yc123.abstractclass;
public abstract class AbstractDemo {
	/**
	 * 抽象类：
	 * 	  把一个不能具体描述 的对象，进行抽象的定义(UFO, 帅哥,  美女.....)
	 *   抽象类是 使用 abstract进行修饰的类
	 *     类中的方法 是 abstract 修饰的方法，抽象类中可以有 非抽象方法；
	 *     抽象类是被 继承的类，可以实现部分 抽象方法；
	 *     继承类 也变成了 抽象了；
	 *     
	 *     抽象类中有 构造函数，但是不可以创建对象，在子类(实现了全部抽象方法的字类)创建对象 的时候 调用抽象类的构造函数;
	 */
	public AbstractDemo(){
		super();
		System.out.println("抽象类 AbstractDemo 中的构造函数.....");
	}
	
	//受保护的 权限
	protected void hello(){
		System.out.println("我是一个 具体的非抽象 方法");
	}
	
	//定义抽象 起飞 方法
	protected abstract String fly();

	public abstract void eatSome();
	//.....
	
}
