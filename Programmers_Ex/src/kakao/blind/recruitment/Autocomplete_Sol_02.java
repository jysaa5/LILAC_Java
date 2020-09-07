package kakao.blind.recruitment;


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
- Ʈ���� (Tire)
3. �ð����⵵
4. ��ü ���� 
*/
//�ڵ��ϼ�
class Trie {
	public NodeInfo root;

	public Trie() {
		this.root = new NodeInfo(' ');
	}

	public void insert(String word) {
		NodeInfo current = root;
		for (int s = 0; s < word.length(); ++s) {
			char c = word.charAt(s);
			int idx = c - 'a';

			if (current.child[idx] == null)
				current.child[idx] = new NodeInfo(c);

			else
				current.child[idx].usedCnt++;

			current = current.child[idx];
		}
	}

	public int search(String word) {
		NodeInfo current = root;
		int cnt = 1;

		for (int s = 0; s < word.length(); ++s) {
			char c = word.charAt(s);
			int idx = c - 'a';

			if (current.child[idx] != null) {
				// ������ �ܾ���
				if (s == word.length() - 1)
					return cnt;

				// �ش� ���ڰ� 1���� ���Ǿ��ٸ� ���̻� ������ �ʿ� x
				if (current.child[idx].usedCnt <= 1) {
					return cnt;
				} else {
					current = current.child[idx];
				}
			}
			cnt++;
		}
		return cnt;
	}
}

class NodeInfo {
	public char ch;
	public int usedCnt;
	public NodeInfo[] child;

	public NodeInfo(char ch) {
		this.ch = ch;
		this.usedCnt = 1;
		this.child = new NodeInfo[26];
	}
}

public class Autocomplete_Sol_02 {

	public static void main(String[] args) {
		// String[] words = { "go", "gone", "guild" };
		// String[] words = { "abc", "def", "ghi", "jklm" };
		String[] words = { "word", "war", "warrior", "world" };
		int answer = solution(words);
		System.out.println("��: " + answer);
	}

	public static int solution(String[] words) {
		int answer = 0;

		// make trie
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		// search word
		for (String word : words) {
			answer += trie.search(word);
		}

		return answer;
	}

}
