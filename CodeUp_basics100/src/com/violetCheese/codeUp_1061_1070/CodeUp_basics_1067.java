package com.violetCheese.codeUp_1061_1070;

import java.util.Scanner;

public class CodeUp_basics_1067 {
	
	//���� �޼���
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num = Integer.parseInt(str);
        
        if(num<0){
            System.out.println("minus");
        }else{
            System.out.println("plus");
        }
        
        if(num%2==0){
            System.out.println("even");
        }else{
            System.out.println("odd");
        }
        sc.close();
        
	}//main �޼��� ��
	
}//CodeUp_basics_1067 Ŭ���� ��
