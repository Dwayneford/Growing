package NumManage;
/**
 * 练习二：.构造方法与重载   
创建一个类，为该类定义三个构造函数，分别执行下列操作：   
1、传递两个整数值并找出其中较大的一个值   2、传递三个double值并求出其乘积   
3、传递两个字符串值并检查其是否相同   4、在main方法中测试构造函数的调用 

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
	
	
	//传递两个整数值比较大小
	int compareSize(int a,int b){
		int c;
		if(a>b){
			c=a;
		}else{
			c=b;
		}	
		System.out.println("最大值为："+c);
		return c;		
	}
	
	//3个double值求乘积
	double multiply(double a,double b,double c){
		double d;
		d=a*b*c;
		System.out.println("乘积为"+d);
		return d;
	}
	
	//传递两个字符串，并检查是否相等
	boolean isEqual(String a,String b){
		if(a.equals(b)){
			System.out.println("相等");
			return true;
		}else{
			System.out.println("不相等");
			return false;
		}										
	}
	
	
	
	
}
