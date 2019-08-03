package Door;

public class SecurityDoor extends Door implements IFunction {

	@Override
	public void theftproof() {
		System.out.println("防盗功能");

	}

	@Override
	public void waterproof() {
		System.out.println("防水功能");

	}

	@Override
	public void bulletproof() {
		System.out.println("防弹功能");

	}

	@Override
	public void fireproof() {
		System.out.println("防火功能");

	}

	@Override
	void openDoor() {
		System.out.println("开门！");
		
	}

	@Override
	void closeDoor() {
		System.out.println("关门！");
		
	}

}
