package com.violetCheese.codeUp_1091_1099;

import java.util.Scanner;

public class CodeUp_basics_1092 {

	// ���� �޼���
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int day = 1;
		while ((day % a != 0) || (day % b != 0) || (day % c != 0)) {
			day++;
		}

		System.out.print(day);

		sc.close();

	}// ���� �޼���

}// CodeUp_basics_1092 Ŭ���� ��
