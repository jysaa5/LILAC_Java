package sort.selectionSort;

//��͸� �̿��� ��������
public class Selection_Sort {

	//selectionSort: ������ �迭�� ���ڷ� �޴� �޼���
	private static void selectionSort(int[] arr) {
		//����Լ� ȣ��: ������ �ȵ� �ε����� ���ڷ� �ѱ��.
		//ó������ �� ������ �ȵ� �����̹Ƿ� �ε��� 0����.
		selectionSort(arr, 0);
	
	}//selectionSort ����

	
	//selectionSort: ������ �迭�� �������� ���ڷ� �޴� �޼���
	private static void selectionSort(int[] arr, int start) {

		//�������� �迭�� ������ �ε������� ���� ��
		if (start < arr.length - 1) {
			
			//���� ���� ���� �ε����� ������ ����
			int min_index = start;

			for (int i = start; i < arr.length; i++) {

				if (arr[i] < arr[min_index]) {
					min_index = i;
				}
			}
			
			//�������� ���� ���� ���� �ִ� �ε����� ���ڷ� �ѱ��.
			//������ �迭���� ���� ���� ���� ���� �ִ� �迭 ���� ���� �¹ٲ۴�.
			swap(arr, start, min_index);
			
			//�� �ٽ� �������� ��� ȣ��
			selectionSort(arr, start + 1);

		}
		
	}//selectionSort ����
	
	

	//�迭���� ���� �¹ٲٴ� �޼���
	private static void swap(int[] arr, int index1, int index2) {
	
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	
	}//swap ����

	//printArray: �迭�� ����ϴ� �޼���
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
		selectionSort(arr);
		printArray(arr);
		
	}//main ����

}//Selection_Sort ����