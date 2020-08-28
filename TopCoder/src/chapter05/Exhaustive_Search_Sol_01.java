package chapter05;

// p.88
// ����: ��ſ� ��Ƽ
// �ַ��: for��, if��, Math.max ���

public class Exhaustive_Search_Sol_01 {

	public static int bestInvitation(String[] first, String[] second) {
		int i, j;
		int ans = 0;

		for (i = 0; i < first.length; i++) {
			int f = 0;
			int s = 0;
			for (j = 0; j < first.length; j++) {
				if (first[i].equals(first[j])) {
					f++;
				}

				if (first[i].equals(second[j])) {
					f++;
				}

				if (second[i].equals(first[j])) {
					s++;
				}

				if (second[i].equals(second[j])) {
					s++;
				}

			}
			ans = Math.max(f, ans);
			ans = Math.max(s, ans);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String[] first = {"fishing", "gardening", "swimming", "fishing"};	
		String[] second = {"hunting", "fishing", "fishing", "biting"};
		System.out.println(bestInvitation(first, second));
	}
}
