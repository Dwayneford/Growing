package NetUser;
/**
 * 练习一：构造方法与重载   
定义一个网络用户类，要处理的信息有用户ID、用户密码、email地址。在建立类的实例时，
把以上三个信息都作为构造函数的参数输入，其中用户ID和用户密码时必须的，缺省的emai
l地址是用户ID加上字符串"@gameschool.com"  

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
		System.out.println("用户名是："+UserID+"，密码是："+UserPWD+"，默认用户邮箱是："+this.UserID+"@gameschool.com");
		
		
	}
	
	void UserInfo2(){
		System.out.println("用户名是："+UserID+"，密码是："+UserPWD+"，默认用户邮箱是："+UserEmail);
		
		
	}
	
	
	
}
