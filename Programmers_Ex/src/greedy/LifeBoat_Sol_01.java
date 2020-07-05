package greedy;

import java.util.Arrays;

// ����: ����Ʈ
/*
���� ����
���ε��� ���� ������� ����Ʈ�� �̿��Ͽ� �����Ϸ��� �մϴ�. 
����Ʈ�� �۾Ƽ� �� ���� �ִ� 2�� �ۿ� Ż �� ����, ���� ���ѵ� �ֽ��ϴ�.

���� ���, ������� �����԰� [70kg, 50kg, 80kg, 50kg]�̰�
����Ʈ�� ���� ������ 100kg�̶�� 2��° ����� 4��° ����� ���� Ż �� ������
1��° ����� 3��° ����� ������ ���� 150kg�̹Ƿ� ����Ʈ�� ���� ������ �ʰ��Ͽ�
���� Ż �� �����ϴ�.

����Ʈ�� �ִ��� ���� ����Ͽ� ��� ����� �����Ϸ��� �մϴ�.

������� �����Ը� ���� �迭 people�� ����Ʈ�� ���� ���� limit�� �Ű������� �־��� ��, 
��� ����� �����ϱ� ���� �ʿ��� ����Ʈ ������ �ּڰ��� return �ϵ��� solution 
�Լ��� �ۼ����ּ���.

���ѻ���
���ε��� ���� ����� 1�� �̻� 50,000�� �����Դϴ�.
�� ����� �����Դ� 40kg �̻� 240kg �����Դϴ�.
����Ʈ�� ���� ������ 40kg �̻� 240kg �����Դϴ�.
����Ʈ�� ���� ������ �׻� ������� ������ �� �ִ񰪺���
ũ�� �־����Ƿ� ������� ������ �� ���� ���� �����ϴ�.

����� ��
people	         | limit | return
[70, 50, 80, 50] |  100  |  3
[70, 80, 50]	 |  100	 |  3

*/
// �ַ��: 

class LifeBoat_Solution_01 {
    public int solution(int[] people, int limit) {

        int answer = 0;
    
        Arrays.sort(people);

        
        int index = people.length - 1;
        
        for(int i=0; i<=index; i++, answer++) {
        	while(index > i && people[i]+people[index--] > limit) {
        		answer++;
        	}
        }
        
        
        return answer;
    }
}

public class LifeBoat_Sol_01 {
	
	public static void main(String[] args) {
		
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		
		LifeBoat_Solution_01 sol = new LifeBoat_Solution_01();
		
		System.out.println(sol.solution(people, limit));
		
	}

}
