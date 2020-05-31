package stack.queue;

import java.util.LinkedList;
import java.util.Queue;

// ����: �ٸ��� ������ Ʈ��
/*
���� ����
Ʈ�� ���� �밡 ���� ���������� �� ���� �ٸ��� ������ ������ �ǳʷ� �մϴ�. ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� �˾Ƴ��� �մϴ�. Ʈ���� 1�ʿ� 1��ŭ �����̸�, �ٸ� ���̴� bridge_length�̰� �ٸ��� ���� weight���� �ߵ��ϴ�.
�� Ʈ���� �ٸ��� ������ ������ ���� ���, �� Ʈ���� ���Դ� ������� �ʽ��ϴ�.

���� ���, ���̰� 2�̰� 10kg ���Ը� �ߵ�� �ٸ��� �ֽ��ϴ�. ���԰� [7, 4, 5, 6]kg�� Ʈ���� ������� �ִ� �ð� �ȿ� �ٸ��� �ǳʷ��� ������ ���� �ǳʾ� �մϴ�.

��� �ð� | �ٸ��� ���� Ʈ��  | �ٸ��� �ǳʴ� Ʈ��  | ��� Ʈ��
0      |	[]	     |      []       |  [7,4,5,6]
1~2	   |    []	     |      [7]      |	[4,5,6]
3	   |    [7]      |	    [4]	     |  [5,6]
4	   |    [7]      |	   [4,5]     | 	[6]
5	   |   [7,4]     |	    [5]      |	[6]
6~7	   |  [7,4,5]    |	    [6]	     |  []
8	   |  [7,4,5,6]  |	     []	     |  []
����, ��� Ʈ���� �ٸ��� �������� �ּ� 8�ʰ� �ɸ��ϴ�.

solution �Լ��� �Ű������� �ٸ� ���� bridge_length, �ٸ��� �ߵ� �� �ִ� ���� weight, Ʈ���� ���� truck_weights�� �־����ϴ�. �̶� ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

���� ����
bridge_length�� 1 �̻� 10,000 �����Դϴ�.
weight�� 1 �̻� 10,000 �����Դϴ�.
truck_weights�� ���̴� 1 �̻� 10,000 �����Դϴ�.
��� Ʈ���� ���Դ� 1 �̻� weight �����Դϴ�.

����� ��
bridge_length |	weight |    truck_weights                   | return
2             |	10     |    [7,4,5,6]                       |	8
100	          | 100    |	[10]	                        |   101
100	          | 100    |	[10,10,10,10,10,10,10,10,10,10] |   110
*/

// �ڷᱸ�� ����
public class Truck_Bridge {

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		// �� Ʈ���� �ٸ����� ���� ������ �ð�: truckOutTime[i] = i��° Ʈ���� �ٸ��� ������ �ö� �ð� + �ٸ��� ����
		int[] truckOutTime = new int[truck_weights.length];

		// Ʈ���� �ٸ��� ���� ��
		Queue<Integer> truckOnBridge = new LinkedList<Integer>();

		// �ð�
		int time = 0;
		// ����ϴ� Ʈ������ �� �տ� Ʈ���� ����
		int firstTruck = 0;

		while (true) {

			// ������ Ʈ�� ����: �ٸ��� Ʈ���� �����鼭 && ���� ���� �� Ʈ���� �ٸ����� ���� ������ �ð�
			if (!truckOnBridge.isEmpty() && (truckOutTime[truckOnBridge.peek()] == time)) {

				// ���� ���� �� Ʈ���� ��ȯ�ϸ鼭 �����ϰ� �ٸ� ���Ը� �� ��ŭ �ø�.
				weight += truck_weights[truckOnBridge.poll()];
			}

			// ����ϴ� Ʈ�� �߰�
			if (firstTruck < truck_weights.length && truck_weights[firstTruck] <= weight) {
				truckOnBridge.add(firstTruck);
				truckOutTime[firstTruck] = time + bridge_length;
				weight -= truck_weights[firstTruck];
				firstTruck++;
			}

			time++;
			if (truckOnBridge.isEmpty()) {
				break;
			}

		}

		return time;

	}

	// test
	public static void main(String[] args) {
		int[] truckArray = { 5, 6, 7, 8 };
		System.out.print(solution(8, 12, truckArray));
	}

}
