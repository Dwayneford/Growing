package com.yc123.service;

public class XinjiangAircraft extends Aerocraft{
	//ӵ�� ���������� �� ����
	
	
	//�ڸ���Ļ����� �������� ��������Ϣ
	private String working_frequency_band;//����Ƶ��  
	private String image_system; 		  // Ӱ��ϵͳ
	private String range_of_voyage; 	  //�������
	private String remote_control_system; //ң��ϵͳ 
	private String environmental;         //Perception������֪
	private String focusing;              //�۽�����
	
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
	 * ���ܸ���
	 *   ���ø÷��� ��ʹ �����������趨·�ߣ�����ģʽ�Զ� ����Ŀ�ģ�
	 */
	public void intelligent_following(){
		System.out.println("���ø÷��� ��ʹ �����������趨·�ߣ�����ģʽ�Զ� ����Ŀ��");
	}
	/**
	 * ָ�����
	 */
	public void pointing_flight(){
		System.out.println("ָ�����");
		
	}
	
	/**
	 * ���ܷ��� 
	 */
	public void pntelligent_return(){
		System.out.println("���ܷ���");
	}
	
	/**
	 * ��д����ķ��� ����
	 */
	public void airFlight() {
		System.out.println("������д�˸���ķ��� ����.....");
	}
	
	
}
