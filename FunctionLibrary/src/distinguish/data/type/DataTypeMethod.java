package distinguish.data.type;

//�ڹ� Ÿ�� �����ϴ� ���

public class DataTypeMethod {
	
	
	//�̱��� ����
	//������ 
	private DataTypeMethod() {
		
	}
	
	//�ν��Ͻ� ����
	private static DataTypeMethod data = new DataTypeMethod();
	
	//�ν��Ͻ��� �� ���� �������ִ� �޼���
	public static DataTypeMethod getInstance() {
		if (data==null) {
			return new DataTypeMethod();
		}else {
			return data;
		}
		
	}
	
	//������ Ÿ�Կ� ���� �޼���
	
	public void dataTypePrint(byte data) {
		System.out.println("byte type");
		System.out.println("---------------------------");
	}
	
	
	public void dataTypePrint(short data) {
		System.out.println("short type");
		System.out.println("---------------------------");
	}

	
	public void dataTypePrint(int data) {
		System.out.println("int type");
		System.out.println("---------------------------");
	}
	
	
	public void dataTypePrint(long data) {
		System.out.println("long type");
		System.out.println("---------------------------");
	}
	
	
	public void dataTypePrint(float data) {
		System.out.println("float type");
		System.out.println("---------------------------");
	}
	
	
	public void dataTypePrint(double data) {
		System.out.println("double type");
		System.out.println("---------------------------");
	}
	
	
	public void dataTypePrint(char data) {
		System.out.println("char type");
		System.out.println("---------------------------");
	}
	
	
	public void dataTypePrint(boolean data) {
		System.out.println("boolean type");
		System.out.println("---------------------------");
	}
	
	public void dataTypePrint(String data) {
		System.out.println("String type");
		System.out.println("---------------------------");
	}
	
}
