package SalaryManagementSystem;

public class SalariedEmployee extends Employee{

	
	private double monthlySalary;
	
	
	public SalariedEmployee(String name, int number, MyDate birthday) {
		super(name, number, birthday);
	}
	public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
		super(name, number, birthday);
		this.monthlySalary = monthlySalary;
	}
	public double getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}


	@Override
	double earnings(int month) {
		
		if (month==super.getBirthday().getMonth()) {
			System.out.print(month+"月为该员工的生日，工资加一百！");
			return monthlySalary+100;
		}else{
			return monthlySalary;
		}		
	}

	@Override
	public String toString() {
		return  "姓名："+super.getName()+",员工号："+super.getNumber()+"，月薪为："+monthlySalary +",生日为："+super.getBirthday();
	}

	
}
