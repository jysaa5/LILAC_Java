package generic_ex;

public class BoxExam_01 {
	
	public static void main(String[] args) {
		
		Box_01 box = new Box_01();
		// Object�� �����ؼ� �־���
		box.setObj(new Object());
		// Object ��ü�� ��� ���� ���� ����
		Object obj1 = box.getObj();
		System.out.println(obj1);

		// object�� ��ӹ޴� ��ü���� ��� �� �� ����.
		box.setObj("hello");
		// ����ȯ
		String str1 = (String) box.getObj();
		System.out.println(str1);

		box.setObj(1);
		// ����ȯ
		int value = (int) box.getObj();
		System.out.println(value);

	}
}
