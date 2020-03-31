package sort.insertionSort;

//��͸� �̿��� ���� ����
public class Insertion_Sort {

	
	//insertionSort �޼���: ���� ���� �޼���
	private static void insertionSort(int[] arr) {
		
		insertionSort(arr, 1);
		
	}//insertionSort ����
	
	
	//insertionSort �޼���: insertion sort�� ��� �޼���
	private static void insertionSort(int[] arr, int start) {
		
		if(start < arr.length) {
			
			//���� �ε����� �迭�� �� = key ��
			int standard = arr[start];
			
			//���ĵǾ� �ִٰ� ������ �ε����� ��
			int compareIndex = start-1;
			
			
			while(compareIndex >= 0 && arr[compareIndex] > standard) {
				arr[compareIndex+1] = arr[compareIndex];
				compareIndex --;
			}
			
			arr[compareIndex+1] = standard;
			insertionSort(arr,start+1);

		}
		
	}//insertionSort ����
	
	
	//printArray: �迭 ��� �޼���
	private static void printArray(int[] arr) {
		
		for (int data : arr) {
			
			System.out.print(data + ",");
		
		}
		
		System.out.println();
		
	}//printArray ����

	
	//main: ���� ���� �޼���
	public static void main(String[] args) {
		
		int[] arr = { 3, 6, 1, 8, 2, 4 };
		
		System.out.println("===========���� ��============");
		printArray(arr);
		
		System.out.println("===========���� ��============");
		insertionSort(arr);
		printArray(arr);
		
	}//main ����

	
}//Insertion_Sort ����
