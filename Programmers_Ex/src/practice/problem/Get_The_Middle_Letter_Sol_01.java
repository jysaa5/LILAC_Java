package practice.problem;
// ����: ��� ���� ��������
/*
���� ����
�ܾ� s�� ��� ���ڸ� ��ȯ�ϴ� �Լ�, solution�� ����� ������. 
�ܾ��� ���̰� ¦����� ��� �α��ڸ� ��ȯ�ϸ� �˴ϴ�.

���ѻ���
s�� ���̰� 1 �̻�, 100������ ��Ʈ���Դϴ�.

����� ��
s     | return
abcde | c
qwer  |	we
*/
// �ַ��: ���ڿ� �迭 ���

class Get_The_Middle_Letter_Solution_01 {
    public String solution(String s) {
        String answer = "";
        
        String[] str = new String[s.length()];
        str = s.split("");
        
        
        if(s.length()%2==0) {
        	answer += str[(s.length()/2)-1];
        	answer += str[s.length()/2];
        }else {
        	
        	answer += str[s.length()/2];
        }
        
        
        return answer;
    }
}

public class Get_The_Middle_Letter_Sol_01 {
	
	public static void main(String[] args) {
		//String s = "abcde";
		String s = "qwer";
		Get_The_Middle_Letter_Solution_01 sol = new Get_The_Middle_Letter_Solution_01();
		System.out.println(sol.solution(s));
		
	}

}
