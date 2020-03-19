package com.violetCheese.basicJava;

public class Ex_55_ThreadB extends Thread {

	// ����
	int total;

	@Override
	public void run() {

		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(i + "�� ���մϴ�.");
				total += i;

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

			//wait() �ϰ� �ִ� �޼��带 �����.
			notify();
		}

	}

}
