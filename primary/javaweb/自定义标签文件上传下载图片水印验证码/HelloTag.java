package com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
/**
 * �����ǩ�࣬�̳�tagsupport����д�����еķ���
 * д�����ļ�����׺Ϊtld�������web-inf
	 <tag>
		<!-- �����ǩ����   -->
		<name>hello</name>
		<!-- ��ǩ��Ӧ��ִ���� -->
		<tag-class>com.tag.HelloTag</tag-class>
		<!-- �Ƿ��б�ǩ�� -->
		<body-content>empty</body-content>
	  </tag>
 *jsp�����ǩ<%@ taglib uri="www.myTag" prefix="ex" %>
 *jspʹ�ñ�ǩ<ex:hello></ex:hello>
 */
public class HelloTag extends TagSupport{

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.print("tagTest,hello world");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
		
	}
	/**
	 * SKIP_BODY ������ʼ�����Ĵ��룬ֱ���������
	 * EVAL_BODY_AGAIN ����ѭ��ʱ�ظ�ִ��
	 * EVAL_BODY_INCLUDE ��body�е������������ǰ���������
	 * SKIP_PAGE ����ʣ���ҳ������
	 * EVAL_PAGE ����ִ��ʣ���ҳ�����
	 */
	
}
