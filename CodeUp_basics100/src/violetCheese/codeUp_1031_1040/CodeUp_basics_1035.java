package violetCheese.codeUp_1031_1040;

import java.util.Scanner;

public class CodeUp_basics_1035 {
	
	//���� �޼���
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num = Integer.parseInt(str, 16);
        String strNum = Integer.toOctalString(num);
        System.out.print(strNum);
        sc.close();
        
	}//main �޼��� ��
	
}//CodeUp_basics_1035 Ŭ���� ��
