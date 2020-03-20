package com.violetCheese.intermediate;

import java.util.Calendar;

//Date�� ������ �ذ��ϰ� ������ ���� CalendarŬ����
//CalendarŬ������ �߻�Ŭ�����̴�.
//CalendarŬ������ ���� �ν��Ͻ��� �����Ϸ��� Calendar�� ������ �ִ� Ŭ���� �޼ҵ� getInstnace()�� ����ؾ� �Ѵ�.
//getInstance()�޼ҵ带 ȣ���ϸ� ���������� java.util.GregorianCalendar �ν��Ͻ��� ���������Ѵ�.
//GregorianCalendar�� Calendar�� �ڽ� Ŭ�����̴�
public class Ex_23_Calendar_01 {
	public static void main(String[] args) {

		// Calendar�� �߻�Ŭ����: ������ �ν��Ͻ��� ����� ����. new�� �� �� ����.
		Calendar cal = Calendar.getInstance();

		// ��� �ʵ带 ����Ҷ��� Ŭ���� ��.���������
		System.out.println(cal.get(Calendar.YEAR));
		// �ڹٴ� ���� 0~11���� ǥ���Ѵ�.
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DATE));

		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));

		// �ð� ���� �ٲ��� �� �ִ�.
		// Calendar�� ������ �ִ� add�޼ҵ带 �̿��ϸ� ���� ���� ��¥�� ���� ��¥�� ���� �� �ִ�.
		cal.add(Calendar.HOUR, 5);
		// ��� �ʵ带 ����Ҷ��� Ŭ���� ��.���������
		System.out.println(cal.get(Calendar.YEAR));
		// �ڹٴ� ���� 0~11���� ǥ���Ѵ�.
		System.out.println(cal.get((Calendar.MONTH) + 1));
		System.out.println(cal.get(Calendar.DATE));

		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));

	}
}
