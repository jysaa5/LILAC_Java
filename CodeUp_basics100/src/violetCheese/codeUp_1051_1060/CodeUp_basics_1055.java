package violetCheese.codeUp_1051_1060;

import java.util.Scanner;

public class CodeUp_basics_1055 {
	
	//���� �޼���
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strNum = str.split(" ");
        int a = Integer.parseInt(strNum[0]);
        int b = Integer.parseInt(strNum[1]);
        System.out.print(a|b);
        sc.close();
        
	}//main �޼��� ��
	
}//CodeUp_basics_1055 Ŭ���� ��
