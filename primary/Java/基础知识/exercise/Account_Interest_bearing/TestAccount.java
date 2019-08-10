package Account_Interest_bearing;

public class TestAccount {

	public static void main(String[] args) {
		Account a = new Account(1122, 20000, 4.5);
		a.withdraw(30000);
		a.withdraw(2500);
		a.deposit(3000);
		
	}
}
