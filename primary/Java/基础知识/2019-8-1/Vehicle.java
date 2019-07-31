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
		System.out.println("目前的移动速度为："+speed);
		
	}
	//设置速度
	int setSpeed(int speed){
		this.speed=speed;	
		return speed;		
	}
	//加速
	int speedUp(int add){
		System.out.println("已加速"+add);		
		speed+=add;
		this.move();
		return (int) speed;
	}
	//减速
	int speedDown(int down){
		System.out.println("已减速"+down);		
		speed-=down;
		this.move();
		return (int) speed;
		
	}
}
