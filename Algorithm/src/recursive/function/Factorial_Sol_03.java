package recursive.function;

// ���丮��
// 0! = 1, 1! = 1, 2! = 1*2
public class Factorial_Sol_03 {

	// ����Լ� �̿�
	static int factorial(int number) {
		if (number <= 1) {
			return 1;
		} else {
			return factorial(number - 1) * number;
		}
	}

	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
}
