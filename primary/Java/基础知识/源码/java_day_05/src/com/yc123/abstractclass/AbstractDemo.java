package com.yc123.abstractclass;
public abstract class AbstractDemo {
	/**
	 * �����ࣺ
	 * 	  ��һ�����ܾ������� �Ķ��󣬽��г���Ķ���(UFO, ˧��,  ��Ů.....)
	 *   �������� ʹ�� abstract�������ε���
	 *     ���еķ��� �� abstract ���εķ������������п����� �ǳ��󷽷���
	 *     �������Ǳ� �̳е��࣬����ʵ�ֲ��� ���󷽷���
	 *     �̳��� Ҳ����� �����ˣ�
	 *     
	 *     ���������� ���캯�������ǲ����Դ�������������(ʵ����ȫ�����󷽷�������)�������� ��ʱ�� ���ó�����Ĺ��캯��;
	 */
	public AbstractDemo(){
		super();
		System.out.println("������ AbstractDemo �еĹ��캯��.....");
	}
	
	//�ܱ����� Ȩ��
	protected void hello(){
		System.out.println("����һ�� ����ķǳ��� ����");
	}
	
	//������� ��� ����
	protected abstract String fly();

	public abstract void eatSome();
	//.....
	
}
