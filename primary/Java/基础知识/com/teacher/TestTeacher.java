package HomeWork8_3;

public class TestTeacher {

	public static void main(String[] args) {
		GeneralTeachers g= new GeneralTeachers("����");		
		g.physics();
		g.setName("����");
		g.physics();
		g.getPay();
		
		SpecialTeacher s = new SpecialTeacher();
		s.setName("��׳");
		s.sport();
		
	}
}
