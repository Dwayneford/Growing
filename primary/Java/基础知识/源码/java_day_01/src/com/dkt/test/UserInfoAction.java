//��ǰ�� ��Ű���λ��
package com.dkt.test;

import java.util.*;

// ������ ����� �ļ�����һ��
public class UserInfoAction {
	/*
	 * �������� �� ����
	 */
	int num1 = 50;
	String goodsName = "������";
	double goods_price = 12.56D;
	
	//���� ����
	public void sunNum(){
		//��ȡ������ �����
		Scanner scn = new Scanner(System.in);
		
		int scn_num1 = scn.nextInt();
		int scn_num2 = scn.nextInt();
		
		int countNum = scn_num1 + scn_num2;
		
		System.out.println(scn_num1+"+"+scn_num2+"="+countNum);
		//�����ǰʱ�� �ĺ�����.....
		System.out.println("��ǰʱ��ĺ����� Ϊ��"+System.currentTimeMillis());
		
	}
	

	/**
	 * �ı�ע�⣺
	 *  ˵�� �� ������ ���ã���������Աʹ���Ķ�
	 *  ˭д����
	 *  ʲôʱ��д�ģ��޸ĵ�
	 *  ���� �Ĳ�������Щ��ʹ����Ҫע��ʲô....
	 *  
	 *  ��ʶmain������
	 *  	�ǳ�����ں������������к� ��ʼ���� �ú���...
	 *  	���巽ʽ��
	 *  		������ �����ķ�����public
	 *  		������ ��̬����,static
	 *  		���� û�з���ֵ, void
	 *  		������ main����
	 *  		���������� ���� stirng
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * ����ע��
		 * �ڳ��򿪷������� д�� ��Ŀ���Ա�໥�����ģ�
		 */
		//����ע��: ��������v�û� ����
		int userAge = 20;
		
		System.out.println("Hello xiaobai you age"+ userAge);
		
		
		//������� ����
		UserInfoAction usEnt = new UserInfoAction();
		
		usEnt.sunNum();
		
	}
	
	public void eatIng(){
		
	}
	
}
