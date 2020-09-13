package string.ex.check.unique;

// ����: �־��� ���ڿ��� ���ڵ��� ��� ���������� Ȯ���ϴ� �Լ��� �����Ͻÿ�. 
// ����, ������ ��������� ������� ���ϴ� ��쿡�� ��� �ذ������� �߰��� �����Ͻÿ�.
// Solution:
/*
 * abcddef
 * -> ���ڿ��� �־�����, �ߺ��� ���ڰ� �ִ��� Ȯ���ϰ� ����� ��ȯ�ϴ´�. 
 * -> Bit Operator
 * -> a ~ z : 26��
 * -> 2^n 
 * -> ������ �ִ밪: 2^31
 * -> ����: 2^26
 * -> ASCII
 * -> a ~ z ( 97 ~ 122 ) = ( 0 ~ 25 )
 * 
 * */


// String_Check_Unique_Char_BitOperator Ŭ����
public class String_Check_Unique_Char_BitOperator {
	
	// isUnique: ASCII�ڵ带 Bit Operator�� �̿��Ͽ� ����ġ ó�� �������� ǥ��
	private static boolean isUnique(String str){
		
		int checker = 0;
		
		for(int i=0; i< str.length(); i++) {
			
			int val = str.charAt(i) - 'a';
		
			// checker�� �̹� 1�̸� false�� ��ȯ
			if((checker & (1<<val))>0) {
				return false;
			}
			// Bit ������: OR = |
			// checker�� 1�� ����Ʈ�� ���� OR �����Ѵ�.
			checker |= (1<<val);			
		
		}
		// ������ �����̹Ƿ� true�� ��ȯ
		return true;
	}// isUnique �޼��� ����
	
	
	// main �޼���
	public static void main(String[] args) {
		
		// �ƽ�Ű�ڵ�
		System.out.println(isUnique("abcdefgghijk"));
		System.out.println(isUnique("abcdefghijk"));
		
	}// main �޼���

}// String_Check_Unique_Char_BitOperator Ŭ���� ����



// �߰� ������ ������� ���� ��, ���ڿ� ���� �ߺ��Ǵ� ���ڰ� �ִ��� Ȯ���ϴ� ���.
// Solution 1: ���� �Ѱ��� ó������ ���鼭, �ڿ� �ִ� ���ڵ�� �ߺ��Ǵ� �� Ȯ���Ѵ�. �ð� ���⵵ = O(n^2)
// Solution 2: ���ڿ����� ������ ��Ų��, �ٷ� ���� �ִ� ���ڵ�� ���Ѵ�. �ð����⵵ = O(2n log n) = O(n log n)


