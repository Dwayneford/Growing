package com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.util.PageUtil;

public class PageTag extends SimpleTagSupport{

	private PageUtil pagination ; 	//分页数据required
	private String href ;		//请求的路径
	private String divId;		//分页div
	private String divClass ;	//分页样式
	
	
	@Override
	public void doTag() throws JspException, IOException {
		//缓冲字符串对象
		StringBuffer strBuf = new StringBuffer();
        strBuf.append("<script type=\"text/javascript\">\n");
        strBuf.append("function paga_toPage(pageNo) {");
        strBuf.append("window.location.href=\"").append(href);
        if (href.indexOf("?") == -1) {
            strBuf.append("?");
        } else {
            strBuf.append("&");
        }
        strBuf.append("pageNo=\"").append("+pageNo;").append("}");
        strBuf.append(" </script> ");
        strBuf.append(" <div id=\"").append(divId).append("\" class=\"")
                .append(divClass).append("\"> ");

		//上一页
        if (pagination.getPageNo() == 1) {
            strBuf.append(" <a>&#9668;</a>");
        } else {
            strBuf.append(" <a οnclick=\"paga_toPage(")
                    .append(pagination.getPageNo() - 1)
                    .append(")\"> &#9668; </a> ");
        }
        // 容器
        strBuf.append(" <span>");

        if (pagination.getStartIndex() != 1) {
            // 显示第一页索引
            strBuf.append(" <a").append(" οnclick=\"paga_toPage(").append(1)
                    .append(");\">").append(1).append("</a> ");
        }

        // 显示省略号
        if (pagination.getStartIndex() > 2) {
            strBuf.append(" <i>...</i> ");
        }
        // 分页条主体
        for (int i = pagination.getStartIndex(); i <= pagination.getEndIndex(); i++) {
            if (pagination.getPageNo() == i) {
                strBuf.append(" <a class=\"current\">").append(i)
                        .append("</a> ");
            } else {
                strBuf.append(" <a οnclick=\"paga_toPage(").append(i)
                        .append(");\">").append(i).append("</a> ");
            }
        }
        // 显示省略号
        if (pagination.getEndIndex() < pagination.getTotalPage() - 1) {
            strBuf.append(" <i>...</i> ");
        }
        if (pagination.getEndIndex() != pagination.getTotalPage()) {
            // 显示最后一页索引
            strBuf.append(" <a").append(" οnclick=\"paga_toPage(")
                    .append(pagination.getTotalPage()).append(");\">")
                    .append(pagination.getTotalPage()).append("</a>");
        }
     // 容器结尾
        strBuf.append(" </span> ");

        // 下一页
        if (pagination.getPageNo() == pagination.getTotalPage()) {
            strBuf.append(" <a>&#9658;</a> ");
            // strBuf.append("<a">末页</a> ");
        } else {
            strBuf.append(" <a οnclick=\"paga_toPage(")
                    .append(pagination.getPageNo() + 1)
                    .append(")\"> &#9658; </a> ");
            // strBuf.append(" <a οnclick=\"paga_toPage(").append(pagination.getTotalPage()).append(")\">末页</a> ");
        }

        strBuf.append(" </div> ");

        JspContext ctx = getJspContext();
         // 获取页面输出流，并输出字符串
        JspWriter out = ctx.getOut();
        out.print(strBuf.toString());
        

	}
	public PageUtil getPagination() {
		return pagination;
	}
	public void setPagination(PageUtil pagination) {
		this.pagination = pagination;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getDivId() {
		return divId;
	}
	public void setDivId(String divId) {
		this.divId = divId;
	}
	public String getDivClss() {
		return divClass;
	}
	public void setDivClss(String divClss) {
		this.divClass = divClss;
	}
	
}
