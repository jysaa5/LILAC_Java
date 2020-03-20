package com.violetCheese.intermediate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//Byte ���� �����
//���Ϸ� ���� 512byte�� �о�鿩 ���Ͽ� 512byte�� �����ϴ� ���α׷��� �ۼ�
public class Ex_29_Byte_IO {

	public static void main(String[] args) {
		
		//����ð� üũ
		long startTime = System.currentTimeMillis();

		// ������ �д� ��ü
		FileInputStream fis = null;
		// ���Ͽ� ���� �ִ� ��ü
		FileOutputStream fos = null;

		try {
			// �о�帱 ���� ��θ� ���� �ȴ�. ���� ������Ʈ ����
			// ������ ���� ���� notfoundException�� ����. �̿��� ���ܵ� �߻��� �� ����.
			fis = new FileInputStream("src/com/violetCheese/basicJava/Ex_27_Byte_01.java");

			// ������ �� ��ġ�� �ִ´�. ��θ� ���� ������ ���� ������Ʈ ��ο� �����.
			fos = new FileOutputStream("byte.txt");

			// �о�鿴�� �� ���� ����
			int readCount = -1;

			// 512����Ʈ ��ŭ �б� ���ؼ� �迭 ����
			// ����ð��� ª����.
			byte[] buffer = new byte[512];

			// read() �� ����Ʈ�� �о ������ ��ȯ = 4byte�߿��� ������ ����Ʈ �����Ѵ�.
			// ���� �����Ͱ� ������ ��� ��ȯ
			// 512����Ʈ�� �о���̱����� buffer �迭�� �ִ´�.
			// �������� ������ �� ������ -1�� ��ȯ�Ѵ�.
			while ((readCount = fis.read(buffer)) != -1) {
				// ���Ͽ� ����.
				// buffer: ���ۿ� �ش��ϴ� ���� ����.
				// readCount: 0���� �о���� ����ŭ ����.
				fos.write(buffer, 0, readCount);
			}

		} catch (Exception e) {

			e.printStackTrace();

			// IO�� �ݵ�� �ݾƾ� �ȴ�.
		} finally {

			try {
				// IOException ���ܸ� ����Ų��.
				fos.close();

			} catch (IOException e) {

				e.printStackTrace();

			}
			try {
				// IOException ���ܸ� ����Ų��.
				fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

}
