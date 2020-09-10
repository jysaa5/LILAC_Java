package chapter11.collections.framework.comparable.comparator;

import java.util.Arrays;
import java.util.Comparator;

// p.629
public class Comparator_02 {
	
	public static void main(String[] args) {
		
		String[] strArr = {"cat", "Dog", "lion", "tiger"};
		
		// String�� Comparable ������ ���� ����
		Arrays.sort(strArr); 
		System.out.println("strArr = "+Arrays.toString(strArr));
		
		// ��ҹ��� ���� ����.
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
		System.out.println("strArr = "+Arrays.toString(strArr));
		
		// ���� ����
		Arrays.sort(strArr, new Descending());
		System.out.println("strArr= "+Arrays.toString(strArr));
		
	}

}

class Descending implements Comparator{
	
	public int compare(Object o1, Object o2) {
		
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			
			// -1�� ���ؼ� �⺻ ���� ����� ������ �����Ѵ�.
			// �Ǵ� c2.compareTo(c1)�� ���� ������ �ٲ㵵 �ȴ�.
			return c1.compareTo(c2)*-1;
		}
		
		return -1;
		
	}
}