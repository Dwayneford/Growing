package com.yc123.demo;

public class PeopleClass {
	
	//��������
	//default 
	private String name;
	private char gender;
	private double tall;
	private String job;
	
	//��˽������ �ṩ ȡֵ ��ֵ ���������� ���빫����Ȩ�ޣ���Ϊ���򵥷�װ
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getTall() {
		return tall;
	}

	public void setTall(double tall) {
		this.tall = tall;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	
	double weight;
	
	
	//��˽������
	int age;
	
	
	
	//������ ӵ�еĹ�����Ϊ
	public void run(){
		System.out.println("�� ����Ϊ..");
	}
	
	void walk(){
		System.out.println("��· �� ����");
	}
	
	void eat(){
		System.out.println("�Զ���");
	}
	
	void sleep(){
		System.out.println("����˯��,,,");
	}
	
	public String learning(){
		String retStr ="����ѧϰz��....";
		
		return retStr;
	}
	/**
	 * Ĭ�Ϲ��캯��
	 */
	public PeopleClass() {
		super();
	}
	/**
	 * �в��� ���캯���������вι��캯�����޲ι��캯�� ������ʾ��д�������򱻸��ǣ��޷�ͨ���޲κ�����������
	 * @param name
	 * @param gender
	 * @param tall
	 * @param job
	 * @param age
	 * @param weight
	 */
	public PeopleClass(String name, char gender, double tall, String job, int age, double weight) {
		super();
		this.name = name;
		this.gender = gender;
		this.tall = tall;
		this.job = job;
		this.age = age;
		this.weight = weight;
	}
	
	
	
	
	
}
