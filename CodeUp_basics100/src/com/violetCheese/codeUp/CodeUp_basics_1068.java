package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1068 {

	// ���� �޼���
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		if (90 <= num && num <= 100) {
			System.out.println("A");
		} else if (70 <= num && num <= 89) {
			System.out.println("B");
		} else if (40 <= num && num <= 69) {
			System.out.println("C");
		} else if (0 <= num && num <= 39) {
			System.out.println("D");
		}

		sc.close();

	}// main �޼��� ��

}// CodeUp_basics_1068 Ŭ���� ��
