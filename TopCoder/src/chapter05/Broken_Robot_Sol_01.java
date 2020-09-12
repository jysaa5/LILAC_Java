package chapter05;

// p. 156
// ����: ���峭 �κ�

class CrazyBot{
	boolean[][] grid = new boolean[100][100];
	
	// ��, ��, ��, ��
	int vx[] = {1, -1, 0, 0};
	int vy[] = {0, 0, -1, 1};
	
	double[] prob = new double[4];
	
	// Ȯ��
	public double getProbability(int n, int east, int west, int south, int north) {
		prob[0] = east/ 100.0;
		prob[1] = west/ 100.0;
		prob[2] = south/ 100.0;
		prob[3] = north/ 100.0;
		
		return dfs(50, 50, n);
	}
	
	// ���� �켱 Ž��
	double dfs(int x, int y, int n) {
		
		// �̵��ߴ� �ڸ�
		if(grid[x][y]) {
			return 0;
		}
		
		// �ƿ� �� ������ ���
		if(n==0) {
			return 1;
		}
		
		grid[x][y] = true;
		double ret = 0;
		
		for(int i=0; i<4; i++) {
			
			// east, west, south, north ������ �κ��� �����δ�.
			ret +=dfs(x+vx[i], y+vy[i], n-1)*prob[i];
		}
		
		grid[x][y] = false;
		
		return ret;
	}
}

public class Broken_Robot_Sol_01 {
	
	public static void main(String[] args) {
		CrazyBot sol = new CrazyBot();
		//int n = 1;
		int n = 2;
		//int n = 7;
		//int n = 14;
		
//		int east = 25;
//		int west = 25;
//		int south = 25;
//		int north = 25;

		int east = 50;
		int west = 0;
		int south = 0;
		int north = 50;

//		int east = 50;
//		int west = 50;
//		int south = 0;
//		int north = 0;
		
//		int east = 25;
//		int west = 25;
//		int south = 25;
//		int north = 25;
		
		
		System.out.println(sol.getProbability(n, east, west, south, north));
	}

}
