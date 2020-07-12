package exhaustive.search;

// ����: ī��
/*
���� ����
Leo�� ī���� �緯 ���ٰ� �Ʒ� �׸��� ���� �߾ӿ��� ��������� ĥ���� �ְ� �׵θ� 1���� �������� ĥ���� �ִ� ���� ��� ī���� �ý��ϴ�.

Leo�� ������ ���ƿͼ� �Ʊ� �� ī���� ������� �������� ��ĥ�� ������ ������ ���������, ��ü ī���� ũ��� ������� ���߽��ϴ�.

Leo�� �� ī�꿡�� ���� ������ �� brown, ����� ������ �� yellow�� �Ű������� �־��� �� ī���� ����, 
���� ũ�⸦ ������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
���� ������ �� brown�� 8 �̻� 5,000 ������ �ڿ����Դϴ�.
����� ������ �� yellow�� 1 �̻� 2,000,000 ������ �ڿ����Դϴ�.
ī���� ���� ���̴� ���� ���̿� ���ų�, ���� ���̺��� ��ϴ�.

����� ��
brown | yellow | return
10	  |    2   | [4, 3]
8	  |    1   | [3, 3]
24	  |   24   | [8, 6]
*/
// �ַ��

class Carpet_Solution_01 {
    public int[] solution(int brown, int yellow) {
    	
        int[] answer = new int[2];
        // ��ü ũ��
        int carpet = brown+yellow;
        // ����
        int x = 0;
        // ����
        int y = 0;
        
        for(int i=carpet; i>=1; i--) {
        	
        	if(((carpet%i)==0) && (i>=(carpet/i)) && (carpet/i >= 3)) {
        		
        		x = i;
        		y = carpet/i;
        		
        		if((x-2>y-2) && (x-2>1) && (y-2>=1) && ((x-2)*(y-2)==yellow)) {
        		break;
        		}
        	}
        	
        }
        
        answer[0] = x;
        answer[1] = y;

        return answer;
    }
}
public class Carpet_Sol_01 {
	
	public static void main(String[] args) {
		
		Carpet_Solution_01 sol = new Carpet_Solution_01();
		int brown = 24;
		int yellow = 24;
		
		int[] answer = sol.solution(brown, yellow);
		
		for(int num :answer ) {
		System.out.println(num);
		}
		
	}

}
