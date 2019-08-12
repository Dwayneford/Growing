package ExceptionHomeWork;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * 1、简述什么是Java异常？
 * 	异常指程序运行过程中出现的非正常现象，例如用户输入错误、除数为零、需要处理的文件不存在、
 * 	数组下标越界等。
 * 
 * 2、什么是Java异常处理？
 * 	对程序出现的异常做出合理的处理，安全的退出，而不至于程序崩溃。
 * 
 * 
 * 3、简述Java异常的分类？
 * 	所有异常的根类为java.lang.Throwable，Throwable下面又派生了两个子类：
 * 	Error和Exception。
 * 	exception常用异常有：
 * 		NullPointerException空指针错误
 * 		ArithmeticException运算错误
 * 		ArrayIndexOutOfBoundsException数组下标越界
 * 		ClassCastException类型转换错误
 * 		IOException
 * 		RunntimeException 
 * 		NumberFormatException格式化数据异常
 * 		InputMismatchException接收的数据类型与实际输入的数据类型不匹配
 * 		IllegalArgumentException接收非法参数
 * 
 * 4、简述关键字try、catch、finally、throw、throws的作用及用法？
 * 	try {	
 * 		可能出现异常的代码块		
		} catch (Exception e) {
		对异常的处理
		}finally {	
		无论是否有异常都会执行的语句块		
		}
 * 
 * 		throw 是语句抛出一个异常，一般是在代码块的内部，当程序出现某种逻辑错误时
 * 			由程序员主动抛出某种特定类型的异常；
		throws 是方法可能抛出异常的声明。(用在声明方法时，表示该方法可能要抛出异常)
 * 

 * 5、将用户输入的数据转换成int(处理可能出现的异常)，如果用户输入给出相应提示，并再次输入？
 *
 * ############
 * 1、简述什么是异常、所有异常的直接父类？
 * 	 异常指程序运行过程中出现的非正常现象，例如用户输入错误、除数为零、
 * 	需要处理的文件不存在、数组下标越界等。所有异常的直接父类是exception
 * 
 * 2、Exception与Error区别？
 * 	Error是程序无法处理的错误，表示运行应用程序中较严重问题。
 * 		大多数错误与代码编写者执行的操作无关，而表示代码运行时 JVM(Java 虚拟机)出现的问题。
 *  Exception是程序本身能够处理的异常。
 * 
 * 3、处理异常的两种方式分别是什么？
	捕捉异常 （try和catch块）和抛出异常（throws）
	

 * @author Administrator
 *
 */

public class Preview {
	public static void main(String[] args) {
		User u= new User();		
		u.userLogin();
	}	
}

class User {
	private String pwd;
	void userLogin() {
		
		Scanner sca= new Scanner(System.in);
		System.out.println("请输入密码：");
		String pwd = sca.next();
				
		int i=6,j=10;
		if (i<= pwd.length() && pwd.length() <=j) {
			System.out.println("正在验证，请稍后！");
		}else{
			try {
				throw new BaseException();
			} catch (BaseException e) {								
			}
		}
		
	}	
}

class BaseException extends Exception{
	public BaseException(){
		System.out.println("密码的长度应该在6-10之间!");
	}	
}





