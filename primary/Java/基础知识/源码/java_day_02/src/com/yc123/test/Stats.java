package com.yc123.test;

public class Stats {

	public static void main(String[] args) {
		//��������
		Stats stEnt = new Stats();
		stEnt.statImg();
	}
	/**
	 * �������
	 */
	public void statImg(){
		//��ӡ�׺�
		for (int i = 1; i <= 21 ; i++) {
			System.out.print("*");
		}
		//����
		System.out.println();
		//�ϰ벿������
		for (int i = 1; i <= 7; i++) {
			System.out.print("*");
			//��ӡ�ո�
			for (int k = 1; k <= (10-i); k++) {
				System.out.print(" ");
			}
			//��ӡ ������
			for(int k = 1; k <= 2*i-1; k++){
				System.out.print("*");
			}
			//��ӡ�ո�
			for (int k = 1; k <= (10-i); k++) {
				System.out.print(" ");
			}
			System.out.print("*");
			//����
			System.out.println();
		}
		//�°벿������
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
