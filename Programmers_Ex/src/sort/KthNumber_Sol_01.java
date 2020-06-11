package sort;

import java.util.Arrays;

// ����: K��°��
/*
���� ����
�迭 array�� i��° ���ں��� j��° ���ڱ��� �ڸ��� �������� ��, k��°�� �ִ� ���� ���Ϸ� �մϴ�.

���� ��� array�� [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3�̶��

array�� 2��°���� 5��°���� �ڸ��� [5, 2, 6, 3]�Դϴ�.
1���� ���� �迭�� �����ϸ� [2, 3, 5, 6]�Դϴ�.
2���� ���� �迭�� 3��° ���ڴ� 5�Դϴ�.
�迭 array, [i, j, k]�� ���ҷ� ���� 2���� �迭 commands�� �Ű������� �־��� ��, 
commands�� ��� ���ҿ� ���� �ռ� ������ ������ �������� �� ���� ����� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
array�� ���̴� 1 �̻� 100 �����Դϴ�.
array�� �� ���Ҵ� 1 �̻� 100 �����Դϴ�.
commands�� ���̴� 1 �̻� 50 �����Դϴ�.
commands�� �� ���Ҵ� ���̰� 3�Դϴ�.

����� ��
array                 | commands                          | return
[1, 5, 2, 6, 3, 7, 4] |	[[2, 5, 3], [4, 4, 1], [1, 7, 3]] |	[5, 6, 3]

����� �� ����
[1, 5, 2, 6, 3, 7, 4]�� 2��°���� 5��°���� �ڸ� �� �����մϴ�. [2, 3, 5, 6]�� �� ��° ���ڴ� 5�Դϴ�.
[1, 5, 2, 6, 3, 7, 4]�� 4��°���� 4��°���� �ڸ� �� �����մϴ�. [6]�� ù ��° ���ڴ� 6�Դϴ�.
[1, 5, 2, 6, 3, 7, 4]�� 1��°���� 7��°���� �ڸ��ϴ�. [1, 2, 3, 4, 5, 6, 7]�� �� ��° ���ڴ� 3�Դϴ�.

*/
// �ַ��: �迭, ���� for��, Arrays

class kthNumber_Solution_01 {
	
    public int[] solution(int[] array, int[][] commands) {
        
    	// ��ȯ��
    	int[] answer = new int[commands.length];
        
        // ù��° �ڸ� ��
        int i = 0;
        
        // �ι�° �ڸ� ��
        int j = 0;
        
        // ������ k��°
        int k = 0;
        
        // �߸� �迭
        int[] ans = {};
        
        for(int l=0; l<commands.length; l++) {
        	
        	i = commands[l][0];
        	j = commands[l][1];
        	k = commands[l][2];
        	
        	ans = new int[j-i+1];
        	
        	for(int n = i-1; n<j; n++) {
        		ans[n-i+1] = array[n];
        	}
        	
        	Arrays.sort(ans);
        	
        	answer[l] = ans[k-1];
        
        }
        return answer;
    }
}

public class KthNumber_Sol_01 {
	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		kthNumber_Solution_01 sol = new kthNumber_Solution_01();
		
		int[] answer = sol.solution(array, commands);
		
		for(int i : answer) {
			System.out.println(i);
		}
		
	}

}
