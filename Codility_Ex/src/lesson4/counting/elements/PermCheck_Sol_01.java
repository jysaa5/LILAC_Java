package lesson4.counting.elements;

import java.util.HashSet;
import java.util.Set;

// ����: PermCheck
/*
A non-empty array A consisting of N integers is given.
A permutation is a sequence containing each element from 1 to N once, and only once.
For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.
The goal is to check whether array A is a permutation.

Write a function:
class Solution { public int solution(int[] A); }
that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.
Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
*/
/*
1. ���� ���
- N���� ������ ������ ��� ���� ���� �迭 A�� �����ȴ�.
- ������ 1���� N������ �� ��Ҹ� �ѹ��� �����ϴ� �������̴�. 

2. �ַ��
- set ���

3. �ð����⵵
: O(N) or O(N * log(N))

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/

class  PermCheck_Solution_01 {
    public int solution(int[] A) {
    	
    	// Set ���
    	Set<Integer> numSet = new HashSet<Integer>();
    	for(int n: A) {
    		if(n>A.length) {
    			return 0;
    		}
    		if(numSet.contains(n)) {
    			return 0;
    		}else {
    			numSet.add(n);
    		}
    	
    	}
    	
    	return 1;
       
    }
}

public class PermCheck_Sol_01 {

}
