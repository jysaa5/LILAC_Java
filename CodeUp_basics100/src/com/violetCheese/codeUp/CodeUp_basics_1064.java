package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1064 {
	
	//���� �޼���
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strNum = str.split(" ");
        int a = Integer.parseInt(strNum[0]);
        int b = Integer.parseInt(strNum[1]);
        int c = Integer.parseInt(strNum[2]);
        
        int result = 0; 
        
        result = ((a<b)? a:b)<c ? ((a<b)? a:b):c;
        System.out.print(result);
        sc.close();
        
	}//main �޼��� ��
	
}//CodeUp_basics_1064 Ŭ���� ��
