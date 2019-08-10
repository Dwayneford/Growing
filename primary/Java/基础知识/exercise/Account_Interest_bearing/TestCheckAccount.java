package Account_Interest_bearing;

public class TestCheckAccount {

	public static void main(String[] args) {
		CheckAccount ca = new CheckAccount(1122, 20000, 4.5, 5000);
		ca.withdraw(5000);
		ca.withdraw(18000);
		ca.withdraw(3000);
		
	}
}
