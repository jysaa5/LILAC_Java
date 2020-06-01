package stack.queue;

import java.util.LinkedList;
import java.util.Queue;

// ����: ������
/*
�Ϲ����� �����ʹ� �μ� ��û�� ���� ������� �μ��մϴ�. �׷��� ������ �߿��� ������ ���߿� �μ�� �� �ֽ��ϴ�. �̷� ������ �����ϱ� ���� �߿䵵�� ���� ������ ���� �μ��ϴ� �����͸� �����߽��ϴ�. �� ���Ӱ� ������ �����ʹ� �Ʒ��� ���� ������� �μ� �۾��� �����մϴ�.

1. �μ� ������� ���� �տ� �ִ� ����(J)�� ����Ͽ��� �����ϴ�.
2. ������ �μ� ����Ͽ��� J���� �߿䵵�� ���� ������ �� ���� �����ϸ� J�� ������� ���� �������� �ֽ��ϴ�.
3. �׷��� ������ J�� �μ��մϴ�.
���� ���, 4���� ����(A, B, C, D)�� ������� �μ� ����Ͽ� �ְ� �߿䵵�� 2 1 3 2 ��� C D A B ������ �μ��ϰ� �˴ϴ�.

���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� �˰� �ͽ��ϴ�. ���� ������ C�� 1��°��, A�� 3��°�� �μ�˴ϴ�.

���� ����Ͽ� �ִ� ������ �߿䵵�� ������� ��� �迭 priorities�� ���� �μ⸦ ��û�� ������ ���� ������� � ��ġ�� �ִ����� �˷��ִ� location�� �Ű������� �־��� ��, ���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
���� ����Ͽ��� 1�� �̻� 100�� ������ ������ �ֽ��ϴ�.
�μ� �۾��� �߿䵵�� 1~9�� ǥ���ϸ� ���ڰ� Ŭ���� �߿��ϴٴ� ���Դϴ�.
location�� 0 �̻� (���� ����Ͽ� �ִ� �۾� �� - 1) ������ ���� ������ ������� ���� �տ� ������ 0, �� ��°�� ������ 1�� ǥ���մϴ�.

����� ��
priorities         | location |	return
[2, 1, 3, 2]       |	 2    |   1
[1, 1, 9, 1, 1, 1] | 	 0	  |   5

*/


// �μ� ������� ���� �տ� �ִ� ���� = J, �߿䵵�� �ִ� ������
// �ַ�� 1: queue 2���� �������. (���� Ǭ ��.)

class Solution_Printer_01 {

	public int solution(int[] priorities, int location) {
		// ��ȯ ��
		int answer = 1;

		// ���� �߿䵵 ���� ��
		int max = 0;

		// ����Ʈ ��⿭�� ���� �� �տ� �ִ� ������ ���
		int j = 0;

		// ����Ʈ ��⿭ ť ����
		Queue<Integer> printer = new LinkedList<Integer>();

		// �ε��� ť
		Queue<Integer> printerIndex = new LinkedList<Integer>();

		// ť�� ����Ʈ ��⿭ �ֱ�
		for (int i = 0; i < priorities.length; i++) {

			printer.add(priorities[i]);
			printerIndex.add(i);

			if (max < priorities[i]) {

				max = priorities[i];

			}
		}

		// ������ ��⿭ ť�� ����Ʈ �� ���� ���� ������
		while (printer.peek() != null) {

			// ������ ��⿭ �տ� �ִ� ����Ʈ ������
			j = printer.poll();

			// �߿䵵�� ���� ���� ��
			if (j == max) {

				// ���ϴ� ��ġ�� �ִ� ����Ʈ�϶�
				if (location == printerIndex.poll()) {

					break;

				} else {

					answer++;

					// max�� �� �ʱ�ȭ
					for (int i = 0; i < priorities.length; i++) {

						if (max == priorities[i]) {
							priorities[i] = 0;
							max = 0;
						}
					}

					// ���ο� max ��
					for (int i = 0; i < priorities.length; i++) {

						if (max < priorities[i]) {

							max = priorities[i];

						}
					}

				}

			} else {

				printer.add(j);
				printerIndex.add(printerIndex.poll());

			}

		}
		return answer;
	}
}

public class Printer_Sol_01 {

	public static void main(String[] args) {

		Solution_Printer_01 sol = new Solution_Printer_01();

		// int[] priorities = {2,1,3,2};
		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		// int location = 2;
		int location = 0;

		System.out.println(sol.solution(priorities, location));

	}

}