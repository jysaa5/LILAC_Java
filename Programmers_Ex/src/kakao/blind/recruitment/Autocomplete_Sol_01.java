package kakao.blind.recruitment;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

//����: �ڵ� �ϼ�
/*
�ڵ��ϼ�
���� �������� �˻��� �ڵ��ϼ� ����� �ְ� ���� ���̾��� �� �� �Էµ� ���ڿ��� �н��ؼ� ���� �Է� �� Ȱ���ϰ� �;� ����.
���� ���, go �� �� �� �ԷµǾ��ٸ�, ���� ����ڴ� g �� �Է��ص� go�� ��õ���ֹǷ� o�� �Է��� �ʿ䰡 ��������!
��, �н��� ���� �ܾ�� �� �պκ��� ���� ��쿡�� ��¿ �� ���� �ٸ� ���ڰ� ���� ������ �Է��� �ؾ� �Ѵ�.
ȿ���� �󸶳� ������ �˰� ���� ���̾��� �н��� �ܾ���� ã�� �� �� ���ڸ� �Է��ؾ� �ϴ��� �ñ�������.

���� ���, �н��� �ܾ���� �Ʒ��� ���� ��
go
gone
guild
go�� ã�� �� go�� ��� �Է��ؾ� �Ѵ�.
gone�� ã�� �� gon ���� �Է��ؾ� �Ѵ�. (gon�� �ԷµǱ� �������� go ���� gone���� Ȯ���� �� ����.)
guild�� ã�� ���� gu ������ �Է��ϸ� guild�� �ϼ��ȴ�.
�� ��� �� �Է��ؾ� �� ������ ���� 7�̴�.
���̾��� ���� ���� ���� ���ڿ��� �Է����� �־����� �н��� ��Ų ��, 
�н��� �ܾ���� ������� ã�� �� �� ���� ���ڸ� �Է��ϸ� �Ǵ��� ����ϴ� ���α׷��� ������.

�Է� ����
�н��� �˻��� ���� �ߺ� ���� �ܾ� N���� �־�����.
��� �ܾ�� ���ĺ� �ҹ��ڷ� �����Ǹ� �ܾ��� �� N�� �ܾ���� ������ ���� L�� ������ ������ ����.

2 <= N <= 100,000
2 <= L <= 1,000,000
��� ����
�ܾ ã�� �� �Է��ؾ� �� �� ���ڼ��� �����Ѵ�.

����� ����
words	result
[go,gone,guild]	7
[abc,def,ghi,jklm]	4
[word,war,warrior,world]	15

����� ����
ù ��° ������ ���� ����� ����.
�� ��° ���������� ��� �ܾ���� ����� �κ��� �����Ƿ�, ���� �ձ��ڸ� �Է��ϸ� �ȴ�.
�� ��° ������ �� 15 �ڸ� �Է��ؾ� �ϰ� ������ �Ʒ��� ����.
word�� word��� �Է��ؾ� �Ѵ�.
war�� war ���� ��� �Է��ؾ� �Ѵ�.
warrior�� warr ������ �Է��ϸ� �ȴ�.
world�� worl���� �Է��ؾ� �Ѵ�. (word�� ���еǾ�� ���� �������)
*/
/*
1. ���� ���
- 
2. �ַ��
- 
3. �ð����⵵
4. ��ü ���� 
*/
class Autocomplete_Solution_01 {
	public int solution(String[] words) {
		// ���
		int answer = 0;
		int value = 0;

		// ������ ����
		Arrays.sort(words);

		ArrayList<String> arr = new ArrayList<String>();
		for (String word : words) {
			arr.add(word);
		}

		value = len(arr.get(0), arr.get(1));

		// �ε��� 0�� ���ڿ� ���̺��� value�� ���� ��
		if (value < arr.get(0).length()) {
			answer += value + 1;
		} else {
			answer += value;
		}

		for (int i = 1; i < words.length - 1; i++) {
			value = len(arr.get(i), arr.get(i - 1));
			value = Math.max(len(arr.get(i), arr.get(i + 1)), value);

			if (value < arr.get(i).length()) {
				answer += value + 1;
			} else {
				answer += value;
			}
		}

		value = len(arr.get(words.length - 2), arr.get(words.length - 1));

		if (value < arr.get(words.length - 1).length()) {
			answer += value + 1;
		} else {
			answer += value;
		}
		return answer;
	}

	// ���ڿ��� ���ʺ��� �󸶳� ���� ���ڸ� ���� �ִ��� ���ڷ� ��ȯ�ϴ� �Լ�
	public static int len(String s1, String s2) {
		int length = 0;
		for (int i = 0; i < s1.length() && i < s2.length(); i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				length++;
			} else {
				break;
			}
		}

		return length;
	}
}

public class Autocomplete_Sol_01 {

	public static void main(String[] args) {
		String[] words = { "go", "gone", "guild" };
		Autocomplete_Solution_01 sol = new Autocomplete_Solution_01();
		System.out.println("��: " + sol.solution(words));
	}

}
