package greedy;
//����: ū �� �����

/*
���� ����
� ���ڿ��� k���� ���� �������� �� ���� �� �ִ� ���� ū ���ڸ� ���Ϸ� �մϴ�.
���� ���, ���� 1924���� �� �� ���� �����ϸ� [19, 12, 14, 92, 94, 24] �� ���� �� �ֽ��ϴ�. �� �� ���� ū ���ڴ� 94 �Դϴ�.
���ڿ� �������� ���� number�� ������ ���� ���� k�� solution �Լ��� �Ű������� �־����ϴ�. 
number���� k ���� ���� �������� �� ���� �� �ִ� �� �� ���� ū ���ڸ� ���ڿ� ���·� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

���� ����
number�� 1�ڸ� �̻�, 1,000,000�ڸ� ������ �����Դϴ�.
k�� 1 �̻� number�� �ڸ��� �̸��� �ڿ����Դϴ�.

����� ��
number     | k | return
1924       | 2 | 94
1231234    | 3 | 3234
4177252841 | 4 |775841

*/
/*
�ַ��: 
- k���� ��������, n = length - k ��� �ϰ� n���� �����ϴ� ������ �ٲ۴�.
- ������ �� �ִ� ������ ������ ���� ������ ���� �����ؾ� �� ������ ���ų� ���� ���ڰ� ���� �־�� �Ѵ�.
- �ð� ������ ���� stringBuilder�� ����Ѵ�.


*/

class Make_Max_Number_Solution_02 {

	public String solution(String number, int k) {

		int idx = 0;
		char max;

		StringBuilder answer = new StringBuilder();

		if (number.charAt(0) == '0') {
			return "0";
		}

		for (int i = 0; i < number.length() - k; i++) {

			max = '0';

			for (int j = idx; j <= k + i; j++) {

				if (max < number.charAt(j)) {

					max = number.charAt(j);

					idx = j + 1;
				}
			}
			answer.append(max);
		}
		return answer.toString();
	}
}

public class Make_Bigger_Number_Sol_02 {
	public static void main(String[] args) {

		String number = "1924";

		int k = 2;

		Make_Max_Number_Solution_01 sol = new Make_Max_Number_Solution_01();

		System.out.println(sol.solution(number, k));

	}
}
