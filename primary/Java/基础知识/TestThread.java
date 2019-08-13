package TestThread;

public class TestThread {

	public static void main(String[] args) {
		Service s1= new Service("VIP����");
		Service s2= new Service("��ͨ����");
		Service s3= new Service("Ա������");
		Service s4= new Service("���˴���");
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
					System.out.println(super.getName()+"�����˵���"+tickets+"Ʊ");
					tickets--;					
				}else{
					System.out.println("Ʊ������!");
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
