package reflectionAndIO;

import java.lang.reflect.Modifier;

public class TestReflection {

	

	double price = 5.00;
	
	public static void main(String[] args) {
		testReflection();
	}
	
	
	double upupup(){
		return price++;
	}
	
	public static void testReflection(){
		Stock stock = new Stock();
		System.out.println("stock===>"+stock);
		stock.getClass();
		Class clazz= stock.getClass();
		System.out.println("clazz===>"+clazz);
		System.out.println("stock.getClass()===>"+stock.getClass());
		
		try {
			Class clazz2=Class.forName("reflectionAndIO.Stock");
			System.out.println("clazz2===>"+clazz2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("获取类名===>"+clazz.getSimpleName());
		System.out.println("获取修饰符序号===>"+clazz.getModifiers());
		System.out.println("获取修饰符名称===>"+Modifier.toString(clazz.getModifiers()));
		System.out.println("获取包路径===>"+clazz.getPackage());
	}
	
}

  class Stock {
	double price = 5.00;
	
	double upupup(){
		return price++;
	}
	
	
}
