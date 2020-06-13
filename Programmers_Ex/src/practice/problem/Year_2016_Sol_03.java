package practice.problem;

import java.util.Calendar;
import java.util.Locale;

//����: 2016��
/*
���� ����

2016�� 1�� 1���� �ݿ����Դϴ�. 
2016�� a�� b���� ���� �����ϱ��? 
�� �� a ,b�� �Է¹޾� 2016�� a�� b���� ���� �������� �����ϴ� �Լ�, solution�� �ϼ��ϼ���. 
������ �̸��� �Ͽ��Ϻ��� ����ϱ��� ���� SUN,MON,TUE,WED,THU,FRI,SAT �Դϴ�.
���� ��� a=5, b=24��� 5�� 24���� ȭ�����̹Ƿ� ���ڿ� TUE�� ��ȯ�ϼ���.

���� ����

2016���� �����Դϴ�. -> 2/29 ����.
2016�� a�� b���� ������ �ִ� ���Դϴ�. (13�� 26���̳� 2�� 45�ϰ��� ��¥�� �־����� �ʽ��ϴ�)

����� ��
a |	b  | result
5 |	24 | TUE

*/
//�ַ��: ���̺귯�� Ȱ��

/*
1��: 31��, 2��: 29��, 3��: 31��, 4��: 30��, 5��: 31��, 6��: 30��, 7��: 31��, 8��: 31��
9��: 30��, 10��: 31��, 11��: 30��, 12��: 31�� 
*/

class Year_Solution_03{
	public String solution(int a, int b) {
	
		String answer = "";
		
		Calendar cal = new Calendar.Builder().setCalendarType("iso8601").setDate(2016, a-1, b).build();
		
		answer = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
		
		
		return answer;
	}
}

public class Year_2016_Sol_03 {
	
	public static void main(String[] args) {
		Year_2016_Solution_02 sol = new Year_2016_Solution_02();

		//int a = 5;
		//int b = 24;

		int a = 1;
		int b = 1;
		
		System.out.println(sol.solution(a, b));
	}

}
