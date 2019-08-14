package reflectionAndIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
//Àà¼ÓÔØÆ÷
public class ClassLoader {

	public static void main(String[] args) {
		ClassLoader clazz=new ClassLoader();
		Class clazz1= clazz.getClass();
		URL url =clazz1.getClassLoader().getResource("exception.txt");
		System.out.println(url);
		InputStream inpt=clazz1.getClassLoader().getResourceAsStream("exception.txt");
		
		try {
			byte[] buffer = new byte[inpt.available()];
			inpt.read(buffer);
			System.out.println("new String(buffer)===>"+new String(buffer));
			inpt.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		
		
	}
	
	
}
