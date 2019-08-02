package com.yc123.inteface;
import com.yc123.entity.UserInfoEnt;

public interface IUserInfo {
	/**
	 * 接口定义
	 *   接口在程序中，只是定义 方法的功能，没有方法的具体实现过程；
	 *   作用：
	 *   	通过接口确定类,程序的业务，在团队项目开发的过程中，
	 *      组员可以通过接口 调用其他 人写的接口方法 而不需要 等待，其他组员的方法具体实现；
	 * 
	 *      实现类可以同时实现多个接口 格式：implements IUserInfo,IUserInfo,IUserInfo...(接口名称)
	 *    
	 *      接口 和接口之间 可以 继承：如果实现类需要去实现 那么 需要实现子接口 父接口中所有 接口方法；
	 *      
	 *      开发 ：面向接口开发...?
	 *      	项目协同开发，多人参与项目中
	 *      	  将项目的需求 分配下来，每个组员根据自己的业务功能，确定需要用到的方法；
	 *      
	 *      	 开始制定每天的 完成的功能,在这个过程中不可避免 会相互使用其他组员的方法；
	 *      
	 *          为了实现协同开发，引入了接口的概念；
	 *          
	 *          定义 方法的功能，不需要马上实现方法的业务；
	 *          
	 *          通过实现类 去实现我们接口方法；
	 *          
	 *          调用：通过接口对象 获取实现类对象；
	 *          
	 *          通过接口对象 调用实现类中 未完成 方法;
	 *      	 
	 *      接口是 编程规范的定义：定义 方法名称   返回类型   方法参数，所有实现 该接口的类 必须按照规范来实现;
	 *           对Java单继承 扩展；
	 *           接口中的 可以方法 可以定义变量(是常量)；
	 *           接口中 没有 构造函数
	 */
	
	/**
	 *  添加数据
	 */
	public boolean saveUserInfo(UserInfoEnt userEnt);
	
	public boolean saveUserInfo(String userName, String userSex, String userAge,String userAdderss);
	/**
	 * 修改数据
	 */
	public boolean updateUserInfo(int userNo);
	/**
	 * 删除数据
	 */
	public boolean deleteUserInfo(int userNo);
	/**
	 * 查询数据
	 */
	public UserInfoEnt queryUserInfo(String userName, String userSex);
	/**
	 * 分页显示
	 */
	public UserInfoEnt[] queryPageUser(UserInfoEnt userEnt);
	
	
	//..........
	
	
	
	
	
	
	
	
	
}
