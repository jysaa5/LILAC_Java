package stack.queue;

// ���� : ��� ����
/*

<���� ����>
���α׷��ӽ� �������� ��� ���� �۾��� ���� ���Դϴ�. �� ����� ������ 100%�� �� ���񽺿� �ݿ��� �� �ֽ��ϴ�.
��, �� ����� ���߼ӵ��� ��� �ٸ��� ������ �ڿ� �ִ� ����� �տ� �ִ� ��ɺ��� ���� ���ߵ� �� �ְ�, �̶� �ڿ� �ִ� ����� �տ� �ִ� ����� ������ �� �Բ� �����˴ϴ�.
���� �����Ǿ�� �ϴ� ������� �۾��� ������ ���� ���� �迭 progresses�� �� �۾��� ���� �ӵ��� ���� ���� �迭 speeds�� �־��� �� �� �������� �� ���� ����� �����Ǵ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

<���� ����>
�۾��� ����(progresses, speeds�迭�� ����)�� 100�� �����Դϴ�.
�۾� ������ 100 �̸��� �ڿ����Դϴ�.
�۾� �ӵ��� 100 ������ �ڿ����Դϴ�.
������ �Ϸ翡 �� ���� �� �� ������, �Ϸ��� ���� �̷�����ٰ� �����մϴ�. ���� ��� �������� 95%�� �۾��� ���� �ӵ��� �Ϸ翡 4%��� ������ 2�� �ڿ� �̷�����ϴ�.

<����� ��>
progresses | speeds   | return
[93,30,55] | [1,30,5] |	[2,1]

<����� �� ����>
ù ��° ����� 93% �Ϸ�Ǿ� �ְ� �Ϸ翡 1%�� �۾��� �����ϹǷ� 7�ϰ� �۾� �� ������ �����մϴ�.
�� ��° ����� 30%�� �Ϸ�Ǿ� �ְ� �Ϸ翡 30%�� �۾��� �����ϹǷ� 3�ϰ� �۾� �� ������ �����մϴ�. ������ ���� ù ��° ����� ���� �ϼ��� ���°� �ƴϱ� ������ ù ��° ����� �����Ǵ� 7��° �����˴ϴ�.
�� ��° ����� 55%�� �Ϸ�Ǿ� �ְ� �Ϸ翡 5%�� �۾��� �����ϹǷ� 9�ϰ� �۾� �� ������ �����մϴ�.
���� 7��°�� 2���� ���, 9��°�� 1���� ����� �����˴ϴ�.

 */

// �ַ�� : 

class Solution_Sol_01 {

	// ����� �ϼ���(%): progresses
	// �� ����� �۾� ���� �ӵ�(%): speeds
	public int[] solution(int[] progresses, int[] speeds) {

		// ����� ���� �۾� ���� 
		int[] rest = new int[progresses.length];
		
		// ���� ������ ����
		int[] count = new int[progresses.length];
		
		// ���� ��¥
		int num = 0;

		// index
		int j = 0;

		// ���� ��¥�� max ��
		int max = 0;

		// ���� �۾� ���� ��¥ ���
		for (int i = 0; i < progresses.length; i++) {

			num = (100 - progresses[i]) / speeds[i];

			if ((100 - progresses[i]) % speeds[i] != 0) {

				num++;

			}

			rest[i] = num;
		}

		// ���� ������ ����
		max = rest[0];
		count[j] = 1;

		for (int i = 1; i < rest.length; i++) {

			if (max < rest[i]) {
		
				j++;
				max = rest[i];
				count[j] += 1;
		
			} else if (max >= rest[i]) {
			
				count[j] += 1;
			
			}

		}

		// ��ȯ��
		int[] answer = new int[j + 1];

		for (int k = 0; k < j + 1; k++) {
			
			answer[k] = count[k];
		
		}

		return answer;

	}

}

public class Function_Development_Sol_01 {

	public static void main(String[] args) {
		Solution_Sol_01 sol = new Solution_Sol_01();

		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };

		int[] answer = sol.solution(progresses, speeds);

		for (int ans : answer) {
			System.out.println(ans);
		}
	}
}
