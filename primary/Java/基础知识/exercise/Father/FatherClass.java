package Father;

public class FatherClass {

	private int num ;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}


	public FatherClass() {
		super();
	}

	public FatherClass(int num) {
		super();
		this.num = num;
	}




	void show(){
		System.out.println("Êı×ÖÊÇ£º"+num);
	}
	
}
