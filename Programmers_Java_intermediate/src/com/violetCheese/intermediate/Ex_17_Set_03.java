package com.violetCheese.intermediate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex_17_Set_03 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");

		Iterator<String> iter = set.iterator();
		// iter�� �̿��ؼ� set�� ������ ����ϼ���.

		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}
}
