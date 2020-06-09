package exhaustive.search;

import java.util.ArrayList;

//����: ���ǰ��

/*
���� ����
�����ڴ� ������ ������ ����� �ظ��Դϴ�. ������ ���ι��� ���ǰ�翡 ���� ������ ���� ������ �մϴ�. 
�����ڴ� 1�� �������� ������ �������� ������ ���� ����ϴ�.

1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, 
���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
������ �ִ� 10,000 ������ �����Ǿ��ֽ��ϴ�.
������ ������ 1, 2, 3, 4, 5�� �ϳ��Դϴ�.
���� ���� ������ ���� ����� ������ ���, return�ϴ� ���� �������� �������ּ���.

����� ��
answers	    | return
[1,2,3,4,5] |	[1]
[1,3,2,4,2]	| [1,2,3]

����� �� ����
����� �� #1

������ 1�� ��� ������ �������ϴ�.
������ 2�� ��� ������ Ʋ�Ƚ��ϴ�.
������ 3�� ��� ������ Ʋ�Ƚ��ϴ�.
���� ���� ������ ���� ���� ����� ������ 1�Դϴ�.

����� �� #2
��� ����� 2�������� ������ϴ�.
*/

//�ַ��: ���� Ž��

class MokTest_Solution_02 {
	
	public int[] solution(int[] answer) {
		
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] c = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int[] score = new int[3];
		
		for (int i = 0; i < answer.length; i++) {
			
			if (answer[i] == a[i % a.length]) {
				score[0]++;
			}
			if (answer[i] == b[i % b.length]) {
				score[1]++;
			}
			if (answer[i] == c[i % c.length]) {
				score[2]++;
			}
		}
		
		int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
		
		ArrayList<Integer> list = new ArrayList<>();
		
		if (maxScore == score[0]) {
			list.add(1);
		}
		if (maxScore == score[1]) {
			list.add(2);
		}
		if (maxScore == score[2]) {
			list.add(3);
		}
		
		return list.stream().mapToInt(i -> i.intValue()).toArray();
	}
}

public class MockTest_Sol_02 {
	public static void main(String[] args) {
		MokTest_Solution_02 sol = new MokTest_Solution_02();
		
		//int[] answers = {1,2,3,4,5};
		int[] answers = {1,3,2,4,2};
		int[] answer = sol.solution(answers);
		
		
		for(int i: answer) {
			System.out.println(i);
		}
		
	}
}
