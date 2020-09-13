package math.combination;

// ����
// �ַ��1: ��Ʈ��ŷ
// �ַ��2: ����Լ�
public class Combination_01 {

	// �ַ��1.
	// ��Ʈ��ŷ ���
	// ��뿹��: combination(arr, visited, 0, n, r)
	// arr: ������ �̾Ƴ� �迭
	// visited: �������� �ƴ��� üũ
	// start: �ε��� ����
	// n: �迭�� ����, r: ������ ����
	public void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		
		if(r==0) {
			printArray(arr, visited, n);
			return;
		}
		
		
		for(int i = start; i<n; i++) {
			visited[i] = true;
			combination(arr, visited, i+1, n, r-1);
			visited[i] = false;
		}
		
	}
	
	// �ַ��2.
	// ����Լ� ���
	// ��뿹��: combinationR(arr, visited, 0, n, r)
	// arr: ������ �̾Ƴ� �迭
	// visited: �������� �ƴ��� üũ
	// depth: 
	// n: �迭�� ����, r: ������ ����
	public void combinationR(int[] arr, boolean[] visited, int depth, int n, int r) {
		
		if(r==0) {
			printArray(arr, visited, n);
			return;
		}
		
		if(depth == n) {
			return;
		}else {
			visited[depth] = true;
			combinationR(arr, visited, depth+1, n, r-1);
			visited[depth] = false;
			combinationR(arr, visited, depth+1, n, r);
		}
		
	}
	
	
	// �迭 ���
	public void printArray(int[] arr, boolean[] visited, int n) {
		
		for(int i=0; i<n; i++) {
			if(visited[i] == true) {
				System.out.print(arr[i]+ " ");
			}
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		int n = 4;
		int[] arr = {1, 2, 3, 4};
		boolean[] visited = new boolean[n];
		
		Combination_01 sol = new Combination_01();
	
		int r = 2;
		int start = 0;
		
		System.out.println("��Ʈ��ŷ�� �̿��� ����");
		sol.combination(arr, visited, start, n, r);
		
//		for(int i=1; i<= n; i++) {
//			sol.combination(arr, visited, 0, n, i);
//		}
		
		
		System.out.println();
	
		System.out.println("����Լ��� ���� ����");
		sol.combinationR(arr, visited, start, n, r);
//		for(int i=1; i<=n; i++) {
//			sol.combinationR(arr, visited, 0, n, i);
//		}
		
		
	}
	
}
