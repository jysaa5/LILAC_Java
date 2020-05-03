package Imp.stack;

import java.util.EmptyStackException;

// stack(����): �״�. �� �������� ���� �����Ͱ� �� ó���� ���´�.
// LIFO (���Լ���): Last In, First Out
// pop(): �� �������� ���� �����͸� �����鼭 ����� ���
// push(): ���ο� �����͸� �� ���� �׾� �ø��� ���
// peek(): �� ������ �����͸� ���� ���
// isEmpty(): ���ÿ� �����Ͱ� �ִ��� ������ Ȯ���ϴ� ���

//stack Ŭ���� ����
class Stack<T>{
	
	// ���� Ÿ���� �޴� ��ü
	class Node<T>{
		
		//������
		private T data;
		
		//���� ���
		private Node<T> next;
		
		//������
		public Node (T data) {
		
			this.data = data;
		
		}
		
	}//Node Ŭ���� ����
	
	// ������ �� ���� �ö� �ִ� ��ü �ּҸ� �˸� �ȴ�.
	// ���� �������� �� ���� �ִ� ������
	private Node<T> top;
	
	//pop �޼���: �� �������� ���� �����͸� �����鼭 ����� ���.
	public T pop() {
		
		//top�� �ƹ��͵� ���� ��
		if(top == null) {
			throw new EmptyStackException();
		}
		
		// ��ȯ�� ������ ����.
		T item = top.data;
		
		//�� ���� �ִ� �����͸� ��ȯ�ϱ� ����, �� ������ �ִ� �����͸� top���� ������ �Ѵ�. 
		top = top.next;
		
		return item;
		
	}//pop ����
	
	
	//push �޼���: ���ο� �����͸� �� ���� �׾� �ø��� ���
	public void push(T item) {
		
		//item�� ������ ��� ����
		Node<T> t = new Node<T>(item);
		
		//top �տ� ������ ��带 ��ġ��Ų��.
		t.next = top;
		
		//������ ��尡 top�� �ȴ�.
		top = t;
		
	}//push ����
	
	
	//peek �޼���: �� ������ �����͸� ���� ���
	public T peek() {
		
		if(top == null) {
			throw new EmptyStackException();
		}
		
		return top.data;
		
	}//peek ����
	
	
	//isEmpty �޼���: ���ÿ� �����Ͱ� �ִ��� ������ Ȯ���ϴ� ���
	public boolean isEmpty() {
		
		return top == null;
		
	}//isEmpty ����
	
}//Stack Ŭ���� ����


//Stack_Imp Ŭ����
public class Stack_Imp {

	//main �޼���: ���� �Լ�
	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
	
	}//main ����
	
}//Stack_Imp ����
