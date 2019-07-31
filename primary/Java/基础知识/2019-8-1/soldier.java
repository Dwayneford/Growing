package homeWork7_31;
//士兵类
public class soldier {

	private int Aggressivity;  //攻击力
	private int num;			//数量
	private double moveSpeed;	//移动速度
	
	
	
	
	//攻击方法
	void attack(){
		System.out.println("长官和士兵已就绪，准备进攻！");
	}
	//移动方法
	void move(){
		System.out.println("长官和士兵移动至目的地，准备就绪！");
	}
	
}

//步兵类
class infantry extends soldier{

	@Override
	void attack() {
		System.out.println("步兵进攻！");
		
	}

	@Override
	void move() {
		System.out.println("步兵移动！");
		
	}
	
}

//水军类
class Navy extends soldier{

	@Override
	void attack() {
		System.out.println("水军进攻！");
		
	}

	@Override
	void move() {
		System.out.println("水兵移动！");
		
	}
	
}

//步兵类
class aiForce extends soldier{

	@Override
	void attack() {
		System.out.println("空军空袭！");
		
	}

	@Override
	void move() {
		System.out.println("空军飞行中！");
		
	}
	
}







