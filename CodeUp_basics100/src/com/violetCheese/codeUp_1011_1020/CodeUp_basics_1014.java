package com.violetCheese.codeUp_1011_1020;

import java.util.Scanner;

public class CodeUp_basics_1014 {
	
	//���� �޼���
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	     String a = sc.nextLine();
	     int i = 0;
	     String result = "";
	        
	     for(i = a.length()-1; i >= 0; i--){
	            result += a.charAt(i);
	        }
	        
	     System.out.print(result);
	     
	     sc.close();
	        
	}//main �޼��� ��
	
}//CodeUp_basics_1014 Ŭ���� ��
