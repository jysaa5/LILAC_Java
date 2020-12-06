package graph.dfs;
/*
1. ����: 10������ �ڿ���n�� �Է¹޾� �ֻ����� n�� ������ ���ü� �ִ� ��� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
2. �ַ��: DFS
*/
import java.util.Scanner;
public class DFS_Dice_Sol_01 {

	static int n = 0;
	
	// 10 ������ ���ڸ� �����ϴ� �迭 
	static int[] arr = new int[11];
	
	// depth: Ʈ���� ���� -> �Լ��� ȣ���ϴ� ��
	static void dfs(int depth) {
		int i=0;
		
		if(depth > n) {
			for(i=1; i<=n; i++) {
				System.out.print(arr[i]+ " ");
			}
			System.out.println("");
			return;
		}
		
		// 1���� ������ ���������� ����� ���� for������ �ۼ�
		for(i=1; i<=6; i++) {
			arr[depth] = i;
			dfs(depth + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dfs(1);
	}
	
}
