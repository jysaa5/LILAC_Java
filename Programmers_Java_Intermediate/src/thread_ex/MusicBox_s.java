package thread_ex;

public class MusicBox_s {

	//����ȭ
	public synchronized void playMusicA() {

		for (int i = 0; i < 10; i++) {
			System.out.println("�ų��� ����!!");
			try {
				Thread.sleep((int) Math.random() * 1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	//����ȭ
	public synchronized void playMusicB() {

		for (int i = 0; i < 10; i++) {
			System.out.println("���� ����!!");
			try {
				Thread.sleep((int) Math.random() * 1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	//����ȭ
	public synchronized void playMusicC() {

		for (int i = 0; i < 10; i++) {
			

			System.out.println("ī�� ����!!");

			try {
				Thread.sleep((int) Math.random() * 1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

}
