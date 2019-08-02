package com.yc123.test;

import java.util.Random;

public class ArrayApp {
	/**
	 * 数组的定义：
	 * 		将相同类型的数据 存入到一个连续的内存地址中；
	 * 
	 *   	数组的创建 方式：
	 *   	
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayApp aa = new ArrayApp();
		aa.arryNumNot();
		
	}
	//数组去重
	public void arryNumNot(){
		int[] numbers = new int[5];
		//循环产生 数字
		for(int i=0;i<5; i++){
			
			int num = new Random().nextInt(5)+1;
			//存放
			numbers[i] = num;
			//判断是否 有重复 数字
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
		String[] strNames1 ={"刘德华","江小白"};
		String[] strNames2 = new String[]{"刘德华","江小白"};
		
		
		
		//String[] strNames3 = new String["CAPCITY"];
		
		//下标赋值、
		strNames[0] = "网络";
		strNames[1] = "貂蝉";
		//java.lang.ArrayIndexOutOfBoundsException: 10  ==》数组下标越界异常
		//strNames[10] = "超出范围";
		
		System.out.println(strNames.length);
		
		//for in	
		for (String strNam : strNames2) {
			System.out.println("==>"+strNam);
		}
		
		//二维数组
		int [][] table = null;
		table = new int[5][];
		
		table = new int[5][3];
		
		//静态初始化
		int [][] table2 = {{12,558,56,485},{172,548,3556,555},{442,218,656,5}};
		
		System.out.println("table2[0][2]==>"+table2[0][2]);
		System.out.println("=======================");
		//遍历行数
		for (int i = 0; i < table2.length; i++) {
			//获取行
			int[] rows = table2[i];
			//遍历 行的列
			for (int j = 0; j < rows.length; j++) {
				//取值
				System.out.print("table2["+i+"]["+j+"]="+table2[i][j]+"   ");
			}
			
			System.out.println();
		}
		
	}
	
	public void demo_fun(){
		//定义一个数组
		int[] numbers = new int[]{45,62,12,33,85,96,78,455,885,95};
		//int[] numbers3 = {12,45,62,33,85,96,78,455,885,95};
		//int[] numbers2 = new int[10];
		int temp = 0;
		
		//排序 冒泡排序： 总共比较多少次
		for (int i = 0; i < numbers.length; i++) {
			//每一次 比较的次数
			for (int j = i+1; j < numbers.length; j++) {
				//两两 交换
				if(numbers[i]<numbers[j]){
					temp=numbers[i];
					numbers[i]= numbers[j];
					numbers[j] = temp;
				}
			}
		}
		//输出 最后 结果
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]+"  ");
		}
		
	}
}
