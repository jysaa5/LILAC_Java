package chapter11.collections.framework.arrays;

import java.util.Arrays;

// Arrays.toString() �޼���
public class ArraysMethod_toString {
	public static void main(String[] args) {
		
		String[] str = {"a", "b", "c"};
		
		// �迭�� �ּҰ� ���
		System.out.println(str.toString());
		
		// �迭�� ���� ���
		System.out.println(Arrays.toString(str));
		
		String s = Arrays.toString(str);
		
		// �迭�� ���ȣ, �޸�, ������� ��� �� ���ڿ��� ��ȯ�Ǿ���.
		for(int i=0; i<s.length(); i++) {
			System.out.println(s.charAt(i));
		}
		
	}

}
