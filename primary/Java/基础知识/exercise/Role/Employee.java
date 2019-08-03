package Role;

public class Employee extends Role{

	protected int salary;
	static int ID;
	
	
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public static int getID() {
		return ID;
	}
	//静态变量也能set？
	public static void setID(int iD) {
		ID = iD;
	}

	public Employee(String name, int age, String gender, int salary) {
		super(name, age, gender);
		this.salary = salary;
	}

	public Employee(String name, int age, String gender) {
		super(name, age, gender);
	}




	@Override
	void play() {
		System.out.println("员工就别想着玩了，老老实实上班赚钱");
		
	}

	final void sing(){
		System.out.println("此员工能歌善舞！他人无法继承。工资为:"+salary);
	}
	
	
}
