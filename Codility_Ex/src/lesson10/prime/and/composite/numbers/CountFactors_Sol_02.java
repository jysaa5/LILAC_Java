package lesson10.prime.and.composite.numbers;
// ����: CountFactors
/*
A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
Write a function:
class Solution { public int solution(int N); }
that, given a positive integer N, returns the number of its factors.
For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. 
There are no other factors of 24.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..2,147,483,647].
*/
/*
1. �������
���� ���� D�� N = D * M�� ���� ���� M���ִ� ��� ���� ���� N�� �μ��̴�.
���� ���, M = 4�� ���� ���� (24 = 6 * 4)�� �����ϹǷ� 6�� 24�� �μ��̴�.
�Լ� �ۼ� :
class Solution {public int solution (int N); }
���� ���� N�� �־����� �μ��� ���� ��ȯ�Ѵ�.
���� ��� N = 24�̸� �Լ��� 8�� ��ȯ�ؾ��Ѵ�. 24���� 8 ���� ����, �� 1, 2, 3, 4, 6, 8, 12, 24�� �ֱ� �����̴�.
24�� �ٸ� �μ��� ����.
���� ������ ���� ȿ������ �˰����� �ۼ��϶�.
N�� [1..2,147,483,647] ���� ���� �����̴�.

2. �ַ��
- for�� ���
- Math.sqrt ���
- Math.pow ���

3. �ð����⵵
: O(sqrt(N))

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/
class CountFactors_Solution_02 {
    public int solution(int N) {
    	
    	if(N==0 || N<0) {
    		return 0;
    	}
    	
    	int result = 0;
    	int squareRootN = (int)Math.sqrt(N);
    	
    	if(Math.pow(squareRootN, 2) != N) {
    		squareRootN++;
    	}else {
    		result++;
    	}
    	
    	for(int i=1; i<squareRootN; i++) {
    		if(N%i==0) {
    			result += 2;
    		}
    	}
        return result;
    }
}
public class CountFactors_Sol_02 {
	
	public static void main(String[] args) {
		int N = 24;
		CountFactors_Solution_01 sol = new CountFactors_Solution_01();
		System.out.println(sol.solution(N));
	}

}
