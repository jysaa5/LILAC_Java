package thread_ex;

public class ThreadExam_02 {

	//���� ������
	public static void main(String[] args) {
		MyThread_02 t1 = new MyThread_02("*");
		MyThread_02 t2 = new MyThread_02("-");
		
		//Thread�� �������߿��� Runnable�� ���� �� �ְ� �Ǿ� �ִ�.
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		System.out.println("main end!!!");
		
	}

}
