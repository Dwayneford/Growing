package com.person;


public class Person {
	
	public static void main(String[] args) {
		Person p = new Person();
		p.setAge(25);
		p.setName("��ѧ��");		
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
	
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	
	
	void display(){
		System.out.println("����Ϊ"+name+"������Ϊ��"+age+"��");
		
	}
	

}
