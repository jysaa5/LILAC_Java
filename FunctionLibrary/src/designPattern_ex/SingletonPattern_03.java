package designPattern_ex;

//������ ����
//Singleton Pattern(�̱��� ����) �����ϱ� 
public class SingletonPattern_03 {

	//1.������ �ʱ�ȭ
	//private ������: �ʱ�ȭ �Ѵ�.
	private SingletonPattern_03() {
		
	}//End of constructor
	
	
	//2.�ν��Ͻ� ����
	//�ܺο��� ������ �ڱ� �ڽ��� �ν��Ͻ� �����Ѵ�. + volatile ����ȭ
	private static volatile SingletonPattern_03 single = new SingletonPattern_03();
	
	
	//3.�޼��� ����
	//getInstance() �޼���: �ڱ� �ڽ��� �ν��Ͻ��� �ܺο� �����Ѵ�. + synchronized ����ȭ ó��: ���� �����尡 �ѹ��� ������ ���ϵ��� �Ѵ�.
	public static SingletonPattern_03 getInstance() {
		if (single == null) {
			
			synchronized (SingletonPattern_03.class) {
				if(single ==null) {
					single = new SingletonPattern_03();
				}
			}
			return single;

		}else {
			
			return single;
		}
	}//End of getInstance
	

}// End of SingletonPattern_03

//synchronized Ű���� ���, volatile Ű���� ���
//DCL(Double Checking Locking)�� ����Ͽ� getInstance()���� ����ȭ �Ǵ� ������ ���� �� �ִ�.
//�ʱ⿡ ��ü�� �������� �����鼭�� ����ȭ�ϴ� �κ��� �۰� �������. 
//�׷��� �� �ڵ�� ��Ƽ �ھ� ȯ�濡�� ������ ��, �ϳ��� CPU�� �����ϰ�� �ٸ� CPU�� lock�� �ɸ��� �ȴ�.
