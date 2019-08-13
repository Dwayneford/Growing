package BankingSystem.copy3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank {

	int numberOfCustomers=0;
	ArrayList customers=new ArrayList();
	
	void addCustomer (String fn,String ln){
		Account acc= new Account();
		acc.setFirstName(fn);
		acc.setLastName(ln);
		customers.add(acc);
//		numberOfCustomers++;
	}
	
	int getNumOfCustomers (){
		numberOfCustomers=customers.size();
		return numberOfCustomers;
		
	}
	
	void getCustomer(){
		Iterator iter = customers.iterator();
		for (int i = 0; i < customers.size(); i++) {
			Account a=(Account) customers.get(i);
			System.out.println("Customer ["+(i+1)+"] is "+a.getFirstName()+","+a.getLastName());
		}
		
		
//		for (Object object : customers) {
//			Account a= (Account) object;
//			System.out.println(a);
//		}
	}
	
}
