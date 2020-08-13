package lesson3.time.complexity;
import java.util.Arrays;

// ����: PermMissingElem
/*
An array A consisting of N different integers is given. 
The array contains integers in the range [1..(N + 1)], 
which means that exactly one element is missing.
Your goal is to find that missing element.

Write a function:
class Solution { public int solution(int[] A); }
that, given an array A, returns the value of the missing element.

For example, given array A such that:
  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
*/
/*
1. ���� ���
- N���� �ٸ� ������ ������ �迭 A�� �����ȴ�.
- �迭���� [1..(N+1)] ������ ������ ���Եȴ�.
- �̴� ��Ȯ�� �ϳ��� ��Ұ� �����Ǿ����� �ǹ��Ѵ�.
- ��ǥ�� �� ������ ��Ҹ� ã�� ���̴�.

2. �ַ��
- Arrays.sort ���, for��

3. �ð����⵵
: O(N) or O(N * log(N))

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/
class PermMissingElem_Solution_01 {
	public int solution(int[] A) {

		int n = 1;
		Arrays.sort(A);

		for (int i = 0; i < A.length; i++) {

			if (A[i] == n) {
				n++;
			} else if (A[i] != n) {
				return n;
			}
		}

		return n;

	}
}

public class PermMissingElem_Sol_01 {
	public static void main(String[] args) {
		PermMissingElem_Solution_01 sol = new PermMissingElem_Solution_01();
		//int[] A = { 2, 3, 1, 5 };
		int[] A = {1};
		System.out.println(sol.solution(A));
	}

}
