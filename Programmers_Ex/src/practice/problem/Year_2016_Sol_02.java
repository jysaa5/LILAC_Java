package practice.problem;

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
//�ַ��: �� ������ �ϼ��� �ľ��ؼ� �迭���� ����, ���� �迭���� ����

/*
1��: 31��, 2��: 29��, 3��: 31��, 4��: 30��, 5��: 31��, 6��: 30��, 7��: 31��, 8��: 31��
9��: 30��, 10��: 31��, 11��: 30��, 12��: 31�� 
*/

class Year_2016_Solution_02 {

	public String solution(int a, int b) {

		// ��ȯ��
		String answer = "";
		
		// �� ���� �ϼ�
		int[] dayOfMonth = {31,29,31,30,31,30,31,31,30,31,30,31};

		// ����
		String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
		
		// �ش� ���� �ϼ�
		int days = 0;
		
		// ��ü �ϼ�
		int totalDay = 0;
		
		
		// 1���� 0�ε������� �����ϹǷ� a-1����
		for(int i=0; i<a-1; i++) {
			
			totalDay += dayOfMonth[i];
		}
		
		// 7�� ������ ��, �������� 0, 1, 2, 3, 4, 5, 6 �̷��� �ǹǷ� 1�� 1���� �ݿ����� �Ƿ��� ���� 1�Ͽ��� 1�� ������Ѵ�. 
		days = b-1;
		
		// String[] dayOfWeek = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
		// ���� ���� �ϸ� b���� 1�� �� ���� �ȴ�.
		
		totalDay += days;
		
		answer = dayOfWeek[totalDay%7]; 	
		
		return answer;
	}
}

public class Year_2016_Sol_02 {
	
	public static void main(String[] args) {
		Year_2016_Solution_02 sol = new Year_2016_Solution_02();

		//int a = 5;
		//int b = 24;

		int a = 1;
		int b = 1;
		
		System.out.println(sol.solution(a, b));
	}

}
