package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1065 {
	
	//���� �޼���
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strNum = str.split(" ");
        int a = Integer.parseInt(strNum[0]);
        int b = Integer.parseInt(strNum[1]);
        int c = Integer.parseInt(strNum[2]);
        
        if (a%2 == 0){
            System.out.println(a);
        } 
        
        if(b%2 == 0){
            System.out.println(b);
        }
        
        if(c%2 == 0){
            System.out.println(c);
        }
        
        sc.close();
        
	}//main �޼��� ��
	
}//CodeUp_basics_1065 Ŭ���� ��
