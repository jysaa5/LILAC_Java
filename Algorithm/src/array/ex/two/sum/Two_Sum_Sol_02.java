package array.ex.two.sum;

import java.util.HashMap;

/*
��ó: LeetCode, Two Sum
����: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
= �������� ��� ��̰� �ϳ� �ִ�. �� �迭 �ȿ� �ִ� ���� �߿� ���� 2���� ���ؼ� Ư���� ���� ������ �� �� ������ ��� �ε����� ��ȯ�ض�. 
�迭 �ȿ��� ������ �� 2���� �ִ�. ���� ���� �� �� ���� ���� 2���� �ε����� ��ȯ�ض�.

ex) 2���� ���� ���ؼ� 5�� ������ �迭 �ε��� 2���� ��ȯ�ض�.
|6|4|3|8|7|5|2| 

-> �ַ�� 2: Hash Table
-> �迭�� �� �� ���鼭 hash table�� ���� key ���, value�� �ε����� ��´�. 
key|6|4|3|8|7|5|2| 
val|0|1|2|3|4|5|6| 
    p1
     5 - 6 = -1 
-> ������ 1���� �����ؼ� �迭���� ���鼭 ���� 1���� 5���� ��� (5 - �� = ������ �� ) �� ������ ���� �迭 �濡 �� ã�´�.
-> �ð����⵵: O(2n) -> O(n)

*/
public class Two_Sum_Sol_02 {

	// nums: ������ �迭
	// target: �迭 ���� ��
	// twoSum �޼���
	static int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		// �ؽ� ���̺� �迭�� ���� �ִ� �κ�
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		// �ؽ� ���̺��� �����͸� �ű�鼭 ���� 5�� ���� ã�� �κ�
		for (int i1 = 0; i1 < nums.length; i1++) {

			Integer i2 = map.get(target - nums[i1]);

			if (i2 != null && i1 != i2) {

				return new int[] { i1, i2 };

			}
		}

		throw new IllegalArgumentException("No two sum solution");

	}
	
	public static void main(String[] args) {

		int[] nums = { 6, 4, 3, 8, 7, 5, 2 };
		int[] result = twoSum(nums, 5);

		System.out.println(result[0] + ", " + result[1]);

	}
}