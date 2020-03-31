package sort.mergeSort;

//��͸� �̿��� ����(�պ�) ����
public class Merge_Sort {
	
	//merge sort �Լ� ����
	//arr: ������ �迭
	//���������Ҷ�, ���� �迭�� �ٽ� ���翡�� ����� �Ѵ�. -> ���� �˰��򿡼��� ���ο� �迭�� �ִ� ������ ���⼭�� ������Ѵ�.
	private static void mergeSort(int[] arr) {

		//�ӽ� ���� �迭�� �����.
		//tmp: �ӽ� �����
		int[] tmp = new int[arr.length];
		
		//arr: ������ �迭, tmp: �ӽ� ���� �迭
		//0: ���� �ε���
		//arr.length-1: �� �ε���
		//����Լ� ȣ��
		mergeSort(arr, tmp, 0, arr.length-1); 
		
	}
	
	//mergeSort: �迭�� �ɰ��� �޼���
	//����Լ�
	//arr: ������ �迭, tmp: �ӽ� ����, start: ���� �ε���, end: �� �ε���
	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		
		//���� �ε����� �� �ε������� ���� ���� ���ȣ��
		if(start<end) {
			//�Լ��� ȣ��Ǹ� �迭�� 2���� �߾ӿ��� �ڸ��� ���ؼ� ��� �ε����� �ʿ��ϴ�.
			int mid = (start+end)/2;
			//�迭�� �պκ�: �ڸ��� �ε����� ��������.
			mergeSort(arr, tmp, start, mid);
			//�迭�� �޺κ�: �ڸ��� �ε����� ��������.
			mergeSort(arr, tmp, mid+1, end);
			//�迭���� �������ش�.
			merge(arr, tmp, start, mid, end);
			
		}
		
	}
	
	//�ΰ��� �迭���� �����ϴ� �޼���
	//arr: �迭�� ���ĵ� ����� �ݺ������� �����ϴ� �迭�� ������
	//tmp: �ӽ� ����, mid:�߰� �ε��� start: ���� �ε���, end: �� �ε��� 
	private static void merge(int[] arr, int[] tmp, int start, int mid, int end ) {
		
		//�ӽ� ����迭�� �ʿ��� ��ū ���ĵ� �迭�� �����Ѵ�.
		for(int i=start; i <= end; i++) {
			tmp[i] = arr[i];
			
		}
		
		//ù��° �迭���� ù��° �迭�� �ε��� 
		int part1 = start;
		//�ι�° �迭���� ù��° �迭�� �ε���
		int part2 = mid+1;
		//��� �迭�濡 ��� �����ؾ� ���� ����ؾ� �ϹǷ� ����ϴ� ����
		int index = start;
		
		//ù��° �迭���� ������ �� ��� �迭�濡 ���ų� �ι�° �迭���� ������ �� ��� �迭�濡 �������� �ݺ�
		while(part1<=mid && part2 <=end) {
			
			//ù��° �迭�� ��
			if(tmp[part1] <= tmp[part2]) {
				arr[index] = tmp[part1];
				//���� �����͸� �ű��.
				part1++;
			}else {
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
			
		}
		
		//ù��° ���� �迭�� �������� ���
		for(int i = 0; i<=mid-part1; i++) {
			arr[index+i] = tmp[part1+i];
		}
		
		//�ι�° ���� �迭�� �������� ���� �׳� ���ֵ� �ȴ�. �ֳ��ϸ� �״�� �ڿ� �پ��ֱ� �����̴�.
		
	}
	
	//printArray �޼���: �迭 ��� 
	public static void printArray(int[] arr) {
		for(int data: arr) {
			System.out.print(data+",");
		}
		
		System.out.println();
		
	}//printArray ����
	
	
	//main �޼���
	public static void main(String[] args) {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		System.out.println("===========���� ��============");
		printArray(arr);
		
		System.out.println("===========���� ��============");
		mergeSort(arr);
		printArray(arr);
	}// main ����

}//Merge_Sort ����
