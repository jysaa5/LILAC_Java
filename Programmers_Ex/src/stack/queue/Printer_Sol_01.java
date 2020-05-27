package stack.queue;

import java.util.LinkedList;
import java.util.Queue;

// ����: ������
// �μ� ������� ���� �տ� �ִ� ���� = J, �߿䵵�� �ִ� ������
// �ַ�� 1: queue 2���� �������. (���� Ǭ ��.)

class Solution {

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

		Solution sol = new Solution();

		// int[] priorities = {2,1,3,2};
		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		// int location = 2;
		int location = 0;

		System.out.println(sol.solution(priorities, location));

	}

}