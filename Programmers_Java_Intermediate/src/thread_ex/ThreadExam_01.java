package thread_ex;

public class ThreadExam_01 {

	//���� ������
	public static void main(String[] args) {
		MyThread_01 t1 = new MyThread_01("*");
		MyThread_01 t2 = new MyThread_01("-");
		
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
