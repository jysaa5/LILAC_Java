package com.violetCheese.intermediate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

//java.util.Date: ���������� ���ϴ�. ���� ������ ����.
//Joda Time: �ڹ��� Date�� Time�� ����� �� �ִ� Ŭ���� �����ϴ� ���̺귯��
//Java���� �����ϴ� Date, Time API�� ������ ��� ������ ������ �������� �������� ������ �־���.
//JDK �ھ�� �̷� ���������� �ذ��ϰ� �� ���� �������� API���� �����ϱ� ���� ���Ӱ� �� �������� Date, Time API�� Java SE 8���� �����Ѵ�.
public class Ex_25_time_01 {
	public static void main(String[] args) {
		// ���ο� API�� �ٽ� Ŭ������ ������Ʈ�� �����ϱ� ���� �پ��� factory �޼��带 ����Ѵ�.
		// ������Ʈ �ڱ� �ڽ��� Ư�� ��Ҹ� ������ ������Ʈ�� ������ ��� of �޼��带 ȣ���ϸ� �ǰ�,
		// �ٸ� Ÿ������ ������ ��쿡�� from �޼��带 ȣ���ϸ� �ȴ�.

		// now�� ���� �ð��� ���Ѵ�.
		LocalDateTime timePoint = LocalDateTime.now();
		System.out.println(timePoint);

		LocalDate ld1 = LocalDate.of(2012, Month.DECEMBER, 12);
		System.out.println(ld1);

		LocalTime lt1 = LocalTime.of(17, 18);
		System.out.println(lt1);

		LocalTime lt2 = LocalTime.parse("10:15:30");
		System.out.println(lt2);

		LocalDate theDate = timePoint.toLocalDate();
		System.out.println(theDate);

		Month month = timePoint.getMonth();

		System.out.println(timePoint.getMonth());
		System.out.println(month.getValue());
		System.out.println(timePoint.getHour());

	}

}
