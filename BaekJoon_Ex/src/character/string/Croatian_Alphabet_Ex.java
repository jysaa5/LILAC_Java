package character.string;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// ����: 2941 (ũ�ξ�Ƽ�� ���ĺ�)
import java.util.Scanner;

public class Croatian_Alphabet_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] ca = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		String str = sc.nextLine();

		for (int i = 0; i < ca.length; i++) {
			str = str.replaceAll(ca[i], "1");
		}
		System.out.println(str.length());
		sc.close();
	}
}
