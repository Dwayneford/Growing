package com.yc123.abstractTemp;
//定义一个雇员类
public class Employee extends Template {

	@Override
	protected void start() {
		System.out.println("我要起来 打卡上班....");
		System.out.println("吃早饭.");
	}

	@Override
	protected void work() {
		System.out.println("1.到公司打卡");
		System.out.println("2.项目经理分配当前 任务");
		System.out.println("3.开电脑，开始写功能");
		System.out.println("4.调试程序 修改问题");
		
		System.out.println("5.结束任务 汇报工作");
	}

	@Override
	protected void end() {
		System.out.println("关闭电脑");
		System.out.println("打卡下班...");
	}
}
