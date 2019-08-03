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
		System.out.println("姓名："+getName()+";ID:"+ID+";年龄："+getAge()+";性别："+getGender()+";工资："+getSalary());
	}
	

}
