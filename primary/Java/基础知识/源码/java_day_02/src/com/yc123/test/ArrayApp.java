package com.yc123.test;

import java.util.Random;

public class ArrayApp {
	/**
	 * ����Ķ��壺
	 * 		����ͬ���͵����� ���뵽һ���������ڴ��ַ�У�
	 * 
	 *   	����Ĵ��� ��ʽ��
	 *   	
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayApp aa = new ArrayApp();
		aa.arryNumNot();
		
	}
	//����ȥ��
	public void arryNumNot(){
		int[] numbers = new int[5];
		//ѭ������ ����
		for(int i=0;i<5; i++){
			
			int num = new Random().nextInt(5)+1;
			//���
			numbers[i] = num;
			//�ж��Ƿ� ���ظ� ����
			for(int j=0; j<i; j++){
				if(numbers[i]== numbers[j]){
					i--;
					break;
				}
			}
		}
		
		for (int i : numbers) {
			System.out.print(i+"  ");
		}
	}
	
	
	public void demo_one(){
		String[] strNames = new String[10];
		String[] strNames1 ={"���»�","��С��"};
		String[] strNames2 = new String[]{"���»�","��С��"};
		
		
		
		//String[] strNames3 = new String["CAPCITY"];
		
		//�±긳ֵ��
		strNames[0] = "����";
		strNames[1] = "����";
		//java.lang.ArrayIndexOutOfBoundsException: 10  ==�������±�Խ���쳣
		//strNames[10] = "������Χ";
		
		System.out.println(strNames.length);
		
		//for in	
		for (String strNam : strNames2) {
			System.out.println("==>"+strNam);
		}
		
		//��ά����
		int [][] table = null;
		table = new int[5][];
		
		table = new int[5][3];
		
		//��̬��ʼ��
		int [][] table2 = {{12,558,56,485},{172,548,3556,555},{442,218,656,5}};
		
		System.out.println("table2[0][2]==>"+table2[0][2]);
		System.out.println("=======================");
		//��������
		for (int i = 0; i < table2.length; i++) {
			//��ȡ��
			int[] rows = table2[i];
			//���� �е���
			for (int j = 0; j < rows.length; j++) {
				//ȡֵ
				System.out.print("table2["+i+"]["+j+"]="+table2[i][j]+"   ");
			}
			
			System.out.println();
		}
		
	}
	
	public void demo_fun(){
		//����һ������
		int[] numbers = new int[]{45,62,12,33,85,96,78,455,885,95};
		//int[] numbers3 = {12,45,62,33,85,96,78,455,885,95};
		//int[] numbers2 = new int[10];
		int temp = 0;
		
		//���� ð������ �ܹ��Ƚ϶��ٴ�
		for (int i = 0; i < numbers.length; i++) {
			//ÿһ�� �ȽϵĴ���
			for (int j = i+1; j < numbers.length; j++) {
				//���� ����
				if(numbers[i]<numbers[j]){
					temp=numbers[i];
					numbers[i]= numbers[j];
					numbers[j] = temp;
				}
			}
		}
		//��� ��� ���
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]+"  ");
		}
		
	}
}
