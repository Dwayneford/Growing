package homeWork7_31;

public class test{

	public static void main(String[] args) {
		soldier commander =new soldier();
		commander.move();
		//步兵
		soldier infantry =new infantry();
		infantry.move();
		infantry.attack();
		//水军
		soldier navy = new Navy();
		navy.move();
		navy.attack();
		//空军
		soldier aiForce= new aiForce();
		aiForce.move();
		aiForce.attack();
		
	}

	
}
