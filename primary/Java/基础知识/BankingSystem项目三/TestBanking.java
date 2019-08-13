package BankingSystem.copy2;

public class TestBanking {

	public static void main(String[] args) {
		
		System.out.println("###################");
		
		Account account =new Account();
		account.setFirstName("Jane");
		account.setLastName( "Smith");
		Customer cust = new Customer(500.00,account);

		cust.withdraw(150.0);
		cust.deposit(22.5);
		cust.withdraw(47.62);
		cust.withdraw(500);

		cust.geBalance(account);
		
		
		
	}
}
