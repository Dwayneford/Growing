package com.yc123.service;

import com.yc123.entity.UserInfoEnt;
import com.yc123.inteface.IUserInfo;
import com.yc123.inteface.StudentInfoImpl;
import com.yc123.inteface.UserInfoImpl;

public class GoodsService {

	/**
	 * �¶��� ����
	 * @return
	 */
	IUserInfo iUser = new UserInfoImpl();
	IUserInfo iStu = new StudentInfoImpl();
	public boolean saveOrder(){
		//���� �û���Ϣ���淽��
		boolean bool = iUser.saveUserInfo(new UserInfoEnt());
		boolean bool2 = iStu.saveUserInfo(new UserInfoEnt());
		
		if (bool2&&bool) {
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		GoodsService gsEnt = new GoodsService();
		boolean bool =  gsEnt.saveOrder();
		
		if (bool) {
			System.out.println("���ݲ����ɹ���������");
		}else{
			System.out.println("���ݲ���ʧ�ܣ�������");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
