package recursive.function;

// ���丮��
// 0! = 1, 1! = 1, 2! = 1*2
public class Factorial_Sol_02 {

	//for�� �̿�
	static int factorial (int number) {
		
		int sum = 1;
		
		for(int i=2; i<=number; i++) {
			sum *= i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(10));
	}
}
