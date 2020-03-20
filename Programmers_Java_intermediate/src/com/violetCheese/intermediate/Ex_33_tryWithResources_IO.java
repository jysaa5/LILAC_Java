package com.violetCheese.intermediate;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class Ex_33_tryWithResources_IO {
	public static int read3() {
		int sum = 0;
		// data.txt�κ��� int�� 3���� �о�鿩�� sum�� ���ϼ���.
		try (DataInputStream di = new DataInputStream(new FileInputStream("data.txt"));

		) {

			int a = di.readInt();
			int b = di.readInt();
			int c = di.readInt();

			sum = a + b + c;

		} catch (Exception e) {
			e.printStackTrace();
		}

		// �Ʒ��� �׽�Ʈ�� ���� �ڵ��Դϴ�. �������� ������.
		return sum;
	}

}
