package com.baidu.mapping;

public class EatGrassAnimal extends Animal {
	//��������
	private String grass_horn;
	
	
	public String getGrass_horn() {
		return grass_horn;
	}
	public void setGrass_horn(String grass_horn) {
		this.grass_horn = grass_horn;
	}

	//���캯��
	public EatGrassAnimal() {
		super();
		System.out.println("����EatGarss ����޲ι��캯��������");
		
	}
	public EatGrassAnimal(String grass_horn) {
		super();
		this.grass_horn = grass_horn;
	}
	
	
	// ��д �Ե� ����
	public void anEat(){
		System.out.println("����ʳ�� ���ʳ��ʳ�� �� ����....");
	}
	
	
	// ��д �ܵ� ����:����д�� ���� �������η�Ȩ�޷�Χ Ӧ�� ���� ���� ���ࣻ 
	/*
	public void run(){
		System.out.println("������д ����� run��Ϊ��������");
	} */

	/**
	 * ��̬�����
	 */
	static{
		System.out.println("���� EatGrass...��ľ�̬����飡����");
	}
}
