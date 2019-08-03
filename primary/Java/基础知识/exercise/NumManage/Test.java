package NumManage;

public class Test {

	public static void main(String[] args) {
		NumManage n = new NumManage();
		
		n.compareSize(45, 45);
		n.compareSize(12, 32);
		
		n.isEqual("asdf", "gdfg");
		n.isEqual("asdf", "asdf");
		
		n.multiply(1.05, 231.2, 12.6);
		
	}
	
}
