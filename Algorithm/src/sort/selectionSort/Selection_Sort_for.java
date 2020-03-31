package sort.selectionSort;

//for���� �̿��� ��������
public class Selection_Sort_for {
	
	//selectionSort: ��������
	private static void selectionSort(int[] arr) {
		
		int tmp = 0;
		
		for(int i=0; i <=arr.length-1; i++) {
			
			for(int j=1+i; j<=arr.length-1; j++) {
			
				if(arr[i]>=arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				
			}
			}	
		}	
	}//selectionSort ����
	
	
	//printArray: �迭�� ����ϴ� �޼���
	private static void printArray(int[] arr) {
		
		for(int data: arr) {
			
			System.out.print(data+",");
			
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

}//Selection_Sort_for ����
