package reflectionAndIO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class GetMethodDemo {
	//入口函数
	public static void main(String[] args) {
		Teacher tea =  new Teacher();
		//反射类teaClass
		Class teaCalss =tea.getClass();
		
		//通过反射类获取公共的方法，得到包含父类的方法组
		Method[] methods = teaCalss.getMethods();
		for (Method method : methods) {
			System.out.println("getMethods()==>"+method);
		}
		System.out.println("###########");
		//通过反射类得到当前类所有的方法
		methods = teaCalss.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println("getDeclaredMethods()==>"+method);			
			System.out.println("访问修饰符号："+method.getModifiers()+" "+Modifier.toString(method.getModifiers()));
			System.out.println("方法名称："+method.getName());
			System.out.println("方法返回值类型："+method.getReturnType().getSimpleName());
			System.out.println("方法参数类型 列表："+Arrays.asList(method.getParameterTypes()));
		}
		System.out.println("###########");
		//获取 方法对象
		try {
			Method method = teaCalss.getDeclaredMethod("sayHello");
			//开启私有方法的调用
			method.setAccessible(true);
			//通过反射的反射调用该方法
			method.invoke(tea);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
