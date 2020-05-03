package sort.quickSort;

//Quick Sort: �� ���� Ŭ���� 
public class Quick_Sort {
	
	//quickSort: �� ���� �޼���
	private static void quickSort(int[] arr) {
		//��� �Լ� ȣ��
		//arr: �迭
		//0: �迭�� ���� �ε���
		//arr.length-1: �迭�� ������ �ε���
		quickSort(arr, 0, arr.length-1);
		
	}//quickSort ����
	
	
	//quickSort: ����Լ�
	//start, end: ��Ƽ���� ���� ����
	private static void quickSort(int[] arr, int start, int end) {
		
		// part2: ��Ƽ���� ������ ������ ��Ƽ�� ù ��° �迭�� �ε��� ��
		int part2 = partition(arr, start, end);
		
		//���� ��Ƽ�ǿ��� ����
		//���� ��Ƽ�ǿ� �迭 ������ 1�� �ʰ� �϶��� ����
		if(start < part2 -1 ) {
		
			quickSort(arr, start, part2 -1 );
		
		}
		
		//������ ��Ƽ�ǿ��� ����
		//������ ��Ƽ�ǿ� �迭 ������ 1�� �ʰ� �� ���� ����
		if(part2 < end) {
		
			quickSort(arr, part2, end);
		
		}
		
	}//quickSort ����
	
	
	//�迭�� ��Ƽ���� ������ �޼���
	private static int partition(int[] arr, int start, int end) {
		
		//pivot: �߰� �������� ���� ���̴�.
		int pivot = arr[(start+end)/2];
		
		// start�����Ϳ� end�����Ͱ� �����ļ� ����ĥ������ �ݺ�
		while(start <= end) {
			while(arr[start] < pivot) {
				start ++;
			}
			
			while(arr[end] > pivot) {
				end --;
			}
			
			if(start <= end) {
				swap(arr, start, end);
				start ++;
				end--;
			}
			
		}
		
		// ��Ƽ���� �� ������ ������ ��Ƽ���� ���� start ������ ���� ��ȯ�Ѵ�.
		return start;
		
	}//partition ����
	
	
	//swap: ��ȯ �޼���
	private static void swap(int[] arr, int start, int end) {
	
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	
	}//swap ����
	
	
	//printArray: �迭 ��� �޼���
	private static void printArray(int[] arr) {
		
		for(int data: arr) {
			
			System.out.print(data+",");
			
		}
		
		System.out.println();
		
	}//printArray ����
	
	
	//main: ���� ���� �޼���
	public static void main(String[] args) {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		System.out.println("===========���� ��============");
		printArray(arr);
		System.out.println("===========���� ��============");
		quickSort(arr);
		printArray(arr);
	}//main ����

}//Quick_Sort ����