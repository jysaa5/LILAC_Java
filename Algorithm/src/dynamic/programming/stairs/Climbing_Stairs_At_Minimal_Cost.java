package dynamic.programming.stairs;

// Dynamic Programming
// ����: �ּҺ������ ��� ������ (Min Cost Climbing Stairs)
// ��ܿ��� i��° ����� �ö󰡷���, ������� ������ cost i�� �Ҵ�Ǿ� �ִ�. �迭 �ȿ� ���� �ִ�. 
// �ε���(i)�� ����̶�� �����ϰ� ��ܸ��� �ö� ��, �����ؾ� �ϴ� ������ �Ű��� �ִ�. 
// ����� ���� �����ϸ� ����� 1ĭ�̳� 2ĭ�� �� �� �ִ�. ��� ������ ���µ� ���� �ΰ� ���� ����� ã�ƾ� �Ѵ�. 
// �׸��� ����� ó�� ������ ��, ����� 0���̳� 1�� �� �����ؼ� ������ �� �ִ� �ɼ��� �ִ�. 

// example 1: 
/* Input: cost = [10, 15, 20] -> 10, 15, 20�� 3���� ����� �ִ�.
 * Output: 15 -> ��� 0�� �Ǵ� ��� 1���߿��� ������ �� �����Ƿ�, 15�޷� �����ϰ� 2ĭ �ö󰡸� ������ �ö� �� �ִ�.
 */

// example 2:
/* Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 */

// Climbing_Stairs_At_Minimal_Cost Ŭ����
public class Climbing_Stairs_At_Minimal_Cost {

	
	// minCostClimbingStairs �޼���
	public static int minCostClimbingStairs(int[] cost) {
		int case1 = 0, case2 = 0, current;
		
		for(int i = cost.length-1; i>=0; --i) {
			current = cost[i]+Math.min(case1, case2);
			case2 = case1;
			case1 = current;
		}
		
		return Math.min(case1, case2);
	}// minCostClimbingStairs �޼��� ����
	
	
	//main �޼���
	public static void main(String[] args) {
		//int[] cost = new int[]{1,2,3,4,5,6,7};
		//int[] cost = new int[]{10, 15, 20};
		int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		int result = minCostClimbingStairs(cost);
		System.out.println(result);
	}// main �޼��� ����
}// Climbing_Stairs_At_Minimal_Cost Ŭ���� ����
