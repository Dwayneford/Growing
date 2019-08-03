package StaticTest;
/**
 * 练习三：Static关键字与普通变量的区别：   
创建一个名称为StaticDemo的类，并声明一个静态变量和一个普通变量。
对变量分别赋予10 和5的初始值。
再创建 多个StaticDemo类对象,通过对象给变量赋值,
在main()方法中调用输出变量值。

 * @author Administrator
 *
 */
public class StaticDemo {

	private static int a=10;
	protected int b=5;
	
	
	public static int getA() {
		return a;
	}
	public static void setA(int a) {
		StaticDemo.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	
	
	public StaticDemo(int b) {
		super();
		this.b = b;
	}
	public StaticDemo() {
		super();
	}
	
	
	void show(){
		System.out.println("静态a(10)===》"+getA()+"  ;非静态b(5)===》"+getB());
	}
	
	
	
}
