package com.jjfk.tagsupport;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SayHelloTat extends TagSupport{

	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return super.doAfterBody();
	}

	@Override
	public int doStartTag() throws JspException {
		//ҳ����� helloWorld
		JspWriter out = pageContext.getOut();
		try {
			out.print("TagPage,Hello World!!!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * SKIP_BODY:������ʼ �����Ĵ��� ֱ���������
		 * EVAL_BODY_AGAIN:����ѭ�� ʱ �ظ�ִ��
		 * EVAL_BODY_INCLUDE����body�е���������� ��ǰ���������
		 * SKIP_PAGE:����ʣ��� ҳ������
		 * EVAL_PAGE:����ִ�� ʣ���ҳ�����
		 */
		return super.SKIP_BODY;
	}
}
