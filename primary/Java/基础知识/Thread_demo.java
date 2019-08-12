package com.yc123.test;
/**
 * 线程的表述：
 * 		进程：计算机中的每一个正在执行的程序就是一个进程，一个进程有一个 或者多个线程；
 * 			每个应用中的线程 可以同时执行多个不同操作；
 * 
 * 例如：
 * 	开发工具：myEclipse：
 * 		
 * 
 * 
 * Java中线程的实现方式:
 * 		两种：
 * 		第一种：继承therad类 重写 run() 方法，创建子类对象实现线程调用
 * 			  eg：new Thread 或者子类对象，开始线程：对象.start();
 * 		
 * 		第二种：实现 Runnable接口();
 * 			开启线程 调用 start();
 * 
 * 		线程的 特性：
 * 			原子性：
 * 			可见性：
 * 			有序性：
 * 			结果无序：
 * 
 * @author direct
 */

public class Thread_demo {
	public static void main(String[] args) {
		//创建对象
		Booking bk1 = new Booking("一号窗口");
		Booking bk2 = new Booking("老年人窗口");
		Booking bk3 = new Booking("军人窗口");
		Booking bk4 = new Booking("VIP窗口");
		
		//开始启用线程
		bk1.start();
		bk2.start();
		bk3.start();
		bk4.start();
	}
}

/**
 * 售票操作
 * @author direct
 */
class Booking extends Thread{
	//构造 函数
	public Booking(String name){
		super(name);
	}
	//定义变量
	static int pices=100;
	// 定义一个同步对象
	Object ob="aa";
	
	//重写 run方法，买票
	@Override
	public void run() {
		while(pices>0){
			//执行 代码加锁
			synchronized (ob) {
				if(pices>0){
					System.out.println(super.getName()+"---> 买出了第"+pices+"张票");
					pices--;
				}else{
					System.out.println("票已售罄！！！");
				}
				
				//线程休息 10毫秒
				try {
					this.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
		}				
		//super.run();
	}
	
	
}
























