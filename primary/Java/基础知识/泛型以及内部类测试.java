package GenericParadigm;

/**
 * 集合：存放java中任意对象的容器，集合分为多个类型每个集合对象，存放的元素特点各不相同；
 * 
 * 加入泛型之后：
 * 		只根据泛型指定的一种类型存放元素；
 * 		优势：
 * 			提供程序的安全性；
 * 			将程序运行时错误转移到编译期间；
 * 			使用集合中的对象不需要强制转型
 * 		使用场景：
 * 			1、集合中使用泛型，指定数据类型，集合以后只能存放该类型的元素，
 * 			2、在类和方法中指定，在类中指定泛型，类中的方法均可以使用类指定的泛型，
 * 				也可以重新定义数据类型
 * 			3、接口中通过泛型定义数据类型，实现接口的同时，实现类的数据类型必须和接口的一致，
 * 				接口中的方法必须全部实现，数据类型参考第二条；
 
 */
public class GenericsDemo {
	//定义一个内部内接口
	interface MyInterface<T>{
		void showT(T t);
		<U> void sayT();
	}
	//实现一个内部类接口
	class MyInterTest<T> implements MyInterface<T>{
		//继承两个方法
		@Override
		public void showT(T t) {
			System.out.println("继承内部类接口showT方法："+t);		
		}
		@Override
		public  void sayT() {
			System.out.println("继承内部类接口sayT");			
		}

		//自定义内部类方法
		<U> void diy(U u){
			System.out.println("自定义的内部类方法："+u);
		}
		
	}
	//外部类方法！用于调用内部类
	void diaoyong(){
		MyInterTest mt = new MyInterTest();
		mt.sayT();
		mt.showT(88);
		mt.diy("diy自定义传入的测试参数");
	}
	
	public static void main(String[] args) {
		GenericsDemo gd= new GenericsDemo();
		gd.diaoyong();
		
		testGen<stut> gdt = new testGen<stut>();
		gdt.sayOutClass("sadasgasg");
		gdt.sayOutClass(new stut("小王"));
	}
	
}

//外部类，泛型类
class testGen<T>{
	public void showOutClass(T t){
		System.out.println("外部类泛型方法"+t);
	}
	<S> void sayOutClass(S s){
		System.out.println(s);
	}
	
}

class stut{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public stut(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "stut [name=" + name + "]";
	}
	
}



