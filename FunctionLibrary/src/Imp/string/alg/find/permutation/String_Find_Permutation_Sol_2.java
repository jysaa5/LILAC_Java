package Imp.string.alg.find.permutation;

// ����: �־��� �� ���� ���ڿ��� ���� ġȯ�Ǵ����� �˾Ƴ��� �Լ��� �����Ͻÿ�.
// ġȯ: � ���ڿ� �ȿ� ������ ������ �ٲ۰��� ���Ѵ�. �� ���� ���ڿ��� ���� ġȯ�� �Ƿ���, ������ �ִ� ������ ������ ������ ���ƾߵȴ�.
// ��ҹ��� ����, ���� �����ϰ� ���� Ǯ���Ѵ�. 

// Solution 2: ���ڿ� 2���� �����ϰ� �տ��� ���� ������ ���Ѵ�. ASCII�� 128���θ� �����Ǿ� �ִٰ� �����Ѵ�.
// �׸��� 128���� �迭���� �����ϰ� ���ڿ��� �ִ� ���ڰ� ������ ���ڸ� ������Ű�� �ٸ� ���ڿ��� ���� ���� �� �迭���� ���ڸ� ���ҽ�Ų��.
// ġȯ�� ������ ���ڿ��̶�� ��� �迭���� ���ڰ� �� 0�̾�� �ϳ�.

// String_Find_Permutation_Sol_2 Ŭ����
public class String_Find_Permutation_Sol_2 {
	
	// permutation �޼���: ġȯ�� �Ǵ��� Ȯ��
	private static boolean permutation(String s, String t) {
		
		// ���ڿ��� ���̰� �ٸ� ��
		if(s.length() != t.length()) {
			return false;
		}
		
		int[] letters = new int[128];
		
		// ù ��° ���ڿ��� �ִ� ���ڸ� �迭�濡 ���� ���� ��Ű��
		for(int i=0; i<s.length(); i++) {
			
			letters[s.charAt(i)]++;
		
		}
		
		// �� ��° ���ڿ��� �ִ� ���ڰ� �ִٸ� �迭�濡�� ���� ���� ��Ű��
		for(int i=0; i<t.length(); i++) {
			
			letters[t.charAt(i)]--;
			
			// ���� �迭�濡 ������ ������ = �ι�° ���ڿ��� ù��° ���ڿ� ������ �ٸ� �� �ִٴ� ���̴�.
			if(letters[t.charAt(i)]<0) {
				return false;
			}
		}
		
		return true;
		
	}// permutation �޼��� ����
	
	
	
	
	// main �޼���
	public static void main(String[] args) {
		
		System.out.println(permutation("ABC", "BCA"));
		System.out.println(permutation("ABC", "BDA"));
		
	}// main �޼��� ����
	
}// String_Find_Permutation_Sol_2 Ŭ���� ����
