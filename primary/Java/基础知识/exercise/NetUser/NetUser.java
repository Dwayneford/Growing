package NetUser;
/**
 * ��ϰһ�����췽��������   
����һ�������û��࣬Ҫ�������Ϣ���û�ID���û����롢email��ַ���ڽ������ʵ��ʱ��
������������Ϣ����Ϊ���캯���Ĳ������룬�����û�ID���û�����ʱ����ģ�ȱʡ��emai
l��ַ���û�ID�����ַ���"@gameschool.com"  

 * @author Administrator
 *
 */
public class NetUser {

	protected int UserID;
	protected String UserPWD;
	protected String UserEmail;
	
	public NetUser(int userID, String userPWD, String userEmail) {
		super();
		UserID = userID;
		UserPWD = userPWD;
		UserEmail = userEmail;
	}

	public NetUser(int userID, String userPWD) {
		super();
		UserID = userID;
		UserPWD = userPWD;
	}

	public NetUser() {
		super();
	}
	
	void UserInfo(){
		System.out.println("�û����ǣ�"+UserID+"�������ǣ�"+UserPWD+"��Ĭ���û������ǣ�"+this.UserID+"@gameschool.com");
		
		
	}
	
	void UserInfo2(){
		System.out.println("�û����ǣ�"+UserID+"�������ǣ�"+UserPWD+"��Ĭ���û������ǣ�"+UserEmail);
		
		
	}
	
	
	
}
