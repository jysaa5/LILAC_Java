package chapter11.collections.framework;

import java.util.Comparator;

public class DescComp implements Comparator{
	
	public int compare(Object o1, Object o2) {
		if(!(o1 instanceof Integer)) {
			return -1;
		}
		
		if(!(o2 instanceof Integer)) {
			return -1;
		}
		
		Integer i = (Integer)o1;
		Integer i2 = (Integer)o2;
		
		//return i.compareTo(i2)* -1; // �⺻ ���Ĺ���� �ݴ�
		
		return i2.compareTo(i);  // �⺻ ���Ĺ���� �ݴ�
	}
}

