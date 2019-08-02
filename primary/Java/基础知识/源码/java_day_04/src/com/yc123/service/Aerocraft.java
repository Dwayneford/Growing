package com.yc123.service;

public class Aerocraft {
	//公共属性 
	private String material_science;//材料
	private String factory;         //厂家 
	private String price;           //价格 
	private String name;            //名称 
	private String size;            //尺寸
	private String weight;          //重量
	private String place_of_origin; //产地 
	
	public String getMaterial_science() {
		return material_science;
	}
	public void setMaterial_science(String material_science) {
		this.material_science = material_science;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getPlace_of_origin() {
		return place_of_origin;
	}
	public void setPlace_of_origin(String place_of_origin) {
		this.place_of_origin = place_of_origin;
	}
	
	
	//构造函数 
	public Aerocraft() {
		super();
	}
	public Aerocraft(String material_science, String factory, String price, String name, String size, String weight,
			String place_of_origin) {
		super();
		this.material_science = material_science;
		this.factory = factory;
		this.price = price;
		this.name = name;
		this.size = size;
		this.weight = weight;
		this.place_of_origin = place_of_origin;
	}
	
	//公共方法
	public void airFlight(){
		System.out.println("飞行器 的公共 飞行方法！！！！");
	}
	
	public void aircraftWork(int aerType){
		switch (aerType) {
		case 1:
			System.out.println("科学考察。。。。。");
			break;
		case 2:
			System.out.println("飞行表演。。。。。");
			break;
		case 3:
			System.out.println("技能竞赛。。。。。");
			break;
		default:
			System.out.println("未知飞行器。。。。");
			break;
		}
		
	}

}
