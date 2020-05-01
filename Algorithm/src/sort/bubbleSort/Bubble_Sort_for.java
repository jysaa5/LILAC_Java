package sort.bubbleSort;

//Bubble_Sort_For Ŭ����: for���� �̿��� �������� ����
public class Bubble_Sort_For {

	//bubbleSort: for�� �̿��� �޼��� 
	private static void bubbleSort(int[] arr) {
		
		int tmp = 0;
		
		//�迭 ���������� ���Ľ�Ų��.
		for(int i=arr.length-1; i>=0; i--) {
			
			for(int j=0; j<i; j++) {
				
				if(arr[j]>arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}	
			}
		}
	}//bubbleSort ����
	
	//printArray: �迭 ��� �޼���
	private static void printArray(int[] arr) {
		
		for (int data : arr) {
			
			System.out.print(data + ",");
			
		}
			
			System.out.println();
			
		}//printArray ����
	
	//main ���� �޼���
	public static void main(String[] args) {
		
		int[] arr = {3,5,4,2,1};
		
		System.out.println("===========���� ��============");
		printArray(arr);
		
		System.out.println("===========���� ��============");
		bubbleSort(arr);
		printArray(arr);
		
	}//main ����
	
}//Bubble_Sort_For ����
