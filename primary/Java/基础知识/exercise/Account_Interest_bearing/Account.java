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
	//方法
	public void withdraw (double amount){
		if (amount>balance) {
			System.out.println("余额不足！");
		}else{
			balance-=amount;
		}
		System.out.println("您的余额为："+balance);
	}
	
	public void deposit (double amount){
		balance+=amount;
		System.out.println("您的余额为："+balance);
		System.out.println("月利率为："+annualInterestRate/(12*100));
	}
	
	
	
	
}
