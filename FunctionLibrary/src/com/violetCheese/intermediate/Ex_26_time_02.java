package com.violetCheese.intermediate;

import java.time.LocalDateTime;

public class Ex_26_time_02 {
	public static void main(String[] args) {
		// ������ ��������� �����(��. 1���̸� JANUARY, 2���̸� FEBRUARY) ����ϼ���

		LocalDateTime ld = LocalDateTime.now();
		// Month month = ld.getMonth();
		System.out.println(ld.getMonth());

	}
}
