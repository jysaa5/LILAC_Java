package com.violetCheese.sort;

import java.util.Scanner;

// ���ڿ� �Ųٷ� ���: ���� �ȵ�
// 1)solution
public class Ex_String_Reverse_01 {
	
	public void inputStrReverse(String str) {
		
		String inputStr = str;
		//for�� �̿�
		for(int i=inputStr.length()-1; i>=0; i--) {
		
			System.out.print(inputStr.charAt(i));
		}
		
	}
	
	// test
	public static void main(String[] args) {
		Ex_String_Reverse_01 strObject = new Ex_String_Reverse_01();
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		strObject.inputStrReverse(str);
		
		sc.close();
	}

}
