package math.two;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ����: 2581 (�Ҽ�)
import java.util.Scanner;
public class PrimeNumber_Ex {
	public static boolean prime[];
	
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		prime = new boolean[N + 1];	// �迭 ���� 
		get_prime();
		
		
		// �Ҽ� �� �� �ּڰ� 
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for(int i = M; i <= N; i++) {
			if(prime[i] == false) {	// false = �Ҽ� 
				sum += i;
				if(min == Integer.MAX_VALUE) {	// ù �Ҽ��� �ּڰ���  
					min = i;
				}
			}
		}
		
		if(sum == 0) {	// �Ҽ��� ���ٸ� 
			System.out.println(-1);
		}
		else {
			System.out.println(sum);
			System.out.println(min);
		}
		sc.close();
		
	}
 
	
	// �����佺�׳׽� ü �˰��� 
	public static void get_prime() {
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
		
	}
}
