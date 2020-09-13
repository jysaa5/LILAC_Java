package sort.number.size;

// �迭�� �ִ밪, �ּҰ� ���ϱ�
// 1)solution
public class Max_Min_Sol_01 {

	// �ִ밪 ���ϴ� �޼���
	public int max(int[] nums) {

		int max = nums[0];

		for (int i = 0; i < nums.length; i++) {
			if (max < nums[i]) {
				max = nums[i];
			}
		}
		return max;
	}

	// �ּҰ� ���ϴ� �޼���
	public int min(int[] nums) {

		int min = nums[0];

		for (int i = 0; i < nums.length; i++) {
			if (min > nums[i]) {
				min = nums[i];
			}
		}

		return min;
	}

	// ���� �޼���
	public static void main(String[] args) {

		// �ִ밪, �ּҰ��� ���� int �迭
		int array[] = { 4, 3, 2, 1, 10, 8, 7, 6, 9, 5 };

		Max_Min_Sol_01 mm = new Max_Min_Sol_01();

		System.out.println("�ִ밪: " + mm.max(array));
		System.out.println("�ּҰ�: " + mm.min(array));
	}

}
