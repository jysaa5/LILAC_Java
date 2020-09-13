package string.ex.find.permutation;

// ����: �־��� �� ���� ���ڿ��� ���� ġȯ�Ǵ����� �˾Ƴ��� �Լ��� �����Ͻÿ�.
// ġȯ: � ���ڿ� �ȿ� ������ ������ �ٲ۰��� ���Ѵ�. �� ���� ���ڿ��� ���� ġȯ�� �Ƿ���, ������ �ִ� ������ ������ ������ ���ƾߵȴ�.
// ��ҹ��� ����, ���� �����ϰ� ���� Ǯ���Ѵ�. 

// Solution 1: ���ڿ� 2���� �����ϰ� �տ��� ���� ������ ���Ѵ�.

// String_Find_Permutation_Sol_1 Ŭ����
public class String_Find_Permutation_Sol_1 {
	
	// sort �޼���: ���ڿ� ����
	private static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.parallelSort(content);
		return new String(content);
	}// sort �޼��� ����
	
	// permutation �޼���: ġȯ�� �Ǵ��� Ȯ��
	private static boolean permutation(String s, String t) {
		
		// ���ڿ��� ���̰� �ٸ� ��
		if(s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
		
	}// permutation �޼��� ����
	
	
	
	
	// main �޼���
	public static void main(String[] args) {
		
		System.out.println(permutation("ABC", "BCA"));
		System.out.println(permutation("ABC", "BDA"));
		
	}// main �޼��� ����
	
}// String_Find_Permutation_Sol_1 Ŭ���� ����
