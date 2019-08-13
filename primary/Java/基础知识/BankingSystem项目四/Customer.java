package BankingSystem.copy3;

public class Customer extends Account{

	public Customer(double balance) {
		super(balance);
		// TODO Auto-generated constructor stub
	}

	private Account account;

	public Customer(double balance, Account account) {
		super(balance);
		this.account = account;
		System.out.println("Creating the customer "+account.getFirstName()+" "+account.getLastName()+".");
		System.out.println("Creating an account with a "+balance+" balance");
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		
		this.account = account;
	}
	
}
