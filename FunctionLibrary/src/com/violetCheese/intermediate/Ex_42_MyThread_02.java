package com.violetCheese.intermediate;

//������ �����(implements Runnable)
public class Ex_42_MyThread_02 implements Runnable {

	String str;

	//������
	public Ex_42_MyThread_02(String str) {
		this.str = str;
	}

	@Override
	public void run() {

		for (int i = 0; i< 10; i++) {
			System.out.println(str);

			try {
				Thread.sleep((int) Math.random() * 100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

}
