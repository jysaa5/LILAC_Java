package com.violetCheese.intermediate;

public class Ex_43_ThreadExam_02 {

	//���� ������
	public static void main(String[] args) {
		Ex_42_MyThread_02 t1 = new Ex_42_MyThread_02("*");
		Ex_42_MyThread_02 t2 = new Ex_42_MyThread_02("-");
		
		//Thread�� �������߿��� Runnable�� ���� �� �ְ� �Ǿ� �ִ�.
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		System.out.println("main end!!!");
		
	}

}
