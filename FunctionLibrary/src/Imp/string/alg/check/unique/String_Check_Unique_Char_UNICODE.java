package Imp.string.alg.check.unique;

import java.util.HashMap;

// ����: �־��� ���ڿ��� ���ڵ��� ��� ���������� Ȯ���ϴ� �Լ��� �����Ͻÿ�. 
// ����, ������ ��������� ������� ���ϴ� ��쿡�� ��� �ذ������� �߰��� �����Ͻÿ�.
// Solution:
/*
 * abcddef
 * -> ���ڿ��� �־�����, �ߺ��� ���ڰ� �ִ��� Ȯ���ϰ� ����� ��ȯ�ϴ´�. 
 * -> �ش� ���ڿ��� ASCII(�ƽ�Ű�ڵ�)�� �̷���� �ִ���, Unicode(�����ڵ�)�� �̷���� �ִ��� Ȯ���ؾ� �ȴ�.
 * 
 * 1) Unicode = 2^20 + 2^16 = 1,114,112
 * -> Unicode(�����ڵ�): �ؽø����� �����Ѵ�.
 * 
 * */


// String_Check_Unique_Char_UNICODE Ŭ����
public class String_Check_Unique_Char_UNICODE {
	
	// isUnique: Unicode(�����ڵ�)�θ� �̷���� ���� ��, ����
	private static boolean isUnique(String str){
		HashMap<Integer, Boolean> hashmap = new HashMap<Integer, Boolean>();
		
		for(int i=0; i<str.length(); i++) {
			int c = str.charAt(i);
			
			// �Է��� �Ǿ��� Ű���� Ȯ��
			if(hashmap.containsKey(c)) {
				return false;
			}
			
			// ���ڸ� �ؽøʿ� �Է�
			hashmap.put(c, true);
		}
		
		return true;
		
	}// isUnique �޼��� ����
	
	
	// main �޼���
	public static void main(String[] args) {
		
		// �ƽ�Ű�ڵ�
		System.out.println(isUnique("abcdefgghijk"));
		System.out.println(isUnique("abcdefghijk"));
		
	}// main �޼���

}// String_Check_Unique_Char_UNICODE Ŭ���� ����
