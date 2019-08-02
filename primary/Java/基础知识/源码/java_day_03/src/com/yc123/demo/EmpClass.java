package com.yc123.demo;
/*����Ա���ࣺ
Ա���������ԣ�5������
		  empName ����
		  empSex �Ա�
		  empAge Ա�����䣺
		  empEducation Ա��ѧ������ר  ����  �о���  ˶ʿ ��ʿ ....
		  empWrokYear �����趨��1~3,3~5,5~10,10������
		  empPost :��λ�趨������Ա������Ŀ����  ��Ŀ�ܼ�  CEO ���³�..
		  empSpec :Ա���س�������  ����  ̽��  ��Ĭ  ��ȭ�� ����......
		  .......
		  
Ա���ķ���������()��work type
		  ���ʷ���()��Payment of wages
		  Ա���س�()��Employee specialty
		  Ա��ѧϰ����(),learning ability
		 
Ҫ��:����Ա���ģ��������ݣ������س� ѧϰ�������ó� Ӧ�����ʣ�		

    �ο�����������5000Ԫ��
               ����ѧ������ͬ500Ԫ�ı䶯
               ���ݹ���Σ�ÿ������1000Ԫ
               ���ݸ�λ��ÿ������ 3000Ԫ
               Ա���س� ���־���:ÿһ��200Ԫ ��಻���� 1000Ԫ        
      .......              
*/
public class EmpClass {
	//����
	private String empName;
	private String empSex;
	private int empAge;
	private String empEducation;
	private int empWrokYear;
	private String empPost;
	private String empSpec;
	//�������� ����
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSex() {
		return empSex;
	}
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmpEducation() {
		return empEducation;
	}
	public void setEmpEducation(String empEducation) {
		this.empEducation = empEducation;
	}
	public int getEmpWrokYear() {
		return empWrokYear;
	}
	public void setEmpWrokYear(int empWrokYear) {
		this.empWrokYear = empWrokYear;
	}
	public String getEmpPost() {
		return empPost;
	}
	public void setEmpPost(String empPost) {
		this.empPost = empPost;
	}
	public String getEmpSpec() {
		return empSpec;
	}
	public void setEmpSpec(String empSpec) {
		this.empSpec = empSpec;
	}
	//���캯��
	public EmpClass(String empName, String empSex, int empAge, String empEducation, int empWrokYear, String empPost,
			String empSpec) {
		super();
		this.empName = empName;
		this.empSex = empSex;
		this.empAge = empAge;
		this.empEducation = empEducation;
		this.empWrokYear = empWrokYear;
		this.empPost = empPost;
		this.empSpec = empSpec;
	}
	public EmpClass() {
		super();
	}
	
	@Override
	public String toString() {
		return "EmpClass [empName=" + empName + ", empSex=" + empSex + ", empAge=" + empAge + ", empEducation="
				+ empEducation + ", empWrokYear=" + empWrokYear + ", empPost=" + empPost + ", empSpec=" + empSpec + "]";
	}
	
	
	//Ա�������Ϊ����:��������
	public double workType(String empPost){
		//�����λ���ʱ���
		double empSola = 0.0;
		switch (empPost) {
		case "����Ա��":
			empSola=3000;
			break;
		case "��Ŀ���� ":
			empSola=5000;		
			break;
		case "��Ŀ�ܼ�":
			empSola=8000;	
			break;
		case "CEO" :
			empSola=10000;	
			break;
		case "���³�Ա��":
			empSola=15000;	
			break;
		default:
			empSola=3000;
			break;
		}
		return empSola;
	}
	// Ա���س�()
	public double employeeSpecialty(String empSpec){
		//����  ����  ̽��  ��Ĭ  ��ȭ�� ����
		double specMoney = 0.0;
		if("����".equals(empSpec)){
			specMoney=200;
		}else if("����".equals(empSpec)){
			specMoney=200;
		}else if("̽��".equals(empSpec)){
			specMoney=50;
		}else if("��Ĭ".equals(empSpec)){
			specMoney=500;
		}else if("��ȭ��".equals(empSpec)){
			specMoney=1000;
		}else if("����".equals(empSpec)){
			specMoney=6000;
		}else{
			specMoney=200;
		}
		return specMoney;
	}
	//Ա��ѧϰ����   ����  �о���  ˶ʿ ��ʿ
	public double learningAbility(String empEducation){
		//�����λ���ʱ���
		double educationSola = 0.0;
		switch (empEducation) {
		
		case "����":
			educationSola=1000;		
			break;
		case "�о���":
			educationSola=2000;	
			break;
		case "˶ʿ" :
			educationSola=3000;	
			break;
		case "��ʿ":
			educationSola=5000;	
			break;
		default:
			break;
		}
		return educationSola;
	}
	//���ʷ���
	public double paymentWages(EmpClass empEnt){
		
		//Ӧ���ܹ���
		double totalMoney= 5000.00;
		//���õ�ǰ���󷽷�
		double workMon =  this.workType(empEnt.getEmpPost());
		double apecMon =  this.employeeSpecialty(empEnt.getEmpSpec());
		double abilityMon =  this.learningAbility(empEnt.getEmpEducation());
		
		//����
		return totalMoney+=(abilityMon+apecMon+workMon);
	}
	
	
	
	
	
	
	
}
