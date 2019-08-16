package add_delete_select;
//数据访问处理层

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

public class ManagerDao {
	ConnDB connDB=new ConnDB();
	//增加一条数据
	public boolean insert(Manager manager){
		boolean flag = false;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ConnDB connDB=new ConnDB();
		conn =  connDB.getConn();
		try {
			pstmt= conn.prepareStatement("insert into employee(id,name,work) value(?,?,?)");
			pstmt.setInt(1, manager.getId());
			pstmt.setString(2, manager.getName());
			pstmt.setInt(3, manager.getWork());
			//返回受影响的行数
			int rowcount = pstmt.executeUpdate();
			if (rowcount>0) {
				flag=true;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connDB.closeDB(null, pstmt, conn);
		}				
		return flag;
	}
	
	//删除一条数据
	public boolean delete(String name){
		boolean flag = false;
		PreparedStatement pstmt =null;
		Connection conn =null;
		conn = connDB.getConn();
		//删除一条员工信息的sql语句
		try {
			pstmt = conn.prepareStatement("delete from employee where name=?");
			pstmt.setString(1, name);
		
			int rowcount =pstmt .executeUpdate();
			if (rowcount>0) {
				flag=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connDB.closeDB(null, pstmt, conn);
		}
		
		return flag;		
	}
	//查询数据
	public ArrayList<Manager> select(){
		ArrayList<Manager> list = new ArrayList<Manager>();
		PreparedStatement pstmt = null;
		Connection conn =null;
		ResultSet rs = null;
		conn = connDB.getConn();
		//查询所有员工的信息的sql语句
		try {	
			pstmt = conn.prepareStatement("select * from employee");
			rs= pstmt.executeQuery();
			//循环遍历并输出，next判断结果集中是否有下一行
			while (rs.next()) {
				Manager manager =new Manager();
				manager.setId(rs.getInt("id"));
				manager.setName(rs.getString("name"));
				manager.setWork(rs.getInt("work"));
				list.add(manager);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connDB.closeDB(rs, pstmt, conn);
		}
		
		return list;
	}
		
	//修改一条数据
	public boolean update(Manager userEnt,int idOld){

		
		PreparedStatement pstmt =null;
		Connection conn =null;
		conn = connDB.getConn();
		boolean flag= false;
		String sql= "update employee set id=? , name=?,work=? where id= "+idOld+" ";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userEnt.getId());
			pstmt.setString(2, userEnt.getName());
			pstmt.setInt(3, userEnt.getWork());
			
			int i =pstmt.executeUpdate();
			if (i>0) {
				flag=true;
				System.out.println("修改成功！");
			}else {
				System.out.println("修改失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connDB.closeDB(null, pstmt, conn);
		}		
		return flag;	
	}
	
//	public  Manager getManager(String name){
//		
//		try {
//			Field field = getClass().getDeclaredField(name);
//			field.setAccessible(true);
//			return (Manager) field.get(field);
//		} catch (NoSuchFieldException e) {
//			e.printStackTrace();
//			return null;
//		} catch (SecurityException e) {
//			e.printStackTrace();
//			return null;
//		}
//		
//		
//					
//	}
	
	
}
