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
	//��̬����Ҳ��set��
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
		System.out.println("Ա���ͱ��������ˣ�����ʵʵ�ϰ�׬Ǯ");
		
	}

	final void sing(){
		System.out.println("��Ա���ܸ����裡�����޷��̳С�����Ϊ:"+salary);
	}
	
	
}
