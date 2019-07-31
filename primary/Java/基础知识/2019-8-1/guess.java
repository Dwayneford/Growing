package homeWork7_31;
import java.util.Scanner;

public class guess {
	
	public static void main(String[] args) {
		
		
		boolean flag = true ;
		
	    while(flag) {
	    	System.out.println("请输入一个数字进行比较：");
	        Scanner input = new Scanner(System.in);
	        int i = input.nextInt();
	        
	        A a= new A();

			if (i > a.v) {
	            System.out.println("您输入的数字大了！");
	        } else if (i == a.v) {
	            System.out.println("您猜对了！");
	            flag = false ;
	            input.close();
	        } else {
	            System.out.println("您输入的数字小了！");
	        }
	    }
		
		
	}

	
	
	
}

