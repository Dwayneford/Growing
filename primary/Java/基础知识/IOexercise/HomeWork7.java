package IO.HomeWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class HomeWork7 {

	public static void main(String[] args) throws Exception {
		//创建以及写入内容
		File f = new File("D:/IO测试/作业7的测试.txt");
		if (f.exists()) {
			System.out.println("文件已经存在！！！");
		}else {
			f.createNewFile();
			System.out.println("文件创建成功！！");
		}
		FileOutputStream fos = new FileOutputStream(f);
		String str = "改文件存在副本！";
		byte[] bt= str.getBytes();
		fos.write(bt);
		fos.close();
		
		//复制
		File f2 = new File("D:/temp/作业7的测试.txt");
		if (f2.exists()) {
			System.out.println("文件已经存在！！！");
		}else {
			f2.createNewFile();
			System.out.println("文件复制成功！！");
		}
		
		FileInputStream fis = new FileInputStream(f);
		FileOutputStream fos2 = new FileOutputStream(f2);
		byte[] buffer = new byte[1024];
		int temp=0;
		while ((temp=fis.read(buffer)) != -1) {
			fos2.write(buffer, 0, temp);
		}
		fis.close();
		fos2.close();
		
		
	}
}
