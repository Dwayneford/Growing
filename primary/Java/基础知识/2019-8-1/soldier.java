package homeWork7_31;
//ʿ����
public class soldier {

	private int Aggressivity;  //������
	private int num;			//����
	private double moveSpeed;	//�ƶ��ٶ�
	
	
	
	
	//��������
	void attack(){
		System.out.println("���ٺ�ʿ���Ѿ�����׼��������");
	}
	//�ƶ�����
	void move(){
		System.out.println("���ٺ�ʿ���ƶ���Ŀ�ĵأ�׼��������");
	}
	
}

//������
class infantry extends soldier{

	@Override
	void attack() {
		System.out.println("����������");
		
	}

	@Override
	void move() {
		System.out.println("�����ƶ���");
		
	}
	
}

//ˮ����
class Navy extends soldier{

	@Override
	void attack() {
		System.out.println("ˮ��������");
		
	}

	@Override
	void move() {
		System.out.println("ˮ���ƶ���");
		
	}
	
}

//������
class aiForce extends soldier{

	@Override
	void attack() {
		System.out.println("�վ���Ϯ��");
		
	}

	@Override
	void move() {
		System.out.println("�վ������У�");
		
	}
	
}







