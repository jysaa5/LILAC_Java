package com.violetCheese.codeUp_1091_1099;

import java.util.Scanner;

public class CodeUp_basics_1091 {

	// ���� �޼���
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long m = sc.nextLong();
		long d = sc.nextLong();
		long n = sc.nextLong();
		
		//�����ص� ��. �ٵ� ���� ���� ������ڸ� �̷���.
		//long result = a; 

		for (int i = 1; i < n; i++) {
			
			//result = result*m+d;
			a = a * m + d;
		}

		System.out.print(a);
		sc.close();

	}// ���� �޼���

}// CodeUp_basics_1091 Ŭ���� ��
