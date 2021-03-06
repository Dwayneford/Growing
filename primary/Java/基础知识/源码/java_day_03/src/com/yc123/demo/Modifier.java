package com.yc123.demo;

public class Modifier {
	/**
	 * 权限修饰符：
	 *  private :私有 权限，在创建的对象 或者本类中使用；
		default :同一个包中的类 才能访问
		protected:受保护的权限修饰符，同一个包可以访问，或者子类 子类的子类 可以访问；
		public:所有的 类 都可以访问
	 */
	public String modName;
	
	/*通过方法 确定 修饰符的使用*/
	private void hello(){
		System.out.println("我是 私有的方法 别玩我！！！！");
	}
	
	protected void hello1(){
		System.out.println("我是 受保护的方法， 子类才可以使用！！！ /同一包");
	}
	
	void hello2(){
		System.out.println("带默认修饰符 的方法！！！");
	}
	
	public static final void hello3(){
		System.out.println("公共的 可以任意调用的方法！！！");
		
	}
	
	
	// 定义方法 调用 被不同 权限修饰符 操作的方法
	public static void main(String[] args) {
		Modifier modEnt = new Modifier();
		modEnt.hello();
		modEnt.hello1();
		
		modEnt.hello2();
		modEnt.hello3();
		
	}
	
	
}
