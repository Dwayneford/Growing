package com.yc123.test;
import java.util.Random;
import java.util.Scanner;
public class Test02 {
	// ���������Ҷ�Ӧ���Ƶ�����
	static String playerFinger = "";
	static String npcFinger = "";
	public static void main(String[] args) {
		// ����ɨ��������
		Scanner scanner = new Scanner(System.in);
		System.out.println("---��ӭʹ��YC123���ʯͷ��������Ϸ---");
		// �����Ƿ�����ı�־
		boolean flag = true;
		do {
			System.out.println("���������:��1��ʯͷ, 2������, 3������");
			// ������ҵ�����
			int player = scanner.nextInt();
			//����
			switch (player) {
			case 1:
				playerFinger = "ʯͷ";
				break;
			case 2:
				playerFinger = "����";
				break;
			case 3:
				playerFinger = "��";
				break;
			}
			//��������� ��������
			Random rd = new Random();
			//����1~3֮��������
			int npc = rd.nextInt(3) + 1;
			switch (npc) {
			case 1:
				npcFinger = "ʯͷ";
				break;
			case 2:
				npcFinger = "����";
				break;
			case 3:
				npcFinger = "��";
				break;
			}
			
			//�û������ ���ֺ� ���Բ���������;���ΰ����Ƚϣ�
			switch (player) {
				case 1:
				comPic(npc);
				break;
			case 2:
				comPic(npc);
				break;
			case 3:
				comPic(npc);
				break;
			}
			// �ж���Ϸ�Ƿ����
			System.out.println("�Ƿ������Ϸ?y/n");
			String val = scanner.next();
			if (val.equals("y")) {
				flag = true;
			} else {
				flag = false;
				System.out.println("��ӭ�´����棡");
			}
		} while(flag);
		//�ر�����
		scanner.close();
	}
	
	//�ͼ�������������ֽ��бȽ�
	public static void comPic(int npc){
		switch (npc) {
			case 1:
			System.out.println("ƽ��");
			break;
		case 2:
			System.out.println("��Ӯ��");
			break;
		case 3:
			System.out.println("������");
			break;
		}
		System.out.println("�����:" + playerFinger + ",���Գ�����:" + npcFinger);
	}

}
