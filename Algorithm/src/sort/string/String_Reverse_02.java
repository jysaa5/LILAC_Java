package sort.string;

import java.util.Scanner;

// ���ڿ� �Ųٷ� ���: ���� �ȵ�
// 2)solution
public class String_Reverse_02 {
	
	public void inputStrReverse(String str) {
		
		String inputStr = str;
		//StringBuffer �̿�
		StringBuffer sb = new StringBuffer();
		
		sb.append(inputStr);
		
		System.out.print(sb.reverse());
		
	}
	
	// test
	public static void main(String[] args) {
		String_Reverse_02 inputStr = new String_Reverse_02();
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		inputStr.inputStrReverse(str);
		sc.close();
		
	}

}
