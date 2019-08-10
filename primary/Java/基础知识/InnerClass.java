
public class InnerClass {

	public static void main(String[] args) {
		//直接调用内部类方法
		Out o = new Out();
		o.showOfOut();
		System.out.println("############");
		Out.InnerClass oi = new Out().new InnerClass();
		oi.showOfInner();
		System.out.println("############");
		//通过方法调用
		Out.InnerClass oi2 = new Out().new InnerClass();
		oi2.showOfInner2();
		System.out.println("############");
		//外部类方法调用内部类方法
		Out o2= new Out();
		o2.showOfOut2();
		System.out.println("############");
		//调用方法内部类方法
		Out out = new Out();
		out.showInternalClass("这是传递的参数");
		
	}
}

class Out{
	//静态属性
	static int ages = 21;
	static String names ="小静外";
	//私有属性\
	private int agep = 22;
	private String namep="小私";
	
	//外部类普通方法
	void showOfOut(){
		System.out.println("这是外部类方法");
		System.out.println("--自有属性:"+names);
		//调用内部类私有属性可以new一个内部类对象
		System.out.println("--调用内部类属性:"+new InnerClass().nameIp);
	}
	//外部类方法调用内部类方法
	void showOfOut2(){
		System.out.println("外部类方法调用内部类方法");
		Out.InnerClass oic = new Out().new InnerClass();
		oic.showOfInner();
	}
	//定义一个内部类
	class InnerClass{
		//内部类属性
		 int ages = 21;
		 String names ="小静内";
		//私有属性
		private int agep = 22;
		private String nameIp="小内私";
		//内部类方法
		void showOfInner(){
			System.out.println("这是内部类方法");
			//调用外部类私有属性可以new一个内部类对象
			System.out.println("--调用外部类静态属性："+new Out().namep);
			System.out.println("--自有属性:"+names);
		}
		
		void showOfInner2(){
			System.out.println("内部类方法调用外部类方法");
			new Out().showOfOut();
		}
		
		
		
	}
	
	//定义一个方法内部类，方法内定义类
	void showInternalClass(String str){
		//方法中的类
		class InternalClass{
			void inShow(){
				System.out.println("这是方法内部类方法");
				System.out.println("传递的参数："+str);
			}
			
		}
		//将方法内部类的方法调用出来
		new InternalClass().inShow();
		
	}

	
	
	
}

