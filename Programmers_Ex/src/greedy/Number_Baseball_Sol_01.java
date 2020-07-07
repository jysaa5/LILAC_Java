package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// ����: ���� �߱�
/*
���� ����
���� �߱� �����̶� 2���� ���ΰ� ������ ���ڸ� ���ߴ� �����Դϴ�. �����غ���

���� ���� �ٸ� 1~9���� 3�ڸ� ������ ���ڸ� ���� �� ���ο��� 3�ڸ��� ���ڸ� �ҷ��� ����� Ȯ���մϴ�. �׸��� �� ����� ���� ��밡 ���� ���ڸ� ������ �� �����ϴ�.

* ���ڴ� ������, ��ġ�� Ʋ���� ���� ��
* ���ڿ� ��ġ�� ��� ���� ���� ��Ʈ����ũ
* ���ڿ� ��ġ�� ��� Ʋ���� ���� �ƿ�
���� ���, �Ʒ��� ��찡 ������

A : 123
B : 1��Ʈ����ũ 1��.
A : 356
B : 1��Ʈ����ũ 0��.
A : 327
B : 2��Ʈ����ũ 0��.
A : 489
B : 0��Ʈ����ũ 1��.
�̶� ������ ���� 324�� 328 �� �����Դϴ�.

������ �� �ڸ��� ��, ��Ʈ����ũ�� ��, ���� ���� ���� 2���� �迭 baseball�� �Ű������� �־��� ��, ������ ���� ������ return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
������ ���� 1 �̻� 100 ������ �ڿ����Դϴ�.
baseball�� �� ���� [�� �ڸ��� ��, ��Ʈ����ũ�� ��, ���� ��] �� ��� �ֽ��ϴ�.

����� ��
baseball                                             | return
[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]] |	2

����� �� ����
������ ���� ���� �����ϴ�.
*/
// �ַ��: 

class Number_Baseball_Solution_01 {
	public int solution(int[][] baseball) {
		int[] tmp = new int[3];

		// ������ ��� ����� ���� stack�� �ִ´�.
		Stack<String> stack = new Stack<>();
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				for (int k = 1; k <= 9; k++) {
					if (i != j && j != k && i != k) {
						stack.add(String.valueOf(i * 100 + j * 10 + k));
					}
				}
			}
		}

		// �´� ����� ���� �־��� answerList ����
		Stack<String> answerList = new Stack<>();

		// ������ ������ baseball.length
		// ������ �ϳ��� �ȸ´� ��� flag�� ���ؼ� �ɷ�����.
		while (!stack.isEmpty()) {
			String out = stack.pop();

			boolean flag = false;
			for (int i = 0; i < baseball.length; i++) {
				int strike = strike(out, String.valueOf(baseball[i][0]));
				int ball = ball(out, String.valueOf(baseball[i][0])) - strike;

				if (strike != baseball[i][1] || ball != baseball[i][2]) {
					flag = true;
					break;
				}
			}

			if (flag == false) {
				answerList.add(out);
			}
		}

		return answerList.size();
	}

	static int strike(String n1, String n2) {
		int rtn = 0;
		for (int i = 0; i < 3; i++) {
			if (n1.charAt(i) == n2.charAt(i)) {
				rtn++;
			}
		}
		return rtn;
	}

	static int ball(String n1, String n2) {
		int rtn = 0;

		List<Character> tmp = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			tmp.add(n2.charAt(i));
		}

		for (int i = 0; i < 3; i++) {
			if (tmp.contains(n1.charAt(i))) {
				rtn++;
			}
		}

		return rtn;
	}
}

public class Number_Baseball_Sol_01 {

	public static void main(String[] args) {

		int[][] baseball = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };

		Number_Baseball_Solution_01 sol = new Number_Baseball_Solution_01();

		System.out.println(sol.solution(baseball));

	}

}
