package IO.HomeWork;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HomeWork1 {

	public static void main(String[] args) throws Exception {
		File f = new File("D:/IO����"); 
		f.mkdir();
		File f2 = new File("D:/IO����/IO����.txt");
		f2.createNewFile();
		
		String str = "�ҵ������Ƕ��Ǳ�";
		FileWriter fw = new FileWriter(f2);		
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(str);
		bw.flush();
		fw.close();
		System.out.println("�ļ�����д��ɹ���");
		System.out.println("�ļ���Ϣ���£�");
		
		System.out.println("�ļ������޸����ڣ�"+f2.lastModified());
		System.out.println("�ļ�����"+f2.getName());
		System.out.println("�����ļ��У�"+f2.getPath());
		
	}
}
