package character.string;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// ����: 11654 (�ƽ�Ű �ڵ�)
import java.util.Scanner;

public class ASCII_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine().trim();
		System.out.println((int) s.charAt(0));
		sc.close();
	}
}
