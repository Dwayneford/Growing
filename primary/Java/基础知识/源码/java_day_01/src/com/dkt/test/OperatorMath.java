package com.dkt.test;

import java.util.Scanner;

public class OperatorMath {
	
	public static void main(String[] args) {
		//调用方法
		//String retStr = queryMaxMinNum();
		//System.out.println(retStr);
		
		//创建对象
		OperatorMath omEnt = new OperatorMath();
		//omEnt.sunNumFun();
		omEnt.cacheGoods();
		
	}
	/**
	 * 使用 while  dowhile 循环 计算数字求和：100 以内的 奇数 偶数；
	 * 
	 *  switch：抽奖：math 函数生成 1 到 10 范围数字，使用 switch....判断 抽中的奖品 信息 输出...
	 *  	
	 *  if()......
	 */
	public void cacheGoods(){
		int mathNum = (int)Math.round(Math.random()*10);
		switch (mathNum) {
			case 1:
				System.out.println("汽水 一瓶....");
				break;
			case 3:
				System.out.println("老干妈一瓶");
				break;
			case 5:
				System.out.println("再抽一次");
				break;
			case 7:
				System.out.println("现金抵用券一张");
				break;	
			default:
				
				System.out.println("谢谢参与");
				break;
		}
	}
	
	public void sunNumFun(){
		//定义 求和的数字
		int countNum=0;
		int countNum2=0;
		int i= 1;
		while(i<=100){
			//求奇数和 
			if(i%2==1){
				countNum+=i;
			}
			//求偶数和
			if(i%2==0){
				countNum2+=i;
			}
			
			i++;
		}
		
		System.out.println("奇数："+countNum+",偶数和："+countNum2);
		
		
	}
	
	
	
	
		/**
		 *  定义 整数 数组： 输入 5 个数字 存入其中， 遍历 比较取出最大  最小值；
		 *  
		 */
	public static String queryMaxMinNum(){
		//定义输入对象
		Scanner sc = new Scanner(System.in);
		//定义能够存放 6位数字的数组
		int[] itarry = new int[5];
		//double [] dbarry = new double[5];
		//String [] strarry = new String[5];
		
		//数组中存入值
		for (int i = 0; i < 5; i++) {
			System.out.printf("请输入第%d参数：",(i+1));
			
			itarry[i] = sc.nextInt();
		}
		System.out.println("数字存放 完成，长度："+itarry.length);
		
		//遍历 比较大小
		int maxNum = itarry[0];
		int minNum = itarry[0];
		
		for(int h=0;h<itarry.length;h++){
			//三目 运算
			maxNum = maxNum<itarry[h] ? itarry[h] : maxNum;
			
			minNum = minNum>itarry[h] ? itarry[h] : minNum;
		}
		return "最大数为："+maxNum+"；最大数为："+minNum;
	}
	
	public void operMeht(){
		//运算符 的使用
				int count = 10;
				//递增  递减的 使用
				System.out.println(count++);
				System.out.println(++count);
				
				System.out.println(count--);
				System.out.println(--count);
				
				
				System.out.println(count%3);
				
				//三目运算
				String strNum = count%2>0 ? "奇数" : "偶数";
				
				// 条件表达式 ?  成立 ： 不成立；
				// 条件表达式 ?  (条件表达式 ? (条件表达式 ?  成立 ： 不成立) ： 不成立) ： 不成立;
				System.out.println(count+"是："+strNum);
				
				//逻辑运算符
				int num1 = 2;
				int num2 = 4;
				
				System.out.println(num1>1 && num2<-2); //false
				System.out.println(num1>1 || num2<-2); //true
				System.out.println(!(num1>1 || num2<-2)); //false
				
				/**
				 * 位运算符  
				 * 0000101001  >> 2  ===>   0000001010
				 * 
				 */
				
				int a = 9;
				int b = 5;
				//0000 0101 ==>  0000 0001 《==》 右移动
				System.out.println("b>>2==>"+(b>>2));
				//0000 0101 ==> 0010 1000《==》 左移动
				System.out.println(b<<3);
				
				
				/*
				 * 按位 取反 ~
				 * 
				 * 步骤:
				 *   二进制：0 1001
				 *  计算补码：0 1001
				 *  按位取反：1 0110
				 *  
				 *  转为原码：1 1001
				 *  末位加一：1 1010
				 *  
				 *  符号位一的负数: -10;	
				 */
				System.out.println(~a);
				
				/**
				 * Java 中的流程控制：
				 * 	 1. if(条件){ }else if(){} else{}
				 *   2. switch (key) {
						case value:
							
							break;
						case value:
							
							break;
						default:
							break;
						}
						
					 3.	while(条件){ }
				 * 
				 * 	 4.	do{ }while(条件);
				 * 		
				 *   5.	for(初始值;比较条件;增量改变){  }
				 * 
				 * 	 6.	for (被遍历的数据类型  遍历对象 : 数组/集合) {
								遍历对象......
						}
						
					  7. break; 结束整个循环操作
						 continue; 结束当前循环操作，进入下一次循环
				 */
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
