package com.violetCheese.basicJava;

//���׸� ���� ���: Ŭ���� ���ʿ� < > 
//<E>�� ������ ���� �ƴϴ�.
public class Ex_12_Box_02<E> {
	private E obj;

	// set �޼���
	public void setObj(E obj) {
		this.obj = obj;

	}

	// get �޼���
	public E getObj() {
		return obj;
	}

}
//�ڽ��� ���� Ŭ���� E�� ����ϰڴٴ� �ǹ�.
//E�� ������ �����ϴ� Ŭ������ �ƴϴ�.
//�����Ҷ��� �������� ����� ���� ����Ҷ��� ��ü������ ���ؼ� �����. 