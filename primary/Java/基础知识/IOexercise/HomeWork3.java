package IO.HomeWork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HomeWork3 {

	public static void main(String[] args) throws Exception {
		File f = new File("D:/IO����/"); 
		f.mkdir();
		File f2 = new File("D:/IO����/IO����2.txt");
		f2.createNewFile();
		
		String str = "2019��08��14�գ���������ѧϰ��Java���ļ���д������";
		String str2 = "���Ѿ�����FileWriter��BufferedWriter��д�ļ���";
		FileWriter fw = new FileWriter(f2);		
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(str);
		//���в���
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
		//readLine()��ȡһ�еķ���
		while ((record=br.readLine()) != null) {
			recCount++;
			System.out.println(record);
		}
		
		br.close();
	}
}
