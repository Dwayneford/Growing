package IO.HomeWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class HomeWork7 {

	public static void main(String[] args) throws Exception {
		//�����Լ�д������
		File f = new File("D:/IO����/��ҵ7�Ĳ���.txt");
		if (f.exists()) {
			System.out.println("�ļ��Ѿ����ڣ�����");
		}else {
			f.createNewFile();
			System.out.println("�ļ������ɹ�����");
		}
		FileOutputStream fos = new FileOutputStream(f);
		String str = "���ļ����ڸ�����";
		byte[] bt= str.getBytes();
		fos.write(bt);
		fos.close();
		
		//����
		File f2 = new File("D:/temp/��ҵ7�Ĳ���.txt");
		if (f2.exists()) {
			System.out.println("�ļ��Ѿ����ڣ�����");
		}else {
			f2.createNewFile();
			System.out.println("�ļ����Ƴɹ�����");
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
