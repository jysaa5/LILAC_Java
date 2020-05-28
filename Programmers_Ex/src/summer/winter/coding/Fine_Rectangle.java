package summer.winter.coding;

//������ ���� ����
//������ ��Ģ�� ã�� ����
public class Fine_Rectangle {

	public static long solution(long w, long h) {

		// ������ ����
		long width = w;

		// ������ ����
		long height = h;

		// ���ο� ���� �߿� ���� �� ���� ����
		long num_small = 0;
		// �ݺ������� ���
		long i = 0;
		// �ִ�����
		long gcd = 0;
		// ��ȯ��
		long answer;

		// ���ο� �����߿��� ���� �� ã��
		if (width > height) {
			num_small = height;
		} else {
			num_small = width;
		}

		// i ������ �����鼭 �ִ� ����� ã��
		for (i = num_small; i > 0; i--) {
			if ((width % i == 0) && (height % i == 0)) {
				gcd = i;
				break;
			}
		}

		// ������ ���簢�� = ��ü ���簢�� - (�ҿ����� �簢��)
		answer = (width * height) - (width + height - gcd);

		return answer;

	}

	// test
	public static void main(String[] args) {
		System.out.print(solution(8, 12));
	}

}
