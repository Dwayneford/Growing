package HomeWork8_3;

public class SpecialTeacher extends Teacher implements TeacherPay{

	@Override
	public void getPay() {
		System.out.println("���ʷ��Ÿ��ؼ���ʦ");
		
	}

	@Override
	void physics() {
		System.out.println(getName()+"�ؼ���ʦ������");
		
	}

	@Override
	void math() {
		System.out.println(getName()+"�ؼ���ʦ����ѧ");
		
	}

	@Override
	void sport() {
		System.out.println(getName()+"�ؼ���ʦ������");
		
	}

}
