package com.dkt.test;

import java.util.ArrayList;

public class Variable {
	/**
	 * java �е� �˴��������� + һ�� ö������
	 * 
	 * ������������: byte short  int long
	 * ���ָ������ͣ�float  double
	 * һ���ַ����ͣ�char
	 * һ�ֲ������ͣ�boolean
	 * 
	 * Java�е������������ͣ����� �ַ��� �Զ������
	 * 
	 * �����������ڴ��� �����һ���ڴ� ��ַ;
	 * 
	 * �������ͣ��������� ����������
	 * 
	 * ��������﷨: ��������  �������� = ����ֵ;
	 * 
	 * ��������淶��
	 * 		������������ĸ  �»���"_"  ����$ ��ͷ���������� ���ܰ��� ��$ ��������������ַ���
	 *      ������������� ���壻
	 *      ������ʽ���շ����� �»�������
	 *      ע�ⲻ��ʹ�� ��Ӣ�� �������
	 * Java�е��������
	 * 	 ��������
	 * 		���ࣺ%
	 * 		���� �ݼ�  ++  --
	 * 		����������ϼ���� �ڸ�ֵ������+= -= ......
	 * 	  �߼����У�
	 * 		&& ||  ��
	 *   λ���㣺
	 *   	& ~ | >>  << .....
	 *   
	 *   7 ת�� 2 ���ƣ�
	 */
	public static void main(String[] args) {
		
		//�������
		int age = 106;
		
		float $$_$ =10.4f;
		
		double price = 153.68;
		
		byte _tb =127; //(-128~127)
		
		char ch='B';
		
		
		System.out.println(age-5);
		System.out.println(ch);
		System.out.println(ch+20);
		
		//�������� ת�� �������� ת�� λ ������ �Զ�ת���� ��ת�� �� ǿ��ת�� ���ȶ�ʧ��
		
		float sunNum = age+$$_$;
		
		int sunInt = (int)(age+$$_$);
		
		System.out.println("float===>"+sunNum);
		System.out.println("int===>"+sunInt);
		
	}
	
}
