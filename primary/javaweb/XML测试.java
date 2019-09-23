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
	//����xml�ĵ��ķ���
	public static void creatxml(){
		//�����ĵ�
		Document docu = new Document();
		//������Ŀ¼
		Element root = new Element("root");
		//�����Ӷ���
		Element student1 = new Element("student1");
		//�Ӷ���Ԫ��
			
		Element sID = new Element("sID");
		Element sName = new Element("sName");
		Element sAge = new Element("sAge");
		Element sSex = new Element("sSex");
		
		Element student2 = new Element("student2");
//		//�Ӷ���Ԫ��
		Element sID2 = new Element("sID");
		Element sName2 = new Element("sName");
		Element sAge2 = new Element("sAge");
		Element sSex2 = new Element("sSex");
		
		//���ò㼶��ϵ
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

		//����ֵ
		student1.setAttribute("sNo","121545");
		sID.setText("1001");
		sName.setText("����ӱ");
		sAge.setText("32");
		sSex.setText("Ů");
		
		student2.setAttribute("sNo","121546");
		sID2.setText("1002");
		sName2.setText("�����");
		sAge2.setText("35");
		sSex2.setText("Ů");
		
		//����document����
		docu.addContent(root);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}







