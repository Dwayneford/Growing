package com.yc123.abstractTemp;
//ʹ�ó����ඨ�� һ��Ĺ�������
public abstract class Template {
	
	//������󷽷�
	protected abstract void start();
	protected abstract void work();
	protected abstract void end();
	
	
	/**
	 * ���幤������
	 */
	public void  doWorkIng(){
		start();
		work();
		end();
	}
}
