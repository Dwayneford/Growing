package homeWork7_31;
import java.util.Scanner;

public class guess {
	
	public static void main(String[] args) {
		
		
		boolean flag = true ;
		
	    while(flag) {
	    	System.out.println("������һ�����ֽ��бȽϣ�");
	        Scanner input = new Scanner(System.in);
	        int i = input.nextInt();
	        
	        A a= new A();

			if (i > a.v) {
	            System.out.println("����������ִ��ˣ�");
	        } else if (i == a.v) {
	            System.out.println("���¶��ˣ�");
	            flag = false ;
	            input.close();
	        } else {
	            System.out.println("�����������С�ˣ�");
	        }
	    }
		
		
	}

	
	
	
}

