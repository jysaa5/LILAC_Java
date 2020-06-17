package exhaustive.search;

import java.util.Arrays;
// ����: �Ҽ� ã��
/*
���� ����
���ڸ� ���ڰ� ���� ���� ������ ������ֽ��ϴ�. 
����� ���� ������ �ٿ� �Ҽ��� �� �� ���� �� �ִ��� �˾Ƴ��� �մϴ�.

�� ���� ������ ���� ���ڰ� ���� ���ڿ� numbers�� �־����� ��,
���� �������� ���� �� �ִ� �Ҽ��� �� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.

���ѻ���
numbers�� ���� 1 �̻� 7 ������ ���ڿ��Դϴ�.
numbers�� 0~9���� ���ڸ����� �̷���� �ֽ��ϴ�.
013�� 0, 1, 3 ���ڰ� ���� ���� ������ ������ִٴ� �ǹ��Դϴ�.

����� ��
numbers | return
17      | 3
011	    | 2

����� �� ����
���� #1
[1, 7]���δ� �Ҽ� [7, 17, 71]�� ���� �� �ֽ��ϴ�.

���� #2
[0, 1, 1]���δ� �Ҽ� [11, 101]�� ���� �� �ֽ��ϴ�.

11�� 011�� ���� ���ڷ� ����մϴ�.
*/


/*
�ַ�� �� ���� ���
ù ��°: ���� �������� ���� �� �ִ� ��� ���ڸ� ����� �� ���ڵ� �� �Ҽ��� ������ ���� ���
�� ��°: ���� �������� ���� �� �ִ� �ִ� ������ �Ҽ��� ��� ���� �� ��� �Ҽ��� �˻��ϸ� �ش� �Ҽ��� ���� ������� �̷���� ��
�ִ� �� Ȯ���ϴ� ���

-> �� ��° ���
1) ���� ������� ���� �� �ִ� ���� ū ���� ���Ѵ�.
2) ���� ū ������ �Ҽ��� ���Ѵ�.
3) ������ �Ҽ��� �� ���� ������� ������� �� �ִ��� Ȯ���Ѵ�.

-> 0~9�� ������ ���� �ش�. 
�Ҽ����� ���� ���� ��ŭ ������ ������ �ٿ��ش�.
�Ҽ����� ���� ���� ����� �� �ִ� ������ ���ٸ� ���� ������� ���� �� ���� �Ҽ��̴�.


ex) �־��� ��: 1, 2, 3
       ����    : 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
��밡�� ����: 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 
*/

// 
class Find_Prime_Number_Solution_01 {
	
	
	public int solution(String numbers) {
	    int maxNum = makeMaxNum(numbers.toCharArray());
	    boolean[] primeNum = findPrimeNum(maxNum);

	    return findMakePossiblePrimeNum(primeNum, maxNum);
	}
	
	// �־��� �����߿��� ���� �� �ִ� �ִ� ��
	// �־��� ���� �����鿡�� ���� �� �ִ� ���� ū ���� int������ ��ȯ�Ѵ�.
	private int makeMaxNum(char[] inputNum) {
		
		// �������� ����
	    Arrays.sort(inputNum);
	    int len = inputNum.length;
		// ������������ �ٽ� ������
	    for (int i = 0; i < len/2; i++) {
	        char temp = inputNum[i];
	        inputNum[i] = inputNum[len - 1 - i];
	        inputNum[len - 1 - i] = temp;
	    }
	 // ���ڹ迭�� ���ڿ��� ����� ������ ��ȯ ��, ��ȯ
	    return Integer.parseInt(new String(inputNum));
	}
	
	
	// �ִ� �� �ȿ��� �Ҽ��� ã�� �޼��� 
	// �־��� ���� ū �������� �Ҽ��� �����佺�׳׽��� ü�� �̿��Ͽ� ���Ѵ�.
	private boolean[] findPrimeNum(int maxNum) {
	    boolean[] result = new boolean[maxNum + 1];
	    for (int i = 2; i < Math.sqrt(maxNum); i++) {
	        if (!result[i]) {
	            for (int j = i * 2; j <= maxNum; j += i) {
	                result[j] = true;
	            }
	        }
	    }
	    return result;
	}
	
	

	// �־��� ������������ ���� �� �ִ� �Ҽ����� ������ ���Ͽ� ��ȯ�ϴ� �Լ��̴�.
	private int findMakePossiblePrimeNum(boolean[] primeNum, int maxNum) {
	    int possiblePrimeNumCount = 0;

	    for (int primeNumIndex = 2; primeNumIndex <= maxNum; primeNumIndex++) {
	        if (!primeNum[primeNumIndex] && isPossible(maxNum, primeNumIndex)) {
	            possiblePrimeNumCount++;
	        }
	    }
	    return possiblePrimeNumCount;
	}

	
	// �ش� �Ҽ��� �־��� ���� �������� ������� �� �ִ��� ���θ� �Ǵ��ϴ� �Լ��̴�. 
	private boolean isPossible(int maxNum, int primeNum) {
	    int[] numCount = countAvailableNums(maxNum);

	    while(primeNum != 0) {
	        if (numCount[primeNum % 10] <= 0) return false;
	        numCount[primeNum % 10]--;
	        primeNum /= 10;
	    }

	    return true;
	}
	
	// �־��� ������������ ����� �� �ִ� 0~9�� ������ ���� �Լ��̴�.
	private int[] countAvailableNums(int maxNum) {
	    char[] str = String.valueOf(maxNum).toCharArray();
	    int[] numCount = new int[10];
	    for (int i = 0; i < str.length; i++) {
	        numCount[str[i] - '0']++;
	    }
	    return numCount;
	}
}

public class Find_Prime_Number_Sol_01 {
	
	public static void main(String[] args) {
		
		Find_Prime_Number_Solution_01 sol = new Find_Prime_Number_Solution_01();
		
		String numbers = "17";
		System.out.println(sol.solution(numbers));
	}

}
