package sort;

public class Bubble_Sort {

	//bubbleSort: �������� �޼���
	private static void bubbleSort(int[] arr) {
		//����Լ� ȣ��
		//arr: �迭
		//arr.length-1: �迭�� ������ �ε���
		bubbleSort(arr, arr.length-1);
		
	}//bubbleSort ����
	
	
	//bubbleSort: ���� ���� �޼����� ����Լ�
	private static void bubbleSort(int[] arr, int last) {
		
		//������ �ε����� 0���� Ŭ ������
		if(last > 0) {
			
			//������ �ε������� �迭���� ����.
			for(int i=1; i <= last; i++) {
				
				//�� ���ʿ� �ִ� ���� ������ Ŭ��
				if(arr[i-1] > arr[i]) {
					//�ڸ� �ٲٱ�
					swap(arr, i-1, i);
				}
				
			}
			
			//������ �ε����� �����ϰ� �ٽ� ���� ���� ��� ȣ��
			bubbleSort(arr, last-1);
		}

	}//bubbleSort ����
	
	
	//swap �޼���: �ڸ��ٲٱ�(����)
	private static void swap(int[] arr, int source, int target) {
		int tmp = arr[source];
		arr[source] = arr[target];
		arr[target] = tmp;
		
	}//swap ����
	
	
	//printArray: �迭 ��� �޼���
	private static void printArray(int[] arr) {
		
		for (int data : arr) {
			
			System.out.print(data + ",");
		}
		
		System.out.println();
		
	}//printArray ����


	
	//main ���� �Լ�
	public static void main(String[] args) {
		
		int[] arr = {3,5,4,2,1};
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
		
	}//main ����
	
}//Bubble_Sort ����
