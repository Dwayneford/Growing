package com.tag;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.util.PageModel;

/**
 * ͨ�� �ⲿ ���Դ��� ��Ҫ��ҳ�� ��������
 * @author direct
 *
 */
public class MyPageTag extends TagSupport{

	//������Ҫ������
	private String url;
	private String items;
	private String var;
	private String scope;
	
	//���ݷ�ҳ����
	private PageModel pm;
	//��������
	Iterator it = null;
	
	@Override
	public int doStartTag() throws JspException {
		//��ȡ����
		if("page".equals(scope)){
			pm = (PageModel)pageContext.getAttribute(items, pageContext.PAGE_SCOPE);
		}else if("request".equals(scope)){
			pm = (PageModel)pageContext.getAttribute(items, pageContext.REQUEST_SCOPE);
			
		}else if("session".equals(scope)){
			pm = (PageModel)pageContext.getAttribute(items, pageContext.SESSION_SCOPE);
			
		}else if("application".equals(scope)){
			pm = (PageModel)pageContext.getAttribute(items, pageContext.APPLICATION_SCOPE);
		}
		
		//���� ��ҳ���� �е�����
		it = pm.getList().iterator();
		if(it.hasNext()){
			//�� ��ȡ��ֵ��ŵ� page������
			pageContext.setAttribute(var, it.next());
			return super.EVAL_BODY_INCLUDE;
		}else{
			return super.SKIP_BODY;
		}
	}
	
	@Override
	public int doAfterBody() throws JspException {
		//�ж��Ƿ� ������һ������
		if(it.hasNext()){
			pageContext.setAttribute(var,it.next());
			return super.EVAL_BODY_AGAIN;
		}else{
			return super.SKIP_BODY;
		}
	}
	/**
	 * ������ ����ִ�е�����ȥ
	 */
	@Override
	public int doEndTag() throws JspException {
		//�����ҳ����
		JspWriter out = pageContext.getOut();
		try {
			//����ѭ����
			
			//.................
			
			out.print("<tr>");
			out.print("<td><a href='"+url+"?method=myPgaeInfo3&size=3&currentPage=1'>��ҳ</a></td>");//getCurrntPage getCurrentPage
			out.print("<td><a href='"+url+"?method=myPgaeInfo3&size=3&currentPage="+((pm.getCurrentPage()==1) ? pm.getCurrentPage():(pm.getCurrentPage()-1))+"'>��һҳ</a></td>");
			out.print("<td><a href='"+url+"?method=myPgaeInfo3&size=3&currentPage="+((pm.getCurrentPage()==pm.getSumPage())?pm.getCurrentPage():(pm.getCurrentPage()+1))+"'>��һҳ</a></td>");
			out.print("<td><a href='"+url+"?method=myPgaeInfo3&size=3&currentPage="+pm.getSumPage()+"'>βҳ</a><td>");
			out.print("</tr>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.EVAL_PAGE;
	}
	/****************************/
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public PageModel getPm() {
		return pm;
	}
	public void setPm(PageModel pm) {
		this.pm = pm;
	}
	
	
	
	
	
	
	
}
