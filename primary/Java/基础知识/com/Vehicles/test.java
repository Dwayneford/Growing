package com.Vehicles;

public class test {

	public static void main(String[] args) {
		
		Vehicles v= new Vehicles("���乤��", "��ɫ");
		v.showCar();
		System.out.println("##########");
		
		car c =new car("���ǵ�", "��ɫ", 8);
		c.showCar();
		System.out.println("##########");
		
		Truck t = new Truck("����", "��ɫ", 3000);
		t.showCar();
		
	}
	
	
	
}
