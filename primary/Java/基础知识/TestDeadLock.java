package deadlock.deadlock;

public class TestDeadLock {

	public static void main(String[] args) {
//		System.out.println("1111111111");
		Makeup makeup1= new Makeup();
		makeup1.girl="凤姐";
		makeup1.flag=true;
//		System.out.println("2222222222222");
		Makeup makeup2= new Makeup();
		makeup2.girl="芙蓉姐姐";
		makeup2.flag=false;
		makeup1.start();
//		System.out.println("333333333333");
		makeup2.start();
	}
}
//口红类
class Lipstick{
	
}
//镜子类
class Mirror{
	
}
//化妆类
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
				System.out.println(girl+"拿着口红！");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (mirror) {
					System.out.println(girl+"拿着镜子！");
				}			
			}
		}else {
			synchronized (mirror) {
				System.out.println(girl+"拿着镜子！");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lipstick) {
					System.out.println(girl+"拿着口红！");
				}	
			}			
		}		
	}	
}










