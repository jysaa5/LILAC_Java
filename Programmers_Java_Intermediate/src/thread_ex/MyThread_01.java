package thread_ex;

//������ �����(extend Thread)
//�ڹٿ��� Thread�� ����� ����� ũ�� Thread Ŭ������ ��ӹ޴� ����� Runnable�������̽��� �����ϴ� ����� �ִ�.
public class MyThread_01 extends Thread {
	
	String str;
	
	//������
	public MyThread_01(String str) {
		this.str = str;
		
	}

	
	//���� �帧�� �ϳ� �� ������ �� �帧�� ������ �ٸ� ���� �޼��� ��� �����ϸ� �ȴ�.
	@Override
	public void run() {

		super.run();
	
		for(int i=0; i<10; i++) {
			System.out.println(str);
			
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

	
	
	
	

}
