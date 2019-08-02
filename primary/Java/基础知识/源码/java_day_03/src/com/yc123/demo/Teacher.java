package com.yc123.demo;
/**
 * 关键字的使用：
 * 	this：代指被创建的 当前对象本身;
 *  super：父类对象，通过super关键字 能够取出 父类属性中，允许访问的 所有 属性和方法；
 *  
 *  static： 1.修饰 属性 ，方法  代码块: 被修饰的内容不需要 通过对象来调用：通过类名称.被修饰的内容；
 *  	    2.在静态方法中 必须使用静态成员变量 ，或者调用 静态方法；
 *  		3.静态成员变量 静态 方法类共享，不是属于某一个对象；
 *  	    4.在静态的 方法中不能使用 关键字 this;
 *       注意：全局 变量/方法 不经常发生改变的属性，业务代码块；
 *  final：修饰 方法，类 ，属性，
 *  		被final修饰的属性 称为常量，常量只能被赋值一次，名称必须是大写;
 *  		被final修饰的方法 不能被重写；
 *  		final修饰符一般和 static 一起使用。
 * 
 * @author direct
 *
 */
public class Teacher {
	//私有 的成员 变量：所有的数据类型 都会有一个默认 值； 
	private String name;
	private String advanced;
	private int age;
	//定义 静态 工资变量
	public static double salary = 9000;
	
	//定义常量
	public static final String ADDRESS_CODE="AD_21053_CHANI";
	
	
	public static void main(String[] args) {
		//不能使用 非 静态变量
		//System.out.println(age);
		//getName();
	}
	
	//get  set  方法
	public  String getName() {
		// 局部变量：没有默认值，如果需要使用必须 赋初始值;
		int score;
		
		return name;
	}
	/**
	 * set方法 接收名称为name的参数，将值付给当前对象的name属性；
	 * 
	 * 相同的参数名称 有一个原则：就近原则
	 * @param name
	 */
	public void setName(String tec_nam) {
		// name = name;
		//this.name = name;
		//省略
		name = tec_nam;
	}
	public String getAdvanced() {
		return advanced;
	}
	public void setAdvanced(String advanced) {
		this.advanced = advanced;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
