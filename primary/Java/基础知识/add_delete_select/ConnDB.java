package add_delete_select;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

//���ݿ�������

public class ConnDB {
	
	public static void main(String[] args) {
		ConnDB c = new ConnDB();
		c.getConn();
	}
	//���һ�����Ӷ���
	public   Connection getConn(){
		Connection conn = null;
		
//		ResourceBundle rb =	ResourceBundle.getBundle("jdbc");
//		String DB_url = rb.getString("DB_url");
//		String DB_user = rb.getString("DB_user");
//		String DB_driver=  rb.getString("DB_driver");
//		String DB_password =  rb.getString("DB_password");
//		try {
//			Class.forName("DB_driver");
//			
//			conn = DriverManager.getConnection(DB_url, DB_user, DB_password);						
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		InputStream in= this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		//�����ļ��� ��ȡ�ļ�������
		Properties properties = new Properties();
		try {
			properties.load(in);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//ȡ����Ӧ������ֵ
		String DB_url = properties.getProperty("DB_url");
		String DB_user = properties.getProperty("DB_user");
		String DB_driver=  properties.getProperty("DB_driver");
		String DB_password =  properties.getProperty("DB_password");
		try {
			Class.forName(DB_driver);
			
			conn = DriverManager.getConnection(DB_url, DB_user, DB_password);						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}				
		return conn;		
	}
	//�ر�����
	public void closeDB(ResultSet rs , PreparedStatement pstmt,Connection conn){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}				
	}
	
}
