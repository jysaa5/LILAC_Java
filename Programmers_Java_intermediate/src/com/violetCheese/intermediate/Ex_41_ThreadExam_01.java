package com.violetCheese.intermediate;

public class Ex_41_ThreadExam_01 {

	//���� ������
	public static void main(String[] args) {
		Ex_40_MyThread_01 t1 = new Ex_40_MyThread_01("*");
		Ex_40_MyThread_01 t2 = new Ex_40_MyThread_01("-");
		
		//Thread���۽� run()�� �ƴ� start()�޼��带 ȣ���ؾ� �Ѵ�.
		//������ 2��
		t1.start();
		
		//������ 3��
		//���� �帧�� 3���� �ȴ�.
		t2.start();
		
		//������ ���ᰡ �ǵ� �ٸ� �����尡 ���ᰡ �Ǿ� ������ ������.
		System.out.println("main end!!!");
	}

}
