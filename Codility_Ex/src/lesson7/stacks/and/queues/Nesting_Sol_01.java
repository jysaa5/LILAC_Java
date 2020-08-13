package lesson7.stacks.and.queues;

import java.util.Stack;
//����: Nesting 
/*
A string S consisting of N characters is called properly nested if:
S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:
class Solution { public int solution(String S); }
that, given a string S consisting of N characters, 
returns 1 if string S is properly nested and 0 otherwise.
For example, given S = "(()(())())", the function should return 1 and given S = "())",
the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..1,000,000];
string S consists only of the characters "(" and/or ")".
*/
/*
1. ���� ���
- ���ڿ� S�� N���� ���ڵ��� ������ �ְ� �Ʒ� ���ǵ��� �����ϸ� ������ nested�� �θ���.
- S�� ��� �ִ�.
- S�� "(U)" ���¸� ������ ���� ��, U�� ������ nested ���ڿ��̴�. 
- S�� "VM" ���¸� ������ ���� ��, V�� M�� ������ nested ���ڿ��̴�.
- ���� ���, ���ڿ��� "(()(())())"�� ������ nested������ "())"�� �׷��� �ʴ�.
- ���ڿ� S�� N�� ���ڵ��� ���ڤӰ� �ְ� ������ nested�̸� 1�� ��ȯ�ϰ� �ƴϸ� 0�� ��ȯ�Ѵ�.
- N ����: [0,...1,000,000]
- ���ڿ� S: "(" , ")" ���ڵ鸸 ������ �ִ�.

2. �ַ�� 
- stack ���
- for��
- if����

3. �ð����⵵
: O(N)

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/

class Nesting_Solution_01 {
	public int solution(String S) {
		Stack<Character> ch = new Stack<Character>();

		if (S.length() == 0) {
			return 1;
		}

		for (int i = 0; i < S.length(); i++) {
			if (ch.isEmpty()) {
				if (S.charAt(i) == '(' || S.charAt(i) == ')') {
					ch.push(S.charAt(i));
				}
			} else {
				char n = ch.peek();

				if (n == '(' && S.charAt(i) == ')') {
					ch.pop();
				} else {
					ch.push(S.charAt(i));
				}

			}
		}

		if (ch.isEmpty()) {
			return 1;
		}

		return 0;

	}

}

public class Nesting_Sol_01 {

	public static void main(String[] args) {
		
		//String S = "(()(())())";
		String S = "())";
		Nesting_Solution_01 sol = new Nesting_Solution_01();
		System.out.println(sol.solution(S));

	}

}
