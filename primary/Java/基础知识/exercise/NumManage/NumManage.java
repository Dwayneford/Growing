package NumManage;
/**
 * ��ϰ����.���췽��������   
����һ���࣬Ϊ���ඨ���������캯�����ֱ�ִ�����в�����   
1��������������ֵ���ҳ����нϴ��һ��ֵ   2����������doubleֵ�������˻�   
3�����������ַ���ֵ��������Ƿ���ͬ   4����main�����в��Թ��캯���ĵ��� 

 * @author Administrator
 *
 */
public class NumManage {

	protected int i;
	protected double d;
	protected String s;
	
	public NumManage(int i, double d, String s) {
		super();
		this.i = i;
		this.d = d;
		this.s = s;
	}

	public NumManage() {
		super();
	}
	
	
	//������������ֵ�Ƚϴ�С
	int compareSize(int a,int b){
		int c;
		if(a>b){
			c=a;
		}else{
			c=b;
		}	
		System.out.println("���ֵΪ��"+c);
		return c;		
	}
	
	//3��doubleֵ��˻�
	double multiply(double a,double b,double c){
		double d;
		d=a*b*c;
		System.out.println("�˻�Ϊ"+d);
		return d;
	}
	
	//���������ַ�����������Ƿ����
	boolean isEqual(String a,String b){
		if(a.equals(b)){
			System.out.println("���");
			return true;
		}else{
			System.out.println("�����");
			return false;
		}										
	}
	
	
	
	
}
