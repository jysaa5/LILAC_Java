package lambda_ex;

//���ٽ�
public class Lambda_02 {

	public static void main(String[] args) {
		
		//���ٽ�
		new Thread(()-> {
				for (int i = 0; i < 10; i++) {
					System.out.println("hello");
				}
		}).start();

	}

}
