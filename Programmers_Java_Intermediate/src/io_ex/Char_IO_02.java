package io_ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Char_IO_02 {

	public static void main(String[] args) {

		// �� �پ� �б�
		BufferedReader br = null;

		// ��� (����)
		PrintWriter pw = null;

		try {
			// ���Ͽ��� �б�
			// ���: ���� ������Ʈ�� �⺻ ����̴�.
			// FileReader ���� ó�� �ʿ�
			br = new BufferedReader(new FileReader("src/io_ex/Char_IO_02.java"));

			// PrintWriter ��ü�� ������ �޾Ƶ��ϼ� �ִ�. �׷��Ƿ� PrintWriter �� ���� ��� ����.
			// ���
			// println�� PrintWriter�� �޼���
			pw = new PrintWriter(new FileWriter("test.txt"));

			// ���� �б�
			// �� �� �а� �����ϱ� ���� ��ü: line
			String line = null;
			// ������ ���� �Ǹ� null�� �ȴ�.
			while ((line = br.readLine()) != null) {
				pw.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();

			// IO�� ���� �ݾƾ� �ȴ�.
			// �ݵ�� ó���ؾ��� ������ finally �ȿ� ����.
		} finally {

			try {
				pw.close();
				br.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

}
