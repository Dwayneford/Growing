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
	
	
	//封装接口
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
	//构造方法
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
	//display方法
	void display(){
		System.out.println("时间为：星期"+week+"；时"+hour+"；分"+minute+"；秒"+second+"。");
	}
	//时间加减方法
	int addMinute(int min){
		minute+=min;
		System.out.println("增加"+min+"分钟");
		this.display();
		return minute;
		
	}
	
	int addHour(int hou){
		hour+=hou;
		System.out.println("增加"+hou+"小时");
		this.display();
		return hour;
		
	}
	
	int addWeek(int wee){
		week+=wee;
		System.out.println("增加"+wee+"天");
		this.display();
		return week;
		
	}

	
	int addSecond(int sec){
		second+=sec;
		System.out.println("增加"+sec+"秒");
		this.display();
		return second;
		
	}
	
	int subMinute(int min){
		minute-=min;
		System.out.println("减少"+min+"分钟");
		this.display();
		return minute;
		
	}
	
	int subHour(int hou){
		hour-=hou;
		System.out.println("减少"+hou+"小时");
		this.display();
		return hour;
		
	}
	
	int subWeek(int wee){
		week-=wee;
		System.out.println("减少"+wee+"天");
		this.display();
		return week;
		
	}

	
	int subSecond(int sec){
		second-=sec;
		System.out.println("减少"+sec+"秒");
		this.display();
		return second;
		
	}
	
}
