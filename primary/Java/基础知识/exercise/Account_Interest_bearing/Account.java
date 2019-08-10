package Account_Interest_bearing;

public class Account {

	private int id;
	private double balance;
	private double annualInterestRate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public Account(int id, double balance, double annualInterestRate) {
		super();
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	//����
	public void withdraw (double amount){
		if (amount>balance) {
			System.out.println("���㣡");
		}else{
			balance-=amount;
		}
		System.out.println("�������Ϊ��"+balance);
	}
	
	public void deposit (double amount){
		balance+=amount;
		System.out.println("�������Ϊ��"+balance);
		System.out.println("������Ϊ��"+annualInterestRate/(12*100));
	}
	
	
	
	
}
