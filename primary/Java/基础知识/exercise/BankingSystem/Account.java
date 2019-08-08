package BankingSystem;

public class Account {

	private double balance;

	public Account(double balance) {
		super();
		this.balance = balance;
		System.out.println("Creating an account with a "+this.geBalance()+" balance");
	}

//	public Account() {
//		super();
//	}
	//ªÒ»°”‡∂Ó
	double geBalance(){
		System.out.println("The account has a balance of "+balance);
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
	
	
}
