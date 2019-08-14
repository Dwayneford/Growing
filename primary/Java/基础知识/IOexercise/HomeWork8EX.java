package IO.HomeWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HomeWork8EX {

	public static void main(String[] args) {
		File file =new File("D:/workspace");
		scanFiles(file);
	

		
		copyFile("D:/IO����/", "e:/");
		
	}
	//�ݹ�����ļ���
    public static void scanFiles(File file){
        //�ж�·���Ƿ�Ϊ��
        if(file!=null){
            //�ж����ļ��л����ļ�
            if(file.isDirectory()){
                //��õ�ǰ�ļ����������ļ���Ŀ¼
                File[] files=file.listFiles();
                //�ж����ļ������ļ���  ���ݹ��������            
                for (File flies2:files) {
                	scanFiles(flies2);
                }
            }else{
                System.out.println("�ļ�����"+file);
            }
        }else{
            System.out.println("�ļ�������");
        }
    }
	
    
    
    public static void copyFile(String yFileName,String nFileName){
    	
        InputStream input = null;
        OutputStream output = null;
    try {
          yFileName = yFileName.replaceAll("/\\/","\\\\");
          input = new FileInputStream(yFileName);
          output = new FileOutputStream("E:\\Copy\\"+nFileName,true);
          byte[] buf = new byte[1024*1024];
          int bytesRead;
          while ((bytesRead = input.read(buf)) > 0) {
            output.write(buf, 0, bytesRead);
          }

    } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        yFileName = null;
        nFileName = null;
   }

    
    
    
}
