package sort.insertionSort;

public class Insertion_Sort_while {
	
	//insertionSort �޼���: ���� ����
	private static void insertionSort(int[] arr) {
		
		//key��
		int key;
		int i, j;
		
		for(j=1; j<arr.length; j++) {
			
			//key ��
			key = arr[j];
			i = j-1;
			
			//�ε����� 0���� ũ�� key ������ �տ� ���ĵ� ���� Ŭ��
			while(i>=0 && arr[i] > key) {
				//�迭�� �� ĭ�� �ڷ� �о��.
				arr[i+1] = arr[i];
				i = i-1;
			}
			
			arr[i+1] = key;
		}
	}


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
	
}//Insertion_Sort_while ����
