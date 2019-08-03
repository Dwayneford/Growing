package Auto;

public class Auto {
	
	private int NumOfTires;
	private String colour;
	private double weight;   //重量
	private boolean passenger ; //能否载人
	private int speed =0;
	
	
	
	
	
	public Auto() {
		super();
	}
	public Auto(int numOfTires, String colour, double weight, boolean passenger) {
		super();
		NumOfTires = numOfTires;
		this.colour = colour;
		this.weight = weight;
		this.passenger = passenger;
	}
	public int getNumOfTires() {
		return NumOfTires;
	}
	public void setNumOfTires(int numOfTires) {
		NumOfTires = numOfTires;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public boolean isPassenger() {
		return passenger;
	}
	public void setPassenger(boolean passenger) {
		this.passenger = passenger;
	}
	
	

	//加速方法
	int  speedUp(int add){
		speed+=add;
		System.out.println("已经加速："+add+"目前的速度为"+speed);
		return speed;
		
	}
	
	//减速方法
	int  speedDown(int reduce){
		speed-=reduce;
		System.out.println("已经减速："+reduce+"目前的速度为"+speed);
		return speed;
		
	}
		
	//停车方法
	void stop(){
		speed=0;
		System.out.println("父类停车方法！"+"目前的速度为"+speed);
	}
	
	
	
}
