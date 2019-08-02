package com.yc123.abstractTemp;

public class TestAbstract {
	public static void main(String[] args) {
		
		Employee emp= new Employee();
		//调用抽象类中 得 工作内容方法
		emp.doWorkIng();
		System.out.println("--------");
		Boss boss = new Boss();
		boss.doWorkIng();
		
	}
}
