package com.yc123.inteface;

import com.yc123.entity.UserInfoEnt;

/**
 *  ʵ���� ����ʵ�ֽӿ��е����з���
 * @author direct
 *
 */
public class UserInfoImpl implements IUserInfo {

	
	@Override
	public boolean saveUserInfo(UserInfoEnt userEnt) {
		// ��Ҫ���õ����� �ӿ� ʵ�����ǵ�ҵ�����̣���Ҫ�ȴ�5��.......
		System.out.println("������ userInfoImpl�е� saveUserInfo(UserInfoEnt userEnt) ����");
		return false;
	}

	@Override
	public boolean saveUserInfo(String userName, String userSex, String userAge, String userAdderss) {
		return false;
	}

	@Override
	public boolean updateUserInfo(int userNo) {
		return false;
	}

	@Override
	public boolean deleteUserInfo(int userNo) {
		return false;
	}

	@Override
	public UserInfoEnt queryUserInfo(String userName, String userSex) {
		return null;
	}

	@Override
	public UserInfoEnt[] queryPageUser(UserInfoEnt userEnt) {
		return null;
	}

}
