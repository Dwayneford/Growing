package Auto;

public class Auto {
	
	private int NumOfTires;
	private String colour;
	private double weight;   //����
	private boolean passenger ; //�ܷ�����
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
	
	

	//���ٷ���
	int  speedUp(int add){
		speed+=add;
		System.out.println("�Ѿ����٣�"+add+"Ŀǰ���ٶ�Ϊ"+speed);
		return speed;
		
	}
	
	//���ٷ���
	int  speedDown(int reduce){
		speed-=reduce;
		System.out.println("�Ѿ����٣�"+reduce+"Ŀǰ���ٶ�Ϊ"+speed);
		return speed;
		
	}
		
	//ͣ������
	void stop(){
		speed=0;
		System.out.println("����ͣ��������"+"Ŀǰ���ٶ�Ϊ"+speed);
	}
	
	
	
}
