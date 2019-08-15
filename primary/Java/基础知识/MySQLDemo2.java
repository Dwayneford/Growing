package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDemo2 {

	//JDBC �����������ݿ� URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mysql2019815";
	
	// ���ݿ���û���������
	static final String USER = "root";
    static final String PASS = "root";
	
	public static void main(String[] args) {
		Connection conn =null;
		Statement stmt = null;
		try {
			//ע������
			Class.forName(JDBC_DRIVER);
			//������
			System.out.println("�������ݿ�...");
			conn= DriverManager.getConnection(DB_URL,USER,PASS);
			
			//ִ�в�ѯ
			System.out.println("ʵ����statement����...");
			stmt=conn.createStatement();
			String sql = "SELECT user_id, user_name, user_age FROM userInfo";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				 // ͨ���ֶμ���
                int id  = rs.getInt("user_id");
                String name = rs.getString("user_name");
                String age = rs.getString("user_age");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print("����: " + name);
                System.out.print("����: " + age);
                System.out.print("\n");
			}
			rs.close();
			stmt.close();
			conn.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
		
		
		System.out.println("Goodbye!");
		
		
		
		
	}
	
	
	
	
	
	
}
