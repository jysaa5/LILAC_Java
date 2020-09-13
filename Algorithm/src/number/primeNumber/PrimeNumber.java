package number.primeNumber;

public class PrimeNumber {

	static boolean isPrime(int n) {

		// 1�� �Ҽ��� �ƴϴ�.
		if (n <= 1) {
			return false;
			}
		
		// ¦��
		if ((n & 1) == 0) {
			
			// 2�̸� true. �ƴϸ� �Ҽ��� �ƴϴ�.
			return (n == 2);
		}
		
		// i = 3 ~ sqrt(n) ������ Ȧ��
		for (int i = 3; i * i <= n; i++) {
		
			// i�� n�� ������ ����� �����ϴ� ���̹Ƿ� �Ҽ��� �ƴϴ�.
			if (n % i == 0) {// i�� n�� ������
				return false; 
			}
		}
		return true; // �Ҽ��̴�
	}

	public static void main(String[] args) {

		// int number = 7;
		// int number = 2;
		int number = 1;
		//int number = 9;
		System.out.println(isPrime(number));
	}

}
