package CoupleCheck;

public class PersonImpl extends Person{
	
	

	public PersonImpl() {
		super();

	}

	public PersonImpl(String name, String sex, int age, boolean marry) {
		super(name, sex, age, marry);

	}

	//判断年龄是否合法
	public boolean isAge(){
		//男大于23，女大于21
		boolean x ;
		if("男".equals(this.sex) && this.age >= 23 ){
			x=true;
		}else if ("女".equals(this.sex) && this.age >= 21) {
			x=true;
		}else{
			x=false;
		}
		return x;
					
	}
	
	//判断能否结婚
	@Override
	public void isCouple(Person person) {
		PersonImpl p = (PersonImpl)person;
		if(this.sex==p.sex){
			System.out.println("中国目前还不支持同性结婚！");
		}else if (this.marry==false || p.marry == false) {
			System.out.println("两方同时未结婚才行！");
		}else if (this.isAge()== false || p.isAge()== false){
			System.out.println("年龄不合法！");
		}else{
			System.out.println(this.name+"和"+p.name+"符合结婚条件！");
		}
		
	}

}
