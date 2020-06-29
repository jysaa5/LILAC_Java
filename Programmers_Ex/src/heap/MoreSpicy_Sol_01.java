package heap;

import java.util.PriorityQueue;
// ����: �� �ʰ�
/*
���� ����
�ſ� ���� �����ϴ� Leo�� ��� ������ ���ں� ������ K �̻����� ����� �ͽ��ϴ�. 
��� ������ ���ں� ������ K �̻����� ����� ���� Leo�� ���ں� ������ ���� ���� �� ���� ������ �Ʒ��� ���� Ư���� ������� ���� ���ο� ������ ����ϴ�.

���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)

Leo�� ��� ������ ���ں� ������ K �̻��� �� ������ �ݺ��Ͽ� �����ϴ�.
Leo�� ���� ������ ���ں� ������ ���� �迭 scoville�� ���ϴ� ���ں� ���� K�� �־��� ��, 
��� ������ ���ں� ������ K �̻����� ����� ���� ����� �ϴ� �ּ� Ƚ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
scoville�� ���̴� 2 �̻� 1,000,000 �����Դϴ�.
K�� 0 �̻� 1,000,000,000 �����Դϴ�.
scoville�� ���Ҵ� ���� 0 �̻� 1,000,000 �����Դϴ�.
��� ������ ���ں� ������ K �̻����� ���� �� ���� ��쿡�� -1�� return �մϴ�.

����� ��
scoville	         |k | return
[1, 2, 3, 9, 10, 12] |7 | 2

����� �� ����
���ں� ������ 1�� ���İ� 2�� ������ ������ ������ ���ں� ������ �Ʒ��� ���� �˴ϴ�.
���ο� ������ ���ں� ���� = 1 + (2 * 2) = 5
���� ������ ���ں� ���� = [5, 3, 9, 10, 12]

���ں� ������ 3�� ���İ� 5�� ������ ������ ������ ���ں� ������ �Ʒ��� ���� �˴ϴ�.
���ο� ������ ���ں� ���� = 3 + (5 * 2) = 13
���� ������ ���ں� ���� = [13, 9, 10, 12]

��� ������ ���ں� ������ 7 �̻��� �Ǿ��� �̶� ���� Ƚ���� 2ȸ�Դϴ�.
*/
// �ַ��: PriorityQueue ���

class MoreSpicy_Solution_01 {

	public int solution(int[] scoville, int K) {
		
		int answer = 0;
		
		// �켱���� ť ����
		PriorityQueue<Integer> food = new PriorityQueue<Integer>();
		
		// ť�� scoville�� �ִ´�.
		// ������������ ť�� ����ȴ�.
		for(int aScoville: scoville) {
			food.offer(aScoville);
		}
		
		
		while(food.peek() <= K) {
			
			if(food.size() == 1) {
				return -1;
			}
			
			int a = food.poll();
			int b = food.poll();
			
			int result = a + (2*b);
			
			food.offer(result);
			answer ++;
			
		}
		return answer;
	}
}

public class MoreSpicy_Sol_01 {
	
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		MoreSpicy_Solution_01 sol = new MoreSpicy_Solution_01();
		
		System.out.println(sol.solution(scoville, K));
	}

}
