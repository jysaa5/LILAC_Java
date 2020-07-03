package sort;

import java.util.Arrays;

// ����: H-Index
/*
���� ����
H-Index�� �������� ���꼺�� ������� ��Ÿ���� ��ǥ�Դϴ�.
��� �������� H-Index�� ��Ÿ���� ���� h�� ���Ϸ��� �մϴ�. 
��Ű���1�� ������, H-Index�� ������ ���� ���մϴ�.
� �����ڰ� ��ǥ�� �� n�� ��, h�� �̻� �ο�� ���� h�� �̻��̰�
������ ���� h�� ���� �ο�Ǿ��ٸ� h�� �ִ��� �� �������� H-Index�Դϴ�.

� �����ڰ� ��ǥ�� ���� �ο� Ƚ���� ���� �迭 citations�� �Ű������� �־��� ��, 
�� �������� H-Index�� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
�����ڰ� ��ǥ�� ���� ���� 1�� �̻� 1,000�� �����Դϴ�.
���� �ο� Ƚ���� 0ȸ �̻� 10,000ȸ �����Դϴ�.

����� ��
citations       | return
[3, 0, 6, 1, 5] |	3

����� �� ����
�� �����ڰ� ��ǥ�� ���� ���� 5���̰�, ���� 3���� ���� 3ȸ �̻� �ο�Ǿ����ϴ�.
 �׸��� ������ 2���� ���� 3ȸ ���� �ο�Ǿ��� ������ �� �������� H-Index�� 3�Դϴ�.
*/
// �ַ��:

class H_Index_Solution_01 {
	
    public int solution(int[] citations) {
        int answer = 0;
        
        int length = citations.length;
        int h = 0;
        int k = 0;
        
        Arrays.sort(citations);
        
        for(int i=0; i<length; i++) {
        	h = citations[i];
        	k = length - i;
        	
        	if(k <= h) {
        		answer = k;
        		break;
        	}
        }
        
        
        return answer;
    }
}

public class H_Index_Sol_01 {
	
	public static void main(String[] args) {
		
		int[] citations = {3, 0, 6, 1, 5};
		
		H_Index_Solution_01 sol = new H_Index_Solution_01();
		
		
		System.out.println(sol.solution(citations));
	}

}
