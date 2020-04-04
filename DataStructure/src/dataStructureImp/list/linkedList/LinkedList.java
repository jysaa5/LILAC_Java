package dataStructureImp.list.linkedList;

public class LinkedList {
	
	//���� ó�� ���
	private Node head;
	
	//���� ���� ���
	private Node tail;

	//LinkedList ũ��
	private int size = 0; 
	
	//��� = ���ؽ� = ��ü 
	//������ ����, ���� ��尡 �������� �����ؾ� ��.
	private class Node{
		
		private Object data; 
		
		//���� ����� ����
		private Node next;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
		
	}
	
	//���� �տ� ��� �߰��ϴ� �޼���
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		
		//���� ������� ��尡 ������ ����� �ּҸ� head�� �����ؼ� �˰� �ȴ�.
		newNode.next = head;
		
		//head�� ������ ��带 ����Ų��.
		head = newNode;
		//����Ʈ ������ ����
		size ++;
		
		//��ü ��尡 1���϶�: tail�� ��带 �����Ѿ� �Ѵ�.
		if(head.next == null ) {
			tail = head;
		}
	}
	
}
