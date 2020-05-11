package singleton.pattern;

//������ ����
//Singleton Pattern(�̱��� ����) �����ϱ� 
public class SingletonPattern_05 {

	// 1.������ �ʱ�ȭ
	// private ������: �ʱ�ȭ �Ѵ�.
	private SingletonPattern_05() {

	}// End of constructor

	// 2.�ν��Ͻ� ����
	// �ܺο��� ������ �ڱ� �ڽ��� �ν��Ͻ� �����Ѵ�. + ��ø Ŭ���� Holder
	private static class SingletonHolder {
		
		private static final SingletonPattern_05 single = new SingletonPattern_05();
		
	}

	// 3.�޼��� ����
	// getInstance() �޼���: �ڱ� �ڽ��� �ν��Ͻ��� �ܺο� �����Ѵ�.
	public static SingletonPattern_05 getInstance() {

		return SingletonHolder.single;
		
	}// End of getInstance

}// End of SingletonPattern_05

// ��ø Ŭ������ �̿��� Holder�� ����� ��� 
// final Ű���� ���
// getInstance �޼��尡 ȣ��Ǳ� �������� singleton�ν��Ͻ��� �������� �ʴ´�.
// �ֽ� VM�� Ŭ������ �ʱ�ȭ�ϱ� ���� �ʵ� ������ ����ȭ�Ѵ�.
// �ʱ�ȭ�ǰ� ���� �ڵ带 �ٲ㼭 �������� �ʵ� ���ٿ��� � ����ȭ�� �˻絵 �ʿ����� �ʰ� �ȴ�.
// �׷��Ƿ� �ʱ�ȭ ���� �ٽ� getInstance()�޼��尡 ȣ�� �Ǵ��� new SingletonPattern_05()�� ȣ�� ���� �ʴ´�.
