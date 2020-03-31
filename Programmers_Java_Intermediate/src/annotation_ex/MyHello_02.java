package annotation_ex;

import java.lang.reflect.Method;

//Ex_37_MyHello Ŭ������ ����Ǵ� Ŭ����
public class MyHello_02 {

	public static void main(String[] args) {

		// �ν��Ͻ� ����
		MyHello_01 hello = new MyHello_01();

		// Method ��ü: �޼��� ������ �˱� ���� ��ü
		// getClass(): Object�� ��� �ް� ����. �ش� �ν��Ͻ��� ���鶧 ����� Ŭ������ ������ �����Ѵ�.
		// getDeclaredMethod: "Hello"��� �޼��带 ������ �����Ͷ�
		try {
			Method method = hello.getClass().getDeclaredMethod("hello");

			// Ư�� �޼��忡 ������̼��� ����Ǿ� �ִ��� �˾ƺ��� ��
			// ����Ǿ� ������ true
			if (method.isAnnotationPresent(Count100.class)) {
				
				for(int i =0 ; i<100; i++) {
					hello.hello();
				}

			} else {
				
				hello.hello();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
