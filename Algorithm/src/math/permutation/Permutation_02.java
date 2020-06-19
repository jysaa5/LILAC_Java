package math.permutation;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation_02 {

	// nPr�� n
	private int n;
	// nPr�� r
	private int r;
	private ArrayList<Integer> itemList;
	// ����� �迭
	private int[] res;

	// ������
	// �ʱ�ȭ
	public Permutation_02(int[] intArr, int r) {

		// nPr�� r
		this.r = r;
		// nPr�� n
		this.n = intArr.length;
		// ����� �迭
		this.res = new int[r];

		// �������� �� ����Ʈ
		itemList = new ArrayList<Integer>();

		for (int item : intArr) {
			itemList.add(item);
		}
	}
	
	
	public void perm(int depth) {
		perm(itemList, 0);
	}
	
	
	public void perm(ArrayList<Integer> itemList, int depth) {
		
		// depth�� 0���� �������� ��� depth == r���� ����
		if(depth == r) {
			System.out.println(Arrays.toString(res));
			return;
		}
		
		
		for(int i=0; i<n-depth; i++) {
			res[depth] = itemList.remove(i);
			perm(itemList, depth+1);
			itemList.add(i, res[depth]);
		}
		
	}
	
	
	public static void main(String[] args) {
		int r = 3;
		int[] arr = {1,2,3,4,5};
		
		Permutation_02 main = new Permutation_02(arr, r);
		main.perm(0);
	}
	
	
}
