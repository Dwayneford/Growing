package com.yc123.demo;
/*定义员工类：
员工基本属性：5个以上
		  empName 名称
		  empSex 性别
		  empAge 员工年龄：
		  empEducation 员工学历：大专  本科  研究生  硕士 博士 ....
		  empWrokYear 工龄设定：1~3,3~5,5~10,10年以上
		  empPost :岗位设定：初级员工，项目经理  项目总监  CEO 董事长..
		  empSpec :员工特长：表演  主持  探险  幽默  跆拳道 赛车......
		  .......
		  
员工的方法：工作()，work type
		  工资发放()，Payment of wages
		  员工特长()，Employee specialty
		  员工学习能力(),learning ability
		 
要求:根据员工的，工作内容，个人特长 学习能力，得出 应发工资；		

    参考：基本工资5000元，
               根据学历：不同500元的变动
               根据工龄段：每段上张1000元
               根据岗位：每段上涨 3000元
               员工特长 扶持经费:每一项200元 最多不超过 1000元        
      .......              
*/
public class EmpClass {
	//属性
	private String empName;
	private String empSex;
	private int empAge;
	private String empEducation;
	private int empWrokYear;
	private String empPost;
	private String empSpec;
	//访问属性 方法
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
	//构造函数
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
	
	
	//员工类的行为方法:工作类型
	public double workType(String empPost){
		//定义岗位工资变量
		double empSola = 0.0;
		switch (empPost) {
		case "初级员工":
			empSola=3000;
			break;
		case "项目经理 ":
			empSola=5000;		
			break;
		case "项目总监":
			empSola=8000;	
			break;
		case "CEO" :
			empSola=10000;	
			break;
		case "董事长员工":
			empSola=15000;	
			break;
		default:
			empSola=3000;
			break;
		}
		return empSola;
	}
	// 员工特长()
	public double employeeSpecialty(String empSpec){
		//表演  主持  探险  幽默  跆拳道 赛车
		double specMoney = 0.0;
		if("表演".equals(empSpec)){
			specMoney=200;
		}else if("主持".equals(empSpec)){
			specMoney=200;
		}else if("探险".equals(empSpec)){
			specMoney=50;
		}else if("幽默".equals(empSpec)){
			specMoney=500;
		}else if("跆拳道".equals(empSpec)){
			specMoney=1000;
		}else if("赛车".equals(empSpec)){
			specMoney=6000;
		}else{
			specMoney=200;
		}
		return specMoney;
	}
	//员工学习能力   本科  研究生  硕士 博士
	public double learningAbility(String empEducation){
		//定义岗位工资变量
		double educationSola = 0.0;
		switch (empEducation) {
		
		case "本科":
			educationSola=1000;		
			break;
		case "研究生":
			educationSola=2000;	
			break;
		case "硕士" :
			educationSola=3000;	
			break;
		case "博士":
			educationSola=5000;	
			break;
		default:
			break;
		}
		return educationSola;
	}
	//工资发放
	public double paymentWages(EmpClass empEnt){
		
		//应发总工资
		double totalMoney= 5000.00;
		//调用当前对象方法
		double workMon =  this.workType(empEnt.getEmpPost());
		double apecMon =  this.employeeSpecialty(empEnt.getEmpSpec());
		double abilityMon =  this.learningAbility(empEnt.getEmpEducation());
		
		//返回
		return totalMoney+=(abilityMon+apecMon+workMon);
	}
	
	
	
	
	
	
	
}
