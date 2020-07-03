package sort;

import java.util.Arrays;


// ����: ���� ū ��
/*
���� ����
0 �Ǵ� ���� ������ �־����� ��, ������ �̾� �ٿ� ���� �� �ִ� ���� ū ���� �˾Ƴ� �ּ���.

���� ���, �־��� ������ [6, 10, 2]��� [6102, 6210, 1062, 1026, 2610, 2106]��
 ���� �� �ְ�, ���� ���� ū ���� 6210�Դϴ�.

0 �Ǵ� ���� ������ ��� �迭 numbers�� �Ű������� �־��� ��, ������ ���ġ�Ͽ� ���� �� �ִ� ����
 ū ���� ���ڿ��� �ٲپ� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
numbers�� ���̴� 1 �̻� 100,000 �����Դϴ�.
numbers�� ���Ҵ� 0 �̻� 1,000 �����Դϴ�.
������ �ʹ� Ŭ �� ������ ���ڿ��� �ٲپ� return �մϴ�.

����� ��
numbers	          | return
[6, 10, 2]	      | 6210
[3, 30, 34, 5, 9] |	9534330

*/
// �ַ��


class Largest_Number_Solution_01 {

	public String solution(int[] numbers) {
    	
    	String[] arr = new String[numbers.length];
    	
    	for(int i=0; i<numbers.length; i++) {
    		arr[i] = String.valueOf(numbers[i]);
    	}
    		Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
    		
    		if(arr[0].equals("0")) {
    			return "0";
    		}
    		
    		StringBuilder sb = new StringBuilder();
    		
    		for(int i=0; i<arr.length; i++) {
    			sb.append(arr[i]);
    		}
    		
        return sb.toString();
    }
}

public class Largest_Number_Sol_01 {
	
	public static void main(String[] args) {
		
		Largest_Number_Solution_01 sol = new Largest_Number_Solution_01();
		
		//int[] numbers = {6, 10, 2};
		
		int[] numbers = {3, 30, 34, 5, 9};
		
		System.out.println(sol.solution(numbers));
		
	}

}
