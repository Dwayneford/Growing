package BankingSystem;

public class TestBanking {

	public static void main(String[] args) {
		Account a= new Account(500);
		
		a.deposit(1000);
		a.withdraw(539.7);
		
		a.geBalance();
	}
}
