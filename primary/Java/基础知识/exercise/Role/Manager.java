package Role;

public class Manager extends Employee{

	final int ID=123456789;
	
	
	
	public Manager(String name, int age, String gender, int salary) {
		super(name, age, gender, salary);
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, int age, String gender) {
		super(name, age, gender);
		// TODO Auto-generated constructor stub
	}


	void info(){
		System.out.println("������"+getName()+";ID:"+ID+";���䣺"+getAge()+";�Ա�"+getGender()+";���ʣ�"+getSalary());
	}
	

}
