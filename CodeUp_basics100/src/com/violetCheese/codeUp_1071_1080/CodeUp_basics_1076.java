package com.violetCheese.codeUp_1071_1080;

import java.util.Scanner;

public class CodeUp_basics_1076 {

	// ���� �޼���
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c1 = str.charAt(0);
        char c2 = 'a';
        
        do{
            System.out.print(c2);
            System.out.print(" ");
            c2 ++;
        }while(c1>=c2);
        
        sc.close();

	}// main �޼��� ��

}// CodeUp_basics_1076 Ŭ���� ��
