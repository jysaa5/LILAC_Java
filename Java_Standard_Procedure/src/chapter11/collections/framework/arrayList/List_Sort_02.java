package chapter11.collections.framework.arrayList;

// List �����ϱ�

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class List_Sort_02 {
	
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(2354);
		intList.add(5);
		intList.add(99999);
		intList.add(-50);
		
		// ���� ����
		Collections.sort(intList);
		System.out.println("Collections.sort: ");
		for(int n: intList) {
			System.out.println(n);
		}
		
		System.out.println("====================");
		
		// ���� ����
		Collections.sort(intList, Collections.reverseOrder());
		System.out.println("Collections.reverseOrder()");
		for(int n: intList) {
			System.out.println(n);
		}
		
	}

}
