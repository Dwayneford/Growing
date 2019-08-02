package com.yc123.demo;

public class TestMain {
	//入口函数
	public static void main(String[] args) {
		
		//通过 PeopleClass 获得张三实体对象
		PeopleClass zs = new PeopleClass();
		
		//设置属性 调用 方法
		zs.age= 100;
		zs.weight=150;
		
		//使用私有化 属性 ，赋值
		zs.setName("刘德华");
		zs.setGender('M');
		zs.setJob("歌手");
		zs.setTall(175.00);
		
		
		//取值
		String peoInfo = zs.getName()+"=="+zs.getGender()+"=="+zs.age+"=="+
						 zs.getTall()+"=="+zs.weight+"=="+zs.getJob();
		System.out.println("人员基本信息："+peoInfo);
		
		//调用 对象的方法
		String retStr = zs.learning();
		
		System.out.println("retStr==>"+retStr);
		
		zs.walk();
		
		//创建一个员工对象
		EmpClass empent = new EmpClass();
		empent.setEmpName("张三");
		empent.setEmpAge(25);
		empent.setEmpEducation("本科");
		empent.setEmpPost("项目经理");
		empent.setEmpSex("男");
		empent.setEmpSpec("跆拳道");
		empent.setEmpWrokYear(5);
		
		double totalMoney = empent.paymentWages(empent);
		
		System.out.println("员工信息为："+empent.toString());
		System.out.println("总工资为："+totalMoney);
		
		
		/************************/
		Teacher tent = new Teacher();
		tent.setName("人工智能开发讲师");
		
		System.out.println("tent.getName()==>"+tent.getName());
		
		//使用常亮
		String finalAddress = tent.ADDRESS_CODE;
		
		String finalClass =Teacher.ADDRESS_CODE;
		//不允许第二次赋值
		//Teacher.ADDRESS_CODE="AD_21053_USA";
		System.out.println("finalAddress==>"+finalAddress+",finalClass==>"+finalClass);
		
		
	}
	
}
