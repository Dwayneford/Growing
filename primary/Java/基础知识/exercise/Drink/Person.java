package Drink;

import java.util.Scanner;

public class Person {

	void getDrink(){
		System.out.println("���������");
		Scanner sca = new Scanner(System.in);
		int num = sca.nextInt();
		switch (num) {
		case 1:
			System.out.println("���������1,������");
			Coffee coffee= new Coffee();
			coffee.taste();
			break;

		case 2:
			System.out.println("���������2,����ơ��");
			Beer beer = new Beer();
			beer.taste();
			
			break;
		case 3:
			System.out.println("���������3,����ţ��");
			Milk milk = new Milk();
			milk.taste();
			break;
	
		default:
			System.out.println("��������ִ���û�и�������");
			break;
		}
		
		
	}
	
	
}
