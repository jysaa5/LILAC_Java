package com.violetCheese.intermediate;

import java.util.ArrayList;
import java.util.List;

public class Ex_18_List_01 {
	public static void main(String[] args) {
		// List�� �������̽��̱� ������ new�� ���� �Ұ���
		// �׷��Ƿ� ArrayList Ŭ������ �����Ѵ�.
		// String�� �޴� �ڷ� ������ ������.
		List<String> list = new ArrayList<>();

		// �� �ֱ�
		list.add("kim");
		list.add("joo");
		list.add("kim");

		// �÷����� ������ �ִ� �޼���: size()
		System.out.println(list.size());

		// ����Ʈ�� �ߺ��� ���� ���� ���� ����Ѵ�.
		// ����Ʈ�� ������ ����ؼ� index ��� ����
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}

	}
}
