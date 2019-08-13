package BankingSystem.copy;

public class Account {

	private double balance;
	private String firstName;
	private String lastName ;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Account() {
		super();
	}
	public Account(double balance) {
		super();
		this.balance = balance;
		
	}

//	public Account() {
//		super();
//	}
	//ªÒ»°”‡∂Ó
	double geBalance(){
		System.out.println("The account has a balance of "+balance);
		return balance;		
	}
	double geBalance(Account a){
		System.out.println("Customer ["+a+"] has a balance of "+balance);
		return balance;		
	}
	//¥Ê«Æ
	double deposit(double dep){
		balance+=dep;
		System.out.println("deposit "+dep);
		return balance;
	}
	//»°«Æ
	double withdraw (double wit){
		balance-=wit;
		System.out.println("Withdraw "+wit);
		return balance;
		
	}
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	
	
}
