package com.yc123.abstractTemp;

public class Boss extends Template{

	@Override
	protected void start() {
		System.out.println("Boss来了....");
	}

	@Override
	protected void work() {
		System.out.println("喝了一杯茶，看了一份报纸...");
	}

	@Override
	protected void end() {
		System.out.println("老板走了...");
	}

	
}
