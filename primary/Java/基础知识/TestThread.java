package TestThread;

public class TestThread {

	public static void main(String[] args) {
		Service s1= new Service("VIP窗口");
		Service s2= new Service("普通窗口");
		Service s3= new Service("员工窗口");
		Service s4= new Service("军人窗口");
		s1.start();
		s2.start();
		s3.start();
		s4.start();
	}
}

class Service extends Thread{
	
	static int tickets = 100;	
	public Service(String name ){
		super(name);
	}
	
	Object ob = "";
	@Override
	public void run() {
		while (tickets>0) {			
			synchronized (ob) {				
				if (tickets>0) {
					System.out.println(super.getName()+"卖出了第张"+tickets+"票");
					tickets--;					
				}else{
					System.out.println("票已售罄!");
				}
				
				try {
					this.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}		
	}	
}
