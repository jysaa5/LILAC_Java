package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1083 {

	// ���� �޼���
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 1; i <= num; i++) {

			if (i == 3 || i == 6 || i == 9) {
				System.out.print("X" + " ");
			} else {
				System.out.print(i + " ");
			}
		}

		sc.close();

	}// main �޼��� ��

}// CodeUp_basics_1083 Ŭ���� ��
