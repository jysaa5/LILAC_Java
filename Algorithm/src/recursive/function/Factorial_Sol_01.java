package recursive.function;

// ���丮��
// 0! = 1, 1! = 1, 2! = 1*2
public class Factorial_Sol_01 {

	// for�� �̿�
	static int factorial(int number) {

		int fac = 1;

		for (int i = number; i >= 1; i--) {
			fac = fac * i;
		}
		return fac;
	}

	public static void main(String[] args) {
		System.out.println(factorial(10));
	}
}
