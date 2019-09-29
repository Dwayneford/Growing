package com.tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.print.attribute.standard.PresentationDirection;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.util.JDBCUtil;

//�Զ����ѯ��ǩ
public class QueryTag extends TagSupport{

	private String tableName;


	@Override
	public int doStartTag() throws JspException {
		//�������ݿ�
		JDBCUtil db = new JDBCUtil();
		Connection conn =db.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		//�����ѯ��sql���
		String sql = "select *from "+tableName;
		try {
			ps = conn.prepareStatement(sql);
			//��ȡ���ݣ���+��ṹ
			ResultSetMetaData rsmd = ps.getMetaData();
			//�õ�������
			int clomn = rsmd.getColumnCount();
			//��jspҳ�������������
			JspWriter out = pageContext.getOut();
			out.print("<table border='1' cellspacing='0' cellpadding='0'>");
			//��ͷ
			out.print("<tr>");
			for (int i = 0; i < clomn; i++) {
				out.print("<th>"+rsmd.getColumnName(i+1)+"</th>");
			}
			out.print("</tr>");
			//���������
			rs = ps.executeQuery();
			while (rs.next()) {
				out.print("<tr>");
				//�����
				for (int i = 0; i < clomn; i++) {
					out.print("<td>"+rs.getObject(i+1)+"</td>");
				}
				out.print("</tr>");
			}
			
			out.print("</table>");
		
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return super.SKIP_BODY;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
}

//<%@ taglib uri="www.myTag" prefix="ex" %>
//�Զ������ѯ��ǩ:<ex:queryTag tableName="websites"></ex:queryTag>