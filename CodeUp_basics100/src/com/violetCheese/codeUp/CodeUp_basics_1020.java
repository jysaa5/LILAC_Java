package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1020 {
	
	//���� �޼���
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] idNum = str.split("-");
        System.out.print(idNum[0]+idNum[1]);
        
        sc.close();
        
	}//main �޼��� ��
	
}//CodeUp_basics_1020 Ŭ���� ��
