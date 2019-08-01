package com.people;

public class People {
	
	public static void main(String[] args) {
		People p = new People();
		p.setAge(18);
		p.setName("张三");
		
		p.display();
		
	}
	
	private String name;
	private int age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public People(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public People() {
		super();
	}
	
	
	void display(){
		System.out.println("名字为"+name+"；年龄为："+age+"。");
		
	}
	

}
