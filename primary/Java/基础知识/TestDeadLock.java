package deadlock.deadlock;

public class TestDeadLock {

	public static void main(String[] args) {
//		System.out.println("1111111111");
		Makeup makeup1= new Makeup();
		makeup1.girl="���";
		makeup1.flag=true;
//		System.out.println("2222222222222");
		Makeup makeup2= new Makeup();
		makeup2.girl="ܽ�ؽ��";
		makeup2.flag=false;
		makeup1.start();
//		System.out.println("333333333333");
		makeup2.start();
	}
}
//�ں���
class Lipstick{
	
}
//������
class Mirror{
	
}
//��ױ��
class Makeup extends Thread{
	boolean flag;
	String girl;
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror =new Mirror();
	
	public void run() {
        doMakeup();
    }
	
	void doMakeup(){
		if (flag) {
			synchronized (lipstick) {
				System.out.println(girl+"���ſں죡");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (mirror) {
					System.out.println(girl+"���ž��ӣ�");
				}			
			}
		}else {
			synchronized (mirror) {
				System.out.println(girl+"���ž��ӣ�");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lipstick) {
					System.out.println(girl+"���ſں죡");
				}	
			}			
		}		
	}	
}










