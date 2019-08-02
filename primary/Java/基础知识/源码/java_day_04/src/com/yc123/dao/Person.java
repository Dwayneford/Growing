package com.yc123.dao;

public class Person {

	//定义属性 
	
	
	//定义 方法 在当前类中重载 方法
	public String sayMySelf(String name,String sex,int age,String address){
		String retStr = "";
		//switch 判断输出的内容
		switch (age) {
		case 18:
			if(("男").equals(sex)){
				retStr = "我是大学城 扛把子，年龄为："+age+"，姓名"+name+",家住"+address;
			}else{
				retStr = "我是大学城 村花，年龄为："+age+"，姓名"+name+",家住"+address;
			}
			break;
		case 28:
			if(("男").equals(sex)){
				retStr = "我是大学城 有为青年，年龄为："+age+"，姓名"+name+",家住"+address;
			}else{
				retStr = "我是大学城 小姐姐，年龄为："+age+"，姓名"+name+",家住"+address;
			}
			break;
			
		case 38:
			if(("男").equals(sex)){
				retStr = "我是大学城 油腻大叔，年龄为："+age+"，姓名"+name+",家住"+address;
			}else{
				retStr = "我是大学城 阿姨，年龄为："+age+"，姓名"+name+",家住"+address;
			}
			break;
		default:
			
			break;
		}
		
		return retStr;
	}
	
	//重载sayMySelf 方法
	public int sayMySelf(String happy,int age, String name){
		
		if(10<age && age<18){
			System.out.println(name+"叛逆期阶段！！！"+happy+"===="+age);
		}else if(18<=age && age<28){
			System.out.println(name+"社会精英阶段v！！"+happy+"===="+age);
		}else if(28<=age && age<38){
			System.out.println(name+"事业有成阶段！！"+happy+"===="+age);
		}else if(38<=age && age<58){
			System.out.println(name+"安稳度日阶段！！"+happy+"===="+age);
		}else{
			System.out.println(name+"混吃等死阶段！！"+happy+"===="+age);
		}
		
		return 0;
	}
	
	
}
