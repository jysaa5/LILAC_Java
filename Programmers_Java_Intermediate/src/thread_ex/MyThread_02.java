package thread_ex;

//������ �����(implements Runnable)
public class MyThread_02 implements Runnable {

	String str;

	//������
	public MyThread_02(String str) {
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
