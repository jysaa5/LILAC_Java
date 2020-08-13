package chapter11.collections.framework;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

// p.602
public class LinkedList_02 {
	
	// add �޼���
	public static void add(List list) {
		for(int i=0; i<100000; i++) {
			list.add(i+"");
		}
	}
	
	// access �޼���
	public static long access(List list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<10000; i++) {
			list.get(i);
		}
		
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	// main �޼���
	public static void main(String[] args) {
		ArrayList al = new ArrayList(1000000);
		LinkedList ll = new LinkedList();
		add(al);
		add(ll);
		
		System.out.println("= ���ٽð��׽�Ʈ =");
		System.out.println("ArrayList: "+access(al));
		System.out.println("LinkedList: "+access(ll));
	}
}
