package HomeWork8_3;

public class GeneralTeachers extends Teacher implements TeacherPay{

	public GeneralTeachers(String name) {
		this.setName(name);
	}
	public GeneralTeachers() {
		
	}

	@Override
	void physics() {
	System.out.println(getName()+"��ͨ��ʦ������");
		
	}

	@Override
	void math() {
		System.out.println(getName()+"��ͨ��ʦ����ѧ");
		
	}

	@Override
	void sport() {
		System.out.println(getName()+"��ͨ��ʦ������");
		
	}

	@Override
	public void getPay() {
		System.out.println("���ʷ��Ÿ���ͨ��ʦ");
		
	}

}
