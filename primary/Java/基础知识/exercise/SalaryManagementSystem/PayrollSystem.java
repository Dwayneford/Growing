package SalaryManagementSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PayrollSystem {

	public static void main(String[] args) {
		Employee e1=new SalariedEmployee("����", 10001, new MyDate(1990, 5, 30),5500);
		Employee e2=new SalariedEmployee("���", 10002, new MyDate(1995, 7, 12),5000);
		Employee e3=new SalariedEmployee("���", 10003, new MyDate(1994, 3, 24),5900);
		Employee e4=new SalariedEmployee("�ṷ", 10004, new MyDate(1999, 11, 9),4200);
		Employee e5=new SalariedEmployee("�ϱ���", 10005, new MyDate(1991, 2, 17),7100);
		List list = new ArrayList();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		System.out.println("��Ա��Ϣ���£�");
		Iterator iter = list.iterator();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object);

		}
		System.out.println("#######");
		
		System.out.println("����Ϊ��"+e1.earnings(5));
		System.out.println("#######");
		
		System.out.println("����Ϊ��"+e2.earnings(5));
		
	}
}
