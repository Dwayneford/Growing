package com.dkt.test;

import java.util.Scanner;

public class OperatorMath {
	
	public static void main(String[] args) {
		//���÷���
		//String retStr = queryMaxMinNum();
		//System.out.println(retStr);
		
		//��������
		OperatorMath omEnt = new OperatorMath();
		//omEnt.sunNumFun();
		omEnt.cacheGoods();
		
	}
	/**
	 * ʹ�� while  dowhile ѭ�� ����������ͣ�100 ���ڵ� ���� ż����
	 * 
	 *  switch���齱��math �������� 1 �� 10 ��Χ���֣�ʹ�� switch....�ж� ���еĽ�Ʒ ��Ϣ ���...
	 *  	
	 *  if()......
	 */
	public void cacheGoods(){
		int mathNum = (int)Math.round(Math.random()*10);
		switch (mathNum) {
			case 1:
				System.out.println("��ˮ һƿ....");
				break;
			case 3:
				System.out.println("�ϸ���һƿ");
				break;
			case 5:
				System.out.println("�ٳ�һ��");
				break;
			case 7:
				System.out.println("�ֽ����ȯһ��");
				break;	
			default:
				
				System.out.println("лл����");
				break;
		}
	}
	
	public void sunNumFun(){
		//���� ��͵�����
		int countNum=0;
		int countNum2=0;
		int i= 1;
		while(i<=100){
			//�������� 
			if(i%2==1){
				countNum+=i;
			}
			//��ż����
			if(i%2==0){
				countNum2+=i;
			}
			
			i++;
		}
		
		System.out.println("������"+countNum+",ż���ͣ�"+countNum2);
		
		
	}
	
	
	
	
		/**
		 *  ���� ���� ���飺 ���� 5 ������ �������У� ���� �Ƚ�ȡ�����  ��Сֵ��
		 *  
		 */
	public static String queryMaxMinNum(){
		//�����������
		Scanner sc = new Scanner(System.in);
		//�����ܹ���� 6λ���ֵ�����
		int[] itarry = new int[5];
		//double [] dbarry = new double[5];
		//String [] strarry = new String[5];
		
		//�����д���ֵ
		for (int i = 0; i < 5; i++) {
			System.out.printf("�������%d������",(i+1));
			
			itarry[i] = sc.nextInt();
		}
		System.out.println("���ִ�� ��ɣ����ȣ�"+itarry.length);
		
		//���� �Ƚϴ�С
		int maxNum = itarry[0];
		int minNum = itarry[0];
		
		for(int h=0;h<itarry.length;h++){
			//��Ŀ ����
			maxNum = maxNum<itarry[h] ? itarry[h] : maxNum;
			
			minNum = minNum>itarry[h] ? itarry[h] : minNum;
		}
		return "�����Ϊ��"+maxNum+"�������Ϊ��"+minNum;
	}
	
	public void operMeht(){
		//����� ��ʹ��
				int count = 10;
				//����  �ݼ��� ʹ��
				System.out.println(count++);
				System.out.println(++count);
				
				System.out.println(count--);
				System.out.println(--count);
				
				
				System.out.println(count%3);
				
				//��Ŀ����
				String strNum = count%2>0 ? "����" : "ż��";
				
				// �������ʽ ?  ���� �� ��������
				// �������ʽ ?  (�������ʽ ? (�������ʽ ?  ���� �� ������) �� ������) �� ������;
				System.out.println(count+"�ǣ�"+strNum);
				
				//�߼������
				int num1 = 2;
				int num2 = 4;
				
				System.out.println(num1>1 && num2<-2); //false
				System.out.println(num1>1 || num2<-2); //true
				System.out.println(!(num1>1 || num2<-2)); //false
				
				/**
				 * λ�����  
				 * 0000101001  >> 2  ===>   0000001010
				 * 
				 */
				
				int a = 9;
				int b = 5;
				//0000 0101 ==>  0000 0001 ��==�� ���ƶ�
				System.out.println("b>>2==>"+(b>>2));
				//0000 0101 ==> 0010 1000��==�� ���ƶ�
				System.out.println(b<<3);
				
				
				/*
				 * ��λ ȡ�� ~
				 * 
				 * ����:
				 *   �����ƣ�0 1001
				 *  ���㲹�룺0 1001
				 *  ��λȡ����1 0110
				 *  
				 *  תΪԭ�룺1 1001
				 *  ĩλ��һ��1 1010
				 *  
				 *  ����λһ�ĸ���: -10;	
				 */
				System.out.println(~a);
				
				/**
				 * Java �е����̿��ƣ�
				 * 	 1. if(����){ }else if(){} else{}
				 *   2. switch (key) {
						case value:
							
							break;
						case value:
							
							break;
						default:
							break;
						}
						
					 3.	while(����){ }
				 * 
				 * 	 4.	do{ }while(����);
				 * 		
				 *   5.	for(��ʼֵ;�Ƚ�����;�����ı�){  }
				 * 
				 * 	 6.	for (����������������  �������� : ����/����) {
								��������......
						}
						
					  7. break; ��������ѭ������
						 continue; ������ǰѭ��������������һ��ѭ��
				 */
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
