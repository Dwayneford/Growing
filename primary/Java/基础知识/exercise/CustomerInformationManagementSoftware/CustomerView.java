package CustomerInformationManagementSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
	
	//用途：显示主菜单，响应用户输入，根据用户操作分别调用其他相应的成员方法
	//	（如addNewCustomer），以完成客户信息处理。

//	public void enterMainMenu(){
//		
//	}
//	
//	private void addNewCustomer() {
//		
//	}
//
//	private void modifyCustomer(){
//			
//	}
//
//	private void deleteCustomer(){
//		
//	}
//
//	private void listAllCustomers(){
//		
//	}
	
	//用途：创建CustomerView实例，并调用 enterMainMenu()方法以执行程序。
	public static void main(String[] args){
			
		CustomerList customers = new CustomerList();		
		String name;
		char gender;
		int age;
		String phone;
		String email;
		String flag;
		
		while(true) {
			System.out.println("-----------------客户信息管理软件-----------------");
			System.out.println("	1 添 加 客 户");
			System.out.println("	2 修 改 客 户");
			System.out.println("	3 删 除 客 户");
			System.out.println("	4 客 户 列 表");
			System.out.println("	5 退           出");
			System.out.println("	请选择(1-5)：");
//			Scanner sca = new Scanner(System.in);
			CMUtility cmu = new CMUtility();
			char  num =cmu.readMenuSelection();
			switch (num) {
			case '1':
				do {
					System.out.println("---------------------添加客户---------------------");
					System.out.println("请输入姓名！");
//					name =sca.next();
					name =cmu.readString(5);
					System.out.println("请输入性别！");
//					gender =sca.next();
					gender=cmu.readChar(); 
					System.out.println("请输入年龄！");
//					age =sca.nextInt();
					age=cmu.readInt(); 
					System.out.println("请输入手机号！");
//					phone =sca.next();
					phone =cmu.readString(11);  
					System.out.println("请输入邮箱！");
//					email =sca.next();
					email=cmu.readString(25);
					Customer cust = new Customer(name, gender, age, phone, email);
					customers.addCustomer(cust);
					System.out.println("---------------------添加完成---------------------");
					System.out.println("是否继续添加？(Y/N)");
					flag =cmu.readString(1);
				} while ("y".equals(flag)||"Y".equals(flag));
				
				break;
			case '2':
				do {
					System.out.println("---------------------修改客户---------------------");
					System.out.println("请输入手机号以确定将要修改的客户：");				
					String phoneNum =cmu.readString(11);
					if (customers.map.containsKey(phoneNum)) {
											
						ArrayList al = (ArrayList) customers.map.get(phoneNum);
						Customer cust=(Customer) al.get(0);
						System.out.println("请输入要修改的姓名！"+cust.getName());
//						name =sca.next();
						name =cmu.readString(5,cust.getName());
						System.out.println("请输入要修改的性别！"+cust.getGender());
//						gender =sca.next();
						gender=cmu.readChar(cust.getGender()); 
						System.out.println("请输入要修改的年龄！"+cust.getAge());
//						age =sca.nextInt();
						age=cmu.readInt(cust.getAge()); 
						System.out.println("请输入要修改的手机号！"+cust.getPhone());
//						phone =sca.next();
						phone =cmu.readString(11,cust.getPhone());  
						System.out.println("请输入要修改的邮箱！"+cust.getEmail());
//						email =sca.next();
						email=cmu.readString(25,cust.getEmail());
						customers.replaceCustomer(phoneNum, new Customer(name, gender, age, phone, email));
						
						System.out.println("---------------------修改完成---------------------");
					}else{
						System.out.println("该手机号没有匹配到以存入的客户，请检查后再输入");
					}				
					
					System.out.println("是否继续修改？(Y/N)");
					flag =cmu.readString(1);
				} while ("y".equals(flag)||"Y".equals(flag));

				break	;
			case '3':			
				do {
					System.out.println("---------------------删除客户---------------------");
					System.out.println("请输入手机号以确定将要删除的客户：");				
					String phoneNum =cmu.readString(11);
					
					if (customers.map.containsKey(phoneNum)) {				
						customers.deleteCustomer(phoneNum);					
						System.out.println("---------------------删除完成---------------------");
					}else{
						System.out.println("该手机号没有匹配到以存入的客户，请检查后再输入");
					}				
					
					System.out.println("是否继续删除？(Y/N)");
					flag =cmu.readString(1);
				} while ("y".equals(flag)||"Y".equals(flag));
				
				break;
			case '4':
				System.out.println("---------------------客户列表---------------------");
				System.out.println("姓名	性别	年龄	电话	邮箱");
				customers.getAllCustomers();
				System.out.println("---------------------客户列表---------------------");
				break;
			case '5':
				System.out.println("感谢您使用本软件，欢迎下次使用！");
				return;
			default:
				System.out.println("请输入正确的数字！");
				break;
			}
			
		} 
		
		
	}

	
	
}
