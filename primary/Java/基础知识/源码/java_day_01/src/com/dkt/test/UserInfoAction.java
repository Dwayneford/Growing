//当前类 存放包的位置
package com.dkt.test;

import java.util.*;

// 类名称 必须和 文件名称一致
public class UserInfoAction {
	/*
	 * 定义属性 和 方法
	 */
	int num1 = 50;
	String goodsName = "巧乐兹";
	double goods_price = 12.56D;
	
	//定义 方法
	public void sunNum(){
		//获取两数字 计算和
		Scanner scn = new Scanner(System.in);
		
		int scn_num1 = scn.nextInt();
		int scn_num2 = scn.nextInt();
		
		int countNum = scn_num1 + scn_num2;
		
		System.out.println(scn_num1+"+"+scn_num2+"="+countNum);
		//输出当前时间 的毫秒数.....
		System.out.println("当前时间的毫米数 为："+System.currentTimeMillis());
		
	}
	

	/**
	 * 文本注解：
	 *  说明 类 方法的 作用，供开发人员使用阅读
	 *  谁写的类
	 *  什么时间写的，修改的
	 *  方法 的参数有哪些，使用需要注意什么....
	 *  
	 *  认识main函数：
	 *  	是程序入口函数，程序运行后 开始查找 该函数...
	 *  	定义方式：
	 *  		必须是 公共的方法，public
	 *  		必须是 静态方法,static
	 *  		必须 没有返回值, void
	 *  		必须是 main名称
	 *  		参数必须是 数组 stirng
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 多行注解
		 * 在程序开发过程中 写给 项目组成员相互交流的；
		 */
		//单行注解: 定义属性v用户 年龄
		int userAge = 20;
		
		System.out.println("Hello xiaobai you age"+ userAge);
		
		
		//调用求和 函数
		UserInfoAction usEnt = new UserInfoAction();
		
		usEnt.sunNum();
		
	}
	
	public void eatIng(){
		
	}
	
}
