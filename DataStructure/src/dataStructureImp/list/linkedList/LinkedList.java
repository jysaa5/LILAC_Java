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
	
	//����Ʈ�� ������ �ִ� ������ ���
	public String toString() {
		
		//����Ʈ�� �����Ͱ� ���� ��.
		if(head == null) {
			return "[]";
		}
		
		Node temp = head;
		String str = "[";
		
		while (temp.next != null) {
			//������: ,
			str += temp.data + ",";
			temp = temp.next;
			
		}
		
		str += temp.data;
		
		return str+"]";
	}
	
	//removeFirst: ù ��° ��� ����
	//������ ���� �޼���
	//�����Ͱ� �����Ǹ� ���� �ִ� ������ ���� ��ȯ�Ѵ�.
	public Object removeFirst() {
		//head ���� temp�� �ִ´�.
		Node temp = head;
		//head�� ���� ��带 ����Ű�� �Ѵ�.
		head = head.next;
		
		//������ ����� ������ �� ����
		Object returnData = temp.data;
		temp = null;
		//����Ʈ ������ ���ҽ�Ų��.
		size --;
		
		return returnData;
	}
	
	//remove: ����Ʈ�� �ε����� �ش��ϴ� ��带 �����ϴ� �޼���
	//k: index(�ε���)
	public Object remove(int k) {
		
		//����Ʈ�� �ε��� 0�� ��.
		if(k == 0) {
			return removeFirst();
		}
		
		//����Ʈ ������ ��, ���� ��带 �˾ƾ� �ȴ�. ���� ��忡�� next���� �ٲ���� �ϱ� �����̴�.
		//���� = ��ũ�� �������ٴ� �ǹ�
		//������ ����� ���� ���
		Node temp = node(k-1);
		//������ ���
		Node todoDeleted = temp.next;
		temp.next = temp.next.next;
		
		Object  returnData = todoDeleted.data;
		
		//������ ��尡 ���� ������ ��� �϶�
		if(todoDeleted == tail) {
			tail = temp;
		}
		
		todoDeleted = null;
		//������ ����
		size --;
		return returnData;

	}
	
	//removeLast: ����Ʈ�� �� ������ ��带 �����ϴ� �޼���
	public Object removeLast() {
		
		return remove(size-1);
	}
	
	//size: ����Ʈ�� ���̸� ��ȯ�ϴ� �޼���
	public int size() {
		return size;
	}

	//get: ����Ʈ �ε����� �ش��ϴ� ����� ������ ���� ��ȯ�ϴ� �޼���
	//k: ����Ʈ index
	public Object get(int k) {
		Node temp = node(k);
		
		return temp.data;
	}
	
	//indexOf: �����Ͱ� ����Ʈ������ ��ġ�� ��ȯ�ϴ� �޼���
	public Object indexOf(Object data) {
		Node temp = head;
		int index = 0;
		
		//���� temp�� ���� ���ڷ� �����ͷ� ���� �������� ���� ���� �ʴٸ� �ݺ�
		while(temp.data != data) {
			temp = temp.next;
			index ++;
			//������ ��忡 ���������� ���ڷ� ���� �����Ͱ� ���� ��.
			if(temp ==null) {
				return -1;
			}
		}
		return index;
	}
	
	
	//listIterator: ListIterator ��ü�� �����ؼ� ��ȯ�ϴ� �޼���
	public ListIterator listIterator() {
	
		return new ListIterator();
	
	}//listIterator ����
	
	
	//ListIterator Ŭ����
	public class ListIterator{
		
		//next ����: ù��° ��Һ��� ������ ��ұ��� ���ʴ�� ����Ų��.
		private Node next;
		//lastReturned ����: ��ȯ�� �� 
		private Node lastReturned;
		//nextIndex ����: next������ ����Ű�� �ִ� ����� �ε���
		private int nextIndex;
		
		//������
		ListIterator(){
			next = head;
		}
		
		//next �޼���: ù��°�� ����� ���� ��ȯ�ǰ� �� ���� next�� ȣ������ ��, ���ϵ� ���� ����Ų��.
		//next �޼��尡 ȣ��� ������ ����Ʈ�� ���� ��ȯ�ȴ�.
		public Object next() {
			
			lastReturned = next;
			next = next.next;
			nextIndex ++;
			
			return lastReturned.data;
		}
		
		//hasNext: ���� next ������ null���� �ȴ��� true �Ǵ� false�� ��ȯ�ϴ� �޼���
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		//add: ��� ����
		public void add(Object input) {
			Node newNode = new Node(input);
			
			//�� ó���� ��尡 ���� �� ��.next�� ������ ����߿��� �� ó���� ����Ų��.
			//lastReturned�� null �����̴�.
			if(lastReturned==null) {
			
				head = newNode;
				newNode.next = next;
			
				//�߰��� ����
			}else {
				
				lastReturned.next = newNode;
				newNode.next = next;
			
			}
			lastReturned = newNode;
			nextIndex ++;
			size ++;
		}
		
		//remove: ��� ���� = ������ �����ϴ� ���� �ǹ��Ѵ�.
		public void remove() {
			
			// next�� �ѹ��� ȣ�� ���� �ʾ��� �� = �ƹ��� ��Ҹ� �������� ���� ���� = next�� ù��° ��带 ����ų ��
			if(nextIndex == 0) {
				throw new IllegalStateException();
			}
			
			//����
			//lastReturned�� ���� ���� �Ѵ�.
			//������ �� �۾��� node�� ã�� �۾��� �ٽ� �Ѵ�. = ��ȿ�����̴�.
			LinkedList.this.remove(nextIndex-1);
			
			nextIndex --;
			
		
		}
		
	}//ListIterator ����
	
}//LinkedList ����