package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1071 {

	// ���� �޼���
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strNum = str.split(" ");

		for (int i = 0; i < strNum.length; i++) {
			if (strNum[i].equals("0")) {
				break;
			} else {
				System.out.println(strNum[i]);
			}
		}
		sc.close();

	}// main �޼��� ��

}// CodeUp_basics_1071 Ŭ���� ��
