package CoupleCheck;

public abstract class Person implements Couple{

	protected String name;
	protected String sex ;
	protected int age ;
	protected boolean marry; //true Ϊδ��飬falseΪ�ѽ��
	//���췽��
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
	
	//����
	public boolean isAge(){
		System.out.println("�ж������Ƿ�Ϸ�");
		return false;
					
	}
	
	public boolean isCople(Person person){
		System.out.println("�ж��Ƿ���");
		return false;
		
	}
	
	
	
}
