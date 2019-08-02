package com.yc123.abstractTemp;
//使用抽象类定义 一天的工作内容
public abstract class Template {
	
	//定义抽象方法
	protected abstract void start();
	protected abstract void work();
	protected abstract void end();
	
	
	/**
	 * 定义工作方法
	 */
	public void  doWorkIng(){
		start();
		work();
		end();
	}
}
