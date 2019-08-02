package HomeWork8_3;

public class SpecialTeacher extends Teacher implements TeacherPay{

	@Override
	public void getPay() {
		System.out.println("工资发放给特级教师");
		
	}

	@Override
	void physics() {
		System.out.println(getName()+"特级老师教物理");
		
	}

	@Override
	void math() {
		System.out.println(getName()+"特级老师教数学");
		
	}

	@Override
	void sport() {
		System.out.println(getName()+"特级老师教体育");
		
	}

}
