package Door;

public class SecurityDoor extends Door implements IFunction {

	@Override
	public void theftproof() {
		System.out.println("��������");

	}

	@Override
	public void waterproof() {
		System.out.println("��ˮ����");

	}

	@Override
	public void bulletproof() {
		System.out.println("��������");

	}

	@Override
	public void fireproof() {
		System.out.println("������");

	}

	@Override
	void openDoor() {
		System.out.println("���ţ�");
		
	}

	@Override
	void closeDoor() {
		System.out.println("���ţ�");
		
	}

}
