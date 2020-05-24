package array.alg.two.sum.sol_3;

import java.util.HashMap;

/*
��ó: LeetCode, Two Sum
����: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
= �������� ��� ��̰� �ϳ� �ִ�. �� �迭 �ȿ� �ִ� ���� �߿� ���� 2���� ���ؼ� Ư���� ���� ������ �� �� ������ ��� �ε����� ��ȯ�ض�. 
�迭 �ȿ��� ������ �� 2���� �ִ�. ���� ���� �� �� ���� ���� 2���� �ε����� ��ȯ�ض�.

ex) 2���� ���� ���ؼ� 5�� ������ �迭 �ε��� 2���� ��ȯ�ض�.
|6|4|3|8|7|5|2| 

-> �ַ�� 3: Hash Table
-> �迭�� �� �� ���鼭 hash table�� ���� key ���, value�� �ε����� ��´�. 
key|6|4|3|8|7|5|2| 
val|0|1|2|3|4|5|6| 

-> ������ 1���� �����ؼ� �迭���� ���鼭 ���� 1���� 5���� ��� (5 - �� = ������ �� ) �� ������ ���� �迭 �濡 �� ã�´�.
-> �����鼭 �����͵� ������
-> �ð����⵵: O(2n) -> O(n)

*/

//Solution Ŭ����
class Solution{
	
	// nums: ������ �迭
	// target: �迭 ���� ��
	// twoSum �޼��� 
	public int[] twoSum(int[] nums, int target) {
	
		HashMap<Integer, Integer>map = new HashMap<Integer,Integer>();
		
		// �˻��ϸ鼭 �ؽ����̺� ���� �����Ѵ�.
		for(int i= 0; i<nums.length; i++) {
			
			if(map.containsKey(target-nums[i])) {

				return new int[] {map.get(target-nums[i]), i};
			
			}
			
			// �ؽøʿ� ���� ����
			map.put(nums[i], i);
		}
		
		throw new IllegalArgumentException("No two sum solution");
	}// twoSum �޼��� ����
	
}// Solution Ŭ���� ����


// Two_Sum_Imp Ŭ����
public class Two_Sum_Imp {

	// main �޼��� 
	public static void main(String[] args) {
		
		int[] nums = {6,4,3,8,7,5,2};
		
		Solution sol = new Solution();
		
		int[] result = sol.twoSum(nums, 5);
		
		System.out.println(result[0]+", "+result[1]);
		
	}// main �޼��� ����
	
}// Two_Sum_Imp Ŭ���� ����