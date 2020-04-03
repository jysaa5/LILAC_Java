package sort.radixSort;

import java.util.Arrays;

//RadixSort: ��� ���� Ŭ����
//MSB -> LSB
public class RadixSort {

	//getMax: �ִ밪�� ã�� �޼���
	//arr: �迭�� ����
	//n: �迭�� ����
	private static int getMax (int[] arr, int n) {
		
		//max: �ִ밪�� ��� ����
		int max = arr[0];
		
		for(int i=1; i<n; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		
		return max;
	}
	
	//countSort: �迭�� ��������ϴ� �޼���
	//arr: �迭 ����
	//n: �迭�� ����
	//exp: 10, 100, 1000... 
	private static void countSort(int[] arr, int n, int exp) {
		
		int[] output = new int[n];
		int i;
		int[] count = new int[10];
		
		//0���� �ʱ�ȭ
		Arrays.fill(count, 0);
		
		//������ �迭�� �ڸ������� ���� ������ count �迭�� ���� 
		for(i = 0; i<n; i++) {
			count[(arr[i]/exp)%10] ++;
		}
		
		//count �迭 �� ����
		for(i=1; i<10; i++) {
			count[i] += count[i-1];
		}
		
		//���� �迭 �ڿ������� count �迭�� ���� Ȯ���ϰ� �ش� �ε��� �迭�� ���� ����
		//����Ǹ� count ���� 1�� ���̱�
		for(i=n-1; i>=0; i--) {
			output[count[(arr[i]/exp)%10]-1] = arr[i];
			count[(arr[i]/exp)%10] --;
		}
		
		//���� �迭�� ����� �迭 �����ϱ�
		for(i = 0; i < n; i++) {
			arr[i] = output[i];
		}
		
	}
	
	
	//radixSort: ��� ����
	private static void radixSort(int[] arr, int n) {
		
		//������ �迭 �� �߿��� ���� ū ��
		int max = getMax(arr, n);
		
		//������ �迭 ������ �ִ밪�� ���ؼ� �� �ڸ� ������ �����ϴ� �� Ȯ���Ͽ��� ��� ������ �ݺ��Ѵ�.
		for(int exp = 1; max/exp > 0; exp *= 10) {
			countSort(arr, n, exp);
		}
		
	}
	
	//printArray: �迭 ���
	private static void printArray(int[] arr) {
		for(int data: arr) {
			System.out.print(data+",");
		}
		
		System.out.println();
	}
	
	//main �޼���
	public static void main(String[] args) {
		
		//int[] arr = {326, 453, 608, 835, 751, 435, 704, 690};
		int[] arr = {170, 45, 75, 90, 802, 24, 2, 66}; 
		
		int n = arr.length;
		
		System.out.println("===========���� ��============");
		printArray(arr);
		System.out.println("===========���� ��============");
		radixSort(arr, n);
		printArray(arr);
		
	}//main ����
	
}//RadixSort ����
