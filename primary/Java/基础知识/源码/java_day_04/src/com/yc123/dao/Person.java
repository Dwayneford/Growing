package com.yc123.dao;

public class Person {

	//�������� 
	
	
	//���� ���� �ڵ�ǰ�������� ����
	public String sayMySelf(String name,String sex,int age,String address){
		String retStr = "";
		//switch �ж����������
		switch (age) {
		case 18:
			if(("��").equals(sex)){
				retStr = "���Ǵ�ѧ�� �����ӣ�����Ϊ��"+age+"������"+name+",��ס"+address;
			}else{
				retStr = "���Ǵ�ѧ�� �廨������Ϊ��"+age+"������"+name+",��ס"+address;
			}
			break;
		case 28:
			if(("��").equals(sex)){
				retStr = "���Ǵ�ѧ�� ��Ϊ���꣬����Ϊ��"+age+"������"+name+",��ס"+address;
			}else{
				retStr = "���Ǵ�ѧ�� С��㣬����Ϊ��"+age+"������"+name+",��ס"+address;
			}
			break;
			
		case 38:
			if(("��").equals(sex)){
				retStr = "���Ǵ�ѧ�� ������壬����Ϊ��"+age+"������"+name+",��ס"+address;
			}else{
				retStr = "���Ǵ�ѧ�� ���̣�����Ϊ��"+age+"������"+name+",��ס"+address;
			}
			break;
		default:
			
			break;
		}
		
		return retStr;
	}
	
	//����sayMySelf ����
	public int sayMySelf(String happy,int age, String name){
		
		if(10<age && age<18){
			System.out.println(name+"�����ڽ׶Σ�����"+happy+"===="+age);
		}else if(18<=age && age<28){
			System.out.println(name+"��ᾫӢ�׶�v����"+happy+"===="+age);
		}else if(28<=age && age<38){
			System.out.println(name+"��ҵ�гɽ׶Σ���"+happy+"===="+age);
		}else if(38<=age && age<58){
			System.out.println(name+"���ȶ��ս׶Σ���"+happy+"===="+age);
		}else{
			System.out.println(name+"��Ե����׶Σ���"+happy+"===="+age);
		}
		
		return 0;
	}
	
	
}
