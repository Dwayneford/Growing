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

//自定义查询标签
public class QueryTag extends TagSupport{

	private String tableName;


	@Override
	public int doStartTag() throws JspException {
		//连接数据库
		JDBCUtil db = new JDBCUtil();
		Connection conn =db.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		//定义查询的sql语句
		String sql = "select *from "+tableName;
		try {
			ps = conn.prepareStatement(sql);
			//获取数据：表+表结构
			ResultSetMetaData rsmd = ps.getMetaData();
			//得到总列数
			int clomn = rsmd.getColumnCount();
			//向jsp页面输出遍历内容
			JspWriter out = pageContext.getOut();
			out.print("<table border='1' cellspacing='0' cellpadding='0'>");
			//表头
			out.print("<tr>");
			for (int i = 0; i < clomn; i++) {
				out.print("<th>"+rsmd.getColumnName(i+1)+"</th>");
			}
			out.print("</tr>");
			//输出表内容
			rs = ps.executeQuery();
			while (rs.next()) {
				out.print("<tr>");
				//输出列
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
//自定义表格查询标签:<ex:queryTag tableName="websites"></ex:queryTag>