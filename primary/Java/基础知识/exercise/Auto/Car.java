package Auto;

public class Car extends Auto{

	double temperature;
	int volume;
	
	//�򿪿յ��ķ���
	void airCon(double temperature){
		System.out.println("�򿪿յ����¶�Ϊ��"+ temperature);
	}
	
	//��CD
	void openCD(int volume){
		System.out.println("�����裬����Ϊ"+volume);
		
	}

	@Override
	void stop() {
		System.out.println("����С��������ɲ��");
	}
	
	void stop1(){
		super.stop();
	}
	
}
