package chapter05;

// p. 118
// ����: ȸ��
// �ַ��: ���� for��

public class Palindrome_Sol_01 {

	public static int find(String s) {

		// ���� ���� ���̸� �����Ѵ�.
		for (int i = s.length();; i++) {

			boolean flag = true;

			for (int j = 0; j < s.length(); j++) {

				// �ݴ��ʿ� ���ڰ� �����ϴ� ��, �ٸ� ��� �÷��׸� �����Ѵ�.
				if ((i - j - 1) < s.length() && s.charAt(j) != s.charAt(i - j - 1)) {

					flag = false;
					break;

				}
			}

			// ������ ��� �����ϸ� ���� �����Ѵ�.
			if (flag) {
				return i;
			}

		}
	}

	public static void main(String[] args) {
		
		String s = "abab";
		System.out.println(find(s));

	}

}
