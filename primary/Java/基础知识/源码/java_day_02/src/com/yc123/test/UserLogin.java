package com.yc123.test;

import java.util.Scanner;

public class UserLogin {

	public static void main(String[] args) {
		UserLogin ul = new UserLogin();
		ul.login();
	}
	
	/**
	 * ��½����
	 */
	public void  login(){
		//�����û��� ����
		String userName = "admin";
		String userPwd = "123456";
		
		//���룺
		Scanner sc = new Scanner(System.in);
		int i = 0;
		do{
			System.out.println("�������û�����");
			String str_name= sc.next();
			System.out.println("���������룺");
			String str_pwd= sc.next();
			
			//�ж�
			if(userName.equals(str_name)&&userPwd.equals(str_pwd)){
				System.out.println("��ϲ ��½�ɹ�������");
				//����ѭ��
				break;
			}else if(!userName.equals(str_name)){
				System.out.println("�û������󣡣���");
				
				System.out.println("�㻹��"+(2-i)+"�λ��ᣡ��");
			}else if(!userPwd.equals(str_pwd)){
				System.out.println("������󣡣���");
				System.out.println("�㻹��"+(2-i)+"�λ��ᣡ��");
			}
			
			//��������
			i++;
		}while(i<3);
	}
}
