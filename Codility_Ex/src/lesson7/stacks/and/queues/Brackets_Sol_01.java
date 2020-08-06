package lesson7.stacks.and.queues;

import java.util.Stack;

// ����: Brackets
/*
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:
class Solution { public int solution(String S); }
that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
For example, given S = "{[()()]}",
the function should return 1 and given S = "([)()]",
the function should return 0, as explained above.
Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
*/
/*
1. ���� ���
- ���ڿ� s: N���� ���ڵ�� �̷���� �ִ�. �Ʒ��� ���� �����߿� � ���̵��� ���̶�� ������ ��Ʈ��� ��������.
-> S�� ��� �ִ�.
-> S�� (U) �Ǵ� [U] �Ǵ� {U} ������ ������ �ִٸ�, U�� ������ ���ڿ� ��Ʈ�̴�. 
-> S��  vM ������ ������ �ִٸ� V�� M�� ������ ��Ʈ ���ڿ��̴�. 
- ���� ��� {[()()]}�� ������ ��Ʈ������ ([)()]�� �׷��� �ʴ�.
- N���� ���ڵ�� �̷���� �ִ� ���ڿ� S�� ���� S�� ������ ��Ʈ�̸� 1�� ��ȯ�ϰ� �׷��� ������ 0�� ��ȯ�Ѵ�.


2. �ַ��
- for��, Stack, if��, while��

3. �ð� ���⵵
: O(N)

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%

*/

class Brackets_Solution_01 {
    public int solution(String S) {
    	
    	char ch = '0';
    	Stack<Character> charStack = new Stack<Character>();
    	
    	for(int i=0; i<S.length(); i++) {
    		
    		ch = S.charAt(i);
    		
    		if(charStack.isEmpty()) {
    			charStack.push(ch);
    		}else {
    			
    			if(charStack.peek()=='(' && ch == ')') {
    				charStack.pop();
    			}else if(charStack.peek()=='{' && ch =='}') {
    				charStack.pop();
    			}else if(charStack.peek()=='['&& ch==']') {
    				charStack.pop();
    			}else {
    				charStack.push(ch);
    			}
    			
    			
    		}
   
    		
    	}
    	
		while(!charStack.isEmpty()) {
			ch = charStack.peek();
			
			if((ch>='A' && ch<='Z')||(ch>='a'&&ch<='z')) {
				charStack.pop();
			}else {
				return 0;
			}
		}
    	

    		return 1;
        
    }
}


public class Brackets_Sol_01 {
	
	public static void main(String[] args) {
		
		Brackets_Solution_01 sol = new Brackets_Solution_01();
		//String S = "{[()()]}";
		//String S = "([)()]";
		String S = "VM";
		System.out.println(sol.solution(S));
		
	}

}
