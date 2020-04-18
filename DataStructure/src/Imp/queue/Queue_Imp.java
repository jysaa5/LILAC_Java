package Imp.queue;

import java.util.NoSuchElementException;

// Queue(ť): ���� ���� �����͸� ���� ������ �ڷᱸ���̴�.
// FIFO: First In, First Out
// add(): �� ���� ������ �߰��ϴ� ���
// remove(): �� �տ��� �����͸� �� �� ������ ����� ���
// peek(): �� �տ� �ִ� �����͸� ���� ���
// isEmpty(): ť�� ����ִ��� Ȯ���ϴ� ���

// Queue Ŭ����
class Queue<T> {

	// Node Ŭ����
	class Node<T> {

		// ������
		private T data;
		// ���� ���
		private Node<T> next;

		// ������
		public Node(T data) {
			this.data = data;
		}

	}// Node Ŭ���� ����

	// ť�� �հ� ���� �ּҸ� �˰� �־�� �Ѵ�.
	// �� ó�� ���
	private Node<T> first;

	// �� ������ ���
	private Node<T> last;

	// add �޼���: ������ �߰�
	public void add(T item) {
	
		// ��� ����
		Node<T> t = new Node<T>(item);

		// ������ ��尡 ���� ��
		if (last != null) {
		
			last.next = t;
	
		}

		// �߰��� ��尡 �� ������ ���
		last = t;

		// ť�� ������� ��
		if (first == null) {
		
			first = last;
		
		}

	}// add �޼��� ����

	
	//remove �޼���
	public T remove() {
		
		// ť�� ��� ���� ��
		if (first == null) {
		
			throw new NoSuchElementException();
		
		}

		// ������ �ӽ� ����
		T data = first.data;
		
		// �� ó�� ����� ���� ��忡 �ִ� ���� �� ó������ �����.
		first = first.next;

		//ť�� ��� ���� ��
		if (first == null) {
		
			last = null;
		
		}
		
		return data;

	}// remove �޼��� ����

	
	// peek �޼���
	public T peek() {
		
		//ť�� ��� ���� ��
		if (first == null) {
		
			throw new NoSuchElementException();
		
		}
	
		return first.data;
	
	}// peek �޼��� ����

	
	//isEmpty �޼���
	public boolean isEmpty() {
	
		return first == null;

	}//isEmpty �޼��� ����

}//Queue Ŭ���� ����

//Queue_Imp Ŭ����
public class Queue_Imp {
	
	//main �޼���: ���� �Լ�
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
	
	}//main �Լ� ����

}//Queue_Imp Ŭ���� ����