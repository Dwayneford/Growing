package GenericParadigm;

/**
 * ���ϣ����java�������������������Ϸ�Ϊ�������ÿ�����϶��󣬴�ŵ�Ԫ���ص������ͬ��
 * 
 * ���뷺��֮��
 * 		ֻ���ݷ���ָ����һ�����ʹ��Ԫ�أ�
 * 		���ƣ�
 * 			�ṩ����İ�ȫ�ԣ�
 * 			����������ʱ����ת�Ƶ������ڼ䣻
 * 			ʹ�ü����еĶ�����Ҫǿ��ת��
 * 		ʹ�ó�����
 * 			1��������ʹ�÷��ͣ�ָ���������ͣ������Ժ�ֻ�ܴ�Ÿ����͵�Ԫ�أ�
 * 			2������ͷ�����ָ����������ָ�����ͣ����еķ���������ʹ����ָ���ķ��ͣ�
 * 				Ҳ�������¶�����������
 * 			3���ӿ���ͨ�����Ͷ����������ͣ�ʵ�ֽӿڵ�ͬʱ��ʵ������������ͱ���ͽӿڵ�һ�£�
 * 				�ӿ��еķ�������ȫ��ʵ�֣��������Ͳο��ڶ�����
 
 */
public class GenericsDemo {
	//����һ���ڲ��ڽӿ�
	interface MyInterface<T>{
		void showT(T t);
		<U> void sayT();
	}
	
	class MyInterTest<T> implements MyInterface<T>{

		@Override
		public void showT(T t) {
			System.out.println("�̳�showT������"+t);
			
		}

		@Override
		public  void sayT() {
			System.out.println("�̳�sayT");
			
		}

		//�Զ����ڲ��෽��
		<U> void diy(U u){
			System.out.println("�Զ�����ڲ��෽����"+u);
		}
		
	}
	//�ⲿ�෽�������ڵ����ڲ���
	void diaoyong(){
		MyInterTest mt = new MyInterTest();
		mt.sayT();
		mt.showT(88);
		mt.diy("diy�Զ��崫��Ĳ��Բ���");
	}
	
	public static void main(String[] args) {
		GenericsDemo gd= new GenericsDemo();
		gd.diaoyong();
		
	}
	
}

//�ⲿ��
class testGen<T>{
	
}





