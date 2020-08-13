package chapter12.enumEx;

// p.698

enum Transportation{
	BUS(100){
		int fare(int distance) {
			return distance*BASIC_FARE;
		}
	},
	
	TRAIN(150){
		int fare(int distance) {
			return distance*BASIC_FARE;
		}
	},
	
	SHIP(100){
		int fare(int distance) {
			return distance*BASIC_FARE;
		}
	},
	
	AIRPLANE(300){
		int fare(int distance) {
			return distance*BASIC_FARE;
		}
	};
	
	//protected�� �ؾ� �� ������� ���ٰ���
	protected final int BASIC_FARE;
	
	// private Transportation(int basicFare)
	Transportation (int basicFare){
		BASIC_FARE = basicFare;
	}
	
	public int getBasicFare() {
		return BASIC_FARE;
	}
	
	// �Ÿ��� ���� ��� ���
	abstract int fare(int distance);
}


public class Enum_03 {
	
	public static void main(String[] args) {
		System.out.println("bus fare = "+Transportation.BUS.fare(100));
		System.out.println("train fare = "+Transportation.TRAIN.fare(100));
		System.out.println("ship fare = "+Transportation.SHIP.fare(100));
		System.out.println("airplane fare = "+Transportation.AIRPLANE.fare(100));
	}

}
