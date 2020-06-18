package exhaustive.search;

import java.util.HashSet;

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

// �ַ��: ��͸� �̿���.

class Find_Prime_Number_Solution_02 {

	public int solution(String numbers) {
		
		// �ؽ����� ���� -> �ߺ��� ���� ������ �ʱ� ���ؼ�.
		HashSet<Integer> set = new HashSet<Integer>();
		
		permutation("", numbers, set);
		
		int count = 0;
		
		// �ؽ����տ��� ���ڵ��� �����ϸ鼭 �Ҽ��̸� count�� ���� ��Ų��.
		while (set.iterator().hasNext()) {
		
			int a = set.iterator().next();
			
			set.remove(a);
			
			if (a == 2) {
				count++;
			}
			
			// 2�� ����� �ƴϸ鼭 Ȧ���ε� �������� �� �ƴϾ�� �Ҽ��� �ȴ�.
			if (a % 2 != 0 && isPrime(a)) {
				count++;
			}
		}
		return count;
	}

	
	// �Ҽ����� �ƴ��� �Ǻ� 
	public boolean isPrime(int n) {
	
		if (n == 0 || n == 1) {
			return false;
		}
		
		// ���� �����ٱ��� Ȧ���� ã�Ƽ� �ش� ���� ������ ���� �ݺ��Ѵ�.
		for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
			
			if (n % i == 0) {
				return false;
			}
			
		}
		
		return true;
	}

	// prefix: ���λ� -> "" ���� ���� ���� �� ������ ����
	// str: �־��� ���ڸ� string���� �޴´�. 
	// permutation: ���� 
	public void permutation(String prefix, String str, HashSet<Integer> set) {
		
		int n = str.length();
		// if (n == 0) System.out.println(prefix);
		
		// ������ �ƴϸ� �ؽ����տ� ����
		if (!prefix.equals("")) {
			
			// ������ ���θ� ������ �޾Ƽ� ����
			set.add(Integer.valueOf(prefix));
		
		}

		// ����Լ� ȣ��
		for (int i = 0; i < n; i++) {
			// ���ڿ����� �� ���� ����� ���ؼ� ��͸� �θ���.
			permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
		}
	}

}


public class Find_Prime_Number_Sol_02 {

	public static void main(String[] args) {

		Find_Prime_Number_Solution_02 sol = new Find_Prime_Number_Solution_02();

		String numbers = "17";
		
		System.out.println(sol.solution(numbers));
	}

}