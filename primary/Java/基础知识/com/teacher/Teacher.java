package HomeWork8_3;

public abstract class Teacher  {

	private String name;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public Teacher() {
		super();
	}
	
	
	
	
	public Teacher(String name) {
		super();
		this.name = name;
	}
	abstract void physics();
	abstract void math();
	abstract void sport();
	
	
}
