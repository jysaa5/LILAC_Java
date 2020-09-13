package chapter07;

//p. 211
//����: ��� Ž��
//�ַ��: �޸�ȭ ��͸� ����� ���̿켱 Ž��
public class Route_Search_Sol_02 {

	static final int h = 5;
	static final int w = 4;
	// �޸�ȭ�ϱ� ���� 2���� �迭
	static int[][] dp = new int[h + 1][w + 1];

	static int dfs(int nowh, int noww) {

		if (nowh > h || noww > w) {
			return 0;
		}

		if (nowh == h && noww == w) {
			return 1;
		}

		if (dp[nowh][noww] != 0) {
			return dp[nowh][noww];
		}

		// ���ο� ���϶� �������� ���� ����� ���������� ���� ����� ã�´�.
		return dp[nowh][noww] = dfs(nowh + 1, noww) + dfs(nowh, noww + 1);
	}

	public static void main(String[] args) {
		System.out.println("����� ��: "+dfs(0, 0));

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println("");
		}
	}

}
