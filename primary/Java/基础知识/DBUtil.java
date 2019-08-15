package jdbc;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



/**
 * jdbc (java DateBase Connectivity)是一种用于执行SQL
 * 		（结构化查询语言(Structured Query Language)）语句的javaAPI
 * 		可以为多种关系型数据库提供统一的访问形式
 * 	
 * 	jdbc 连接数据库的驱动
 * 		jdbc-ODBC：桥接驱动程序，有部分数据库，外部框架无法通过jdbc直接进行连接，需要通过ODBC
 * 			桥接方式连接
 * 	本地jdbc驱动程序：驱动程序将jdbc转换成dbms（客户端与服务器的通信机制），进行客户端的API调用；
 * 		jdbc转换为dbms与网络协议无关

 *
 */

public class DBUtil {

	public static void main(String[] args) {
		DBUtil db =new DBUtil();
		Connection conn = db.conn();
		System.out.println("===>"+conn);
		

		
	}
	
	//连接数据库需要的参数
	public static String url="jdbc:mysql://127.0.0.1:3306/mysql2019815?userUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
	public static String user="root";
	public static String password="root";
	
	//检测驱动是否加载正常
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//数据库连接方法
	public 	Connection conn(){
		Connection conn= null;
		try {
			conn=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return conn;		
	}
	
	//数据库关闭方法
	public void closeDB(ResultSet rs , PreparedStatement ps , Connection conn){
		
			try {
				if(rs!= null)rs.close();
				if(ps != null)ps.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}	
		
}










