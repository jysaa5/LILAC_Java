package math.one;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ����: 2775 (�γ�ȸ���� ���׾�)
import java.util.Scanner;
public class WomenChairman_Ex {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// ����Ʈ ���� 
		int[][] APT = new int[15][15];
 
		for(int i = 0; i < 15; i++) {
			APT[i][1] = 1;	// i�� 1ȣ
			APT[0][i] = i;	// 0�� iȣ
		}
 
 
		for(int i = 1; i < 15; i ++) {	// 1������ 14������
 
			for(int j = 2; j < 15; j++) {	// 2ȣ���� 14ȣ����
				APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
			}
		}
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(APT[n][k]);
		}
		sc.close();
	}
}
