package jdbc;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



/**
 * jdbc (java DateBase Connectivity)��һ������ִ��SQL
 * 		���ṹ����ѯ����(Structured Query Language)������javaAPI
 * 		����Ϊ���ֹ�ϵ�����ݿ��ṩͳһ�ķ�����ʽ
 * 	
 * 	jdbc �������ݿ������
 * 		jdbc-ODBC���Ž����������в������ݿ⣬�ⲿ����޷�ͨ��jdbcֱ�ӽ������ӣ���Ҫͨ��ODBC
 * 			�Žӷ�ʽ����
 * 	����jdbc����������������jdbcת����dbms���ͻ������������ͨ�Ż��ƣ������пͻ��˵�API���ã�
 * 		jdbcת��Ϊdbms������Э���޹�

 *
 */

public class DBUtil {

	public static void main(String[] args) {
		DBUtil db =new DBUtil();
		Connection conn = db.conn();
		System.out.println("===>"+conn);
		

		
	}
	
	//�������ݿ���Ҫ�Ĳ���
	public static String url="jdbc:mysql://127.0.0.1:3306/mysql2019815?userUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
	public static String user="root";
	public static String password="root";
	
	//��������Ƿ��������
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//���ݿ����ӷ���
	public 	Connection conn(){
		Connection conn= null;
		try {
			conn=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return conn;		
	}
	
	//���ݿ�رշ���
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










