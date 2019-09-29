package com.tag;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.util.PageModel;

/**
 * 通过 外部 属性传递 需要分页的 集合数据
 * @author direct
 *
 */
public class MyPageTag extends TagSupport{

	//定义需要的属性
	private String url;
	private String items;
	private String var;
	private String scope;
	
	//传递分页对象
	private PageModel pm;
	//迭代属性
	Iterator it = null;
	
	@Override
	public int doStartTag() throws JspException {
		//获取数据
		if("page".equals(scope)){
			pm = (PageModel)pageContext.getAttribute(items, pageContext.PAGE_SCOPE);
		}else if("request".equals(scope)){
			pm = (PageModel)pageContext.getAttribute(items, pageContext.REQUEST_SCOPE);
			
		}else if("session".equals(scope)){
			pm = (PageModel)pageContext.getAttribute(items, pageContext.SESSION_SCOPE);
			
		}else if("application".equals(scope)){
			pm = (PageModel)pageContext.getAttribute(items, pageContext.APPLICATION_SCOPE);
		}
		
		//解析 分页对象 中的数据
		it = pm.getList().iterator();
		if(it.hasNext()){
			//将 获取的值存放到 page作用中
			pageContext.setAttribute(var, it.next());
			return super.EVAL_BODY_INCLUDE;
		}else{
			return super.SKIP_BODY;
		}
	}
	
	@Override
	public int doAfterBody() throws JspException {
		//判断是否 存在下一条数据
		if(it.hasNext()){
			pageContext.setAttribute(var,it.next());
			return super.EVAL_BODY_AGAIN;
		}else{
			return super.SKIP_BODY;
		}
	}
	/**
	 * 将内容 最终执行到哪里去
	 */
	@Override
	public int doEndTag() throws JspException {
		//输出到页面中
		JspWriter out = pageContext.getOut();
		try {
			//数据循环：
			
			//.................
			
			out.print("<tr>");
			out.print("<td><a href='"+url+"?method=myPgaeInfo3&size=3&currentPage=1'>首页</a></td>");//getCurrntPage getCurrentPage
			out.print("<td><a href='"+url+"?method=myPgaeInfo3&size=3&currentPage="+((pm.getCurrentPage()==1) ? pm.getCurrentPage():(pm.getCurrentPage()-1))+"'>上一页</a></td>");
			out.print("<td><a href='"+url+"?method=myPgaeInfo3&size=3&currentPage="+((pm.getCurrentPage()==pm.getSumPage())?pm.getCurrentPage():(pm.getCurrentPage()+1))+"'>下一页</a></td>");
			out.print("<td><a href='"+url+"?method=myPgaeInfo3&size=3&currentPage="+pm.getSumPage()+"'>尾页</a><td>");
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
