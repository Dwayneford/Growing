package com.baidu.mapping;

public class Sheep extends EatGrassAnimal{
	
	public Sheep(){
		super();
		System.out.println("���� Sheep����޲ι��캯��...");
	}
	
	//��Ϊ
	public void  sheepShout(){
		System.out.println("�������е� ��Ϊ....");
	}
	
	/**
	 * ��̬�����
	 */
	static{
		System.out.println("���� Sheep ��ľ�̬����飡����");
	}
	
}
