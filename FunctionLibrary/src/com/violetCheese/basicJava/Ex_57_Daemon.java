package com.violetCheese.basicJava;

public class Ex_57_Daemon implements Runnable {

	@Override
	public void run() {

		while (true) {
			System.out.println("���� �����尡 �������Դϴ�.");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}

	}

	// ���ε� �������̴�.
	public static void main(String[] args) {
		Thread thread = new Thread(new Ex_57_Daemon());
		// ���� ������� ������.
		thread.setDaemon(true);
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("���� �����尡 ����˴ϴ�.");

	}

}
