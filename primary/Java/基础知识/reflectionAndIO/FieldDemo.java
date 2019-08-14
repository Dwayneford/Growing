package reflectionAndIO;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class FieldDemo {

	public static void main(String[] args) {
		//�����������
		Class teacher =Teacher_1.class;
		//�����������ʵ����
		try {
			Teacher_1 t =(Teacher_1) teacher.newInstance();
			//ʵ��������Ի�ȡ����ͽӿ��е�����
			System.out.println(t.degree);
			System.out.println(t.salary);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println("11111111111111");
		//�õ��ӿڵ�����
		 Field[] fi=teacher.getFields();
		for (Field temp : fi) {
			System.out.println(temp); 
			
		}
		System.out.println("22222222222222222");
		//�õ���ǰ��ĵ�����
		Field[] dfi=teacher.getDeclaredFields();		
		for (Field field : dfi) {
			System.out.println("��ȡ����===>"+field.getName());
			System.out.println("��ȡ����ֵ����ȫ��===>"+field.getType());
			System.out.println("��ȡ����ֵ���ͼ��===>"+field.getType().getSimpleName());
			System.out.println("��ȡ���η�===>"+Modifier.toString(field.getModifiers()));
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
		System.out.println("�̳н��鷽��");
	}
	
}

class Teach{
	int salary=15000;
	String sex;
	
}	

interface ITeach{
	String degree="�߼�";
	boolean flag=true;
	String name="Сzhang";
	void teach();
}




