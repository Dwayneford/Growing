package com.yc123.service;

public class Aerocraft {
	//�������� 
	private String material_science;//����
	private String factory;         //���� 
	private String price;           //�۸� 
	private String name;            //���� 
	private String size;            //�ߴ�
	private String weight;          //����
	private String place_of_origin; //���� 
	
	public String getMaterial_science() {
		return material_science;
	}
	public void setMaterial_science(String material_science) {
		this.material_science = material_science;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getPlace_of_origin() {
		return place_of_origin;
	}
	public void setPlace_of_origin(String place_of_origin) {
		this.place_of_origin = place_of_origin;
	}
	
	
	//���캯�� 
	public Aerocraft() {
		super();
	}
	public Aerocraft(String material_science, String factory, String price, String name, String size, String weight,
			String place_of_origin) {
		super();
		this.material_science = material_science;
		this.factory = factory;
		this.price = price;
		this.name = name;
		this.size = size;
		this.weight = weight;
		this.place_of_origin = place_of_origin;
	}
	
	//��������
	public void airFlight(){
		System.out.println("������ �Ĺ��� ���з�����������");
	}
	
	public void aircraftWork(int aerType){
		switch (aerType) {
		case 1:
			System.out.println("��ѧ���졣��������");
			break;
		case 2:
			System.out.println("���б��ݡ���������");
			break;
		case 3:
			System.out.println("���ܾ�������������");
			break;
		default:
			System.out.println("δ֪��������������");
			break;
		}
		
	}

}
