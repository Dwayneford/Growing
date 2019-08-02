package com.yc123.test;

public class Stats {

	public static void main(String[] args) {
		//创建对象
		Stats stEnt = new Stats();
		stEnt.statImg();
	}
	/**
	 * 输出菱形
	 */
	public void statImg(){
		//打印首航
		for (int i = 1; i <= 21 ; i++) {
			System.out.print("*");
		}
		//换行
		System.out.println();
		//上半部分内容
		for (int i = 1; i <= 7; i++) {
			System.out.print("*");
			//打印空格
			for (int k = 1; k <= (10-i); k++) {
				System.out.print(" ");
			}
			//打印 内容星
			for(int k = 1; k <= 2*i-1; k++){
				System.out.print("*");
			}
			//打印空格
			for (int k = 1; k <= (10-i); k++) {
				System.out.print(" ");
			}
			System.out.print("*");
			//换行
			System.out.println();
		}
		//下半部分内容
		for(int i=6;i>=1;i--){
			System.out.print("*");
			for(int k=1;k<=10-i;k++){
				System.out.print(" ");
			}
			for (int k = 1; k <= 2*i-1; k++) {
				System.out.print("*");
			}
			for (int k = 1; k <= 10-i; k++) {
				System.out.print(" ");
			}
			System.out.print("*");
			System.out.println();
		}
		for (int i = 1; i <= 21; i++) {
			System.out.print("*");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
