package CustomerInformationManagementSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
	
	//��;����ʾ���˵�����Ӧ�û����룬�����û������ֱ����������Ӧ�ĳ�Ա����
	//	����addNewCustomer��������ɿͻ���Ϣ����

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
	
	//��;������CustomerViewʵ���������� enterMainMenu()������ִ�г���
	public static void main(String[] args){
			
		CustomerList customers = new CustomerList();		
		String name;
		char gender;
		int age;
		String phone;
		String email;
		String flag;
		
		while(true) {
			System.out.println("-----------------�ͻ���Ϣ�������-----------------");
			System.out.println("	1 �� �� �� ��");
			System.out.println("	2 �� �� �� ��");
			System.out.println("	3 ɾ �� �� ��");
			System.out.println("	4 �� �� �� ��");
			System.out.println("	5 ��           ��");
			System.out.println("	��ѡ��(1-5)��");
//			Scanner sca = new Scanner(System.in);
			CMUtility cmu = new CMUtility();
			char  num =cmu.readMenuSelection();
			switch (num) {
			case '1':
				do {
					System.out.println("---------------------��ӿͻ�---------------------");
					System.out.println("������������");
//					name =sca.next();
					name =cmu.readString(5);
					System.out.println("�������Ա�");
//					gender =sca.next();
					gender=cmu.readChar(); 
					System.out.println("���������䣡");
//					age =sca.nextInt();
					age=cmu.readInt(); 
					System.out.println("�������ֻ��ţ�");
//					phone =sca.next();
					phone =cmu.readString(11);  
					System.out.println("���������䣡");
//					email =sca.next();
					email=cmu.readString(25);
					Customer cust = new Customer(name, gender, age, phone, email);
					customers.addCustomer(cust);
					System.out.println("---------------------������---------------------");
					System.out.println("�Ƿ������ӣ�(Y/N)");
					flag =cmu.readString(1);
				} while ("y".equals(flag)||"Y".equals(flag));
				
				break;
			case '2':
				do {
					System.out.println("---------------------�޸Ŀͻ�---------------------");
					System.out.println("�������ֻ�����ȷ����Ҫ�޸ĵĿͻ���");				
					String phoneNum =cmu.readString(11);
					if (customers.map.containsKey(phoneNum)) {
											
						ArrayList al = (ArrayList) customers.map.get(phoneNum);
						Customer cust=(Customer) al.get(0);
						System.out.println("������Ҫ�޸ĵ�������"+cust.getName());
//						name =sca.next();
						name =cmu.readString(5,cust.getName());
						System.out.println("������Ҫ�޸ĵ��Ա�"+cust.getGender());
//						gender =sca.next();
						gender=cmu.readChar(cust.getGender()); 
						System.out.println("������Ҫ�޸ĵ����䣡"+cust.getAge());
//						age =sca.nextInt();
						age=cmu.readInt(cust.getAge()); 
						System.out.println("������Ҫ�޸ĵ��ֻ��ţ�"+cust.getPhone());
//						phone =sca.next();
						phone =cmu.readString(11,cust.getPhone());  
						System.out.println("������Ҫ�޸ĵ����䣡"+cust.getEmail());
//						email =sca.next();
						email=cmu.readString(25,cust.getEmail());
						customers.replaceCustomer(phoneNum, new Customer(name, gender, age, phone, email));
						
						System.out.println("---------------------�޸����---------------------");
					}else{
						System.out.println("���ֻ���û��ƥ�䵽�Դ���Ŀͻ��������������");
					}				
					
					System.out.println("�Ƿ�����޸ģ�(Y/N)");
					flag =cmu.readString(1);
				} while ("y".equals(flag)||"Y".equals(flag));

				break	;
			case '3':			
				do {
					System.out.println("---------------------ɾ���ͻ�---------------------");
					System.out.println("�������ֻ�����ȷ����Ҫɾ���Ŀͻ���");				
					String phoneNum =cmu.readString(11);
					
					if (customers.map.containsKey(phoneNum)) {				
						customers.deleteCustomer(phoneNum);					
						System.out.println("---------------------ɾ�����---------------------");
					}else{
						System.out.println("���ֻ���û��ƥ�䵽�Դ���Ŀͻ��������������");
					}				
					
					System.out.println("�Ƿ����ɾ����(Y/N)");
					flag =cmu.readString(1);
				} while ("y".equals(flag)||"Y".equals(flag));
				
				break;
			case '4':
				System.out.println("---------------------�ͻ��б�---------------------");
				System.out.println("����	�Ա�	����	�绰	����");
				customers.getAllCustomers();
				System.out.println("---------------------�ͻ��б�---------------------");
				break;
			case '5':
				System.out.println("��л��ʹ�ñ��������ӭ�´�ʹ�ã�");
				return;
			default:
				System.out.println("��������ȷ�����֣�");
				break;
			}
			
		} 
		
		
	}

	
	
}
