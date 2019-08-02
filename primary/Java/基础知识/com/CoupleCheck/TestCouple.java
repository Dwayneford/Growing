package CoupleCheck;

public class TestCouple {
	public static void main(String[] args) {
	
		Person p1 = new PersonImpl("张三","男",26,true);
		Person p2 = new PersonImpl("李四","男",36,false);
		Person p3 = new PersonImpl("翠花","女",33,false);
		Person p4 = new PersonImpl("乔碧萝","女",22,true);
		Person p5 = new PersonImpl("阿珂","女",17,true);
		
		
		p1.isCouple(p2);
		p1.isCouple(p3);
		p1.isCouple(p5);
		p1.isCouple(p4);
		
	}
}
