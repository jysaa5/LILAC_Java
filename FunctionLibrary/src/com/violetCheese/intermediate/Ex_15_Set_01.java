package com.violetCheese.intermediate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//set�� �ߺ��� ����, ������ ���� �ڷᱸ��. Hashset�� TreeSet�� �ִ�.
public class Ex_15_Set_01 {
	public static void main(String[] args) {

		// Set �������̽� �̹Ƿ� new�� ������ �� ����.
		// Set�� ������ Ŭ������ HashSet���� new ����
		// ���׸����� String�� �����ϰ� ��.
		Set<String> set1 = new HashSet<>();

		// �����Ҷ����� boolean���� ��ȯ�Ѵ�.
		boolean flag1 = set1.add("kim");
		boolean flag2 = set1.add("joo");
		boolean flag3 = set1.add("kim");

		// �ڷᱸ���� ũ�⸦ �˾ƺ����� �޼���: size()
		System.out.println(set1.size());

		System.out.println(flag1);
		System.out.println(flag2);
		System.out.println(flag3); // �ߺ��ǹǷ� false

		// set���� ����ִ� ������ �ϳ��� �������� Set�� �θ� Ŭ������ Collection�� ������ �ִ�
		// Iterator �������̽��� �̿��Ѵ�.

		// �ϳ��� �������� ���ؼ� Iterator ����
		// Iterator �������̽��� ������ ��ü ����
		Iterator<String> iter = set1.iterator();

		// �����Ͱ� �ִ� ���ȿ��� true�̴�.
		while (iter.hasNext()) {
			// �ϳ��� ������ �ڵ����� ���� ������ ����.
			String str = iter.next();
			System.out.println(str);
		}

	}
}
