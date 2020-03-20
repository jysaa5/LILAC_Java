package com.violetCheese.intermediate;

import java.lang.reflect.Method;

public class Ex_39_Annotation {
	// �޼ҵ�1~3�� ���ϴ� �κп� @RunTwice ������̼��� �ٿ�������.

	public void method1() {
		System.out.println("�޼ҵ� 1 �Դϴ�.");
	}

	@RunTwice
	public void method2() {
		System.out.println("�޼ҵ� 2 �Դϴ�.");
	}

	public void method3() {
		System.out.println("�޼ҵ� 3 �Դϴ�.");
	}

	public static void main(String[] args) {
		Ex_39_Annotation exam = new Ex_39_Annotation();

		try {
			Method method = exam.getClass().getDeclaredMethod("method1");
			if (method.isAnnotationPresent(RunTwice.class)) {
				exam.method1();
				exam.method1();
			}

			method = exam.getClass().getDeclaredMethod("method2");
			if (method.isAnnotationPresent(RunTwice.class)) {
				exam.method2();
				exam.method2();
			}

			method = exam.getClass().getDeclaredMethod("method3");
			if (method.isAnnotationPresent(RunTwice.class)) {
				exam.method3();
				exam.method3();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
