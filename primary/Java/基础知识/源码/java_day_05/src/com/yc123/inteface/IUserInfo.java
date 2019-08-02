package com.yc123.inteface;
import com.yc123.entity.UserInfoEnt;

public interface IUserInfo {
	/**
	 * �ӿڶ���
	 *   �ӿ��ڳ����У�ֻ�Ƕ��� �����Ĺ��ܣ�û�з����ľ���ʵ�ֹ��̣�
	 *   ���ã�
	 *   	ͨ���ӿ�ȷ����,�����ҵ�����Ŷ���Ŀ�����Ĺ����У�
	 *      ��Ա����ͨ���ӿ� �������� ��д�Ľӿڷ��� ������Ҫ �ȴ���������Ա�ķ�������ʵ�֣�
	 * 
	 *      ʵ�������ͬʱʵ�ֶ���ӿ� ��ʽ��implements IUserInfo,IUserInfo,IUserInfo...(�ӿ�����)
	 *    
	 *      �ӿ� �ͽӿ�֮�� ���� �̳У����ʵ������Ҫȥʵ�� ��ô ��Ҫʵ���ӽӿ� ���ӿ������� �ӿڷ�����
	 *      
	 *      ���� ������ӿڿ���...?
	 *      	��ĿЭͬ���������˲�����Ŀ��
	 *      	  ����Ŀ������ ����������ÿ����Ա�����Լ���ҵ���ܣ�ȷ����Ҫ�õ��ķ�����
	 *      
	 *      	 ��ʼ�ƶ�ÿ��� ��ɵĹ���,����������в��ɱ��� ���໥ʹ��������Ա�ķ�����
	 *      
	 *          Ϊ��ʵ��Эͬ�����������˽ӿڵĸ��
	 *          
	 *          ���� �����Ĺ��ܣ�����Ҫ����ʵ�ַ�����ҵ��
	 *          
	 *          ͨ��ʵ���� ȥʵ�����ǽӿڷ�����
	 *          
	 *          ���ã�ͨ���ӿڶ��� ��ȡʵ�������
	 *          
	 *          ͨ���ӿڶ��� ����ʵ������ δ��� ����;
	 *      	 
	 *      �ӿ��� ��̹淶�Ķ��壺���� ��������   ��������   ��������������ʵ�� �ýӿڵ��� ���밴�չ淶��ʵ��;
	 *           ��Java���̳� ��չ��
	 *           �ӿ��е� ���Է��� ���Զ������(�ǳ���)��
	 *           �ӿ��� û�� ���캯��
	 */
	
	/**
	 *  �������
	 */
	public boolean saveUserInfo(UserInfoEnt userEnt);
	
	public boolean saveUserInfo(String userName, String userSex, String userAge,String userAdderss);
	/**
	 * �޸�����
	 */
	public boolean updateUserInfo(int userNo);
	/**
	 * ɾ������
	 */
	public boolean deleteUserInfo(int userNo);
	/**
	 * ��ѯ����
	 */
	public UserInfoEnt queryUserInfo(String userName, String userSex);
	/**
	 * ��ҳ��ʾ
	 */
	public UserInfoEnt[] queryPageUser(UserInfoEnt userEnt);
	
	
	//..........
	
	
	
	
	
	
	
	
	
}
