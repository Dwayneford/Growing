package StaticTest;

public class Test {

	public static void main(String[] args) {
		
		StaticDemo s=new StaticDemo();
		s.setA(12);
		s.setB(6);
		s.show();
		
		StaticDemo a=new StaticDemo(7);
		a.show();
	}
	
	
}
