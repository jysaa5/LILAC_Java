package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1090 {

	// ���� �޼���
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int r = sc.nextInt();
        int n = sc.nextInt();
        
        double s = 0;
        
        s = a*Math.pow(r,(n-1));
        
        System.out.print(Math.round(s));
        sc.close();

	}// ���� �޼���

}// CodeUp_basics_1090 Ŭ���� ��
