package ExceptionHomeWork;

import java.util.Scanner;

public class TestException {
	public static void main(String[] args) {
		Student1 stu = new Student1();
		stu.inputAge();
	}

}


class Student1 {
	void inputAge (){
		Scanner sca = new Scanner(System.in);
		boolean flag=true;
		while (flag) {
			System.out.println("请输入年龄：");		
			int age=sca.nextInt();
			if (age>=18 &&	age<=120) {
				System.out.println("您输入的年龄为"+age+"岁！！！");
				flag=false;
			}else{
				try{
					throw new AgeException(age);
				}catch (Exception e) {
				}
			}
		}				
		System.out.println("程序正常结束！");
	}
}

class AgeException extends Exception{
	private int age;
	
	public AgeException(int age) {
		super();
		this.age = age;
		System.out.println(age+"岁不合法，年龄必须是18-120之间的正整数！");
	}

	public AgeException(){
		System.out.println("系统提示：年龄必须是18-120之间的正整数，您的输入有误！");
	}
	
}