package com.yc123.demo;

public class Modifier {
	/**
	 * Ȩ�����η���
	 *  private :˽�� Ȩ�ޣ��ڴ����Ķ��� ���߱�����ʹ�ã�
		default :ͬһ�����е��� ���ܷ���
		protected:�ܱ�����Ȩ�����η���ͬһ�������Է��ʣ��������� ��������� ���Է��ʣ�
		public:���е� �� �����Է���
	 */
	public String modName;
	
	/*ͨ������ ȷ�� ���η���ʹ��*/
	private void hello(){
		System.out.println("���� ˽�еķ��� �����ң�������");
	}
	
	protected void hello1(){
		System.out.println("���� �ܱ����ķ����� ����ſ���ʹ�ã����� /ͬһ��");
	}
	
	void hello2(){
		System.out.println("��Ĭ�����η� �ķ���������");
	}
	
	public static final void hello3(){
		System.out.println("������ ����������õķ���������");
		
	}
	
	
	// ���巽�� ���� ����ͬ Ȩ�����η� �����ķ���
	public static void main(String[] args) {
		Modifier modEnt = new Modifier();
		modEnt.hello();
		modEnt.hello1();
		
		modEnt.hello2();
		modEnt.hello3();
		
	}
	
	
}
