package violetCheese.codeUp_1071_1080;

import java.util.Scanner;

public class CodeUp_basics_1072 {

	// ���� �޼���
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String strNum = sc.nextLine();
		String strNums = sc.nextLine();

		String[] str1 = strNum.split(" ");
		String[] str2 = strNums.split(" ");

		int num = Integer.parseInt(str1[0]);

		for (int i = 0; i < num; i++) {
			System.out.println(str2[i]);
		}
		sc.close();

	}// main �޼��� ��

}// CodeUp_basics_1072 Ŭ���� ��
