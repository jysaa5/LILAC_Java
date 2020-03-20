package com.violetCheese.intermediate;

public class Ex_56_ThreadA {

	//���� ������
	public static void main(String[] args) {
		Ex_55_ThreadB b = new Ex_55_ThreadB();

		//b ������ ����
		b.start();

		synchronized (b) {
			try {
				System.out.println("b�� �Ϸ�ɶ����� ��ٸ��ϴ�.");
				//������ ���߰� �Ѵ�.
				b.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Total is :" +b.total);
		}

	}

}
