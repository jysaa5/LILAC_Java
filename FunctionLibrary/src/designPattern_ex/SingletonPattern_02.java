package designPattern_ex;

//������ ����
//Singleton Pattern(�̱��� ����) �����ϱ� 
public class SingletonPattern_02 {

	//1.������ �ʱ�ȭ
	//private ������: �ʱ�ȭ �Ѵ�.
	private SingletonPattern_02() {
		
	}//End of constructor
	
	
	//2.�ν��Ͻ� ����
	//�ܺο��� ������ �ڱ� �ڽ��� �ν��Ͻ� �����Ѵ�.
	private static SingletonPattern_02 single = new SingletonPattern_02();
	
	
	//3.�޼��� ����
	//getInstance() �޼���: �ڱ� �ڽ��� �ν��Ͻ��� �ܺο� �����Ѵ�. + synchronized ����ȭ ó��: ���� �����尡 �ѹ��� ������ ���ϵ��� �Ѵ�.
	public static synchronized SingletonPattern_02 getInstance() {
		if (single == null) {
			
			return new SingletonPattern_02();

		}else {
			
			return single;
		}
	}//End of getInstance
	

}// End of SingletonPattern_02

//synchronized Ű���� ���
//�� Ű���带 ����ϸ� ���ɻ� �������� �����Ѵ�.