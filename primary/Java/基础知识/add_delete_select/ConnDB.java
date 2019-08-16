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

//数据库连接类

public class ConnDB {
	
	public static void main(String[] args) {
		ConnDB c = new ConnDB();
		c.getConn();
	}
	//获得一个连接对象
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
		//加载文件流 获取文件的属性
		Properties properties = new Properties();
		try {
			properties.load(in);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//取出对应的属性值
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
	//关闭连接
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
