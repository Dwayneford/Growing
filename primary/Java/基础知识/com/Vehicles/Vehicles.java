package com.Vehicles;

public class Vehicles {

	private String brand,color;

	
	
	//构造器
	public Vehicles(String brand, String color) {
		super();
		this.brand = brand;
		this.color = color;
	}

	public Vehicles() {
		super();
	}

	//封装接口
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	//方法
	void run(){
		System.out.println("车已经开动！");
	}
	
	void showCar(){
		System.out.println("品牌为："+brand+"颜色为："+color);
		
	}

	
	
}
