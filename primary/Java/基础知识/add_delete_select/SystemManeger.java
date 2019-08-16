package add_delete_select;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.element.Element;

public class SystemManeger {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		boolean flag = true;
		int num;
		String name;
		int work=0;	
		int id;
		ManagerDao dao = new ManagerDao();
		while (flag) {
			System.out.println("-------��Ա��ɾ�Ĳ�С����------");
			System.out.println("��ѡ���ܣ�1��2��3��4������");
			System.out.println("1������Ա��");
			System.out.println("2���޸�Ա��");
			System.out.println("3����Ҫ��Ա");
			System.out.println("4����ѯԱ��");
			System.out.println("5���˳�����");
			num=sca.nextInt();
			switch (num) {
			case 1:
				System.out.println("������ID��");
				id=sca.nextInt();
				System.out.println("������������");
				name=sca.next().trim();
				Manager manager = new Manager();
				System.out.println("�����빤�����䣺");
				work=sca.nextInt();
				manager.setId(id);
				manager.setName(name);
				manager.setWork(work);
				if (dao.insert(manager)) {
					System.out.println("Ա�������ɹ���");
				}else {
					System.out.println("Ա������ʧ�ܣ�");
				}
				break;
			case 2:
				System.out.println("������Ҫ�޸�Ա����ID��");
				int idold=sca.nextInt();
				System.out.println("������ID��");
				id=sca.nextInt();
				System.out.println("������������");
				name=sca.next().trim();
				System.out.println("�����빤�����䣺");
				work=sca.nextInt();
				Manager userEnt = new Manager(id, name, work);
				dao.update(userEnt, idold);
				
				break;
			case 3:
				System.out.println("������������");
				name=sca.next().trim();
				
				if (dao.delete(name)) {
					System.out.println("��Ա�ɹ���");
				}else {
					System.out.println("��Աʧ�ܣ�");
				}
				
				break;
			case 4:
				System.out.println("���ڲ�ѯ��");
				ArrayList<Manager> list = dao.select();
				if (list.size()==0) {
					System.out.println("û���κ�Ա��");
				}else {
					for (Manager m : list) {
						System.out.println(m.toString());
					}
				}				
				break;
			case 5:
				System.out.println("�����˳������򣬻�ӭ�ٴ�ʹ�ã�");
				flag= false;
				return;
			default:
				System.out.println("��������Ӧ�Ĺ��ܣ�");
			}
			
		}					
	}
}
