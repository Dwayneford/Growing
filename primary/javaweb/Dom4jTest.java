package com.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

//dom4j操作
public class Dom4jTest {

	public static void main(String[] args) throws DocumentException {
//		readxmlDom4j();
		creatXMLdom4j();
	}
	
	
	//读取xml文档
	public static void readxmlDom4j() throws DocumentException{
		SAXReader sr = new SAXReader();
		Document docu = sr.read(new File("D://studentXML2.xml"));
		//获取根元素
		Element root = docu.getRootElement();
		System.out.println("ROOT==="+root.getName());
		//获取所有子元素
		List<Element> student = root.elements();
		System.out.println("子元素数量:"+student.size());
		//迭代输出
		for (Element element : student) {
//			System.out.println(element.attributeValue("attr"));
			System.out.println(element.elementText("sName")+":"+element.elementText("sAge")+"岁");
		}
		
	}
	
	
	
	//写入xml文档
	public static void creatXMLdom4j(){
		Document docu = DocumentHelper.createDocument();
		Element root = docu.addElement("root");
		root.addElement("code").setText("1");
		Element data = root.addElement("data");
		
		Element person1 = data.addElement("person");
		person1.addElement("name").setText("张飞");
		person1.addElement("age").setText("63");
		person1.addElement("sex").setText("man");
		
		Element courses1 = person1.addElement("courses");
        Element course1 = courses1.addElement("course");
        course1.addElement("courseName").setText("chinaese");
        course1.addElement("courseMarks").setText("90");
        course1.addElement("courseId").setText("1");
        Element course2 = courses1.addElement("course");
        course2.addElement("courseName").setText("math");
        course2.addElement("courseMarks").setText("80");
        course2.addElement("courseId").setText("2");
        Element course3 = courses1.addElement("course");
        course3.addElement("courseName").setText("english");
        course3.addElement("courseMarks").setText("70");
        course3.addElement("courseId").setText("3");
		
        try {
			XMLWriter writer = new XMLWriter(new FileOutputStream("D://dom4jTest.xml"));
			writer.write(docu);
			writer.close();
        
        
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
       
	}
	
	
	
}
