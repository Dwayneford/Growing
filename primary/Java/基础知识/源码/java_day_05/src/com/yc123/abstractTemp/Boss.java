package com.yc123.abstractTemp;

public class Boss extends Template{

	@Override
	protected void start() {
		System.out.println("Boss����....");
	}

	@Override
	protected void work() {
		System.out.println("����һ���裬����һ�ݱ�ֽ...");
	}

	@Override
	protected void end() {
		System.out.println("�ϰ�����...");
	}

	
}
