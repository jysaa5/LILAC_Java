package com.violetCheese.intermediate;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex_28_Byte_IO {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("byte.txt");
			fos = new FileOutputStream("copy.txt");
			// byte.txt�� ������ �о �״�� copy.txt�� �����Ϸ��� �մϴ�.
			// �� �Ʒ����� fis�� fos�� �̿��ؼ� ���� ���縦 �ϼ��� ������.
			int readData = -1;
			while ((readData = fis.read()) != -1) {
				fos.write(readData);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// fis�� fos�� ����ϰ� ���� close�ؾ� �մϴ�.
			try {
				fis.close();
				fos.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
