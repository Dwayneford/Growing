package Drink;

import java.util.Scanner;

public class Person {

	void getDrink(){
		System.out.println("请输入代号");
		Scanner sca = new Scanner(System.in);
		int num = sca.nextInt();
		switch (num) {
		case 1:
			System.out.println("您输入的是1,代表咖啡");
			Coffee coffee= new Coffee();
			coffee.taste();
			break;

		case 2:
			System.out.println("您输入的是2,代表啤酒");
			Beer beer = new Beer();
			beer.taste();
			
			break;
		case 3:
			System.out.println("您输入的是3,代表牛奶");
			Milk milk = new Milk();
			milk.taste();
			break;
	
		default:
			System.out.println("输入的数字错误，没有该种饮料");
			break;
		}
		
		
	}
	
	
}
