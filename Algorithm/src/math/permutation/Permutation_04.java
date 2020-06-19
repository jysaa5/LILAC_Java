package math.permutation;

import java.util.Arrays;

// ����
// �ַ��: ����Լ� + ��ġ����(swap)�� �̿���.
// �ߺ��� ������� �ʴ´�.
public class Permutation_04 {

	// nPr�� n
	private int n;
	
	// nPr�� r
	private int r;
	private int[] res;
	
	// �ʱ�ȭ 
	public Permutation_04(int n, int r) {
		this.n = n;
		this.r = r;
		res = new int[r];
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void perm(int[] arr, int depth) {
		
		if(depth == r) {
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for(int i=depth; i<n; i++) {
			
			// ����
			swap(arr, depth, i);
			// ���õ� ���� ����
			res[depth] = arr[depth];
			// ��� ȣ��
			perm(arr, depth+1);
			// ����
			swap(arr, depth, i);
		}
		
		
	}
	
	public static void main(String[] args) {
		int r = 3;
		int[] arr = {1,2,3,4,5};
		
		Permutation_04 main = new Permutation_04(arr.length, r);
		main.perm(arr, 0);
	}
	
}
