package com.yc123.service;

public class XinjiangAircraft extends Aerocraft{
	//拥有 公共的属性 和 方法
	
	
	//在父类的基础上 继续完善 ，子类信息
	private String working_frequency_band;//工作频段  
	private String image_system; 		  // 影像系统
	private String range_of_voyage; 	  //续航里程
	private String remote_control_system; //遥控系统 
	private String environmental;         //Perception环境感知
	private String focusing;              //聚焦功能
	
	public String getWorking_frequency_band() {
		return working_frequency_band;
	}
	public void setWorking_frequency_band(String working_frequency_band) {
		this.working_frequency_band = working_frequency_band;
	}
	public String getImage_system() {
		return image_system;
	}
	public void setImage_system(String image_system) {
		this.image_system = image_system;
	}
	public String getRange_of_voyage() {
		return range_of_voyage;
	}
	public void setRange_of_voyage(String range_of_voyage) {
		this.range_of_voyage = range_of_voyage;
	}
	public String getRemote_control_system() {
		return remote_control_system;
	}
	public void setRemote_control_system(String remote_control_system) {
		this.remote_control_system = remote_control_system;
	}
	public String getEnvironmental() {
		return environmental;
	}
	public void setEnvironmental(String environmental) {
		this.environmental = environmental;
	}
	public String getFocusing() {
		return focusing;
	}
	public void setFocusing(String focusing) {
		this.focusing = focusing;
	}
	/**
	 * 智能跟随
	 *   调用该方法 可使 飞行器根据设定路线，飞行模式自动 到达目的；
	 */
	public void intelligent_following(){
		System.out.println("调用该方法 可使 飞行器根据设定路线，飞行模式自动 到达目的");
	}
	/**
	 * 指点飞行
	 */
	public void pointing_flight(){
		System.out.println("指点飞行");
		
	}
	
	/**
	 * 智能返航 
	 */
	public void pntelligent_return(){
		System.out.println("智能返航");
	}
	
	/**
	 * 重写父类的飞行 方法
	 */
	public void airFlight() {
		System.out.println("子类重写了父类的飞行 方法.....");
	}
	
	
}
