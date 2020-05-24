package array.alg.two.sum.sol_1;

/*
��ó: LeetCode, Two Sum
����: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
= �������� ��� ��̰� �ϳ� �ִ�. �� �迭 �ȿ� �ִ� ���� �߿� ���� 2���� ���ؼ� Ư���� ���� ������ �� �� ������ ��� �ε����� ��ȯ�ض�. 
�迭 �ȿ��� ������ �� 2���� �ִ�. ���� ���� �� �� ���� ���� 2���� �ε����� ��ȯ�ض�.

ex) 2���� ���� ���ؼ� 5�� ������ �迭 �ε��� 2���� ��ȯ�ض�.
|6|4|3|8|7|5|2| 

-> �ַ�� 1: Brute Force (�����ϰ� Ǫ�� ���)
������ 2���� �����ؼ� �� ���鼭 2���� ���� 5���� Ȯ���ϴ� ���

-> �ð����⵵: O(n^2)
*/

// Solution Ŭ����
class Solution{
	
	// nums: ������ �迭
	// target: �迭 ���� ��
	// twoSum �޼���
	public int[] twoSum(int[] nums, int target) {
	
		for(int i = 0; i<nums.length; i++) {
			
			for(int j = i+1; j <nums.length; j++) {
				
				if(target == nums[i]+nums[j]) {
				
					return new int[] {i, j};
				
				}
			}
		}
		
		throw new IllegalArgumentException("No two sum solution");
	}// twoSum �޼��� ����

}//Solution Ŭ���� ����


// Two_Sum_Imp Ŭ����
public class Two_Sum_Imp {

	// main �޼��� ����
	public static void main(String[] args) {
		
		int[] nums = {6,4,3,8,7,5,2};
		
		Solution sol = new Solution();
		
		int[] result = sol.twoSum(nums, 5);
		
		System.out.println(result[0]+", "+result[1]);
		
	}// main �޼��� ����
	
}// Two_Sum_Imp Ŭ���� ����