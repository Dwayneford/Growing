package IO.HomeWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//∏¥÷∆Õº∆¨
public class HomeWork6 {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("D:/IO≤‚ ‘/test.png");
		FileOutputStream fos =new FileOutputStream("D:/temp/test.png");
		byte[] buffer = new byte[1024];
		int temp = 0;
		while ((temp=fis.read(buffer)) != -1) {
			fos.write(buffer, 0, temp);
		}
		fis.close();
		fos.close();
		
	}
	
	
}
