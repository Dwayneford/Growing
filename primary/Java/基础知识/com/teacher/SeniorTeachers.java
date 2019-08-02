package HomeWork8_3;

public class SeniorTeachers extends Teacher implements TeacherPay{

	@Override
	void physics() {
		System.out.println(getName()+"高级老师教物理");
		
	}

	@Override
	void math() {
		System.out.println(getName()+"高级老师教数学");
		
	}

	@Override
	void sport() {
		System.out.println(getName()+"高级老师教体育");
		
	}

	@Override
	public void getPay() {
		System.out.println("工资发放给高级教师");
		
	}

	
}
