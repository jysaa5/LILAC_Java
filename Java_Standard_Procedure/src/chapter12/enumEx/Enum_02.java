package chapter12.enumEx;

// p.696

enum Direction_02{
	EAST(1, ">"), SOUTH(2, "V"), WEST(3,"<"), NORTH(4,"^");
	
	private static final Direction_02[] DIR_ARR = Direction_02.values();
	
	private final int value;
	
	private final String symbol;
	
	// ���� ������ private�� ������
	Direction_02(int value, String symbol){
		this.value = value;
		this.symbol = symbol;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public static Direction_02 of(int dir) {
		if(dir <1 || dir >4) {
			throw new IllegalArgumentException("Invalid value: "+dir);
		}
		return DIR_ARR[dir-1];
	}
	
	// ������ ȸ����Ű�� �޼���
	// num�� ����ŭ 90���� �ð�������� ȸ���Ѵ�.
	public Direction_02 rotate(int num) {
		num = num%4;
		
		if(num < 0) {
			// num�� ������ ���� �ð�ݴ� �������� ȸ��
			num +=4;
		}
		
		return DIR_ARR[(value-1+num)%4];
	}
	
	public String toString() {
		return name()+getSymbol();
	}
	// enum Direction
}

public class Enum_02 {
	
	public static void main(String[] args) {
		for(Direction_02 d : Direction_02.values()) {
			System.out.printf("%s=%d%n", d.name(), d.getValue());
		}
		
		Direction_02 d1 = Direction_02.EAST;
		Direction_02 d2 = Direction_02.of(1);
		
		System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
		System.out.printf("d2=%s, %d%n", d2.name(), d2.getValue());
		System.out.println(Direction_02.EAST.rotate(1));
		System.out.println(Direction_02.EAST.rotate(2));
		System.out.println(Direction_02.EAST.rotate(-1));
		System.out.println(Direction_02.EAST.rotate(-2));
	}

}
