package PurificationOfWater;

public class PurifiedWater extends RawWater implements process{

	
	
	@Override
	void takeWater() {
		System.out.println("首先取水");
		
	}
	@Override
	public void filter() {
		System.out.println("处理过程：过滤");
		
	}

	@Override
	public void buffer() {
		System.out.println("处理过程：缓冲");
		
	}

	@Override
	public void warm() {
		System.out.println("处理过程：加热");
		
	}

	@Override
	public void putSuger() {
		System.out.println("处理过程：放糖");
		
	}



}
