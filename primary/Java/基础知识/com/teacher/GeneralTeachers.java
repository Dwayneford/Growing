package HomeWork8_3;

public class GeneralTeachers extends Teacher implements TeacherPay{

	public GeneralTeachers(String name) {
		this.setName(name);
	}
	public GeneralTeachers() {
		
	}

	@Override
	void physics() {
	System.out.println(getName()+"普通老师教物理");
		
	}

	@Override
	void math() {
		System.out.println(getName()+"普通老师教数学");
		
	}

	@Override
	void sport() {
		System.out.println(getName()+"普通老师教体育");
		
	}

	@Override
	public void getPay() {
		System.out.println("工资发放给普通教师");
		
	}

}
