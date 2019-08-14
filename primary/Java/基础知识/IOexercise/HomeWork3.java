package IO.HomeWork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HomeWork3 {

	public static void main(String[] args) throws Exception {
		File f = new File("D:/IO测试/"); 
		f.mkdir();
		File f2 = new File("D:/IO测试/IO测试2.txt");
		f2.createNewFile();
		
		String str = "2019年08月14日，今天我们学习了Java中文件读写！！！";
		String str2 = "我已经会用FileWriter和BufferedWriter读写文件了";
		FileWriter fw = new FileWriter(f2);		
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(str);
		//换行操作
		bw.newLine();
		bw.write(str2);
		bw.newLine();
		bw.flush();
		fw.close();
		
		
		System.out.println("#########");
		String record =null;
		int recCount =0;
		FileReader fr =new FileReader(f2);
		BufferedReader br =new BufferedReader(fr);
		//readLine()读取一行的方法
		while ((record=br.readLine()) != null) {
			recCount++;
			System.out.println(record);
		}
		
		br.close();
	}
}
