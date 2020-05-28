package programmers;

//������ ���� ����
//������ ���� �ǹ� �� 3�� ������ ���. 0, 1, 2�� ǥ���ϴ� ���� �ƴ϶� 4,1,2�� ǥ��.
public class Country_124_Numbers {

	// solution1 �� �̹� ��ȯ Ÿ�Կ��� ��Ʈ�� �ְ� �ִ�.= String
	public static String solution1(int n) {

		// ���� ��
		String answer = "";

		// 1,2,4�θ� ǥ���ϱ� ���� ���� ����
		int reminder;

		// n�� 0���ϰ� �ɶ����� ���ѹݺ� �� ���ڰ� Ŀ������ ����ϴ� �������� �ظ��ϸ� while������ �ݺ�����.
		while (n > 0) {

			// 10������ 3���� ������ ��Ģ�� ���̹Ƿ� 3���� ������.
			reminder = n % 3;

			// n�� ���� ���Ѵ�.
			n = n / 3;

			// �������� 0�϶�.
			if (reminder == 0) {

				// ��� ���ø� ���� 10������ 3�� ����϶��� 10�� �ڸ����ڰ� ������ ���ں��� ���� 1�� �� ũ�⶧���� ���ش�.
				n -= 1;

				// �׸��� �������� 4�� �־��ش�.
				reminder = 4;

			}

			// �����信 ���������� �տ� �����ش�. int + String = String�̴�.
			answer = reminder + answer;
		}

		return answer;
	}

	// solution2
	public static String solution2(int n) {

		// 1,2,4 ��Ģ�� ���ؼ� �迭�� �����Ѵ�. 3�� ����϶��� 4, 3���� ������ �� 1�̸� 1, 3���� ������ �� 2�̸� 2�� ����
		// �ڸ����ں��� ����� ����.
		String[] num = { "4", "1", "2" };
		// ������
		String answer = "";

		// ���⼭�� ū ���ڵ��� ����ؾߵǱ� ������ while������ �ݺ��� ���̴�.
		while (n > 0) {

			// �Էµ� ���ڸ� 3���� ������ �ε����� ���� �����信 String + String = String���� ����.
			answer = num[n % 3] + answer;

			// �Էµ� ���� 0���ϰ� �ɶ����� 1�� �� ��, 3���� ������.
			n = (n - 1) / 3;

		}

		return answer;
	}

	//test
	public static void main(String[] args) {
		int n = 1;
		
		while (n<20) {
			
			System.out.println(solution1(n));
			System.out.println(solution2(n));
			n++;
		}
		
		

	}

}
