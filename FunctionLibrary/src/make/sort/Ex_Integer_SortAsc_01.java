package make.sort;

import java.util.Arrays;

// ��������
// ���� �迭
public class Ex_Integer_SortAsc_01 {

	public static void main(String[] args) {

		int[] arr1 = { 25, 40, 1, 53, 7, 8 };
		Arrays.sort(arr1);
		
		for (int i = 0; i < arr1.length; i++) {
			
			System.out.print(arr1[i] + " ");
			
		}
		
		System.out.println();
		
		int[] arr2 = { 25, 40, 1, 53, 7, 8 };
		
		// index�� 1�� �迭 ���� �迭 ������ index���� ����
		Arrays.sort(arr2, 1, arr2.length-1);
		
		for (int i = 0; i < arr2.length; i++) {
			
			System.out.print(arr2[i] + " ");
			
		}

	}

}
