package chapter05.array;

public class StringArray_03 {
	
	public static void main(String[] args) {
		
		String src = "ABCDE";
		
		for(int i=0; i<src.length(); i++) {
			// src�� i��° ���ڸ� ch�� ����
			char ch = src.charAt(i);
			
			System.out.println("src.charAt("+i+"):"+ch);
		}
		
		
		// String�� char[]�� ��ȯ
		char[] chArr = src.toCharArray();
		
		// char�迭(char[])�� ���
		System.out.println(chArr);
		
		
	}

}
