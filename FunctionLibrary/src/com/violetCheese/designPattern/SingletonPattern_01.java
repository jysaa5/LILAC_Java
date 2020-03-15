package com.violetCheese.designPattern;

//������ ����
//Singleton Pattern(�̱��� ����) �����ϱ� 
public class SingletonPattern_01 {

	//1.������ �ʱ�ȭ
	//private ������: �ʱ�ȭ �Ѵ�.
	private SingletonPattern_01() {
		
	}//End of constructor
	
	
	//2.�ν��Ͻ� ����
	//�ܺο��� ������ �ڱ� �ڽ��� �ν��Ͻ� �����Ѵ�.
	private static SingletonPattern_01 single = new SingletonPattern_01();
	
	
	//3.�޼��� ����
	//getInstance() �޼���: �ڱ� �ڽ��� �ν��Ͻ��� �ܺο� �����Ѵ�.
	public static SingletonPattern_01 getInstance() {
		if (single == null) {
			
			return new SingletonPattern_01();

		}else {
			
			return single;
		}
	}//End of getInstance
	

}// End of SingletonPattern_01

//��Ƽ ������ ȯ�濡�� �̱��� ������ �����ϸ� ������ �߻��� �� �ִ�. 
//�� �ڵ带 �� �� �����ؾ� �Ѵ�. 