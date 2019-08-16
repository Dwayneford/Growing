package add_delete_select;
//���ݷ��ʴ����

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

public class ManagerDao {
	ConnDB connDB=new ConnDB();
	//����һ������
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
			//������Ӱ�������
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
	
	//ɾ��һ������
	public boolean delete(String name){
		boolean flag = false;
		PreparedStatement pstmt =null;
		Connection conn =null;
		conn = connDB.getConn();
		//ɾ��һ��Ա����Ϣ��sql���
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
	//��ѯ����
	public ArrayList<Manager> select(){
		ArrayList<Manager> list = new ArrayList<Manager>();
		PreparedStatement pstmt = null;
		Connection conn =null;
		ResultSet rs = null;
		conn = connDB.getConn();
		//��ѯ����Ա������Ϣ��sql���
		try {	
			pstmt = conn.prepareStatement("select * from employee");
			rs= pstmt.executeQuery();
			//ѭ�������������next�жϽ�������Ƿ�����һ��
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
		
	//�޸�һ������
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
				System.out.println("�޸ĳɹ���");
			}else {
				System.out.println("�޸�ʧ�ܣ�");
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
