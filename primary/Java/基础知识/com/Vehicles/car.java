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
		System.out.println("品牌为："+super.getBrand()+",颜色为："+super.getColor()+",座位数为:"+seats);
		
	}
	
	
}
