package time_date_ex;

import java.time.LocalDateTime;

public class Time_02 {
	public static void main(String[] args) {
		// ������ ��������� �����(��. 1���̸� JANUARY, 2���̸� FEBRUARY) ����ϼ���

		LocalDateTime ld = LocalDateTime.now();
		// Month month = ld.getMonth();
		System.out.println(ld.getMonth());

	}
}
