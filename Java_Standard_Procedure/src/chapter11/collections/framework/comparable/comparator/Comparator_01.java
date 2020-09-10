package chapter11.collections.framework.comparable.comparator;

import java.util.Arrays;

// p. 628
public class Comparator_01 {
	
	public static void main(String[] args) {
		
		Integer[] arr = {30, 50, 10, 40, 20};
		
		Arrays.sort(arr); //�⺻ ���ı���(Comparable)���� ����
		System.out.println(Arrays.toString(arr));
		
		// sort(Object[] objArr, Comparator c)
		Arrays.sort(arr, new DescComp()); // DescComp�� ������ ���ı������� ����
		System.out.println(Arrays.toString(arr));
		
	}

}


