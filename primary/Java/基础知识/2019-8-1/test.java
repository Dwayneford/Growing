package homeWork7_31;

public class test{

	public static void main(String[] args) {
		soldier commander =new soldier();
		commander.move();
		//����
		soldier infantry =new infantry();
		infantry.move();
		infantry.attack();
		//ˮ��
		soldier navy = new Navy();
		navy.move();
		navy.attack();
		//�վ�
		soldier aiForce= new aiForce();
		aiForce.move();
		aiForce.attack();
		
	}

	
}
