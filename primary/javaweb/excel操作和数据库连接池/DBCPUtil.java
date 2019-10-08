package com.jjfk.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPUtil {
	//��������Դ
	private static DataSource ds = null;
	//��ʼ������
	static BasicDataSource bds = new BasicDataSource();
	
	/**
	 * �������
	 */
	public Connection getConn(){
		//��ȡ�ⲿ��Դ�ļ�
		ResourceBundle rd = ResourceBundle.getBundle("dbcp");
		if(rd==null){
			System.out.println("������Դ�ļ�ʧ�ܣ���1");
		}else if(ds==null){
			//��ȡ����
			String url= rd.getString("url");
			String userName= rd.getString("userName");
			String driverClassName= rd.getString("driverClassName");
			String maxActive= rd.getString("maxActive");
			String minIdle= rd.getString("minIdle");
			String maxWait= rd.getString("maxWait");
			String userPwd= rd.getString("userPwd");
			
			//�����ʼ��������
			bds.setUsername(userName);
			bds.setPassword(userPwd);
			bds.setUrl(url);
			bds.setDriverClassName(driverClassName);
			bds.setMaxActive(Integer.parseInt(maxActive));
			bds.setMinIdle(Integer.parseInt(minIdle));
			bds.setMaxWait(Integer.parseInt(maxWait));
			
			//����ʼ������ ��ֵ������Դ
			ds = bds;
		}
		
		Connection conn = null;
		// ��������
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	/**
	 * ���Է���
	 * @param args
	 */
	public static void main(String[] args) {
		
		for (int i = 0; i < 190; i++) {
			DBCPUtil dp = new DBCPUtil();
			Connection conn = dp.getConn();
			System.out.println(i+"==="+conn);
			//�ر�
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 
		
	}
	
}
