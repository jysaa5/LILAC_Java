package com.violetCheese.basicJava;

public class Ex_46_RunnableExam {

	public static void main(String[] argv) {
		Ex_45_Bus bus = new Ex_45_Bus();
		/*
		 * Runnable�� ������ Ŭ������ �̿��� �����带 �̿��Ҷ��� �Ʒ��� ���� Thread�� �����ڿ� �ش� ��ü(bus)�� �����ϸ� �˴ϴ�.
		 * ������ �̴�� �����ϸ� ������ �߻��մϴ�. bus�� runnable�� implements�ϰ� ���� �ʱ� �����Դϴ�.
		 */
		Thread busThread = new Thread(bus);
		busThread.start();
	}

}
