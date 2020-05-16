package imp.string.alg.print.sortedString;

// ����: �־��� ���ڿ��� ���� k�� ������ ���̰� k�� ���ĵ� ���ڿ��� ��� ������ ����� �Լ��� ���Ͻÿ�. �� �Լ��� k������ ��� ���ڿ��� 
// ���� �Ŀ� �� ���ڿ��� ������ �Ǿ� �ִ� ���� Ȯ���ؾ� �Ѵ�.

// ����: ���ڿ��� ���� k�� 2�� ��. ��� ���ڿ��� ������ ������ �Ѵ�.
/* k = 2
 * aa, ab, ac, ad, ... az -> 26���� ��찡 ���´�.
 * ba, bb, bc, bd, ... bz -> 26���� ��찡 ���´�.
 * ca, cb, cc, cd, ... cz -> 26���� ��찡 ���´�.
 * ...
 * za, zb, zc, zd, ... zz -> 26���� ��찡 ���´�. 
 * 
 * -> C�� 26����� �Ҷ�, C^k��ŭ ����� ���� �þ��.
 * -> k�� 3�̵Ǹ� ť������ �ȴ�. C^3�̹Ƿ�.
 * -> �� ���ڿ��� ������ �� ������ Ȯ���ϸ� �ǹǷ� �Ź� �տ� ���ڶ��� ���ϸ� �ȴ�. ���ڿ��� ���� ��ŭ�� ���� �ȴ�. 
 * -> k*C^k
 * -> �ð����⵵ = O(kC^k)
 * */

// Print_Sorted_String Ŭ����
public class Print_Sorted_String {

	// ��� C
	public static final int C = 26;
	
	
	// printSortedStrings �޼���: ���ĵ� ���ڿ��� ����ϴ� �޼��� 
	// k = ���ڿ��� ����
	private static void printSortedStrings(int k) {
		
		// "" : prefix(���λ�)�� ����� ������ �Լ��� �Ѱ��ش�.
		printSortedStrings(k, "");
		
	}
	
	private static void printSortedStrings(int k, String prefix) {
		
		// k�� 0�� �Ǿ�����, ���ڿ����� ���ĵǾ��� �� Ȯ���Ѵ�.
		if(k==0) {
			
			if(isInOrder(prefix)) {
				System.out.println(prefix);
			}
			
		}else {
		
		
		for(int i=0; i<C; i++) {
			
			// ���ڸ� �޾ƿ´�.
			char c = ithLetter(i);
			
			// prefix�� �޾ƿ� ���ڸ� �߰��Ѵ�. 
			// k�� ���� ��Ű�鼭 ���ڿ��� ������ ���ϴ� ��ŭ �����ϴ� �� �� �� �ִ�.
			printSortedStrings(k-1, prefix+c);
			}
		}
	}//printSortedStrings �޼��� ����
	
	
	// isInOrder �޼���: �ش� ���ڿ��� ������ �Ǿ����� Ȯ���ϴ� �޼���
	// s: ������ �Ǿ����� Ȯ���� ���ڿ� 
	private static boolean isInOrder(String s) {
		
		for (int i=1; i<s.length(); i++) {
			// ���� ����
			int prev = ithLetter(s.charAt(i-1));
			// ���� ����
			int curr = ithLetter(s.charAt(i));
			
			// ���� ���� �� 
			if(prev > curr) {
				return false;
			}
		}
		
		return true;
		
	}// isInOrder �޼��� ����
	
	
	// ithLetter �޼���: i��° ���ڸ� �������� �޼���
	private static char ithLetter(int i) {
		
		return (char)(((int) 'a')+i);
		
	}// ithLetter �޼��� ����
	
	
	
	// main �޼���
	public static void main(String[] args) {
		
		// 351�� = (C^2 / 2) + (C/2)
		printSortedStrings(2);
		
		
	}// main �޼��� ����
	
}// Print_Sorted_String
