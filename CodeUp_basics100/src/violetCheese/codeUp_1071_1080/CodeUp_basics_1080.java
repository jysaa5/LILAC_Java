package violetCheese.codeUp_1071_1080;

import java.util.Scanner;

public class CodeUp_basics_1080 {

	// ���� �޼���
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = 1;
		int result = 0;

		while (num1 > 0) {

			if (result >= num1) {
				System.out.print(num2 - 1);
				break;
			}
			result += num2;
			num2++;
		}
		sc.close();

	}// main �޼��� ��

}// CodeUp_basics_1080 Ŭ���� ��
