package com.myTime;

public class MyTime {
	
	public static void main(String[] args) {
		MyTime t = new MyTime();
		t.setWeek(1);
		t.setHour(8);
		t.setMinute(31);
		t.setSecond(17);
		t.display();
		System.out.println("###################");
		t.addMinute(5);
		t.subSecond(10);
		
	}
	

	private int week;
	private int hour;
	private int minute;	
	private int second;
	
	
	//��װ�ӿ�
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	//���췽��
	public MyTime(int week, int hour, int minute, int second) {
		super();
		this.week = week;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	public MyTime() {
		super();
	}
	//display����
	void display(){
		System.out.println("ʱ��Ϊ������"+week+"��ʱ"+hour+"����"+minute+"����"+second+"��");
	}
	//ʱ��Ӽ�����
	int addMinute(int min){
		minute+=min;
		System.out.println("����"+min+"����");
		this.display();
		return minute;
		
	}
	
	int addHour(int hou){
		hour+=hou;
		System.out.println("����"+hou+"Сʱ");
		this.display();
		return hour;
		
	}
	
	int addWeek(int wee){
		week+=wee;
		System.out.println("����"+wee+"��");
		this.display();
		return week;
		
	}

	
	int addSecond(int sec){
		second+=sec;
		System.out.println("����"+sec+"��");
		this.display();
		return second;
		
	}
	
	int subMinute(int min){
		minute-=min;
		System.out.println("����"+min+"����");
		this.display();
		return minute;
		
	}
	
	int subHour(int hou){
		hour-=hou;
		System.out.println("����"+hou+"Сʱ");
		this.display();
		return hour;
		
	}
	
	int subWeek(int wee){
		week-=wee;
		System.out.println("����"+wee+"��");
		this.display();
		return week;
		
	}

	
	int subSecond(int sec){
		second-=sec;
		System.out.println("����"+sec+"��");
		this.display();
		return second;
		
	}
	
}
