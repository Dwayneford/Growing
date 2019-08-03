package IVehicle;

public class Bike implements IVehicle {

	@Override
	public void start() {
		System.out.println("自行车启动");

	}

	@Override
	public void stop() {
		System.out.println("自行车刹车");

	}

}
