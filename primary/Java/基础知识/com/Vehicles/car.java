package com.Vehicles;

public class car extends Vehicles{

	int seats;
	
	
	
	public car(String brand, String color, int seats) {
		super(brand, color);
		this.seats = seats;
	}
	
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}



	void showCar(){
		System.out.println("Ʒ��Ϊ��"+super.getBrand()+",��ɫΪ��"+super.getColor()+",��λ��Ϊ:"+seats);
		
	}
	
	
}
