package com.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TimeTag extends TagSupport{

	//yyyy��mm������
//	private String format;
//	
//	public String getFormat() {
//		return format;
//	}
//
//	public void setFormat(String format) {
//		this.format = format;
//	}

	@Override
	public int doStartTag() throws JspException {
		String format = "yyyy��MM��dd�� HH:mm:ss a E";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
			
		JspWriter out = pageContext.getOut();
		try {
			out.print(sdf.format(new Date()));
		} catch (IOException e) {
			System.out.println("��ʾʱ��ʧ��");
			e.printStackTrace();
		}
		
		return super.SKIP_BODY;

		
	}
	
}
//�Զ���ʱ���ǩ����: <ex:timetag  ></ex:timetag>