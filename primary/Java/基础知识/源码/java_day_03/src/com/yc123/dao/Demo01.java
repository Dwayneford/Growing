package com.yc123.dao;

import com.yc123.demo.Modifier;
/**
 * Modifier�� ���̳� �ĸ���
 * @author direct
 * 
 * 
 * �౻ ���ص�˳��
 * 		1.���� static ��̬���ε� ����(���� ���� �����)
 *      2.���ع��캯�����ȼ��� ����Ĺ��캯�� �ڼ��� ����Ĺ��캯����
 *      3.�ڴ��ϵ��� ���� �������� �� ����; 
 *
 */
public class Demo01 extends Modifier{
	//�޷���ȡ ��������ݣ��ڼ��ظ��� ����֮ǰ ���޷� ��ȡ�������ݣ�
	//super.
	
	 public static void main(String[] args) {
		 //���� Ȩ�����η���ʹ�� 
		 Demo01 demEnt = new Demo01();
		 //���ø��� ����
		 demEnt.hello1();
		 
		 demEnt.hello3();
		 
		 //ȡ�� �������� ���ʵ� ����(���� ����)
		 //super.
		 
		 //�������෽��
		 demEnt.methodOne();
		 
	}
	
	public void hello3(){
		System.out.println("���� ����� hello3 ����������");
	}
	 
	
	/**
	 * �Ǿ�̬�� ��ͨ ����
	 */
	public void methodOne(){
		//��ȡ ����ķ��� ����
		super.modName = "���� ��������";
		System.out.println("super.modName==>"+super.modName);
		super.hello1();
		super.hello3();
		
		this.hello3();
	} 
	 
}
