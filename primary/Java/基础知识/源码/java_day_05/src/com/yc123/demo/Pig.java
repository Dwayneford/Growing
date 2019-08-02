package com.yc123.demo;

public class Pig extends Animal {
	//从写 父类方法 权限修饰 符 必须 大于 等于 父类方法的 修饰符
		public void eat(){
			System.out.println("小猪 喜欢吃 饲料！！");
		}
		public void sleep(){
			System.out.println("喜欢 呼呼大睡 ！");
		}
}
