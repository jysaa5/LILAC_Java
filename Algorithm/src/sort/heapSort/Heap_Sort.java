package sort.heapSort;

//�� ����: �ִ���, �������� ����
public class Heap_Sort {

	//heapSort: �� ����
	private static void heapSort(int[] arr) {
		
		//�迭�� ũ��
		int arrSize = arr.length;
	
		//1. Build heap :�� ���� ����
		//�� ���� ����� = �迭 ���ġ
		//i: �θ� ���
		//arrSize-1: �迭�� ������ �ε���
		//(arrSize-1)/2: �θ� ����߿��� ���� ���� ����� �ε��� �� 
		for(int i = (arrSize-1)/2; i>=0; i--) {
			
			heapify(arr, arrSize, i);
			
		}
	
		//2. Extract-Max: �ִ밪 ���� -> �� ����
		for(int i=arrSize-1; i>=0; i--) {
			
			//���� ū ���� ���� ��Ʈ�� ������������ ����
			//�ִ� ū ���� �迭�� �� �ڿ������� ä������.
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			
			//�ٽ� �ִ��� ������ �����
			heapify(arr, i, 0);
			
		}
	}//heapSort ����
	
	
	//3. Max heapify: �ִ����� ����� �ִ� ����
	private static void heapify(int[] arr, int arrSize, int i) {
		
		//���� ū ��(��Ʈ)�� ���� �ִ� �迭�� �ε���
		int largest = i;
		
		//left child�� �ε���
		int l = 2*i + 1;
		
		//right child�� �ε���
		int r = 2*i + 2;
		
		//���� �ڽ��� ��Ʈ���� Ŭ ��.
		if(l < arrSize && arr[l]>arr[largest]) {
			largest = l;
		}
		
		//������ �ڽ��� ��Ʈ���� Ŭ ��
		if(r< arrSize && arr[r] > arr[largest]) {
			largest = r;
		}
		
		//���� ū ���� ��Ʈ�� �ƴ� ���
		if(largest != i) {
			
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			
			// ���� Ʈ���� ���ؼ� heapify 
			heapify(arr, arrSize, largest);
		}
	}//heapify ����
	
	
	//printArray �޼��� 
	private static void printArray(int[] arr) {
		
		for(int data: arr) {
			System.out.print(data+",");
		}
		
		System.out.println();
		
	}//printArray ����
	
	
	//main �޼���
	public static void main(String[] args) {
		
		int arr[] = {12,11,13,5,6,7};
		//int arr[] = {12,11,13,5,6,6};
		System.out.println("===========���� ��============");
		printArray(arr);
		
		System.out.println("===========���� ��============");
		heapSort(arr);
		printArray(arr);
 	
	}//main	����
	
}//Heap_Sort ����