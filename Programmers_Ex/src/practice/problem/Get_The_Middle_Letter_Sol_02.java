package practice.problem;
//����: ��� ���� ��������
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
//�ַ��: substring ���
// ���ڿ��� ¦���� �ι�° �ε����� ù ��° �ε����� +2�̴�.
// ���ڿ��� Ȧ���� �ι�° �ε����� ù��° �ε����� +1�̴�.

class Get_The_Middle_Letter_Solution_02 {
    public String solution(String s) {
        String answer = "";
        
        return s != null ? s.substring((s.length()-1)/2, (s.length()+2)/2): "";
        
    }
}

public class Get_The_Middle_Letter_Sol_02 {
	public static void main(String[] args) {
		//String s = "abcde";
		String s = "qwer";
		Get_The_Middle_Letter_Solution_01 sol = new Get_The_Middle_Letter_Solution_01();
		System.out.println(sol.solution(s));
		
	}
}
