package com.Vehicle;

public class Vehicle {
	
	public static void main(String[] args) {
		
		Vehicle  car= new Vehicle();
		car.setSpeed(100);
		car.setSize(500);
		car.move();
		System.out.println("##########");
		car.speedUp(10);
		car.speedDown(50);
	}
	

	double speed ;
	double size;
	
	void move(){
		System.out.println("Ŀǰ���ƶ��ٶ�Ϊ��"+speed+"�������Ϊ��"+size);
		
	}
	//�����ٶ�
	int setSpeed(int speed){
		this.speed=speed;	
		return speed;	
	}
	//�������
	double setSize(double size){
		this.size=size;	
		return size;
	}
	//����
	int speedUp(int add){
		System.out.println("�Ѽ���"+add);		
		speed+=add;
		this.move();
		return (int) speed;
	}
	//����
	int speedDown(int down){
		System.out.println("�Ѽ���"+down);		
		speed-=down;
		this.move();
		return (int) speed;
		
	}
}
