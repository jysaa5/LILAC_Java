package stringBuffer_ex;

import java.util.Random;

public class StringBuffer_02 {

	public String randomName() {
		StringBuffer sb = new StringBuffer();

		String[] firstNames = { "Tod", "John", "Michael" };
		String[] lastNames = { "Smith", "Brown", "Davis" };

		// 0~2 ������ ������ ���ڸ� ���
		int random1 = new Random().nextInt(3);
		// �����ϰ� �̸��� �̴´�.
		String firstName = firstNames[random1];

		// 0~2 ������ ������ ���ڸ� ���
		int random2 = new Random().nextInt(3);
		// �����ϰ� ���� �̴´�.
		String lastName = lastNames[random2];

		// sb�� �̸�(fistName) ����(" ") ��(lastname) ������ append�� ������.
		// �� �޼ҵ� ü�̴��� �̿��ؾ� �մϴ�.

		String str = sb.append(firstName).append(" ").append(lastName).toString();

		return str;
	}

	public static void main(String[] args) {

		StringBuffer_02 s = new StringBuffer_02();

		System.out.println(s.randomName());

	}
}