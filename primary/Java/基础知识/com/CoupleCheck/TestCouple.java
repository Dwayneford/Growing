package CoupleCheck;

public class TestCouple {
	public static void main(String[] args) {
	
		Person p1 = new PersonImpl("����","��",26,true);
		Person p2 = new PersonImpl("����","��",36,false);
		Person p3 = new PersonImpl("�仨","Ů",33,false);
		Person p4 = new PersonImpl("�Ǳ���","Ů",22,true);
		Person p5 = new PersonImpl("����","Ů",17,true);
		
		
		p1.isCouple(p2);
		p1.isCouple(p3);
		p1.isCouple(p5);
		p1.isCouple(p4);
		
	}
}
