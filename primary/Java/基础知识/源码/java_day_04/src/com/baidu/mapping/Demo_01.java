package com.baidu.mapping;

import com.yc123.dao.Person;

public class Demo_01 {
	/**
	 * 定义类 属性
	 * 
	 * 加载 执行 顺序：
	 * 		1 加载 Animal类的构造函数
	 * 		2 加载EatGrass..类的构造函数
	 * 		3 加载Sheep类的构造函数
	 * 		4 执行类的调用 方法
	 * 		。。。。。。。。。根据代码的向后调用顺序执行。
	 * 
	 * 		注意：如果有 静态代码块，final修饰的常量，优先于构造函数执行！！！
	 * 
	 */
	//static 
	//调用动物的 睡觉方法
	/*public void queryEat(){
	}*/
	
	public static void main(String[] args) {
		
		System.out.println("执行 函数入 口方法.....");
		
		/*Sheep weslie = new Sheep();
		// 调用父类 的睡觉的
		weslie.anSleep();
		
		weslie.setAn_name("喜羊羊");
		weslie.setAn_type("绵羊");*/
		
		
		/*//创建对象 Person 调用 syaMyself方法
		Person tom = new Person();
		tom.sayMySelf("吃饭 睡觉 打豆豆..", 15, "王铁锤");
		
		String retSayInfo = tom.sayMySelf("铁蛋", "男", 28, "大学城 拆迁户....");
		System.out.println("retSayInfo==>"+retSayInfo);*/
	}
	
	

}
