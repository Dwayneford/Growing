package StaticTest;
/**
 * ��ϰ����Static�ؼ�������ͨ����������   
����һ������ΪStaticDemo���࣬������һ����̬������һ����ͨ������
�Ա����ֱ���10 ��5�ĳ�ʼֵ��
�ٴ��� ���StaticDemo�����,ͨ�������������ֵ,
��main()�����е����������ֵ��

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
		System.out.println("��̬a(10)===��"+getA()+"  ;�Ǿ�̬b(5)===��"+getB());
	}
	
	
	
}
