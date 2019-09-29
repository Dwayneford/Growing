package com.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TimeTag extends TagSupport{

	//yyyy年mm月属性
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
		String format = "yyyy年MM月dd日 HH:mm:ss a E";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
			
		JspWriter out = pageContext.getOut();
		try {
			out.print(sdf.format(new Date()));
		} catch (IOException e) {
			System.out.println("显示时间失败");
			e.printStackTrace();
		}
		
		return super.SKIP_BODY;

		
	}
	
}
//自定义时间标签测试: <ex:timetag  ></ex:timetag>