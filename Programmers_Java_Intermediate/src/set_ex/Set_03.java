package set_ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set_03 {
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
