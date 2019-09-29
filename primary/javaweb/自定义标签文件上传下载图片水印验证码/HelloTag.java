package com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
/**
 * 定义标签类，继承tagsupport，重写父类中的方法
 * 写配置文件，后缀为tld，存放在web-inf
	 <tag>
		<!-- 定义标签名称   -->
		<name>hello</name>
		<!-- 标签对应的执行类 -->
		<tag-class>com.tag.HelloTag</tag-class>
		<!-- 是否有标签体 -->
		<body-content>empty</body-content>
	  </tag>
 *jsp导入标签<%@ taglib uri="www.myTag" prefix="ex" %>
 *jsp使用标签<ex:hello></ex:hello>
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
	 * SKIP_BODY 跳过开始结束的代码，直接输出内容
	 * EVAL_BODY_AGAIN 数据循环时重复执行
	 * EVAL_BODY_INCLUDE 将body中的内容输出到当前的输出流中
	 * SKIP_PAGE 忽略剩余的页面内容
	 * EVAL_PAGE 继续执行剩余的页面代码
	 */
	
}
