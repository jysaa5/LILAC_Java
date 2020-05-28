package hash;

import java.util.Arrays;
import java.util.HashMap;

//�ڷᱸ�� ����
public class Incomplet_Players {

    //solution1
    //�迭�� Arrays ���.
    //Hash�� ������� �ʰ� Ǯ� ����������, ȿ���� �׽�Ʈ���� �� 0���� �޴´�. 
    //������ for���� �������� ����ؼ� �ð��� ���⵵�� O(n*n)�� �ǹ����� �����̴�.
	public static String solution1(String[] participant, String[] completion) {

		String[] p = participant;
		String[] c = completion;
		String[] check = Arrays.copyOf(p, c.length);
		String player = "";

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {

				if (check[i].equals(c[j])) {
					check[i] = "0";
					c[j] = "0";
					break;
				}
			}
		}
		for (int k = 0; k < c.length; k++) {
			if (!check[k].equals("0")) {
				player = check[k];
				break;
			} else if (k == c.length - 1) {
				player = p[p.length - 1];
				break;
			}
		}

		return player;
	}

    //solution2
    //Hash�� ������� �ʰ� Array�� ���.	
	public static String solution2(String[] participant, String[] completion) {

		Arrays.sort(participant);
		Arrays.sort(completion);

		int i;

		for (i = 0; i < completion.length; i++) {

			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}

		return participant[i];
	}

    //solution3
    //Hash ���.
	public static String solution3(String[] participant, String[] completion) {

		String answer = "";
		// ���� �̸� = key, ���� ��ܿ� �ִ��� ���� üũ�� ���� �� = value
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();

		// for each��
		// �ؽ��ʿ� ���� �ִ� ����: �ߺ��� ���� 2�̰� �ߺ����� ������ 1�̴�.
		for (String player : participant) {

			if (hmap.containsKey(player) == true) {

				// �ؽ��ʿ��� ���� �̸��� ���� ��ȯ(value) ��ȯ
				int result = hmap.get(player);

				// �ؽ��ʿ� ���� �̸�, ���� ����
				hmap.put(player, result + 1);
			} else {

				hmap.put(player, 1);
			}
		}

		// ������ ����� value���� -1�� �Ͽ�, 0���� ����
		for (String player : completion) {
			int result = hmap.get(player);
			hmap.put(player, result - 1);
		}

		// �ؽ��ʿ��� ������ �̸��� Ű������ value�� �����ͼ� 0�� �ƴ� Ű�� ã�Ƴ���.
		for (String player : participant) {
			if (hmap.get(player) != 0) {
				answer = player;
			}
		}

		return answer;
	}

	
    //test
	public static void main(String[] args) {
		String[] participant1 = { "leo", "kiki", "eden" };
		String[] completion1 = { "eden", "kiki" };

		String[] participant2 = { "leo", "kiki", "eden" };
		String[] completion2 = { "eden", "kiki" };

		String[] participant3 = { "leo", "kiki", "eden" };
		String[] completion3 = { "eden", "kiki" };

		System.out.println(solution1(participant1, completion1));
		System.out.println(solution2(participant2, completion2));
		System.out.println(solution3(participant3, completion3));
	}

}
