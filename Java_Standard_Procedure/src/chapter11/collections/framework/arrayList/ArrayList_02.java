package chapter11.collections.framework.arrayList;

import java.util.ArrayList;
import java.util.List;

// p.587
public class ArrayList_02 {
	
	public static void main(String[] args) {
		
		// �ڸ����� �ϴ� ������ ������ �����Ѵ�.
		final int LIMIT = 10;
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();
		
		// ũ�⸦ �ణ ���� �ְ� ��´�.
		List list = new ArrayList(length/LIMIT+10);
		
		for(int i=0; i<length; i+=LIMIT) {
			if(i+LIMIT<length) {
				list.add(source.substring(i, i+LIMIT));
			}else {
				list.add(source.substring(i));
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}//main()

}
