package Picture;

public class Rectangle extends Picture{



	@Override
	void darw() {
		System.out.println("画一个长方形,能否对称："+isSymmetry());
		
	}

}
