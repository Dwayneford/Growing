package Account_Interest_bearing;

public class CheckAccount extends Account {

	private double overdraft;

	
	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
		super(id, balance, annualInterestRate);
		this.overdraft = overdraft;
		 this.setBalance(balance);
	}



	@Override
	public void withdraw(double amount) {

		if (amount<this.getBalance()) {
			this.setBalance(this.getBalance()-amount);
			System.out.println("�����˻����Ϊ��"+this.getBalance());
			System.out.println("���Ŀ�͸֧���Ϊ��"+overdraft);
			
		} else if((this.getBalance()+this.overdraft-amount)>=0){
			this.overdraft=(this.getBalance()-amount+this.overdraft);
            this.setBalance(0);
            System.out.println("�����˻����Ϊ��"+this.getBalance());
			System.out.println("���Ŀ�͸֧���Ϊ��"+overdraft);
		}else{
			System.out.println("������͸֧�޶");
		}
	}

	
	
	
	
}
