package com.yc123.inteface;

import com.yc123.entity.UserInfoEnt;

public class StudentInfoImpl implements IUserInfo{

	@Override
	public boolean saveUserInfo(UserInfoEnt userEnt) {
		
		System.out.println("���� StudentInfoImpl �е�  saveUserInfo(UserInfoEnt userEnt)�еķ���.....");
		
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
