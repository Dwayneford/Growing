package com.jjfk.tagsupport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class FormatTimeTag extends TagSupport{
	// yyyy- 年...  属性
	private String format;
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	//执行函数
	@Override
	public int doStartTag() throws JspException {
		
		SimpleDateFormat sdf =	new SimpleDateFormat(format);
		
		String date = sdf.format(new Date());
		
		JspWriter out = pageContext.getOut();
		 try {
			out.print(date);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.SKIP_BODY;
	}
	
	
	
	
	
	
}
