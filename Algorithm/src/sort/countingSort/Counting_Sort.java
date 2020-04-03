package sort.countingSort;

//Counting_Sort Ŭ����
public class Counting_Sort {

	private static void countingSort(int[] arr) {
		
		int max = arr[0];
		
		//�Էµ� �迭�� ���� ū �� ã��
		for(int i=0; i<arr.length; i++) {
			
			if(max < arr[i]) {
				max =  arr[i];
			}
			
		}
		max ++;
		
		//counting �迭 ���� �� ����
		int[] c = new int[max];
		
		//���ĵ� �迭 ���� �� ����
		int[] b = new int[arr.length];
		
		//counting �迭 �ʱ�ȭ
		for(int i=0; i<max; i++) {
			c[i] = 0;
		}
		
		//�Էµ� �迭�� �� ī���� �� �ֱ�
		for(int i=0; i<arr.length; i++) {
			c[arr[i]] = c[arr[i]] + 1;
		}
		
		
		// c�迭�� �� �����ϱ�
		for(int i=1; i<max; i++) {
			c[i] = c[i] + c[i-1];
		}
		
		//��� ����
		for(int i=(arr.length-1); i>=0; i--) {
			b[c[arr[i]]-1] = arr[i];
			c[arr[i]] = c[arr[i]] - 1;

		}
		
		//���� �迭�� ���ĵ� �迭�� �����
		for(int i=0; i<arr.length; i++) {
			arr[i] = b[i];
		}
		
	}
	
	//printArray: �迭�� ����ϴ� �޼���
	private static void printArray(int[] arr) {
		for(int data : arr) {
			System.out.print(data+",");
		}
		System.out.println();
	}
	
	
	
	//main �޼���
	public static void main(String[] args) {
		int[] arr = {2,5,3,0,2,3,0,3};
		System.out.println("===========���� ��============");
		printArray(arr);
		System.out.println("===========���� ��============");
		countingSort(arr);
		printArray(arr);
		
		
	}//main ����
	
}//Counting_Sort ����
