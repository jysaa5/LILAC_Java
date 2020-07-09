package dfs.bfs;

import java.util.Arrays;

// ����: Ÿ�� �ѹ�
/*
���� ����
n���� ���� �ƴ� ������ �ֽ��ϴ�. �� ���� ������ ���ϰų� ���� Ÿ�� �ѹ��� ������� �մϴ�. 
���� ��� [1, 1, 1, 1, 1]�� ���� 3�� ������� ���� �ټ� ����� �� �� �ֽ��ϴ�.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
����� �� �ִ� ���ڰ� ��� �迭 numbers,
Ÿ�� �ѹ� target�� �Ű������� �־��� �� ���ڸ� ������ ���ϰ� ���� Ÿ�� �ѹ��� ����� ����� ����
return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
�־����� ������ ������ 2�� �̻� 20�� �����Դϴ�.
�� ���ڴ� 1 �̻� 50 ������ �ڿ����Դϴ�.
Ÿ�� �ѹ��� 1 �̻� 1000 ������ �ڿ����Դϴ�.

����� ��
numbers	        |target |return
[1, 1, 1, 1, 1]	|3      |5

����� �� ����
������ ���� ���� �����ϴ�.
*/
// �ַ��: DFS(���� �켱 Ž��)

class Target_Number_Solution_01 {
  
	public int solution(int[] numbers, int target) {
		
		int answer = 0;
		answer = dfs(numbers, 0, 0, target);
        
        return answer;
    }
	
	
	private int dfs(int[] numbers, int node, int sum, int target) {
		
		if(node==numbers.length) {

			if(sum == target) {
				return 1;
			}
			return 0;
		}
		
		return dfs(numbers, node+1, sum+numbers[node], target) + dfs(numbers, node+1, sum - numbers[node], target);
	}

}

public class Target_Number_Sol_01 {
	
	public static void main(String[] args) {
		
		int[] numbers = {1, 1, 1, 1, 1};
		
		int target = 3;
		
		Target_Number_Solution_01 sol = new Target_Number_Solution_01();
		
		System.out.println(sol.solution(numbers, target));
		
	}

}
