package input.and.output.arithmetic.operations;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// ����: 10998 (A*B)
import java.util.Scanner;

public class A_Multiple_B_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.print(a * b);
		sc.close();
	}
}
