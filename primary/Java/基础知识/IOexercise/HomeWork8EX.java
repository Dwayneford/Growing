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
	

		
		copyFile("D:/IO测试/", "e:/");
		
	}
	//递归遍历文件夹
    public static void scanFiles(File file){
        //判断路径是否为空
        if(file!=null){
            //判断是文件夹还是文件
            if(file.isDirectory()){
                //获得当前文件夹下所有文件和目录
                File[] files=file.listFiles();
                //判断是文件还是文件夹  ，递归掉用自身            
                for (File flies2:files) {
                	scanFiles(flies2);
                }
            }else{
                System.out.println("文件名字"+file);
            }
        }else{
            System.out.println("文件不存在");
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
