package com.violetCheese.basicJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Char ���� �����(Console)
public class Ex_34_Char_IO {

	public static void main(String[] args) {

		// BufferedReader: �� �پ� �Է� �ޱ�
		// �Է��� ���� �κ� Ű����: System.in
		// Reader�� �ٲ��ִ� �κ�: InputStreamReader
		// Decorator Pattern: ���ڷ����� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;

		try {

			// ���ܰ� �߻���
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(line);

	}

}
