package Vehicle;

public class Test {
	public static void main(String[] args) {
		Car car = new Car();
		String str=car.NumOfWheels();
		System.out.println(str);
		System.out.println("###########");
		
		Motorbike motorbike = new Motorbike();
		String str1 = motorbike.NumOfWheels();
		System.out.println(str1);
		
	}
}
