package SalaryManagementSystem;

public abstract class Employee {
	
	private String name;
	private int number;
	private MyDate birthday;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public MyDate getBirthday() {
		return birthday;
	}
	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}
	
	public Employee(String name, int number, MyDate birthday) {
		super();
		this.name = name;
		this.number = number;
		this.birthday = birthday;
	}
	public Employee() {
		super();
	}
	//抽象方法earning（）；
	abstract double earnings(int month);
	//重写tostring
	@Override
	public String toString() {
		return "[姓名为：" + name + ", 员工号为：" + number + ",生日为" + birthday + "]";
	}

	
}
