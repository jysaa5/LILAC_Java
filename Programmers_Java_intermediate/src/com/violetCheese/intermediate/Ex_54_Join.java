package com.violetCheese.intermediate;

public class Ex_54_Join {
	
	public static void main(String[] args) {
		//�����尡 �����̶� Ex_53_MyThread: �� 2���̴�.
		Ex_53_MyThread thread = new Ex_53_MyThread();
		thread.start();
		
		System.out.println("����");
		
		try {
			//�� �����尡 �� ����ǰ� ���⶧���� �ٸ� �����尡 ��ٷ��ش�.
			thread.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		System.out.println("����");
		
	}

}
