package com.Fen;

public class WuMingDeFen {
	
	public static void main(String[] args) {
		
		WuMingDeFen d= new WuMingDeFen("牛肉",3,false);
		d.check();
		
		
		
		System.out.println("#############");
		WuMingDeFen w= new WuMingDeFen();
		w.setLikeSoup(true);
		w.setQuantity(2);
		w.setTheMa("麻辣");
		w.check();
		
		
		
		System.out.println("#############");
		w.check(1);
		w.check("香辣", 2);
		
		
	}
	
	
	
	
	private String theMa;
	private int quantity;
	private boolean likeSoup;
	
	


	//封装接口
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

	//构造器
	public WuMingDeFen(String theMa, int quantity, boolean likeSoup) {
		super();
		this.theMa = theMa;
		this.quantity = quantity;
		this.likeSoup = likeSoup;
	}	
	public WuMingDeFen() {
		super();
	}

	//检查方法
	void check(){
		String soup;
		if(likeSoup){
			soup="要汤！";
		}else{
			soup="不要汤！";
		}
		System.out.println("您要的粉是"+theMa+","+quantity+"两,"+soup);
		
	}
	
	
	//用于重载
	void check(int quantity){
		System.out.println("您要的粉是"+quantity+"两。");
		
	}
	
	void check(String theMa){
		System.out.println("您要的粉是"+theMa);
		
	}
	
	
	void check(boolean likeSoup){
		String soup;
		if(likeSoup){
			soup="要汤！";
		}else{
			soup="不要汤！";
		}
		System.out.println("您要的粉是"+soup);
		
	}

	void check(String theMa,int quantity){
		System.out.println("您要的粉是"+theMa+","+quantity+"两。");
		
	}
	
	
	
	
}
