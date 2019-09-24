package com.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


//xml文件增删改读，工具是jdom
/**
 * 常用方法:
 *  SAXBuilder.build(FileInputStream("*.xml");——获取xml文件，返回Document实例(读xml文件)
	Element.getChildren();——获取该节点的所有字节点，返回List
	Element.getChild("child节点名");——获取字节点实例
	Element.getAttribute("属性名");——获取该节点属性的value值(平面式节点)
	Element.getText();——获取该节点的节点文本
	Document(new Element("根节点名"));——新建xml文件文档
	Document.getRootElement();——获取根节点
	Element.addContent(Element);——添加子节点
	Element.setAttribute("属性名","属性值");——添加节点属性
	Element.setText("文本值");——添加该节点的文本值
	XMLOutputter(Format.getPrettyFormat())
	XMLOutputter.output(Document,FileOutPutStream)
 *
 */

public class JdomTest {

	public static void main(String[] args) throws FileNotFoundException, JDOMException, IOException {
		creatxml();	
//		updatexml();
//		deletexml();
//		readxml();
	}
	
	//读取xml元素方法
	public static void readxml() throws FileNotFoundException, JDOMException, IOException{
		//读取xml文件
		SAXBuilder sb = new SAXBuilder();
		Document docu = sb.build(new FileInputStream(new File("D://studentXML2.xml")));
		//获取目录
		Element root = docu.getRootElement();
		//获取根目录中的子元素
		List<Element> list = root.getChildren();
		//遍历操作
		for (Element stu : list) {
			//获取属性
//			String attr = stu.getAttributeValue(null);
			//取内容
			String id = stu.getChildText("sID");
			String name = stu.getChildText("sName");
			String age = stu.getChildText("sAge");
			String sex = stu.getChildText("sSex");
			//输出打印
			System.out.println("sID=="+id+"sName=="+name+"age=="+id+"sSex=="+sex);
						
		}
	}
	
	
	//修改xml文档方法
	public static void updatexml() throws FileNotFoundException, JDOMException, IOException{
		//读取xml文件
		SAXBuilder sb = new SAXBuilder();
		Document docu = sb.build(new FileInputStream(new File("D://studentXML2.xml")));
		//获取目录
		Element root = docu.getRootElement();
		//获取根目录中的子元素
		List<Element> list = root.getChildren();
		//遍历操作
		for (Element stu : list) {
			//获取id
			String uid = stu.getChild("sID").getText();
			if ("1001".equals(uid)) {
				stu.getChild("sAge").setText("366");

			}			
		}
		//将修改后的内容放到文档中
		XMLOutputter xo = new XMLOutputter();
		xo.output(docu, new FileOutputStream(new File("D://studentXML2.xml")));		
	}
	
	
	//删除xml元素方法
	public static void deletexml() throws FileNotFoundException, JDOMException, IOException{
		//读取xml文件
		SAXBuilder sb = new SAXBuilder();
		Document docu = sb.build(new FileInputStream(new File("D://studentXML2.xml")));
		//获取目录
		Element root = docu.getRootElement();
		//获取根目录中的子元素
		List<Element> list = root.getChildren();
		//遍历操作
		for (Element stu : list) {
			//获取id
			String uid = stu.getChild("sID").getText();
			if ("1001".equals(uid)) {
				root.removeContent(stu);

			}			
		}
		//将删除后的内容放到文档中
		XMLOutputter xo = new XMLOutputter();
		xo.output(docu, new FileOutputStream(new File("D://studentXML2.xml")));		
	}	
	
	
	//创建xml文档的方法
	public static void creatxml(){
		//创建文档
		Document docu = new Document();
		//创建根目录
		Element root = new Element("root");
		//创建子对象
		Element student3 = new Element("student3");
		//子对象元素
			
		Element sID = new Element("sID");
		Element sName = new Element("sName");
		Element sAge = new Element("sAge");
		Element sSex = new Element("sSex");
		
		Element student4 = new Element("student4");
		//子对象元素
		Element sID2 = new Element("sID");
		Element sName2 = new Element("sName");
		Element sAge2 = new Element("sAge");
		Element sSex2 = new Element("sSex");
		
		//设置层级关系
		
		//存入document对象
		docu.addContent(root);
		
		root.addContent(student3);
		root.addContent(student4);
		
		student3.addContent(sID);
		student3.addContent(sName);
		student3.addContent(sAge);
		student3.addContent(sSex);
		
		student4.addContent(sID2);
		student4.addContent(sName2);
		student4.addContent(sAge2);
		student4.addContent(sSex2);

		//设置值
		student3.setAttribute("sNo","121566");
		sID.setText("1001");
		sName.setText("张飞");
		sAge.setText("52");
		sSex.setText("男");
		
		student4.setAttribute("sNo","12176");
		sID2.setText("1002");
		sName2.setText("张靓颖");
		sAge2.setText("25");
		sSex2.setText("女");
		
		
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}







