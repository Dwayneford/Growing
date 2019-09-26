package com.jjfk.tagsupport;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TagFor extends TagSupport{

	// ������Ҫ�Ĳ���
	private String var;
	private String items;
	private String scope;

	//����ѭ������
	Iterator it;

	//ʵ�ַ���
	@Override
	public int doStartTag() throws JspException {
		//���������ݵļ���
		ArrayList list = null;
		//��ȡ����
		if("page".equals(scope)){
			list = (ArrayList)pageContext.getAttribute(items, pageContext.PAGE_SCOPE);
		}else if("request".equals(scope)){
			list = (ArrayList)pageContext.getAttribute(items, pageContext.REQUEST_SCOPE);
			
		}else if("session".equals(scope)){
			list = (ArrayList)pageContext.getAttribute(items, pageContext.SESSION_SCOPE);
			
		}else if("application".equals(scope)){
			list = (ArrayList)pageContext.getAttribute(items, pageContext.APPLICATION_SCOPE);
		}
		
		//��������
		it = list.iterator();
		if(it.hasNext()){
			//����ҳ����
			pageContext.setAttribute(var, it.next());
			
			//ִ�� doAfterBody����
			return super.EVAL_BODY_INCLUDE;
		}else{
			return super.doStartTag();
		}
	}
	
	@Override
	public int doAfterBody() throws JspException {
		//�ж� �Ƿ�����һ��ֵ
		if(it.hasNext()){
			//����ҳ����
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

