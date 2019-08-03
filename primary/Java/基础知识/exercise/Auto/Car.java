package Auto;

public class Car extends Auto{

	double temperature;
	int volume;
	
	//打开空调的方法
	void airCon(double temperature){
		System.out.println("打开空调，温度为："+ temperature);
	}
	
	//打开CD
	void openCD(int volume){
		System.out.println("听听歌，音量为"+volume);
		
	}

	@Override
	void stop() {
		System.out.println("子类小汽车快速刹车");
	}
	
	void stop1(){
		super.stop();
	}
	
}
