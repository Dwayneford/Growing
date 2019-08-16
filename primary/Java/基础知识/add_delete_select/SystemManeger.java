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
			System.out.println("-------雇员增删改查小程序------");
			System.out.println("请选择功能（1、2、3、4、）：");
			System.out.println("1、新增员工");
			System.out.println("2、修改员工");
			System.out.println("3、我要裁员");
			System.out.println("4、查询员工");
			System.out.println("5、退出程序");
			num=sca.nextInt();
			switch (num) {
			case 1:
				System.out.println("请输入ID：");
				id=sca.nextInt();
				System.out.println("请输入姓名：");
				name=sca.next().trim();
				Manager manager = new Manager();
				System.out.println("请输入工作年龄：");
				work=sca.nextInt();
				manager.setId(id);
				manager.setName(name);
				manager.setWork(work);
				if (dao.insert(manager)) {
					System.out.println("员工新增成功！");
				}else {
					System.out.println("员工新增失败！");
				}
				break;
			case 2:
				System.out.println("请输入要修改员工的ID：");
				int idold=sca.nextInt();
				System.out.println("请输入ID：");
				id=sca.nextInt();
				System.out.println("请输入姓名：");
				name=sca.next().trim();
				System.out.println("请输入工作年龄：");
				work=sca.nextInt();
				Manager userEnt = new Manager(id, name, work);
				dao.update(userEnt, idold);
				
				break;
			case 3:
				System.out.println("请输入姓名：");
				name=sca.next().trim();
				
				if (dao.delete(name)) {
					System.out.println("裁员成功！");
				}else {
					System.out.println("裁员失败！");
				}
				
				break;
			case 4:
				System.out.println("正在查询！");
				ArrayList<Manager> list = dao.select();
				if (list.size()==0) {
					System.out.println("没有任何员工");
				}else {
					for (Manager m : list) {
						System.out.println(m.toString());
					}
				}				
				break;
			case 5:
				System.out.println("您已退出本程序，欢迎再次使用！");
				flag= false;
				return;
			default:
				System.out.println("请输入相应的功能！");
			}
			
		}					
	}
}
