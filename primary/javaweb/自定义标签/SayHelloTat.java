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
		//页面输出 helloWorld
		JspWriter out = pageContext.getOut();
		try {
			out.print("TagPage,Hello World!!!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * SKIP_BODY:跳过开始 结束的代码 直接输出内容
		 * EVAL_BODY_AGAIN:数据循环 时 重复执行
		 * EVAL_BODY_INCLUDE：将body中的内容输出， 当前的输出流中
		 * SKIP_PAGE:忽略剩余的 页面内容
		 * EVAL_PAGE:继续执行 剩余的页面代码
		 */
		return super.SKIP_BODY;
	}
}
