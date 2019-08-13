package BankingSystem.copy2;

public class Account {

	private static double balance;
	private String firstName;
	private String lastName ;
	private boolean flag;
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
	//»ñÈ¡Óà¶î
	double geBalance(){
		
		System.out.println("The account has a balance of "+balance);
		return balance;		
	}
	double geBalance(Account a){
		System.out.println("Customer ["+a+"] has a balance of "+balance);
		return balance;		
	}
	//´æÇ®
	boolean deposit(double dep){
		balance+=dep;
		flag=true;
		System.out.println("deposit "+dep+":"+flag+" ,balance:"+balance);
		return flag;
	}
	//È¡Ç®
	boolean withdraw (double wit){
		if (balance >= wit) {
			balance -= wit;
			flag=true;
			System.out.println("Withdraw "+wit+":"+flag+" ,balance:"+balance);		
			return flag;
		}else {
			flag=false;
			System.out.println("Withdraw "+wit+":"+flag+" ,balance:"+balance);
			return flag;
		}
		
		
		

		
	}
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	
	
}
