package com.violetCheese.codeUp_1081_1090;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CodeUp_basics_1084 {

	// ���� �޼���
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);

		int r = s.nextInt();
		int g = s.nextInt();
		int b = s.nextInt();

		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < g; j++) {
				for (int k = 0; k < b; k++) {

					String st = i + " " + j + " " + k;
					bf.write(st + "\n");
					//������ flush�� ����� �Ǵµ� �ð��ʰ��� �ڲ� �ɷ��� ü���� �ȵ�.
					//bf.flush();
				}
			}
		}
		bf.write(Integer.toString(r * g * b));
		bf.close();
		s.close();
		
	}// ���� �޼���

}// CodeUp_basics_1084 Ŭ���� ��
