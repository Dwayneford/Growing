package com.yc123.test;
import java.util.Random;
import java.util.Scanner;
public class Test02 {
	// 定义接收玩家对应手势的名称
	static String playerFinger = "";
	static String npcFinger = "";
	public static void main(String[] args) {
		// 创建扫描器对象
		Scanner scanner = new Scanner(System.in);
		System.out.println("---欢迎使用YC123班的石头剪刀布游戏---");
		// 定义是否继续的标志
		boolean flag = true;
		do {
			System.out.println("输入的手势:（1、石头, 2、剪刀, 3、布）");
			// 接收玩家的输入
			int player = scanner.nextInt();
			//手势
			switch (player) {
			case 1:
				playerFinger = "石头";
				break;
			case 2:
				playerFinger = "剪刀";
				break;
			case 3:
				playerFinger = "布";
				break;
			}
			//创建随机数 电脑手势
			Random rd = new Random();
			//产生1~3之间的随机数
			int npc = rd.nextInt(3) + 1;
			switch (npc) {
			case 1:
				npcFinger = "石头";
				break;
			case 2:
				npcFinger = "剪刀";
				break;
			case 3:
				npcFinger = "布";
				break;
			}
			
			//用户输入的 数字和 电脑产生的数字;依次挨个比较：
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
			// 判断游戏是否继续
			System.out.println("是否继续游戏?y/n");
			String val = scanner.next();
			if (val.equals("y")) {
				flag = true;
			} else {
				flag = false;
				System.out.println("欢迎下次在玩！");
			}
		} while(flag);
		//关闭输入
		scanner.close();
	}
	
	//和计算机产生的数字进行比较
	public static void comPic(int npc){
		switch (npc) {
			case 1:
			System.out.println("平局");
			break;
		case 2:
			System.out.println("你赢了");
			break;
		case 3:
			System.out.println("你输了");
			break;
		}
		System.out.println("你出是:" + playerFinger + ",电脑出的是:" + npcFinger);
	}

}
