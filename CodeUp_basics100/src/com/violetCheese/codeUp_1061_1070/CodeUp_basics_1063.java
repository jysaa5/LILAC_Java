package com.violetCheese.codeUp_1061_1070;

import java.util.Scanner;

public class CodeUp_basics_1063 {
	
	//���� �޼���
	public static void main(String[] args) {
		
	      Scanner sc = new Scanner(System.in);
	        String str = sc.nextLine();
	        String[] strNum = str.split(" ");
	        int a = Integer.parseInt(strNum[0]);
	        int b = Integer.parseInt(strNum[1]);
	        
	        int result = 0;
	        result = (a>b) ? a:b;
	        System.out.print(result);
	        
	        sc.close();
        
	}//main �޼��� ��
	
}//CodeUp_basics_1063 Ŭ���� ��
