package com.baidu.mapping;

public class Animal {
	//�������еĵ� һЩ ��������
	private String an_name;
	private int an_age;
	private String an_color;
	private String an_weight;
	private String an_type;
	//......
	
	public String getAn_name() {
		return an_name;
	}

	public void setAn_name(String an_name) {
		this.an_name = an_name;
	}

	public int getAn_age() {
		return an_age;
	}

	public void setAn_age(int an_age) {
		this.an_age = an_age;
	}

	public String getAn_color() {
		return an_color;
	}

	public void setAn_color(String an_color) {
		this.an_color = an_color;
	}

	public String getAn_weight() {
		return an_weight;
	}

	public void setAn_weight(String an_weight) {
		this.an_weight = an_weight;
	}

	public String getAn_type() {
		return an_type;
	}

	public void setAn_type(String an_type) {
		this.an_type = an_type;
	}

	
	//���캯��
	public Animal() {
		super();
		System.out.println("���� animal����޲ι��캯��������");
		
	}

	public Animal(String an_name, int an_age, String an_color, String an_weight, String an_type) {
		super();
		this.an_name = an_name;
		this.an_age = an_age;
		this.an_color = an_color;
		this.an_weight = an_weight;
		this.an_type = an_type;
	}

	//�������еĵ� һЩ ��������
	public void anEat(){
		System.out.println("�Զ���..");
	}
	
	/**
	 * �ڿɷ��ʵ� ������ ���ã�˽�е� ���� �� ������������ʹ��
	 */
	public void anSleep(){
		//���õ�ǰ�����ѧϰ ������
		this.learning();
		
		System.out.println("˯������Ϊ....");
	}
	//.......
	
	//�������̳еķ��� д�� ˽�е� 
	private  String learning(){
		String str = "����� learn ����.. ��һ�����в��ܱ��̳� ʹ�õķ�����";
		return str;
	}
	/**
	 * final ���εķ��� �ǲ����� ����д��
	 *    	  ���εı��� ���ܱ����¸�ֵ
	 *       ���ε��� ���ܱ��̳�
	 */
	protected final void run(){
		System.out.println("���� ������Ϊ������");
	}
	/**
	 * ��̬�����
	 */
	static{
		System.out.println("���� animal��ľ�̬����飡����");
	}
	
}
