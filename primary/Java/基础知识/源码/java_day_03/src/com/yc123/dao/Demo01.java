package com.yc123.dao;

import com.yc123.demo.Modifier;
/**
 * Modifier： 被继承 的父类
 * @author direct
 * 
 * 
 * 类被 加载的顺序：
 * 		1.加载 static 静态修饰的 内容(属性 方法 代码块)
 *      2.加载构造函数：先加载 父类的构造函数 在加载 子类的构造函数；
 *      3.在从上到下 加载 基本属性 和 方法; 
 *
 */
public class Demo01 extends Modifier{
	//无法获取 父类的内容，在加载父类 内容之前 是无法 获取它的内容；
	//super.
	
	 public static void main(String[] args) {
		 //测试 权限修饰符的使用 
		 Demo01 demEnt = new Demo01();
		 //调用父类 方法
		 demEnt.hello1();
		 
		 demEnt.hello3();
		 
		 //取出 父类允许 访问的 内容(方法 内容)
		 //super.
		 
		 //调用子类方法
		 demEnt.methodOne();
		 
	}
	
	public void hello3(){
		System.out.println("这是 子类的 hello3 方法！！！");
	}
	 
	
	/**
	 * 非静态的 普通 方法
	 */
	public void methodOne(){
		//获取 父类的方法 属性
		super.modName = "父类 属性名称";
		System.out.println("super.modName==>"+super.modName);
		super.hello1();
		super.hello3();
		
		this.hello3();
	} 
	 
}
