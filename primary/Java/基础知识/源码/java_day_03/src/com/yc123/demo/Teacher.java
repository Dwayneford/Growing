package com.yc123.demo;
/**
 * �ؼ��ֵ�ʹ�ã�
 * 	this����ָ�������� ��ǰ������;
 *  super���������ͨ��super�ؼ��� �ܹ�ȡ�� ���������У�������ʵ� ���� ���Ժͷ�����
 *  
 *  static�� 1.���� ���� ������  �����: �����ε����ݲ���Ҫ ͨ�����������ã�ͨ��������.�����ε����ݣ�
 *  	    2.�ھ�̬������ ����ʹ�þ�̬��Ա���� �����ߵ��� ��̬������
 *  		3.��̬��Ա���� ��̬ �����๲����������ĳһ������
 *  	    4.�ھ�̬�� �����в���ʹ�� �ؼ��� this;
 *       ע�⣺ȫ�� ����/���� �����������ı�����ԣ�ҵ�����飻
 *  final������ �������� �����ԣ�
 *  		��final���ε����� ��Ϊ����������ֻ�ܱ���ֵһ�Σ����Ʊ����Ǵ�д;
 *  		��final���εķ��� ���ܱ���д��
 *  		final���η�һ��� static һ��ʹ�á�
 * 
 * @author direct
 *
 */
public class Teacher {
	//˽�� �ĳ�Ա ���������е��������� ������һ��Ĭ�� ֵ�� 
	private String name;
	private String advanced;
	private int age;
	//���� ��̬ ���ʱ���
	public static double salary = 9000;
	
	//���峣��
	public static final String ADDRESS_CODE="AD_21053_CHANI";
	
	
	public static void main(String[] args) {
		//����ʹ�� �� ��̬����
		//System.out.println(age);
		//getName();
	}
	
	//get  set  ����
	public  String getName() {
		// �ֲ�������û��Ĭ��ֵ�������Ҫʹ�ñ��� ����ʼֵ;
		int score;
		
		return name;
	}
	/**
	 * set���� ��������Ϊname�Ĳ�������ֵ������ǰ�����name���ԣ�
	 * 
	 * ��ͬ�Ĳ������� ��һ��ԭ�򣺾ͽ�ԭ��
	 * @param name
	 */
	public void setName(String tec_nam) {
		// name = name;
		//this.name = name;
		//ʡ��
		name = tec_nam;
	}
	public String getAdvanced() {
		return advanced;
	}
	public void setAdvanced(String advanced) {
		this.advanced = advanced;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
