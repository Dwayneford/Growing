package homeWork7_31;

public class Vehicle {
	
	public static void main(String[] args) {
		
		Vehicle  car= new Vehicle();
		car.setSpeed(100);
		car.move();
		
		car.speedUp(10);
		car.speedDown(50);
	}
	

	double speed ;
	double size;
	
	void move(){
		System.out.println("Ŀǰ���ƶ��ٶ�Ϊ��"+speed);
		
	}
	//�����ٶ�
	int setSpeed(int speed){
		this.speed=speed;	
		return speed;		
	}
	//����
	int speedUp(int add){
		System.out.println("�Ѽ���"+add);		
		speed+=add;
		this.move();
		return (int) speed;
	}
	//����
	int speedDown(int down){
		System.out.println("�Ѽ���"+down);		
		speed-=down;
		this.move();
		return (int) speed;
		
	}
}
