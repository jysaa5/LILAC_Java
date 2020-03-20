package com.violetCheese.intermediate;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Ex_36_Char_IO {
	public static void main(String[] args) {
		PrintWriter pw = null;

		try {
			pw = new PrintWriter(new FileWriter("data.txt"));
			pw.println("�ȳ��ϼ���.PrintWriter�Դϴ�.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			pw.close();
		}

		System.out.println("�ȳ��ϼ���. PrintWriter�Դϴ�.");

	}
}
