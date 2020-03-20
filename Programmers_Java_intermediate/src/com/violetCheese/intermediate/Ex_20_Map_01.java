package com.violetCheese.intermediate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Map: key�� value�� ������ �����͸� ����ȴ�.
//key�� �̿��ؼ� value�� ã���� �ֵ��� ����Ǿ���.
public class Ex_20_Map_01 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();

		// Map�� ���� �ֱ�
		map.put("001", "kim");
		map.put("002", "lee");
		map.put("003", "choi");

		// �ߺ��� Ű�� �־��
		map.put("001", "kang");

		// �ߺ��� Ű ���� �ߺ����� üũ ���� �ʴ´�.
		System.out.println(map.size());

		// �������� ������ ������ �ٲ��.
		System.out.println(map.get("001"));

		System.out.println(map.get("002"));

		// ��� key���� Set�� �ִ´�.
		Set<String> keys = map.keySet();

		// Iterator �������̽� ����. iterator()�޼���� �� ���� ������ �ִ� ��ü ����
		Iterator<String> iter = keys.iterator();

		// �� �������� ���������� �ݺ�
		while (iter.hasNext()) {
			// �Ѱ��� ������
			String key = iter.next();
			// key���� ���� value�� ������
			String value = map.get(key);
			System.out.println(key + ":" + value);
		}

	}
}
