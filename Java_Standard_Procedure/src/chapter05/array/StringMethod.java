package chapter05.array;

public class StringMethod {
	
	public static void main(String[] args) {
		
		// charAt �޼���
		String str1 = "ABCDE";
		// ���ڿ� str1�� 4��° ���� 'D'�� ch�� ����
		char ch = str1.charAt(3);
		System.out.println(ch);
		
		// substring �޼���
		String str2 = "012345";
		// str2���� index ���� 1~4�� ���ڵ��� ��ȯ
		String tmp1 = str2.substring(1,4);
		String tmp2 = str2.substring(2);
		// "123"�� ��µȴ�.
		System.out.println(tmp1);
		System.out.println(tmp2);
		
		//equals �޼���
		String str3 = "abc";
		
		if(str3.equals("abc")) {
			System.out.println("���ڿ��� �����ϴ�.");
		}
		
	}

}
