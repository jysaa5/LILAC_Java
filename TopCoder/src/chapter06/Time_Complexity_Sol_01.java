package chapter06;

// p.199
// ��귮�� ū �Լ��� ȣ���ϴ� ���
// �� �ð����ں�: O(n*2^n)
public class Time_Complexity_Sol_01 {
	static void calc(int n) {
		
		for(int i=0; i<n; i++) {
			// n^3 log n ��
			System.out.println("�Ǻ���ġ: "+Fibonacci_Sol_01.fibonacci(n));
			
			for(int j=0; j<n; j++) {
				// n^2((n)^1/2)
				System.out.println("�Ҽ�: "+IsPrime_Sol_01.isPrime(n));
				
				for(int k=0; k<n; k++) {
					//O(2^n)
					System.out.println("��Ʈ���: "+Bitcount_Sol_01.bitcount(n));
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		calc(5);
	}
}
