package com.Vehicles;

public class test {

	public static void main(String[] args) {
		
		Vehicles v= new Vehicles("运输工具", "蓝色");
		v.showCar();
		System.out.println("##########");
		
		car c =new car("比亚迪", "白色", 8);
		c.showCar();
		System.out.println("##########");
		
		Truck t = new Truck("长城", "黑色", 3000);
		t.showCar();
		
	}
	
	
	
}
