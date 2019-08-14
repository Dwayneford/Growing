package reflectionAndIO;

public class Teacher {

	//定义方法
	private void salary(){
		System.out.println("salary方法 Java方向，薪资待遇：12K");
	}
	
	protected String studyMethod(){
		return "studyMethod方法";
	}
	
	void sayHello(){
		System.out.println("sayHello方法");
	}
	
	public String work(String work,String name){
		return work;
	}
}
