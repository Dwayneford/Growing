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
			System.out.println("���������䣺");		
			int age=sca.nextInt();
			if (age>=18 &&	age<=120) {
				System.out.println("�����������Ϊ"+age+"�꣡����");
				flag=false;
			}else{
				try{
					throw new AgeException(age);
				}catch (Exception e) {
				}
			}
		}				
		System.out.println("��������������");
	}
}

class AgeException extends Exception{
	private int age;
	
	public AgeException(int age) {
		super();
		this.age = age;
		System.out.println(age+"�겻�Ϸ������������18-120֮�����������");
	}

	public AgeException(){
		System.out.println("ϵͳ��ʾ�����������18-120֮�����������������������");
	}
	
}