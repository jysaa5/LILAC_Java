package com.violetCheese.basicJava;

public class Ex_13_BoxExam_01 {
	
	public static void main(String[] args) {
		
		Ex_11_Box_01 box = new Ex_11_Box_01();
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
