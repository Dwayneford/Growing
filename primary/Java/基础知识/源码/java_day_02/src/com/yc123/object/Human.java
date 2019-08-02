package com.yc123.object;

public class Human extends Object{
	
	//属性：private 私有化 权限，有效范围 当前类中有效
	private String sex;   //定义名称 首字母不允许大写；
	private String name;
	private int age;
	private double height;
	private String job;
	
	//通过 封装 对外提供访问的 方法/接口： 提供 操作属性 的方法：取值 方法(get) 和存值 方法(set);
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
		//年龄必须大于0
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
	
	
	//Human 类的默认构造函数
	public Human(){
		super();
		System.out.println("执行了 Human 类的默认构造函数！！！");
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
	
	
	
	//行为
	void run(){
		System.out.println(name+"正在跑步....");
	}
	
	void work(){
		System.out.println(name+"今年"+age+"岁，正在北京上班....");
	}
	
	void think(){
		System.out.println(name+"正在思考....");
		
		//通过this关键之 直接调用当前对象 学习方法
		this.leanrEnglish();
	}
	
	public void leanrEnglish(){
		System.out.println("学习 方法！！！");
	} 
	
	
	//静态代码块 static
	static{
		System.out.println("跟随类一起加载到内存中，它优先于 对象(this)存在");
	}
	
	
	
	

}
