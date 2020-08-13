package chapter11.collections.framework;

import java.util.EmptyStackException;
import java.util.Vector;

// p.606
public class Stack_01 extends Vector {
	
	public Object push(Object item) {
		addElement(item);
		return item;
	}
	
	
	public Object pop() {
		//  Stack�� ����� ������ ��Ҹ� �о�´�.
		Object obj = peek();
		
		// ���� Stack�� ��� ������ peek() �޼��尡 EmptyStackException�� �߻���Ų��.
		// ������ ��Ҹ� �����Ѵ�. �迭�� index 0 ���� �����ϹǷ� 1�� ���ش�.
		
		removeElementAt(size() - 1);
		return obj;
	}
	
	
	public Object peek() {
		
		int len = size();
		
		if(len == 0) {
			throw new EmptyStackException();
		}
		
		// ������ ��Ҹ� ��ȯ�Ѵ�. �迭�� index�� 0���� �����ϹǷ� 1�� ���ش�.
		return elementAt(len-1);
	
	}
	
	
	public boolean empty() {
		return size() == 0;
	}
	
	public int search(Object o) {
		
		// ���������� ��ü�� ã�´�.
		// ��ȯ���� ����� ��ġ(�迭�� index)�̴�.
		int i = lastIndexOf(o);
		
		// ��ü�� ã�� ���
		if(i>=0) {
			// Stack�� �� ���� ����� ��ü�� index�� 1�� �����ϱ� ������ 
			// ����� ���ؼ� ���Ѵ�.
			return size() - i;
		}
		
		return -1;
		
	}

}
