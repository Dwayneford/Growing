package reflectionAndIO;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class FieldDemo {

	public static void main(String[] args) {
		//创建反射对象
		Class teacher =Teacher_1.class;
		//将反射类对象实例化
		try {
			Teacher_1 t =(Teacher_1) teacher.newInstance();
			//实例化后可以获取父类和接口中的属性
			System.out.println(t.degree);
			System.out.println(t.salary);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println("11111111111111");
		//得到接口的属性
		 Field[] fi=teacher.getFields();
		for (Field temp : fi) {
			System.out.println(temp); 
			
		}
		System.out.println("22222222222222222");
		//得到当前类的的属性
		Field[] dfi=teacher.getDeclaredFields();		
		for (Field field : dfi) {
			System.out.println("获取名称===>"+field.getName());
			System.out.println("获取返回值类型全称===>"+field.getType());
			System.out.println("获取返回值类型简称===>"+field.getType().getSimpleName());
			System.out.println("获取修饰符===>"+Modifier.toString(field.getModifiers()));
		}				
		System.out.println("3333333333333333");
		
		Type fit=teacher.getGenericSuperclass();
		System.out.println(fit);
		
		
	}
	
}

class Teacher_1 extends Teach implements ITeach{

	
	protected String teachString;
	@Override
	public void teach() {
		System.out.println("继承教书方法");
	}
	
}

class Teach{
	int salary=15000;
	String sex;
	
}	

interface ITeach{
	String degree="高级";
	boolean flag=true;
	String name="小zhang";
	void teach();
}




