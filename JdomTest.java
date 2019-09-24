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


//xml�ļ���ɾ�Ķ���������jdom
/**
 * ���÷���:
 *  SAXBuilder.build(FileInputStream("*.xml");������ȡxml�ļ�������Documentʵ��(��xml�ļ�)
	Element.getChildren();������ȡ�ýڵ�������ֽڵ㣬����List
	Element.getChild("child�ڵ���");������ȡ�ֽڵ�ʵ��
	Element.getAttribute("������");������ȡ�ýڵ����Ե�valueֵ(ƽ��ʽ�ڵ�)
	Element.getText();������ȡ�ýڵ�Ľڵ��ı�
	Document(new Element("���ڵ���"));�����½�xml�ļ��ĵ�
	Document.getRootElement();������ȡ���ڵ�
	Element.addContent(Element);��������ӽڵ�
	Element.setAttribute("������","����ֵ");������ӽڵ�����
	Element.setText("�ı�ֵ");������Ӹýڵ���ı�ֵ
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
	
	//��ȡxmlԪ�ط���
	public static void readxml() throws FileNotFoundException, JDOMException, IOException{
		//��ȡxml�ļ�
		SAXBuilder sb = new SAXBuilder();
		Document docu = sb.build(new FileInputStream(new File("D://studentXML2.xml")));
		//��ȡĿ¼
		Element root = docu.getRootElement();
		//��ȡ��Ŀ¼�е���Ԫ��
		List<Element> list = root.getChildren();
		//��������
		for (Element stu : list) {
			//��ȡ����
//			String attr = stu.getAttributeValue(null);
			//ȡ����
			String id = stu.getChildText("sID");
			String name = stu.getChildText("sName");
			String age = stu.getChildText("sAge");
			String sex = stu.getChildText("sSex");
			//�����ӡ
			System.out.println("sID=="+id+"sName=="+name+"age=="+id+"sSex=="+sex);
						
		}
	}
	
	
	//�޸�xml�ĵ�����
	public static void updatexml() throws FileNotFoundException, JDOMException, IOException{
		//��ȡxml�ļ�
		SAXBuilder sb = new SAXBuilder();
		Document docu = sb.build(new FileInputStream(new File("D://studentXML2.xml")));
		//��ȡĿ¼
		Element root = docu.getRootElement();
		//��ȡ��Ŀ¼�е���Ԫ��
		List<Element> list = root.getChildren();
		//��������
		for (Element stu : list) {
			//��ȡid
			String uid = stu.getChild("sID").getText();
			if ("1001".equals(uid)) {
				stu.getChild("sAge").setText("366");

			}			
		}
		//���޸ĺ�����ݷŵ��ĵ���
		XMLOutputter xo = new XMLOutputter();
		xo.output(docu, new FileOutputStream(new File("D://studentXML2.xml")));		
	}
	
	
	//ɾ��xmlԪ�ط���
	public static void deletexml() throws FileNotFoundException, JDOMException, IOException{
		//��ȡxml�ļ�
		SAXBuilder sb = new SAXBuilder();
		Document docu = sb.build(new FileInputStream(new File("D://studentXML2.xml")));
		//��ȡĿ¼
		Element root = docu.getRootElement();
		//��ȡ��Ŀ¼�е���Ԫ��
		List<Element> list = root.getChildren();
		//��������
		for (Element stu : list) {
			//��ȡid
			String uid = stu.getChild("sID").getText();
			if ("1001".equals(uid)) {
				root.removeContent(stu);

			}			
		}
		//��ɾ��������ݷŵ��ĵ���
		XMLOutputter xo = new XMLOutputter();
		xo.output(docu, new FileOutputStream(new File("D://studentXML2.xml")));		
	}	
	
	
	//����xml�ĵ��ķ���
	public static void creatxml(){
		//�����ĵ�
		Document docu = new Document();
		//������Ŀ¼
		Element root = new Element("root");
		//�����Ӷ���
		Element student3 = new Element("student3");
		//�Ӷ���Ԫ��
			
		Element sID = new Element("sID");
		Element sName = new Element("sName");
		Element sAge = new Element("sAge");
		Element sSex = new Element("sSex");
		
		Element student4 = new Element("student4");
		//�Ӷ���Ԫ��
		Element sID2 = new Element("sID");
		Element sName2 = new Element("sName");
		Element sAge2 = new Element("sAge");
		Element sSex2 = new Element("sSex");
		
		//���ò㼶��ϵ
		
		//����document����
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

		//����ֵ
		student3.setAttribute("sNo","121566");
		sID.setText("1001");
		sName.setText("�ŷ�");
		sAge.setText("52");
		sSex.setText("��");
		
		student4.setAttribute("sNo","12176");
		sID2.setText("1002");
		sName2.setText("����ӱ");
		sAge2.setText("25");
		sSex2.setText("Ů");
		
		
		//���ø�ʽ
		Format format = Format.getPrettyFormat();
		format.setEncoding("utf-8");
		format.setIndent("	");
		
		//��docuд��xml��
		XMLOutputter xo = new XMLOutputter();
		//��Ӧ�ļ�
		try {
			xo.output(docu, new FileOutputStream("D://studentXML2.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}







