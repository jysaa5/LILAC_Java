package violetCheese.codeUp_1021_1030;

import java.util.Scanner;

public class CodeUp_basics_1027 {
	
	//���� �޼���
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] str1 = str.split("\\.");
        System.out.print(str1[2]+"-"+str1[1]+"-"+str1[0]);
      
        sc.close();
        
	}//main �޼��� ��
	
}//CodeUp_basics_1027 Ŭ���� ��
