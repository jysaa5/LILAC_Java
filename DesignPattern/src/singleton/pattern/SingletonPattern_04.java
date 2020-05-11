package singleton.pattern;

//������ ����
//Singleton Pattern(�̱��� ����) �����ϱ� 
public class SingletonPattern_04 {

	// 1.������ �ʱ�ȭ
	// private ������: �ʱ�ȭ �Ѵ�.
	private SingletonPattern_04() {

	}// End of constructor

	// 2.�ν��Ͻ� ����
	// �ܺο��� ������ �ڱ� �ڽ��� �ν��Ͻ� �����Ѵ�. + volatile ����ȭ
	private static volatile SingletonPattern_04 single = new SingletonPattern_04();

	// 3.�޼��� ����
	// getInstance() �޼���: �ڱ� �ڽ��� �ν��Ͻ��� �ܺο� �����Ѵ�.
	public static SingletonPattern_04 getInstance() {
		if (single == null) {

			single = new SingletonPattern_04();

			return single;
		} else {

			return single;
		}
	}// End of getInstance

}// End of SingletonPattern_04

// volatile Ű���� ���
// Ŭ������ �ε��Ǵ� ������ �̸� ��ü�� �����صΰ� �� ��ü�� ��ȯ�Ѵ�.

