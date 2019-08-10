package CustomerInformationManagementSoftware;

public class Customer {

	
	private String name;
	private char gender ;
	private int age  ;
	private String phone;
	private String email ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer(String name, char gender2, int age, String phone, String email) {
		super();
		this.name = name;
		this.gender = gender2;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}
	@Override
	public String toString() {
		return name + "	" + gender + "	" + age + "	" + phone + "	"
				+ email;
	}
	
	
}
