package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1038 {
	
	//���� �޼���
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    String str = sc.nextLine();
	    String[] strNum = str.split("\\s");
	    double a = Integer.parseInt(strNum[0]);
	    double b = Integer.parseInt(strNum[1]);
	    double result = a + b;
	    System.out.print(Math.round(result));
        sc.close();
        
	}//main �޼��� ��
	
}//CodeUp_basics_1038 Ŭ���� ��
