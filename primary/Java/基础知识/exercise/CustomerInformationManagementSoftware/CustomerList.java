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
//		cl.addCustomer(new Customer("小张", "男", 24, "15688456312", "15688456312@163.com"));
//		cl.addCustomer(new Customer("小倩", "女", 22, "13568432235", "13568432235@186.com"));
//		cl.addCustomer(new Customer("小裕", "女", 22, "18216512251", "18216512251@186.com"));
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
//		cl.replaceCustomer("13568432235", new Customer("小倩", "女", 21, "18568432735", "18568432735@186.com"));
//		cl.getAllCustomers();
//	}
	Map map =new HashMap();
	Customer[] customers;
	int total = 0  ;
	
	//用途：构造器，用来初始化customers数组
	//参数：totalCustomer：指定customers数组的最大空间
	public CustomerList(int totalCustomer){
		
	}
	public CustomerList(){
		
	}
	
	
	//用途：将参数customer添加组中最后一个客户对象记录之后
	//参数：customer指定要添加的客户对象 
	//返回：添加成功返回true；false表示数组已满，无法添加
	public boolean addCustomer(Customer customer) {
		List list = new ArrayList();
		list.add(customer);
		map.put(customer.getPhone(), list);
		return false;		
	}

	//用途：用参数customer替换数组中由index指定的对象
	//参数：customer指定替换的新客户对象 ,index指定所替换对象在数组中的位置
	//返回：替换成功返回true；false表示索引无效，无法替换
	public boolean replaceCustomer(String  phone, Customer customer){
		
		map.remove(phone);
//		map.replace(key, value);
		List list = new ArrayList();
		list.add(customer);
		map.put(customer.getPhone(), list);
		System.out.println("替换成功！");
		return false;
		
	}

	//用途：从数组中删除参数index指定索引位置的客户对象记录
	//参数： index指定所删除对象在数组中的索引位置
	//返回：删除成功返回true；false表示索引无效，无法删除
	public boolean deleteCustomer(String phone){
		map.remove(phone);
		System.out.println("删除成功");
		return false;		
	}

	
	//用途：返回数组中记录的所有客户对象
	//返回： Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
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
	
	//用途：返回参数index指定索引位置的客户对象记录
	//参数： index指定所要获取的客户对象在数组中的索引位置
	//返回：封装了客户信息的Customer对象
	public Customer getCustomer(String phone) {
		System.out.println(map.get(phone));

		return null;
		
	}

}
