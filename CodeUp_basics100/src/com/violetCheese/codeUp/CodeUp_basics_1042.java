package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1042 {
	
	//���� �޼���
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] str2 = str1.split(" ");
        int a = Integer.parseInt(str2[0]);
        int b = Integer.parseInt(str2[1]);
        System.out.print(a/b);
        sc.close();
        
	}//main �޼��� ��
	
}//CodeUp_basics_1042 Ŭ���� ��
