package com.violetCheese.sort;

import java.util.Arrays;
import java.util.Collections;

//1.���ڿ� ������������ ��ġ�ϱ�. ���� ��ҹ��ڷθ� �����Ǹ�, �빮�ڴ� �ҹ��ں��� �۴�. Zbcdefg -> gfedcbZ
//1)solution
public class Ex_String_SortDes_01 {

	public String sortDesStr(String str) {
		//���ڿ��� ���� 1���� �ɰ��� �迭�� �Ѱ��� �ֱ�
		String[] array = str.split("");
		//�迭�� ���� ���ڵ��� ������������ ����
		Arrays.sort(array);
		//�迭�� ArrayList�� ��ȯ�ϰ� Collections Ŭ�������� �⺻������ �����ϴ� static �޼����� reverse�� ���� �迭 �������� ����
		Collections.reverse(Arrays.asList(array));
		//���ڹ迭�� ""�� �߰��ؼ� ���̱�
		return String.join("", array);
		
	}
	
	
	
	//test
	public static void main(String[] args) {
		Ex_String_SortDes_01 strSd = new Ex_String_SortDes_01();
		System.out.println(strSd.sortDesStr("Zbcdefg"));
	}
	
}
