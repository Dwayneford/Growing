package com.yc123.demo;

public class Demo_01 {
	/**
	 * java 中的多态：
	 * 		一种事物的 多种表现形态；
	 *      表现形式：方法的重写  和 重载；
	 *      
	 *    简单理解：相同的事物有公共的行为，行为的具体表现各不相同；
	 *    		eg：猫  狗  猪...
	 *    			吃()
	 *    			睡觉()
	 *    			叫声()
	 */
	public static void main(String[] args) {
		//是用 多态方式 获得 不同对象的相同行为的不同表现；
		 Cat catEnt =  new Cat();
		 Pig pitEnt = new Pig();
		 //父类 类型 接收 子类对象实体
		 Animal an_cat = new Cat();
		 Animal an_pig = new Pig();
		 //多态调用
		 an_cat.eat();
		 an_cat.sleep();
		 
		 an_pig.eat();
		 an_pig.sleep();
		 
		 
		 //调用重载的方法 实现 业务功能
		 Demo_01 doEnt = new Demo_01();
		 int intSum =  doEnt.sum(25, 36);
		 
		 float floatSum = doEnt.sum(32.36f, 52, 158.36f);
		 
		 System.out.println("结果为："+intSum+"=="+floatSum);
		 
	}
	
	
	/**
	 * 重载 的方式 实现多态；
	 * 重载的定义：
	 * 	   在同一个类中，定义相同名称的方法，不同的参数类型 参数 个数 构成不功能 不同作用方法实现,称为重载；
	 */
	public int sum(int num1,int num2){
		return num1+num2;
	}
	
	public float sum(float num1,int num2){
		return num1 + num2;
	}
	
	public float sum(float num1,float num2){
		return num1 + num2;
	}
	
	public float sum(float num1,int num2,float num3){
		return num1 + num2+ num3;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
