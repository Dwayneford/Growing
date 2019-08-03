package Drink;

public abstract class Drink {
	
	protected int num;
	
	
	
	public Drink() {
		super();
	}



	public Drink(int num) {
		super();
		this.num = num;
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	abstract void taste();

}
