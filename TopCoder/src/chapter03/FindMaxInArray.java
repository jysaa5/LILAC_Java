package chapter03;

public class FindMaxInArray {

	// �迭���� �ִ� ������ ���ϱ�
	int getMaxNum(int[] array) {
	
		int ret = array[0];

		for (int i = 1; i < array.length; i++) {

			if (ret < array[i]) {
				ret = array[i];
			}
		}

		return ret;
	}
	
	
	// Test
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4};
		
		FindMaxInArray ar = new FindMaxInArray();
		
		System.out.println(ar.getMaxNum(array));
		
	}

}
