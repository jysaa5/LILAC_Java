package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1057 {
	
	//���� �޼���
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strNum = str.split(" ");
        int a = Integer.parseInt(strNum[0]);
        int b = Integer.parseInt(strNum[1]);
        if(a == b){
            System.out.print(1);
        }else{
            System.out.print(0);
        }
        sc.close();
        
	}//main �޼��� ��
	
}//CodeUp_basics_1057 Ŭ���� ��
