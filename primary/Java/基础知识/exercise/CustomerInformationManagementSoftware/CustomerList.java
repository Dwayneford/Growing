package CustomerInformationManagementSoftware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomerList {
	
//	public static void main(String[] args) {
//		CustomerList cl = new CustomerList(10);
//		cl.addCustomer(new Customer("С��", "��", 24, "15688456312", "15688456312@163.com"));
//		cl.addCustomer(new Customer("Сٻ", "Ů", 22, "13568432235", "13568432235@186.com"));
//		cl.addCustomer(new Customer("Сԣ", "Ů", 22, "18216512251", "18216512251@186.com"));
//		
//		
//		cl.getAllCustomers();
//		System.out.println("#########");
//		cl.deleteCustomer("15688456312");
//		cl.getAllCustomers();
//		System.out.println("#########");
//		cl.getCustomer("13568432235");
//		System.out.println("#########");
//		
//		cl.replaceCustomer("13568432235", new Customer("Сٻ", "Ů", 21, "18568432735", "18568432735@186.com"));
//		cl.getAllCustomers();
//	}
	Map map =new HashMap();
	Customer[] customers;
	int total = 0  ;
	
	//��;����������������ʼ��customers����
	//������totalCustomer��ָ��customers��������ռ�
	public CustomerList(int totalCustomer){
		
	}
	public CustomerList(){
		
	}
	
	
	//��;��������customer����������һ���ͻ������¼֮��
	//������customerָ��Ҫ��ӵĿͻ����� 
	//���أ���ӳɹ�����true��false��ʾ�����������޷����
	public boolean addCustomer(Customer customer) {
		List list = new ArrayList();
		list.add(customer);
		map.put(customer.getPhone(), list);
		return false;		
	}

	//��;���ò���customer�滻��������indexָ���Ķ���
	//������customerָ���滻���¿ͻ����� ,indexָ�����滻�����������е�λ��
	//���أ��滻�ɹ�����true��false��ʾ������Ч���޷��滻
	public boolean replaceCustomer(String  phone, Customer customer){
		
		map.remove(phone);
//		map.replace(key, value);
		List list = new ArrayList();
		list.add(customer);
		map.put(customer.getPhone(), list);
		System.out.println("�滻�ɹ���");
		return false;
		
	}

	//��;����������ɾ������indexָ������λ�õĿͻ������¼
	//������ indexָ����ɾ�������������е�����λ��
	//���أ�ɾ���ɹ�����true��false��ʾ������Ч���޷�ɾ��
	public boolean deleteCustomer(String phone){
		map.remove(phone);
		System.out.println("ɾ���ɹ�");
		return false;		
	}

	
	//��;�����������м�¼�����пͻ�����
	//���أ� Customer[] �����а����˵�ǰ���пͻ����󣬸����鳤������������ͬ��
	public Customer[] getAllCustomers() {
		Set set =map.keySet();
		Iterator iter =set.iterator();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Object customer = (Object) iterator.next();
			List l=(ArrayList) map.get(customer);
			System.out.println(l);
		}
		
		return customers;
		
	}
	
	//��;�����ز���indexָ������λ�õĿͻ������¼
	//������ indexָ����Ҫ��ȡ�Ŀͻ������������е�����λ��
	//���أ���װ�˿ͻ���Ϣ��Customer����
	public Customer getCustomer(String phone) {
		System.out.println(map.get(phone));

		return null;
		
	}

}
