
public class InnerClass {

	public static void main(String[] args) {
		//ֱ�ӵ����ڲ��෽��
		Out o = new Out();
		o.showOfOut();
		System.out.println("############");
		Out.InnerClass oi = new Out().new InnerClass();
		oi.showOfInner();
		System.out.println("############");
		//ͨ����������
		Out.InnerClass oi2 = new Out().new InnerClass();
		oi2.showOfInner2();
		System.out.println("############");
		//�ⲿ�෽�������ڲ��෽��
		Out o2= new Out();
		o2.showOfOut2();
		System.out.println("############");
		//���÷����ڲ��෽��
		Out out = new Out();
		out.showInternalClass("���Ǵ��ݵĲ���");
		
	}
}

class Out{
	//��̬����
	static int ages = 21;
	static String names ="С����";
	//˽������\
	private int agep = 22;
	private String namep="С˽";
	
	//�ⲿ����ͨ����
	void showOfOut(){
		System.out.println("�����ⲿ�෽��");
		System.out.println("--��������:"+names);
		//�����ڲ���˽�����Կ���newһ���ڲ������
		System.out.println("--�����ڲ�������:"+new InnerClass().nameIp);
	}
	//�ⲿ�෽�������ڲ��෽��
	void showOfOut2(){
		System.out.println("�ⲿ�෽�������ڲ��෽��");
		Out.InnerClass oic = new Out().new InnerClass();
		oic.showOfInner();
	}
	//����һ���ڲ���
	class InnerClass{
		//�ڲ�������
		 int ages = 21;
		 String names ="С����";
		//˽������
		private int agep = 22;
		private String nameIp="С��˽";
		//�ڲ��෽��
		void showOfInner(){
			System.out.println("�����ڲ��෽��");
			//�����ⲿ��˽�����Կ���newһ���ڲ������
			System.out.println("--�����ⲿ�ྲ̬���ԣ�"+new Out().namep);
			System.out.println("--��������:"+names);
		}
		
		void showOfInner2(){
			System.out.println("�ڲ��෽�������ⲿ�෽��");
			new Out().showOfOut();
		}
		
		
		
	}
	
	//����һ�������ڲ��࣬�����ڶ�����
	void showInternalClass(String str){
		//�����е���
		class InternalClass{
			void inShow(){
				System.out.println("���Ƿ����ڲ��෽��");
				System.out.println("���ݵĲ�����"+str);
			}
			
		}
		//�������ڲ���ķ������ó���
		new InternalClass().inShow();
		
	}

	
	
	
}

