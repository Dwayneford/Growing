package com.Fen;

public class WuMingDeFen {
	
	public static void main(String[] args) {
		
		WuMingDeFen d= new WuMingDeFen("ţ��",3,false);
		d.check();
		
		
		
		System.out.println("#############");
		WuMingDeFen w= new WuMingDeFen();
		w.setLikeSoup(true);
		w.setQuantity(2);
		w.setTheMa("����");
		w.check();
		
		
		
		System.out.println("#############");
		w.check(1);
		w.check("����", 2);
		
		
	}
	
	
	
	
	private String theMa;
	private int quantity;
	private boolean likeSoup;
	
	


	//��װ�ӿ�
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public boolean isLikeSoup() {
		return likeSoup;
	}

	public void setLikeSoup(boolean likeSoup) {
		this.likeSoup = likeSoup;
	}

	public String getTheMa() {
		return theMa;
	}

	public void setTheMa(String theMa) {
		this.theMa = theMa;
	}

	public int getQuantity() {
		return quantity;
	}

	//������
	public WuMingDeFen(String theMa, int quantity, boolean likeSoup) {
		super();
		this.theMa = theMa;
		this.quantity = quantity;
		this.likeSoup = likeSoup;
	}	
	public WuMingDeFen() {
		super();
	}

	//��鷽��
	void check(){
		String soup;
		if(likeSoup){
			soup="Ҫ����";
		}else{
			soup="��Ҫ����";
		}
		System.out.println("��Ҫ�ķ���"+theMa+","+quantity+"��,"+soup);
		
	}
	
	
	//��������
	void check(int quantity){
		System.out.println("��Ҫ�ķ���"+quantity+"����");
		
	}
	
	void check(String theMa){
		System.out.println("��Ҫ�ķ���"+theMa);
		
	}
	
	
	void check(boolean likeSoup){
		String soup;
		if(likeSoup){
			soup="Ҫ����";
		}else{
			soup="��Ҫ����";
		}
		System.out.println("��Ҫ�ķ���"+soup);
		
	}

	void check(String theMa,int quantity){
		System.out.println("��Ҫ�ķ���"+theMa+","+quantity+"����");
		
	}
	
	
	
	
}
