package com.yc123.test;

import java.util.Scanner;

public class UserLogin {

	public static void main(String[] args) {
		UserLogin ul = new UserLogin();
		ul.login();
	}
	
	/**
	 * 登陆方法
	 */
	public void  login(){
		//定义用户名 密码
		String userName = "admin";
		String userPwd = "123456";
		
		//输入：
		Scanner sc = new Scanner(System.in);
		int i = 0;
		do{
			System.out.println("请输入用户名：");
			String str_name= sc.next();
			System.out.println("请输入密码：");
			String str_pwd= sc.next();
			
			//判断
			if(userName.equals(str_name)&&userPwd.equals(str_pwd)){
				System.out.println("恭喜 登陆成功！！！");
				//跳出循环
				break;
			}else if(!userName.equals(str_name)){
				System.out.println("用户名错误！！！");
				
				System.out.println("你还有"+(2-i)+"次机会！！");
			}else if(!userPwd.equals(str_pwd)){
				System.out.println("密码错误！！！");
				System.out.println("你还有"+(2-i)+"次机会！！");
			}
			
			//变量自增
			i++;
		}while(i<3);
	}
}
