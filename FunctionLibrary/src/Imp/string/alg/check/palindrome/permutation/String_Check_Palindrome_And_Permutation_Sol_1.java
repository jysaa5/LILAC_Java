package Imp.string.alg.check.palindrome.permutation;

// ����: �־��� ���ڿ��� ȸ��(palindrome)�� ����� �ִ� ���ڿ��� ġȯ(permutation)������ Ȯ���ϴ� �Լ��� ����ÿ�.

// ȸ��(palindrome): ������ ������ �ڷ� ������ �Ȱ��� �ܾ ���ڿ��� ���Ѵ�. 
// ȸ������ ã�� ���: ���ڿ� �� ó���̶� �� ���� �����͸� �ΰ� �� ĭ�� �ڿ� ������ �����̸鼭 ���� �������� Ȯ���Ѵ�.
// ȸ�� Ư¡: ���ڿ��� ��� �� ������ �ſ�ó�� ��Į�ڸ��ϰ� �ȴ�. ��� ���ڸ� Ȧ���� �� �� �ִ�. �׷��� �ϳ��� ������ �ٸ� ���ڵ��� ȸ���� �� �� �ִ�.
// ex) mom, racecar

// ġȯ(permutation): ���ڿ� �ȿ� ������ ������ ������ ���� ��
// ex) mmo, omm
// Solution 1: 
/*  a b c  ...  y  z
 * |0|1|2| ... |24|25 -> �迭�� �ε���
 * 
 * -> �� ������ ������ ��� ���ں��� �迭�� ������ �Ŀ� �� �迭�� ���鼭 Ȧ�� ���� ���ڰ� 1�� �ʰ��̸� ȸ�� ��Ģ�� ��߳��Ƿ�, ȸ�� ��Ģ�� �´�
 *    ���� ã�´�. 
 * 
 * */

// �ð����⵵ = O(n)

// String_Check_Palindrome_And_Permutation_Sol_1 Ŭ����
public class String_Check_Palindrome_And_Permutation_Sol_1 {
	
	// isPermutationOfPalindrome �޼���: ȸ������ �ƴ��� ã�� �޼���
	private static boolean isPermutationOfPalindrome(String s) {
		
		// ���ڿ��� ��� �迭�� ��´�.
		int[] table = buildCharFrequencyTable(s);
		
		// ���ڿ��� ���� ������ Ȧ�� ���� ¦�� ���� �Ǵ��Ͽ� true�� false ��ȯ
		return checkMaxOneOdd(table);
		
	}// isPermutationOfPalindrome �޼��� ����
	
	
	// buildCharFrequencyTable: ���ڵ��� ������ ��� �迭�� �����ϴ� �޼���
	private static int[] buildCharFrequencyTable(String s) {
		
		// 26���� �迭���� �����.
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a')+1];
		
		// ���ڿ��� char�迭�� ��ȯ ��. 
		for(char c : s.toCharArray()) {
			// ���ĺ� �ҹ����� ASCII �ڵ� ���� 0~25�ε����� ��ȯ
			int x = getCharNumber(c);
			
			// ���ڰ� �����̳� Ư�����ڸ� ������ ��.
			if(x != -1) {
				// �迭 ���� 1����
				table[x]++;
			}
			
		}
		// ���� �迭�� ��ȯ
		return table;
	}// buildCharFrequencyTable �޼��� ����
	
	
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
	
	
	// checkMaxOneOdd �޼���: �� ������ ������ ����� �迭�� ���鼭 Ȧ���� �迭���� ã�� �޼���
	private static boolean checkMaxOneOdd(int[] table) {
	
		// Ȧ�� ������ ã�� flag
		boolean foundOdd = false;
		
		for(int count : table) {
			
			// �迭���� Ȧ�� �϶�
			if(count % 2 == 1) {

			// �迭���� Ȧ���� 1���� ��
			if(!foundOdd) {
				
				foundOdd = true;
			
			// �迭���� Ȧ���� 1�� �ʰ� �� ��
			}else {
			
				return false;
			}
			
			}
		}
		return true;
		
	}// checkMaxOneOdd �޼��� ����
	
	
	// main �޼��� 
	public static void main(String[] args) {
		
		System.out.println(isPermutationOfPalindrome("aa bb cc dd"));
		System.out.println(isPermutationOfPalindrome("aa bb cc dd e"));
		
		// ȸ���� �� ����
		System.out.println(isPermutationOfPalindrome("aa bb cc dd e fff"));
	}// main �޼��� ����

}// String_Check_Palindrome_And_Permutation_Sol_1 �޼��� ����
