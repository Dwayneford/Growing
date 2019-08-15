package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDemo2 {

	//JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mysql2019815";
	
	// 数据库的用户名与密码
	static final String USER = "root";
    static final String PASS = "root";
	
	public static void main(String[] args) {
		Connection conn =null;
		Statement stmt = null;
		try {
			//注册驱动
			Class.forName(JDBC_DRIVER);
			//打开链接
			System.out.println("链接数据库...");
			conn= DriverManager.getConnection(DB_URL,USER,PASS);
			
			//执行查询
			System.out.println("实例化statement对象...");
			stmt=conn.createStatement();
			String sql = "SELECT user_id, user_name, user_age FROM userInfo";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				 // 通过字段检索
                int id  = rs.getInt("user_id");
                String name = rs.getString("user_name");
                String age = rs.getString("user_age");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print("名字: " + name);
                System.out.print("年龄: " + age);
                System.out.print("\n");
			}
			rs.close();
			stmt.close();
			conn.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		
		
		System.out.println("Goodbye!");
		
		
		
		
	}
	
	
	
	
	
	
}
