package set_ex;

import java.util.HashSet;
import java.util.Set;

public class Set_02 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("a");
		set.add("b");

		System.out.println("set�� ������ ����մϴ�.");

		// for each�����ε� ��� ����
		for (String str : set) {
			System.out.println(str);
		}
	}
}
