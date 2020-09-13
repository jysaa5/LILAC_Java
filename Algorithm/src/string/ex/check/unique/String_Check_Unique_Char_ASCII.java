package string.ex.check.unique;

// ����: �־��� ���ڿ��� ���ڵ��� ��� ���������� Ȯ���ϴ� �Լ��� �����Ͻÿ�. 
// ����, ������ ��������� ������� ���ϴ� ��쿡�� ��� �ذ������� �߰��� �����Ͻÿ�.
// Solution:
/*
 * abcddef
 * -> ���ڿ��� �־�����, �ߺ��� ���ڰ� �ִ��� Ȯ���ϰ� ����� ��ȯ�ϴ´�. 
 * -> �ش� ���ڿ��� ASCII(�ƽ�Ű�ڵ�)�� �̷���� �ִ���, Unicode(�����ڵ�)�� �̷���� �ִ��� Ȯ���ؾ� �ȴ�.
 * 
 * 1) �ƽ�Ű�ڵ�θ� �̷���� ���� ��.
 * ���� �ƽ�Ű�ڵ�θ� �̷���� �ִٸ�, boolean���� �̷���� �ִ� �迭���� 128���� ����� ���ڰ� ������ 1�� �ٲٰ� ������ 0�����Ѵ�.
 * �ߺ��Ǵ� �� �̹� 1�� ���� �� ã���� ���̴�.
 *                               0   1   2   3  ... 126  127
 * -> ASCII(�ƽ�Ű�ڵ�)-> 128�� -> | 0 | 0 | 0 | 0 |   | 0 | 0 | 
 * -> Unicode(�����ڵ�)
 * 
 * */


// String_Check_Unique_Char Ŭ����
public class String_Check_Unique_Char_ASCII {
	
	// isUnique: �ƽ�Ű�ڵ�(128)�θ� �̷���� ���� ��, ����
	private static boolean isUnique(String str){
		// ���ڿ��� ������ 128�� ���� ��
		if(str.length() > 128) {
			return false;
		}
		
		boolean[] char_set = new boolean [128];
		
		for(int i=0; i<str.length(); i++) {
			int val = str.charAt(i);
			
			if(char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}// isUnique �޼��� ����
	
	
	// main �޼���
	public static void main(String[] args) {
		
		// �ƽ�Ű�ڵ�
		System.out.println(isUnique("abcdefgghijk"));
		System.out.println(isUnique("abcdefghijk"));
		
	}// main �޼���

}// String_Check_Unique_Char Ŭ���� ����
