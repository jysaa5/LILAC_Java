package io_ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//Byte ���� �����
//���Ϸ� ���� 1byte�� �о�鿩 ���Ͽ� 1byte�� �����ϴ� ���α׷��� �ۼ�
public class Byte_IO_01 {

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
			fis = new FileInputStream("src/io_ex/Byte_IO_01.java");

			// ������ �� ��ġ�� �ִ´�. ��θ� ���� ������ ���� ������Ʈ ��ο� �����.
			fos = new FileOutputStream("byte.txt");

			// �о�鿴�� �� ���� ����
			int readData = -1;

			// read() �� ����Ʈ�� �о ������ ��ȯ = 4byte�߿��� ������ ����Ʈ �����Ѵ�.
			// ���� �����Ͱ� ������ ��� ��ȯ
			// ������ �� ������ -1�� ��ȯ�Ѵ�.
			while ((readData = fis.read()) != -1) {
				// ���Ͽ� ����.
				fos.write(readData);
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