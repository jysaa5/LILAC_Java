package greedy;

import java.util.Stack;

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

class Make_Max_Number_Solution_03 {
	
	public String solution(String number, int k) {
	
		char[] result = new char[number.length() - k];
		
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < number.length(); i++) {
		
			char c = number.charAt(i);
			while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
				stack.pop();
			}
			stack.push(c);
		}
		for (int i = 0; i < result.length; i++) {
			result[i] = stack.get(i);
		}
		return new String(result);
	}
}

public class Make_Bigger_Number_Sol_03 {
	public static void main(String[] args) {

		String number = "1924";

		int k = 2;

		Make_Max_Number_Solution_01 sol = new Make_Max_Number_Solution_01();

		System.out.println(sol.solution(number, k));

	}
}
