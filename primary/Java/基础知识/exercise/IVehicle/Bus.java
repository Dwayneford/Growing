package IVehicle;

public class Bus implements IVehicle{

	@Override
	public void start() {
		System.out.println("公交车启动");
		
	}

	@Override
	public void stop() {
		System.out.println("公交车刹车");
		
	}

}
