package com.jjfk.tagsupport;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TagFor extends TagSupport{

	// 定义需要的参数
	private String var;
	private String items;
	private String scope;

	//迭代循环遍历
	Iterator it;

	//实现方法
	@Override
	public int doStartTag() throws JspException {
		//定义存放数据的集合
		ArrayList list = null;
		//获取数据
		if("page".equals(scope)){
			list = (ArrayList)pageContext.getAttribute(items, pageContext.PAGE_SCOPE);
		}else if("request".equals(scope)){
			list = (ArrayList)pageContext.getAttribute(items, pageContext.REQUEST_SCOPE);
			
		}else if("session".equals(scope)){
			list = (ArrayList)pageContext.getAttribute(items, pageContext.SESSION_SCOPE);
			
		}else if("application".equals(scope)){
			list = (ArrayList)pageContext.getAttribute(items, pageContext.APPLICATION_SCOPE);
		}
		
		//迭代变量
		it = list.iterator();
		if(it.hasNext()){
			//存入页面中
			pageContext.setAttribute(var, it.next());
			
			//执行 doAfterBody函数
			return super.EVAL_BODY_INCLUDE;
		}else{
			return super.doStartTag();
		}
	}
	
	@Override
	public int doAfterBody() throws JspException {
		//判断 是否有下一个值
		if(it.hasNext()){
			//存入页面中
			pageContext.setAttribute(var, it.next());
			return super.EVAL_BODY_AGAIN;
		}else{
			return super.SKIP_BODY;
		}
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
}

