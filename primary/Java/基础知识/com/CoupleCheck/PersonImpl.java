package CoupleCheck;

public class PersonImpl extends Person{
	
	

	public PersonImpl() {
		super();

	}

	public PersonImpl(String name, String sex, int age, boolean marry) {
		super(name, sex, age, marry);

	}

	//�ж������Ƿ�Ϸ�
	public boolean isAge(){
		//�д���23��Ů����21
		boolean x ;
		if("��".equals(this.sex) && this.age >= 23 ){
			x=true;
		}else if ("Ů".equals(this.sex) && this.age >= 21) {
			x=true;
		}else{
			x=false;
		}
		return x;
					
	}
	
	//�ж��ܷ���
	@Override
	public void isCouple(Person person) {
		PersonImpl p = (PersonImpl)person;
		if(this.sex==p.sex){
			System.out.println("�й�Ŀǰ����֧��ͬ�Խ�飡");
		}else if (this.marry==false || p.marry == false) {
			System.out.println("����ͬʱδ�����У�");
		}else if (this.isAge()== false || p.isAge()== false){
			System.out.println("���䲻�Ϸ���");
		}else{
			System.out.println(this.name+"��"+p.name+"���Ͻ��������");
		}
		
	}

}
