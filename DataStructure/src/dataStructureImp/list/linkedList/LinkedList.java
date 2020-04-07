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
	
	//���� �տ� ��带 �߰��ϴ� �޼���
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
	
	//���� �ڿ� ��带 �߰��ϴ� �޼���
	public void addLast(Object input) {
		
		Node newNode = new Node(input);
		
		//size = 0 �̸� �����Ͱ� �ƿ� ���� �����̴�. �տ��� �ְ� �ڿ��� �ְ� �Ȱ����Ƿ�.
		//�����Ͱ� �ƿ� ���� ���� tail�� �����Ƿ� addFirst �޼��带 ����Ѵ�.
		if(size == 0) {
			addFirst(input);
		}else {
			
			//tail: ���� �ڿ� �ִ� ��� 
			//���� tail ����� ���� ��尡 ���� ������ ����̴�.
			tail.next = newNode;
			//�׸��� tail�� ���� ���� ��尡 �ȴ�.
			tail = newNode;
			size ++;
		
		}
		
	}
	
	//���������θ� ���� API
	//�׽�Ʈ�� ���ؼ� public���� ����
	//public Node node(int index){}
	//���������θ� ���Ǿ�� �ϹǷ� public�� �����Ѵ�.
	Node node(int index) {
		
		//head�� ���� ã�ƾ� �ȴ�.
		Node x = head;
		
		//�� ��°
		//x = x.next;
		
		//����°
		//x = x.next;
		
		for(int i =0; i<index; i++) {
			
			x = x.next;
		
		}
		return x;
	}
	
	//k: �߰��Ϸ��� �ϴ� ����� ����Ʈ���� index��
	//add: �߰��� ��带 ���� = ���� ��带 �˾ƾ� �ȴ�. �׷��� ���Ե� ��尡 ���� ��带 ����ų�� �ִ�.
	public void add(int k, Object input) {
		//�����Ͱ� �ƹ��͵� ���� ��
		if(k == 0) {
			
			addFirst(input);
		
		}else {
			
			//���Ե� ����� ���� ���
			Node temp1 = node(k-1);
			//���Ե� ����� ���� ���
			Node temp2 = temp1.next;
			//���ο� ��� �߰�
			Node newNode = new Node(input);
			temp1.next = newNode;
			newNode.next = temp2;
			size ++;
			
			//������ ��尡 �� ������ ����� ��
			if(newNode.next ==null) {
				tail = newNode;
			}
		
		}
	}
	
}//LinkedList ����