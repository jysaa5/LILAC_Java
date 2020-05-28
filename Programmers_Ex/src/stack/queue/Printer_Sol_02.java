package stack.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// ����: ������
// �μ� ������� ���� �տ� �ִ� ���� = J, �߿䵵�� �ִ� ������
// �ַ�� 2: �߿䵵�� ������� ���� ��, �� ���� ������ ���缭 ť�� ������ Ȯ���Ѵ�. 

class Solution_02 {
	public int solution(int[] priorities, int location) {

		int answer = 0;
		int l = location;

		// ť �Ǿ�
		Queue<Integer> que = new LinkedList<Integer>();

		for (int i : priorities) {
			que.add(i);
		}

		// ����: �߿䵵 ���� -> ������������ ����
		Arrays.sort(priorities);

		// �迭�� ������ �ε��� ��ȣ
		int size = priorities.length - 1;

		while (!que.isEmpty()) {

			// queue���� ������
			Integer i = que.poll();

			// ���� ���� ���� ū �߿䵵 �� ��
			if (i == priorities[size - answer]) {

				// ����Ʈ�� �Ǵ� ���� 1����
				answer++;

				// ť���� �����Ͱ� �������Ƿ� ��ġ�� 1����
				l--;

				if (l < 0)
					break;

				// ���� ���� ���� ū �߿䵵�� �ƴ� ��.
			} else {

				// ť �ڿ� ������ ���̱�
				que.add(i);

				// ť���� �����Ͱ� �������Ƿ� ��ġ�� 1����
				l--;

				// ��ġ�� �� ó���� ��, �ٽ� �ڿ� �ٿ����Ƿ� ��ġ�� ť�� �� ���̴�
				if (l < 0)
					l = que.size() - 1;
			}
		}

		return answer;
	}
}

public class Printer_Sol_02 {

	public static void main(String[] args) {
		Solution_02 sol = new Solution_02();

		// int[] priorities = {2,1,3,2};
		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		// int location = 2;
		int location = 0;

		System.out.println(sol.solution(priorities, location));

	}
}