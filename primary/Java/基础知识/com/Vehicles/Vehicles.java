package com.Vehicles;

public class Vehicles {

	private String brand,color;

	
	
	//������
	public Vehicles(String brand, String color) {
		super();
		this.brand = brand;
		this.color = color;
	}

	public Vehicles() {
		super();
	}

	//��װ�ӿ�
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
	
	//����
	void run(){
		System.out.println("���Ѿ�������");
	}
	
	void showCar(){
		System.out.println("Ʒ��Ϊ��"+brand+"��ɫΪ��"+color);
		
	}

	
	
}
