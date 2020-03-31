package thread_ex;

//��� ���̴� ���ǿ� ���ʰ� 4���� �ִٸ�, �����嵵 4���� ���� ����� �ִ� 4������ ���ÿ� ���������� ���α׷����Ѵ�.
public class Thread_RamenProgram {

	public static void main(String args[]) {
		
		try {
		RamenCook ramenCook = new RamenCook(100); //����� ������ ���Ƿ� 100���� �ົ��.
		//������ ������ 
		new Thread(ramenCook, "A").start();
		new Thread(ramenCook, "B").start();
		new Thread(ramenCook, "C").start();
		new Thread(ramenCook, "D").start();

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}


//�������̽�: Runnable -> run()���� �����带 ���
class RamenCook implements Runnable{
	
	//������ �� ����� ��
	private int ramenCount;
	//�� ������ ����
	private String[] burners = {"_", "_", "_", "_"}; //����ִ� ����
	
	//������: ���� ����� ������ �޾ƿ´�.
	public RamenCook(int count) {
		ramenCount = count;
	}
	
	
	//�����尡 ����Ǹ� �� �κ��� ����ȴ�.
	//�����忡�� ������ �۾��� ���⿡ �����Ѵ�.
	@Override
	public void run() {
		
		//����� 0�� �ɶ����� �ݺ�
		while (ramenCount>0) {
			
			// �� �ȿ� �ִ� ���� �ѹ��� �� �����常 ���� �� �� �ִ�.
			synchronized(this) {
				//��� �� �� ����
				ramenCount --;
				
				System.out.println(Thread.currentThread().getName()+":"+ramenCount+"�� ����");
				
				
				
			}
			
			//�̺κ� �ڵ� ������ �ʿ��ϴ�
			//�׸��� ���ʵ� 4�� �� �� ���� ã�´�.
			for(int i=0; i<burners.length; i++) {
				if(!burners[i].equals("_")) {
					continue;
				}

			//�� �̻��� �����尡 �� ���ʸ� ���� ���ϰ� �Ѵ�.
			synchronized(this) {
				
				//�ش� �������� �̸����� ���ʸ� �����Ѵ�.
				burners[i] = Thread.currentThread().getName();
				System.out.println("                                     "+Thread.currentThread().getName() + ": ["+(i+1)+"]�� ���� ON");
				showBurners();
			}
				
			try {
			//�������� sleep�� �ش� �����带 ���� �ð� �����ϴ� ���̴�.
			//��� ���̴� �ð�: 2��
			Thread.sleep(2000);	
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			//����� �� ���� ����, ���ʸ� ���� ����
			synchronized(this) {
				
				burners[i] = "_";
				System.out.println("                         "+Thread.currentThread().getName()+": ["+(i+1)+ "]�� ���� OFF");
				
				showBurners();
				}
			break;
			
			}

			try {
				//�����尡 ���� ����� ���̱� ���� 0~1.0�ʱ��� �������� �ð��� �ɸ����� �Ѵ�.
				// �̷��� �ϸ� ������ ������� �ھ�Ű�� �� �� �ִ�.
				Thread.sleep(Math.round(1000*Math.random()));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//����Ǵ� �������� ���ʵ��� ���¸� ����Ѵ�.
	private void showBurners() {
		String stringToPrint = "                                                   ";
		for(int i=0; i<burners.length; i++) {
			stringToPrint += (" "+burners[i]);
		}
		System.out.println(stringToPrint);
	}
	
}


