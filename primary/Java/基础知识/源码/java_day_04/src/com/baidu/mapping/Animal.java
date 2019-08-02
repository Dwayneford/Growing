package com.baidu.mapping;

public class Animal {
	//类所具有的的 一些 公共属性
	private String an_name;
	private int an_age;
	private String an_color;
	private String an_weight;
	private String an_type;
	//......
	
	public String getAn_name() {
		return an_name;
	}

	public void setAn_name(String an_name) {
		this.an_name = an_name;
	}

	public int getAn_age() {
		return an_age;
	}

	public void setAn_age(int an_age) {
		this.an_age = an_age;
	}

	public String getAn_color() {
		return an_color;
	}

	public void setAn_color(String an_color) {
		this.an_color = an_color;
	}

	public String getAn_weight() {
		return an_weight;
	}

	public void setAn_weight(String an_weight) {
		this.an_weight = an_weight;
	}

	public String getAn_type() {
		return an_type;
	}

	public void setAn_type(String an_type) {
		this.an_type = an_type;
	}

	
	//构造函数
	public Animal() {
		super();
		System.out.println("这是 animal类的无参构造函数！！！");
		
	}

	public Animal(String an_name, int an_age, String an_color, String an_weight, String an_type) {
		super();
		this.an_name = an_name;
		this.an_age = an_age;
		this.an_color = an_color;
		this.an_weight = an_weight;
		this.an_type = an_type;
	}

	//类所具有的的 一些 公共方法
	public void anEat(){
		System.out.println("吃东西..");
	}
	
	/**
	 * 在可访问的 方法中 调用，私有的 属性 和 方法，供子类使用
	 */
	public void anSleep(){
		//调用当前的类的学习 方法；
		this.learning();
		
		System.out.println("睡觉的行为....");
	}
	//.......
	
	//不允许被继承的方法 写成 私有的 
	private  String learning(){
		String str = "父类的 learn 方法.. 是一个是有不能被继承 使用的方法。";
		return str;
	}
	/**
	 * final 修饰的方法 是不允许 被重写的
	 *    	  修饰的变量 必能被重新赋值
	 *       修饰的类 不能被继承
	 */
	protected final void run(){
		System.out.println("动物 的跑行为。。。");
	}
	/**
	 * 静态代码块
	 */
	static{
		System.out.println("这是 animal类的静态代码块！！！");
	}
	
}
