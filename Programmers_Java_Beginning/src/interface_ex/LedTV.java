package interface_ex;

//TV �������̽� ���� -> ��� ����� �����ؾ� �ȴ�.
public class LedTV implements TV {

	
	@Override
	public void turnOn() {
		System.out.println("�Ѵ�");
	}

	@Override
	public void turnOff() {
		System.out.println("����");

	}

	@Override
	public void changeVolume(int volume) {
		System.out.println("������ �����ϴ�");

	}

	@Override
	public void changeChannel(int channel) {
		System.out.println("channel�� �����ϴ�");

	}

}
