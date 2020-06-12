package practice.problem;

// ����: 2016��
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
// �ַ��: �� ������ �ϼ��� �ľ��ؼ� for���� if���� ����ؼ� ���� ���� �ϼ� ���ϱ�. switch������ ��ü �ϼ��� 7�� ���� ���� ���� ���� ��ȯ�ϱ�.

/*
1��: 31��, 2��: 29��, 3��: 31��, 4��: 30��, 5��: 31��, 6��: 30��, 7��: 31��, 8��: 31��
9��: 30��, 10��: 31��, 11��: 30��, 12��: 31�� 
*/

class Year_2016_Solution_01 {

	public String solution(int a, int b) {

		// ��ȯ��
		String answer = "";
		
		// ��ü �� �� 
		int totalDay = 0;
		
		// �� ���� �� �� 
		int dayOfMonth = 0;
		
		// 2016�� 1�� ~ 12��
		for (int i = 1; i < a; i++) { 
			
			
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
			
				dayOfMonth = 31;
		
			else if (i == 2)
		
				dayOfMonth = 29;
		
			else
			
				dayOfMonth = 30;

			totalDay += dayOfMonth;
			
		}
		
		// �ش��ϴ� ���� ���� ������ ���� ��ü �� �� + �ش��ϴ� �� ��  
		totalDay += b;

		
		// 7�� ������: 2016�� 1�� 1�� = �ݿ���. 
		// ��: 1 / ��: 2 / ��: 3/ ��:4/ ȭ:5/ ��:6/ ��:7/ 
		// 7�� ������, 1 / 2 / 3 / 4 / 5 / 6 / 0
		switch (totalDay % 7) {
		
		case 0:
			answer = "THU";
			break;
		case 1:
			answer = "FRI";
			break;
		case 2:
			answer = "SAT";
			break;
		case 3:
			answer = "SUN";
			break;
		case 4:
			answer = "MON";
			break;
		case 5:
			answer = "TUE";
			break;
		case 6:
			answer = "WED";
			break;

		}

		return answer;

	}
}

public class Year_2016_Sol_01 {

	public static void main(String[] args) {
		Year_2016_Solution_01 sol = new Year_2016_Solution_01();

		int a = 5;
		int b = 24;

		System.out.println(sol.solution(a, b));
	}

}
