package convert.list.array;

//Array �� List (�迭���� ����Ʈ�� ��ȯ)

import java.util.*;
public class Convert_from_Array_to_List_02 {
	public static void main(String[] args) {
		
		String[] strArr = {"a", "b", "c"};
		ArrayList<String> strList = new ArrayList<String>();
		Collections.addAll(strList, strArr);
		
		// �迭�� �ּҰ� ���
		System.out.println(strArr);
		// ����Ʈ�� ���Ұ� ���
		System.out.println(strList);
		// [a, b, c]
		
		Iterator<String> iter = strList.iterator();
		
		while(iter.hasNext()) {
			
			System.out.println(iter.next());
		}
	}
}
