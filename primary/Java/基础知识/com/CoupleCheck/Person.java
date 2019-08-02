package CoupleCheck;

public abstract class Person implements Couple{

	protected String name;
	protected String sex ;
	protected int age ;
	protected boolean marry; //true 为未结婚，false为已结婚
	//构造方法
	public Person(String name, String sex, int age, boolean marry) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.marry = marry;
	}

	public Person() {
		super();
	}
	
	//方法
	public boolean isAge(){
		System.out.println("判断年龄是否合法");
		return false;
					
	}
	
	public boolean isCople(Person person){
		System.out.println("判断是否结婚");
		return false;
		
	}
	
	
	
}
