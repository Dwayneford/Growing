package ExceptionHomeWork;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * 1������ʲô��Java�쳣��
 * 	�쳣ָ�������й����г��ֵķ��������������û�������󡢳���Ϊ�㡢��Ҫ������ļ������ڡ�
 * 	�����±�Խ��ȡ�
 * 
 * 2��ʲô��Java�쳣����
 * 	�Գ�����ֵ��쳣��������Ĵ�����ȫ���˳����������ڳ��������
 * 
 * 
 * 3������Java�쳣�ķ��ࣿ
 * 	�����쳣�ĸ���Ϊjava.lang.Throwable��Throwable�������������������ࣺ
 * 	Error��Exception��
 * 	exception�����쳣�У�
 * 		NullPointerException��ָ�����
 * 		ArithmeticException�������
 * 		ArrayIndexOutOfBoundsException�����±�Խ��
 * 		ClassCastException����ת������
 * 		IOException
 * 		RunntimeException 
 * 		NumberFormatException��ʽ�������쳣
 * 		InputMismatchException���յ�����������ʵ��������������Ͳ�ƥ��
 * 		IllegalArgumentException���շǷ�����
 * 
 * 4�������ؼ���try��catch��finally��throw��throws�����ü��÷���
 * 	try {	
 * 		���ܳ����쳣�Ĵ����		
		} catch (Exception e) {
		���쳣�Ĵ���
		}finally {	
		�����Ƿ����쳣����ִ�е�����		
		}
 * 
 * 		throw ������׳�һ���쳣��һ�����ڴ������ڲ������������ĳ���߼�����ʱ
 * 			�ɳ���Ա�����׳�ĳ���ض����͵��쳣��
		throws �Ƿ��������׳��쳣��������(������������ʱ����ʾ�÷�������Ҫ�׳��쳣)
 * 

 * 5�����û����������ת����int(������ܳ��ֵ��쳣)������û����������Ӧ��ʾ�����ٴ����룿
 *
 * ############
 * 1������ʲô���쳣�������쳣��ֱ�Ӹ��ࣿ
 * 	 �쳣ָ�������й����г��ֵķ��������������û�������󡢳���Ϊ�㡢
 * 	��Ҫ������ļ������ڡ������±�Խ��ȡ������쳣��ֱ�Ӹ�����exception
 * 
 * 2��Exception��Error����
 * 	Error�ǳ����޷�����Ĵ��󣬱�ʾ����Ӧ�ó����н��������⡣
 * 		���������������д��ִ�еĲ����޹أ�����ʾ��������ʱ JVM(Java �����)���ֵ����⡣
 *  Exception�ǳ������ܹ�������쳣��
 * 
 * 3�������쳣�����ַ�ʽ�ֱ���ʲô��
	��׽�쳣 ��try��catch�飩���׳��쳣��throws��
	

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
		System.out.println("���������룺");
		String pwd = sca.next();
				
		int i=6,j=10;
		if (i<= pwd.length() && pwd.length() <=j) {
			System.out.println("������֤�����Ժ�");
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
		System.out.println("����ĳ���Ӧ����6-10֮��!");
	}	
}





