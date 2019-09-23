package com.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class test1 {

	public static void main(String[] args) {
		creatxml();		
	}
	//创建xml文档的方法
	public static void creatxml(){
		//创建文档
		Document docu = new Document();
		//创建根目录
		Element root = new Element("root");
		//创建子对象
		Element student1 = new Element("student1");
		//子对象元素
			
		Element sID = new Element("sID");
		Element sName = new Element("sName");
		Element sAge = new Element("sAge");
		Element sSex = new Element("sSex");
		
		Element student2 = new Element("student2");
//		//子对象元素
		Element sID2 = new Element("sID");
		Element sName2 = new Element("sName");
		Element sAge2 = new Element("sAge");
		Element sSex2 = new Element("sSex");
		
		//设置层级关系
		root.addContent(student1);
		root.addContent(student2);
		
		student1.addContent(sID);
		student1.addContent(sName);
		student1.addContent(sAge);
		student1.addContent(sSex);
		
		student2.addContent(sID2);
		student2.addContent(sName2);
		student2.addContent(sAge2);
		student2.addContent(sSex2);

		//设置值
		student1.setAttribute("sNo","121545");
		sID.setText("1001");
		sName.setText("张靓颖");
		sAge.setText("32");
		sSex.setText("女");
		
		student2.setAttribute("sNo","121546");
		sID2.setText("1002");
		sName2.setText("刘亦菲");
		sAge2.setText("35");
		sSex2.setText("女");
		
		//存入document对象
		docu.addContent(root);
		//设置格式
		Format format = Format.getPrettyFormat();
		format.setEncoding("utf-8");
		format.setIndent("	");
		
		//将docu写入xml中
		XMLOutputter xo = new XMLOutputter();
		//相应文件
		try {
			xo.output(docu, new FileOutputStream("D://studentXML2.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}







