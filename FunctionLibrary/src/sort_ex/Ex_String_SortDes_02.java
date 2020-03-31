package sort_ex;

import java.util.Arrays;
import java.util.Collections;

// 1.���ڿ� ������������ ��ġ�ϱ�. ���� ��ҹ��ڷθ� �����Ǹ�, �빮�ڴ� �ҹ��ں��� �۴�. Zbcdefg -> gfedcbZ
// 2)solution
public class Ex_String_SortDes_02 {
	public String sortDesStr(String str) {
		//���ڿ��� ���ڷ� �ɰ��� ���� �迭 ����
		String[] array = str.split("");
		//�迭 ������ ������ Comparator�� ������ �Ѵ�.
		Arrays.sort(array, Collections.reverseOrder());
		//���ڿ��� �迭 ���̱�
		return String.join("", array);
	}

	// test
	public static void main(String[] args) {
		Ex_String_SortDes_02 strSd = new Ex_String_SortDes_02();
		System.out.println(strSd.sortDesStr("Zbcdefg"));
	}
	
}
