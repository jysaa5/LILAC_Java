package make.sort;

import java.util.Arrays;

// 1.���ڿ� ������������ ��ġ�ϱ�. ���� ��ҹ��ڷθ� �����Ǹ�, �빮�ڴ� �ҹ��ں��� �۴�. Zbcdefg -> gfedcbZ
// 3)solution
public class Ex_String_SortDes_03 {
	public String sortDesStr(String str) {
		//���ڿ��� ���ڷ� �ɰ��� �迭�� ����
		char[] sol = str.toCharArray();
		//���� ������������ ����
		Arrays.sort(sol);
		//���� �迭�� String���� ���� -> StringBuilder�� ���� -> ���� ���� -> toString���� ���
		return new StringBuilder(new String(sol)).reverse().toString();
	}

	
	// test
	public static void main(String[] args) {
		Ex_String_SortDes_03 strSd = new Ex_String_SortDes_03();
		System.out.println(strSd.sortDesStr("Zbcdefg"));
	}
	
}
