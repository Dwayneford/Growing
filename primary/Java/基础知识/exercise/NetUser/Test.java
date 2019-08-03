package NetUser;

public class Test {

	
	public static void main(String[] args) {
		//作为构造函数传递参数时，如何重载？
		NetUser n = new NetUser(25213, "asdf444");
		n.UserInfo();
		
		NetUser s = new NetUser(25213, "asdf444","youxiang");
		s.UserInfo2();
	}
}
