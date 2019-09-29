package com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.util.PageUtil;

public class PageTag extends SimpleTagSupport{

	private PageUtil pagination ; 	//��ҳ����required
	private String href ;		//�����·��
	private String divId;		//��ҳdiv
	private String divClass ;	//��ҳ��ʽ
	
	
	@Override
	public void doTag() throws JspException, IOException {
		//�����ַ�������
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

		//��һҳ
        if (pagination.getPageNo() == 1) {
            strBuf.append(" <a>&#9668;</a>");
        } else {
            strBuf.append(" <a ��nclick=\"paga_toPage(")
                    .append(pagination.getPageNo() - 1)
                    .append(")\"> &#9668; </a> ");
        }
        // ����
        strBuf.append(" <span>");

        if (pagination.getStartIndex() != 1) {
            // ��ʾ��һҳ����
            strBuf.append(" <a").append(" ��nclick=\"paga_toPage(").append(1)
                    .append(");\">").append(1).append("</a> ");
        }

        // ��ʾʡ�Ժ�
        if (pagination.getStartIndex() > 2) {
            strBuf.append(" <i>...</i> ");
        }
        // ��ҳ������
        for (int i = pagination.getStartIndex(); i <= pagination.getEndIndex(); i++) {
            if (pagination.getPageNo() == i) {
                strBuf.append(" <a class=\"current\">").append(i)
                        .append("</a> ");
            } else {
                strBuf.append(" <a ��nclick=\"paga_toPage(").append(i)
                        .append(");\">").append(i).append("</a> ");
            }
        }
        // ��ʾʡ�Ժ�
        if (pagination.getEndIndex() < pagination.getTotalPage() - 1) {
            strBuf.append(" <i>...</i> ");
        }
        if (pagination.getEndIndex() != pagination.getTotalPage()) {
            // ��ʾ���һҳ����
            strBuf.append(" <a").append(" ��nclick=\"paga_toPage(")
                    .append(pagination.getTotalPage()).append(");\">")
                    .append(pagination.getTotalPage()).append("</a>");
        }
     // ������β
        strBuf.append(" </span> ");

        // ��һҳ
        if (pagination.getPageNo() == pagination.getTotalPage()) {
            strBuf.append(" <a>&#9658;</a> ");
            // strBuf.append("<a">ĩҳ</a> ");
        } else {
            strBuf.append(" <a ��nclick=\"paga_toPage(")
                    .append(pagination.getPageNo() + 1)
                    .append(")\"> &#9658; </a> ");
            // strBuf.append(" <a ��nclick=\"paga_toPage(").append(pagination.getTotalPage()).append(")\">ĩҳ</a> ");
        }

        strBuf.append(" </div> ");

        JspContext ctx = getJspContext();
         // ��ȡҳ���������������ַ���
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
