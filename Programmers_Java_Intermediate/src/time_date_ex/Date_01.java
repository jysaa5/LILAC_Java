package time_date_ex;

import java.text.SimpleDateFormat;
import java.util.Date;

//Date: ��¥�� �ð��� ���ϱ� ���� Ŭ���� Date Ŭ����
//DateŬ������ JDK 1.0�� ���������, CalendarŬ������ JDK1.1�� ���������.
//Date�� ����ȭ�� ���� �κ��� ������� �ʾҴ�. 
//����ȭ��, ������ ���� �ð�, ��ȭ(��, �޷�, �� ��) ��� ���Ͽ� ����ϴ� ���α׷����� ����ȭ�� ���� ���α׷����̶�� �Ѵ�.
//DateŬ������ ���� ��κ��� �����ڿ� �޼ҵ尡 Deprecated�Ǿ� �ִ�. 
//Deprecated�� ���� ������ ������ ���ϰų� ������ ���� �� ������ ������� ����� ���̴�.

public class Date_01 {
	public static void main(String[] args) {
		// �⺻ �����ڷ� Date�ν��Ͻ��� ����� �Ǹ� ���� �ð��� ��¥ ������ Date�ν��Ͻ��� ������ �ȴ�.
		Date date = new Date();
		// toString()�޼ҵ带 �̿��Ͽ� ���� �ð��� ���ڿ��� ���Ѵ�.
		System.out.println(date.toString());

		// ���ϴ� �������� ���� �����ϱ�
		// a: �������� �������� ǥ�����ش�.
		// zzz: timezone�� ǥ�����ش�.
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");

		// ������ ���Ĵ�� ��µ�.
		System.out.println(ft.format(date));

		// ���� �ð��� ���
		System.out.println(date.getTime());

		// long������ ���� �ð� ���� ���� �� �ִ�.
		long today = System.currentTimeMillis();
		System.out.println(today);

		// �ν��Ͻ��� ������� �ð��� ���� �ð����� ���� �� ���� �ɸ� �ð��� ���� �� �ִ�.
		System.out.println(today - date.getTime());
	}

}
