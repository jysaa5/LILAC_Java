package violetCheese.programmers;

import java.util.LinkedList;
import java.util.Queue;

//�ڷᱸ�� ����
public class Ex_02_Truck_Bridge {

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
