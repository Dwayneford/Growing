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
			System.out.print(month+"��Ϊ��Ա�������գ����ʼ�һ�٣�");
			return monthlySalary+100;
		}else{
			return monthlySalary;
		}		
	}

	@Override
	public String toString() {
		return  "������"+super.getName()+",Ա���ţ�"+super.getNumber()+"����нΪ��"+monthlySalary +",����Ϊ��"+super.getBirthday();
	}

	
}
