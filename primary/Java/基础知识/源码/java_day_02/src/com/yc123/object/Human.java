package com.yc123.object;

public class Human extends Object{
	
	//���ԣ�private ˽�л� Ȩ�ޣ���Ч��Χ ��ǰ������Ч
	private String sex;   //�������� ����ĸ�������д��
	private String name;
	private int age;
	private double height;
	private String job;
	
	//ͨ�� ��װ �����ṩ���ʵ� ����/�ӿڣ� �ṩ �������� �ķ�����ȡֵ ����(get) �ʹ�ֵ ����(set);
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

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
		//����������0
		if(age<=0){
			this.age = 18;
		}else{
			this.age = age;
		}
	}

	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	//Human ���Ĭ�Ϲ��캯��
	public Human(){
		super();
		System.out.println("ִ���� Human ���Ĭ�Ϲ��캯��������");
	}

	public Human(String name) {
		super();
		this.name = name;
	}

	public Human(String sex, String job) {
		super();
		this.sex = sex;
		this.job = job;
	}

	public Human(String sex, String name, int age, double height, String job) {
		super();
		this.sex = sex;
		this.name = name;
		this.age = age;
		this.height = height;
		this.job = job;
	}
	
	
	
	//��Ϊ
	void run(){
		System.out.println(name+"�����ܲ�....");
	}
	
	void work(){
		System.out.println(name+"����"+age+"�꣬���ڱ����ϰ�....");
	}
	
	void think(){
		System.out.println(name+"����˼��....");
		
		//ͨ��this�ؼ�֮ ֱ�ӵ��õ�ǰ���� ѧϰ����
		this.leanrEnglish();
	}
	
	public void leanrEnglish(){
		System.out.println("ѧϰ ����������");
	} 
	
	
	//��̬����� static
	static{
		System.out.println("������һ����ص��ڴ��У��������� ����(this)����");
	}
	
	
	
	

}
