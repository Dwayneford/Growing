package PurificationOfWater;

public class PurifiedWater extends RawWater implements process{

	
	
	@Override
	void takeWater() {
		System.out.println("����ȡˮ");
		
	}
	@Override
	public void filter() {
		System.out.println("������̣�����");
		
	}

	@Override
	public void buffer() {
		System.out.println("������̣�����");
		
	}

	@Override
	public void warm() {
		System.out.println("������̣�����");
		
	}

	@Override
	public void putSuger() {
		System.out.println("������̣�����");
		
	}



}
