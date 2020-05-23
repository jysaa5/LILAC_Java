package sort.insertionSort;

//Insertion_Sort_For Ŭ����: for���� �̿��� �������� 
public class Insertion_Sort_For {
	
	//insertionSort �޼���: ���� ���� �޼���
	private static void insertionSort(int[] arr) {
		
		int tmp = 0;
		
		for(int i=1; i<=arr.length-1; i++) {
			
			for(int j=i-1; j>=0; j--) {
				
				if(arr[j]>arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;	
					
				}
			}
		}
		
	}//insetionSort ����
	
	
	//printArray �޼���: �迭�� ����ϴ� �޼���
	private static void printArray(int[] arr) {
		
		for(int data: arr) {
			System.out.print(data+",");
		}
		System.out.println();
		
	}//printArray ����
	
	
	//main �޼��� 
	public static void main(String[] args) {
		int[] arr = { 3, 6, 1, 8, 2, 4 };
		System.out.println("===========���� ��============");
		printArray(arr);
		
		System.out.println("===========���� ��============");
		insertionSort(arr);
		printArray(arr);
	
	}//main ����
	
}//Insertion_Sort_For ����
