package character.string;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// ����: 1152 (�ܾ��� ����)
import java.util.Scanner;

public class Number_Of_Words_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().trim();
		String[] w = str.split(" ");
		// ������ �Էµ��� ���� ���
		if (str.length() == 0) {
			System.out.print(0);
		} else {
			System.out.println(w.length);
		}
		sc.close();
	}
}
