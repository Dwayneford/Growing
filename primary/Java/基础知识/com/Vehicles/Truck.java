package com.Vehicles;

public class Truck extends Vehicles {

	
	float load;

	
	
	public Truck(String brand, String color) {
		super(brand, color);
	}

	public Truck(String brand, String color, float load) {
		super(brand, color);
		this.load = load;
	}

	public float getLoad() {
		return load;
	}

	public void setLoad(float load) {
		this.load = load;
	}

	public Truck(float load) {
		super();
		this.load = load;
	}
	
	void showCar(){
		System.out.println("Ʒ��Ϊ��"+super.getBrand()+",��ɫΪ��"+super.getColor()+",����Ϊ:"+load);
		
	}
	
}
