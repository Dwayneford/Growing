package com.number;

public class Number {
	
	public static void main(String[] args) {
		Number num= new Number();
		num.setN1(100);
		num.setN2(50);
		
		
		num.addition();
		num.subtration();
		num.multiplication();
		num.division();
		
	}
	
	

	private int n1;
	private int n2;
	
	
	//封装接口
	public int getN1() {
		return n1;
	}
	public void setN1(int n1) {
		this.n1 = n1;
	}
	public int getN2() {
		return n2;
	}
	public void setN2(int n2) {
		this.n2 = n2;
	}
	//构造方法
	public Number(int n1, int n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}
	public Number() {
		super();
	}
	//加减乘除方法
	int addition(){
		n1+=n2;
		System.out.println(n1);
		return n1;
		
	}
	int subtration(){
		n1-=n2;
		System.out.println(n1);
		return n1;
		
	}
	
	int multiplication(){
		n1*=n2;
		System.out.println(n1);
		return n1;
		
	}
	int division(){
		n1/=n2;
		System.out.println(n1);
		return n1;
		
	}
	
	
	
	
	
}
