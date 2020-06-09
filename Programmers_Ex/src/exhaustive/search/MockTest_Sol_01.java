package exhaustive.search;

import java.util.ArrayList;

// ����: ���ǰ��

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
// �ַ��: ���� Ž��

class MokTest_Solution_01 {

	public int[] solution(int[] answers) {
		int[] supoza1 = {1,2,3,4,5};
		int[] supoza2 = {2,1,2,3,2,4,2,5};
		int[] supoza3 = {3,3,1,1,2,2,4,4,5,5};
		
		int[] cnt = new int[3];
		
		ArrayList<Integer> win = new ArrayList<Integer>();
		
		for(int i=0; i<answers.length; i++) {
			if(answers[i] == supoza1[i%5]) {
				cnt[0]++;
			}
			
			if(answers[i] == supoza2[i%8]) {
				cnt[1]++;
			}
			
			if(answers[i]==supoza3[i%10]) {
				cnt[2]++;
			}
		}
		
		int winner = cnt[0];
		
		for(int i=0; i<cnt.length;i++) {
			if(winner<cnt[i]) {
				winner = cnt[i];
			}
		}
		
		
		for(int i=0; i<cnt.length; i++) {
			if(winner == cnt[i]) {
			win.add(i);	
			}
		}
		
		int[] answer = {};
		
		answer = new int[win.size()];
		
		for(int i=0; i<win.size(); i++) {
			answer[i] = win.get(i)+1;
		}
		
		return answer;

	}

}

public class MockTest_Sol_01 {

	public static void main(String[] args) {
		MokTest_Solution_01 sol = new MokTest_Solution_01();
		
		//int[] answers = {1,2,3,4,5};
		int[] answers = {1,3,2,4,2};
		int[] answer = sol.solution(answers);
		
		
		for(int i: answer) {
			System.out.println(i);
		}
		
	}
}
