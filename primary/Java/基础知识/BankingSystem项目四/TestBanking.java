package BankingSystem.copy3;

public class TestBanking {

	public static void main(String[] args) {
		
		System.out.println("###################");
		
//		Account account =new Account();
//		account.setFirstName("Jane");
//		account.setLastName( "Smith");
//		Customer cust = new Customer(500.00,account);
//
//		cust.withdraw(150.0);
//		cust.deposit(22.5);
//		cust.withdraw(47.62);
//		cust.withdraw(500);
//
//		cust.geBalance(account);
		
		Bank b= new Bank();
		b.addCustomer("��", "��");
		b.addCustomer("��", "��");
		b.addCustomer("��", "��");
		b.addCustomer("��", "��");
		
		System.out.println("�ͻ�����Ϊ��"+b.getNumOfCustomers());
		
		b.getCustomer();
		
		
	}
}
