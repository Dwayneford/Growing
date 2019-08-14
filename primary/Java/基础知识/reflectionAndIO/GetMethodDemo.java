package reflectionAndIO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class GetMethodDemo {
	//��ں���
	public static void main(String[] args) {
		Teacher tea =  new Teacher();
		//������teaClass
		Class teaCalss =tea.getClass();
		
		//ͨ���������ȡ�����ķ������õ���������ķ�����
		Method[] methods = teaCalss.getMethods();
		for (Method method : methods) {
			System.out.println("getMethods()==>"+method);
		}
		System.out.println("###########");
		//ͨ��������õ���ǰ�����еķ���
		methods = teaCalss.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println("getDeclaredMethods()==>"+method);			
			System.out.println("�������η��ţ�"+method.getModifiers()+" "+Modifier.toString(method.getModifiers()));
			System.out.println("�������ƣ�"+method.getName());
			System.out.println("��������ֵ���ͣ�"+method.getReturnType().getSimpleName());
			System.out.println("������������ �б�"+Arrays.asList(method.getParameterTypes()));
		}
		System.out.println("###########");
		//��ȡ ��������
		try {
			Method method = teaCalss.getDeclaredMethod("sayHello");
			//����˽�з����ĵ���
			method.setAccessible(true);
			//ͨ������ķ�����ø÷���
			method.invoke(tea);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
