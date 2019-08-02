package com.yc123.inteface;

import com.yc123.entity.UserInfoEnt;

/**
 *  实现类 必须实现接口中的所有方法
 * @author direct
 *
 */
public class UserInfoImpl implements IUserInfo {

	
	@Override
	public boolean saveUserInfo(UserInfoEnt userEnt) {
		// 需要调用第三方 接口 实现我们的业务流程：需要等待5天.......
		System.out.println("调用了 userInfoImpl中的 saveUserInfo(UserInfoEnt userEnt) 方法");
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
