package com.yc123.abstractTemp;

public class TestAbstract {
	public static void main(String[] args) {
		
		Employee emp= new Employee();
		//���ó������� �� �������ݷ���
		emp.doWorkIng();
		System.out.println("--------");
		Boss boss = new Boss();
		boss.doWorkIng();
		
	}
}
