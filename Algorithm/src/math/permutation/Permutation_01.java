package math.permutation;

// ����: n�� �߿��� r���� ���� �ְ� �̱�
// �ð����⵵: O(n!)

public class Permutation_01 {
	
	// ���� ���ϱ�
	// ���� ���� n�� �߿��� r���� �̴� ���
	public void permutation(int[] arr, int depth, int n, int r) {
		
		if(depth == r) {
			
			printArray(arr, r);
			
			return;
			
		}
		
		for(int i= depth; i<n; i++) {
			swap(arr, depth, i);
			permutation(arr,  depth+1, n, r);
			swap(arr, depth, i);
		}
		
		
	}
	
	
	public void permutationDic(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		 if(depth == r) {
			 printArray(output, r);
			 return;
		 }
		 
		 
		 for(int i=0; i<n; i++) {
			 
			 
			 if(visited[i] != true) {
				 visited[i] = true;
				 output[depth] = arr[i];
				 permutationDic(arr, output, visited, depth+1, n ,r);
				 visited[i] = false;
			 }
			 
		 }
		 
		
	}
	
	
	// swap
	public void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}
	
	
	// �迭 ���
	public void printArray(int[] arr, int r) {
		
		for(int i=0; i<r; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
	}
	
	
	public static void main(String[] args) {
		int n = 3;
		int[] arr  = {1,2,3};
		int[] output = new int[n];
		boolean[] visited = new boolean[n];
		
		Permutation_01 perm = new Permutation_01();
		System.out.println("���������� ���� ���ϱ�");
		perm.permutationDic(arr, output, visited, 0, n, 3);
		System.out.println();
		System.out.println("���� ���ϱ�");
		perm.permutation(arr, 0, n, 3);
	}

}