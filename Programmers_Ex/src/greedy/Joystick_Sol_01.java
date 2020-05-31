package greedy;

// ����: ���̽�ƽ
// �ַ��: �׸���(Greedy) -> Ž��� ���

class Solution {
	public int solution(String name) {
	      
        // 1. ��, �Ʒ� �ּ� �̵�
        int answer = 0;
        for(int i = 0 ; i < name.length() ; i++) {
            if(name.charAt(i)!= 'A') {
                int up = name.charAt(i) - 'A';
                int down = 1 + 'Z' - name.charAt(i);
                answer += (up < down)? up : down;
                System.out.println("ans: "+ answer);
            }
        }
        
        // 2. A �ƴ� ��� ���ڸ� �鸱 �� �ִ� �ּ� �¿� �̵� 
        // ��� ��ġ���� ������ ���ư��� ��� �ּҸ� ã�´�. 
        int minMove = name.length() - 1;
        for(int i = 0 ; i < name.length() ; i++) {
            if(name.charAt(i) != 'A') {
                int next = i+1;
                System.out.println("1: "+next);
                while(next < name.length() && name.charAt(next) == 'A') {
                    next++;
                }
                System.out.println("2: "+next);
                
                // ���� ��ġ���� ������ ���� ��ġ�� ���� �� ���
                int move = 2 * i + name.length() - next;
                
                System.out.println("move: "+move);
                minMove = Math.min(move, minMove);
                System.out.println("minMove: "+minMove);
            }
        }
        
        return answer + minMove;
    }
}

public class Joystick_Sol_01 {

	public static void main(String[] args) {
		// String name = "JAZ";
		 //String name = "JAN";
		//String name = "JEROEN";
		// String name = "AAA";
		// String name = "BBBAAAA";
		//String name = "CANAAAAANAN";
		String name = "BBBBAAAAABBB";
		Solution sol = new Solution();
		System.out.print(sol.solution(name));
	}
}
