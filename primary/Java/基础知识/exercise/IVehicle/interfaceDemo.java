package IVehicle;

public class interfaceDemo {
	public static void main(String[] args) {
		Bike bike = new Bike();
		bike.start();
		bike.stop();
		System.out.println("############");
		
		Bus bus = new Bus();
		bus.start();
		bus.stop();
		
	}

}
