package chapter05;

// p.143
// ����Լ�
// �Ǻ���ġ ����

public class Recursive_function_Sol_01 {

	public static int fib(int a) {
		if (a <= 1) {
			return 1;
		}
		return fib(a - 1) + fib(a - 2);
	}

	public static void main(String[] args) {
		int num = 10;
		System.out.println(fib(num));
	}
}
