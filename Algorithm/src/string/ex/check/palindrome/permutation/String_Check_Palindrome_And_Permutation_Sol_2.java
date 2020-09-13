package string.ex.check.palindrome.permutation;

// ����: �־��� ���ڿ��� ȸ��(palindrome)�� ����� �ִ� ���ڿ��� ġȯ(permutation)������ Ȯ���ϴ� �Լ��� ����ÿ�.

// ȸ��(palindrome): ������ ������ �ڷ� ������ �Ȱ��� �ܾ ���ڿ��� ���Ѵ�. 
// ȸ������ ã�� ���: ���ڿ� �� ó���̶� �� ���� �����͸� �ΰ� �� ĭ�� �ڿ� ������ �����̸鼭 ���� �������� Ȯ���Ѵ�.
// ȸ�� Ư¡: ���ڿ��� ��� �� ������ �ſ�ó�� ��Į�ڸ��ϰ� �ȴ�. ��� ���ڸ� Ȧ���� �� �� �ִ�. �׷��� �ϳ��� ������ �ٸ� ���ڵ��� ȸ���� �� �� �ִ�.
// ex) mom, racecar

// ġȯ(permutation): ���ڿ� �ȿ� ������ ������ ������ ���� ��
// ex) mmo, omm
// Solution 2: 
/*  a b c  ...  y  z
 * |0|1|2| ... |24|25 -> �迭�� �ε���
 * 
 * -> �� ������ ������ ��� ���ں��� �迭�� ������ �Ŀ� �� �迭�� ���鼭 Ȧ�� ���� ���ڰ� 1�� �ʰ��̸� ȸ�� ��Ģ�� ��߳��Ƿ�, ȸ�� ��Ģ�� �´�
 *    ���� ã�´�. 
 * -> �ڵ� ���̸� ���̱⸸ ���� : ������ ���鼭 Ȧ���� ���ڰ� �� ������ ����.
 * 
 * */

// �ð����⵵ = O(n)

// String_Check_Palindrome_And_Permutation_Sol_2 Ŭ���� 
public class String_Check_Palindrome_And_Permutation_Sol_2 {
	
	// isPermutationOfPalindrome �޼���: ȸ������ �ƴ��� ã�� �޼���
	private static boolean isPermutationOfPalindrome(String s) {
		
		// Ȧ�� ���� ����
		int countOdd = 0;
		
		// �迭���� 26�� ����
		int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		
		// ���ڿ��� �� ���� �����´�.
		for(char c : s.toCharArray()) {
			
			// �迭�� ��ȣ ��������
			int x = getCharNumber(c);
			
			if(x != -1) {
				
				table[x]++;
				
				if(table[x]%2 == 1) {
					
					countOdd++;
				
				}else {
					countOdd--;
				}
				
			}
			
		}
		
		return countOdd <= 1;
		
	}// isPermutationOfPalindrome �޼��� ����
	
	
	// getCharNumber �޼���: ���ڸ� ������ �迭�� �ε����� �������� �޼��� 
	private static int getCharNumber(Character c) {
		
		// �ҹ��� a, z�� ASCII �ڵ� ���� �����´�.
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		
		if(a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}// getCharNumber �޼��� ����
	
	
	// main �޼��� 
	public static void main(String[] args) {
		
		System.out.println(isPermutationOfPalindrome("aa bb cc dd"));
		System.out.println(isPermutationOfPalindrome("aa bb cc dd e"));
		
		// ȸ���� �� ����
		System.out.println(isPermutationOfPalindrome("aa bb cc dd e fff"));
	}// main �޼��� ����

}// String_Check_Palindrome_And_Permutation_Sol_2 Ŭ���� ����
