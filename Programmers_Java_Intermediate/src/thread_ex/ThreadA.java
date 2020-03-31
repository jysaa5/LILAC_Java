package thread_ex;

public class ThreadA {

	//���� ������
	public static void main(String[] args) {
		ThreadB b = new ThreadB();

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
