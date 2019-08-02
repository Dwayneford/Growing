package com.dkt.test;

import java.util.ArrayList;

public class Variable {
	/**
	 * java 中的 八大数据类型 + 一种 枚举类型
	 * 
	 * 四种数字类型: byte short  int long
	 * 两种浮点类型：float  double
	 * 一种字符类型：char
	 * 一种布尔类型：boolean
	 * 
	 * Java中的引用数据类型：数组 字符串 自定义对象
	 * 
	 * 变量：电脑内存中 分配的一块内存 地址;
	 * 
	 * 数据类型：基本类型 和引用类型
	 * 
	 * 定义变量语法: 数据类型  变量名称 = 变量值;
	 * 
	 * 定义变量规范：
	 * 		变量必须已字母  下划线"_"  或者$ 开头，其他部分 不能包含 除$ 符号以外的特殊字符；
	 *      变量定义必须有 意义；
	 *      命名方式：驼峰命名 下划线命名
	 *      注意不能使用 中英文 混合命名
	 * Java中的运算符：
	 * 	 四则运算
	 * 		求余：%
	 * 		递增 递减  ++  --
	 * 		在自身基础上计算后 在赋值给本身：+= -= ......
	 * 	  逻辑运行：
	 * 		&& ||  ！
	 *   位运算：
	 *   	& ~ | >>  << .....
	 *   
	 *   7 转换 2 进制：
	 */
	public static void main(String[] args) {
		
		//定义变量
		int age = 106;
		
		float $$_$ =10.4f;
		
		double price = 153.68;
		
		byte _tb =127; //(-128~127)
		
		char ch='B';
		
		
		System.out.println(age-5);
		System.out.println(ch);
		System.out.println(ch+20);
		
		//数据类型 转换 ：低类型 转换 位 高类型 自动转换， 高转换 低 强制转换 精度丢失；
		
		float sunNum = age+$$_$;
		
		int sunInt = (int)(age+$$_$);
		
		System.out.println("float===>"+sunNum);
		System.out.println("int===>"+sunInt);
		
	}
	
}
