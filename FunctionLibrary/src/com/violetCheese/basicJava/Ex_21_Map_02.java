package com.violetCheese.basicJava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Ex_21_Map_02 {
	public Map<String, Integer> makeMap() {
		Map<String, Integer> products = new HashMap<>();
		// ��ǰ�� �̸��� ���� products�� �߰��� ������.
		products.put("����", 2500);
		products.put("ũ���Ľ�", 5000);

		return products;
	}

	public static void main(String[] args) {
		Ex_21_Map_02 mapClass = new Ex_21_Map_02();
		Set<String> keys = mapClass.makeMap().keySet();
		Iterator<String> iter = keys.iterator();

		for (String str : keys) {
			System.out.println(mapClass.makeMap().get(str));
		}

	}

}
