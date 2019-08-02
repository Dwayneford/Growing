package HomeWork8_3;

public class TestTeacher {

	public static void main(String[] args) {
		GeneralTeachers g= new GeneralTeachers("张三");		
		g.physics();
		g.setName("李四");
		g.physics();
		g.getPay();
		
		SpecialTeacher s = new SpecialTeacher();
		s.setName("大壮");
		s.sport();
		
	}
}
