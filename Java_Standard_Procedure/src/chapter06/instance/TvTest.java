package chapter06.instance;

// p. 235

class Tv{
	// Tv�� �Ӽ�(�������)
	
	// ����
	String color;
	// ���� ����(on/off)
	boolean power;
	// ä��
	int channel;
	
	// Tv�� ���(�޼���)
	// Tv�� �Ѱų� ���� ����� �ϴ� �޼���
	void power() {
		power =! power;
	}
	
	// Tv�� ä���� ���̴� ����� �ϴ� �޼���
	 void channelUp() {
		 ++channel;
	 }
	 
	 // Tv�� ä���� ���ߴ� ����� �ϴ� �޼���
	 void channelDown() {
		 --channel;
	 }
}



public class TvTest {
	
	public static void main(String[] args) {
		// Tv�ν��Ͻ��� �����ϱ� ���� ���� t�� ����
		Tv t;
		// Tv�ν��Ͻ��� �����Ѵ�.
		t = new Tv();
		// Tv�ν��Ͻ��� ������� channel�� ���� 7�� �Ѵ�.
		t.channel = 7;
		// Tv�ν��Ͻ��� �޼��� channelDown()�� ȣ���Ѵ�.
		t.channelDown();
		
		System.out.println("���� ä����"+t.channel+" �Դϴ�.");
	}

}
