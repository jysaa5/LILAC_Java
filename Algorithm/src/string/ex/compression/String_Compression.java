package string.ex.compression;

// ����: ���ڿ��� ����
// ex) aabbbccccd
// -> a2b3c4d1 ��ȯ
// ����, ���ົ�� �������� ũ�� �׳� ������ ��ȯ�Ѵ�.
// Solution: ���ڿ��� ���� ������ ī��Ʈ�Ѵ�.
public class String_Compression {
	
	public static void main(String[] args) {
		System.out.println(compressString("aabbbbbbccccdd"));
		System.out.println("abcd");
	}
	
	// compressString �޼���: ����� ���ڿ� ��
	private static String compressString(String str) {
		String newStr = compress(str);
		
		// �� ���߿� ª�� ���� ��ȯ
		return str.length() < newStr.length() ? str : newStr;
		
	}// compressString �޼��� ����
	
	
	// compress �޼���: ���ڿ� ����
	private static String compress(String str) {
		// ������ ���� ����
		int count = 0;
		
		// ������� ������ StringBuilder ����
		StringBuilder newString = new StringBuilder(getTotal(str));
		
		for(int i=0; i<str.length(); i++) {
			count ++;
			
			// �� ������ �����̰ų� ���� ���ڿ� �ٸ� ������ ���
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				newString.append(str.charAt(i));
				newString.append(count);
				count = 0;
			}
		}
		// String Ÿ���� ��ȯ
		return newString.toString();
		
	}// compress �޼��� ����

	
	// getTotal �޼���: ��� ���ڿ��� ������ ����ϴ� �޼���
	private static int getTotal(String str) {
		
		int count = 0;
		int total = 0;
		
		for(int i=0; i<str.length(); i++) {
			count ++;
			
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				
				total += 1 + String.valueOf(count).length();
				count = 0;
				
			}
			
		}
		
		return total;
		
	}// getTotal �޼��� ����
	
}// String_Compression Ŭ���� ����
