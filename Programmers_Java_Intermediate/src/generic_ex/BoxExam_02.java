package generic_ex;

public class BoxExam_02 {
	public static void main(String[] args) {

		Box_02<Object> box = new Box_02<>();
		box.setObj(new Object());
		Object obj2 = box.getObj();
		System.out.println(obj2);

		// String�� �ްڴ�.
		Box_02<String> box2 = new Box_02<>();
		box2.setObj("hello");
		// ����ȯ ���� ��� �����ϴ�.
		String str2 = box2.getObj();
		System.out.println(str2);

		// Integer�� �ްڴ�.
		Box_02<Integer> box3 = new Box_02<>();
		box3.setObj(4);
		int value2 = box3.getObj();
		System.out.println(value2);

	}
}
