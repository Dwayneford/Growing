package IO.HomeWork;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HomeWork1 {

	public static void main(String[] args) throws Exception {
		File f = new File("D:/IO测试"); 
		f.mkdir();
		File f2 = new File("D:/IO测试/IO测试.txt");
		f2.createNewFile();
		
		String str = "我的名字是杜亚彬";
		FileWriter fw = new FileWriter(f2);		
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(str);
		bw.flush();
		fw.close();
		System.out.println("文件内容写入成功！");
		System.out.println("文件信息如下：");
		
		System.out.println("文件最后的修改日期："+f2.lastModified());
		System.out.println("文件名："+f2.getName());
		System.out.println("所在文件夹："+f2.getPath());
		
	}
}
