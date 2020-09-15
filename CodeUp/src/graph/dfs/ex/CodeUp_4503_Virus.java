package graph.dfs.ex;

//4503 : ���̷���

import java.util.Scanner;
public class CodeUp_4503_Virus {
	
	static int[][] arr = new int[200][200];
	static int cnt;
	static int[] visit = new int[200];
	
	static int n;
	
	static void dfs(int depth) {
		// visit: �ǵ��� ���� �ʵ��� �湮�� ���� �����Ѵ�.
		visit[depth] = 1;
		cnt++;
		
		// n = 7 (��� ����)
		for(int i=1; i<=n; i++) {
			if(arr[depth][i]==1 && visit[i]==0) {
				dfs(i);
			}
		}	
	} 
	
	
	public static void main(String[] args) {
		int i = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("����� ������ �Է� �ϼ���:");
		String str1 = sc.nextLine();
		System.out.println("������ ������ �Է� �ϼ���: ");
		String str2 = sc.nextLine();
		
		// n: 1~7 (���)
		n = Integer.parseInt(str1);
		
		// m: ����� ���� ��
		int m = Integer.parseInt(str2);
		
		for(i=1; i<=m; i++) {
			System.out.println("����� ����� ���ڸ� �Է��ϼ���(a): ");
			String str3 = sc.nextLine();
			System.out.println("����� ����� ���ڸ� �Է��ϼ���(b): ");
			String str4 = sc.nextLine();
			int a = Integer.parseInt(str3);
			int b = Integer.parseInt(str4);
			
			arr[a][b] = 1;
			arr[b][a] = 1;
			
		}
		
		dfs(1);
		// 1�� ����� ���� ���ϴ� ���̹Ƿ� �ڱ� �ڽ��� 1�� �����Ѵ�.
		System.out.println("����� ����� ��:");
		System.out.println(cnt-1);
		
	}

}
