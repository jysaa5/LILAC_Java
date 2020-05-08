package Imp.string.alg.encode.url;

// ����: �־��� ���ڿ��� ������ %20���� ��ȯ�ϴ� �Լ��� �����Ͻÿ�. ���ڿ��� �� ������ ��ȯ�� �ʿ��� ����� ������ �ְ� ���� ���ڿ��� ����� 
// �˰� ����.

// Example: Input "Mr John Smith  ", ���ڿ��� ����: 13
// Output "Mr%20John%20Smith"
/*
 * |M|r| |J|o|h|n| |S|m|i|t|h| | | |
 * 
 * ����� 13�̹Ƿ� ���ٰ� 13�� �Ǹ� �׸� ���� �ȴ�.
 * ���� ������ 2���̴�. 
 * ����: | | -> %20 -> %, 20�̹Ƿ� �迭���� ����� 2�� �ʿ���.
 * 13 + 2*2 = 17 -> ��������� ��ȯ�� ���ڿ� ����
 * ���ڿ� ���ʿ� ����� ������ �����Ƿ� �ڿ������� �����Ѵ�. 
 *
 * 1. ��� ���ڿ� ��ȯ �ε���(17)��ŭ �ڷ� ����.  
 * 2. ���� ���ڿ� ���� ���� p(pointer)�� �д�.
 *                          p       i 
 * |M|r| |J|o|h|n| |S|m|i|t|h| | | | |
 * 
 * 3. �����Ϳ� �ִ� ���ڸ� �ε����� �ִ� ���ڸ� �����Ѵ�.
 *                          p       i 
 * |M|r| |J|o|h|n| |S|m|i|t| | | | |h|
 * 
 * 4. �����Ϳ� �ε����� ������ �� ���� �̵��Ѵ�.
 *                        p       i 
 * |M|r| |J|o|h|n| |S|m|i|t| | | | |h|
 * 
 * 5. 3, 4���� �ݺ��Ѵ�.
 *                      p       i 
 * |M|r| |J|o|h|n| |S|m|i| | | | |t|h|
 *
 *                    p       i 
 * |M|r| |J|o|h|n| |S|m| | | | |i|t|h|
 *
 *                  p       i 
 * |M|r| |J|o|h|n| |S| | | | |m|i|t|h|
 *
 * 6. p�� ������ ������ i�� %20�� �ڿ������� �־��ְ� i�� �����δ�.
 *                p       i 
 * |M|r| |J|o|h|n| | | | | |S|m|i|t|h|
 * 
 *                p       i 
 * |M|r| |J|o|h|n| | | | |0|S|m|i|t|h|
 * 
 *                p     i 
 * |M|r| |J|o|h|n| | | |2|0|S|m|i|t|h|
 * 
 *                p   i 
 * |M|r| |J|o|h|n| | |%|2|0|S|m|i|t|h|
 *
 *                p i 
 * |M|r| |J|o|h|n| | |%|2|0|S|m|i|t|h|
 * 
 * 7. ������ �� �־����� p�� �ű��. �׸��� 5���� �ݺ�
 *              p   i 
 * |M|r| |J|o|h|n| | |%|2|0|S|m|i|t|h|
 * 
 *              p   i 
 * |M|r| |J|o|h| | |n|%|2|0|S|m|i|t|h|
 * 
 *            p   i 
 * |M|r| |J|o|h| | |n|%|2|0|S|m|i|t|h|
 * 
 *          p   i 
 * |M|r| |J|o| | |h|n|%|2|0|S|m|i|t|h|
 * 
 *        p   i 
 * |M|r| |J| | |o|h|n|%|2|0|S|m|i|t|h|
 * 
 *      p   i 
 * |M|r| | | |J|o|h|n|%|2|0|S|m|i|t|h|
 * 
 * 8. p�� ������ ������ i�� %20�� �ڿ������� �־��ְ� i�� �����δ�.
 * 
 *      p   i 
 * |M|r| | |0|J|o|h|n|%|2|0|S|m|i|t|h|
 * 
 *      p i 
 * |M|r| |2|0|J|o|h|n|%|2|0|S|m|i|t|h|
 * 
 * 9. i�� ������ �ű��.
 *     pi 
 * |M|r|%|2|0|J|o|h|n|%|2|0|S|m|i|t|h|
 * 
 *    i p 
 * |M|r|%|2|0|J|o|h|n|%|2|0|S|m|i|t|h|
 * 
 * 10. p�� ������ �ű��.
 * 
 *   ip  
 * |M|r|%|2|0|J|o|h|n|%|2|0|S|m|i|t|h|
 * 
 * 11. i�� p�� ������ �ű��.
 * 
 * ip  
 * |M|r|%|2|0|J|o|h|n|%|2|0|S|m|i|t|h|
 * 
 * 12. "Mr%20John%20Smith" ���� ���ڿ��� ��ȯ
 * */ 

// String_Encode_URL Ŭ����
public class String_Encode_URL {

	// URLify �޼���: String(���ڿ�)�� �޾Ƽ� ���� �迭�� ��ȯ���ִ� �޼���
	private static String URLify(String str, int len) {
		
		return URLify(str.toCharArray(), len);
		
	}// URLify �޼��� ����
	
	
	// URLify �޼���
	private static String URLify(char[] str, int len) {
		
		// ������ �� �� ���� �����ϴ� ����
		int spaces = 0;
		
		for(int i = 0; i < len; i++) {
			if(str[i] == ' ') {
				spaces ++;
			}
		}
		
		// ���ڿ��� �ű� �ε��� ���
		int index = len + spaces * 2 - 1;
		
		// pointer
		for(int p = len-1; p >= 0; p--) {
			
			if(str[p] == ' ') {
				
				str[index--] = '0';
				str[index--] = '2';
				str[index--] = '%';
				
			}else {
				str[index--] = str[p];
			}	
		}
		
		return new String(str);
		
	}// URLify �޼��� ����
	
	public static void main(String[] args) {
		
		System.out.println(URLify("Mr John Smith         ", 13));
		
	}
}// String_Encode_URL Ŭ���� ����
