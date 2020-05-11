package imp.list.doubly.linked.list;

//���߿��� ����Ʈ
//����� ���� ����Ʈ
//Java collection Framework�� ���Ḯ��Ʈ = doubly linked list �̴�.
public class DoublyLinkedList {

	// ���� ó�� ���
	private Node head;

	// ���� ���� ���
	private Node tail;

	// LinkedList ũ��
	private int size = 0;

	// ��� = ���ؽ� = ��ü
	// ������ ����, ���� ��尡 �������� �����ؾ� ��.
	private class Node {

		private Object data;

		// ���� ����� ����
		private Node next;

		// ���� ����� ����
		private Node prev;

		public Node(Object input) {
			this.data = input;
			this.next = null;
			this.prev = null;
		}

		public String toString() {
			return String.valueOf(this.data);
		}

	}

	// addFirst: ���� �տ� ��带 �߰��ϴ� �޼���
	// DoublyLinkedList�� ���� ���� ���� ����� ������ ��� ���� �ִ�.
	public void addFirst(Object input) {
		Node newNode = new Node(input);

		// ���� ������� ��尡 ������ ����� �ּҸ� head�� �����ؼ� �˰� �ȴ�.
		newNode.next = head;

		// head�� null�� �ƴҶ�: �� ó�� �߰��Ǵ� ��尡 �ƴ� ����.
		if (head != null) {
			// ������ �� ó�� ����� ������带 ���Ӱ� �߰��� ��带 ����Ų��.
			head.prev = newNode;
		}

		// head�� ���Ӱ� �߰��� ��带 ����Ų��.
		head = newNode;
		// ����Ʈ ������ ����
		size++;

		// ��ü ��尡 1���϶�: tail�� ��带 �����Ѿ� �Ѵ�.
		if (head.next == null) {
			tail = head;
		}
	}

	// addLast: ���� �ڿ� ��带 �߰��ϴ� �޼���
	public void addLast(Object input) {

		Node newNode = new Node(input);

		// size = 0 �̸� �����Ͱ� �ƿ� ���� �����̴�. �տ��� �ְ� �ڿ��� �ְ� �Ȱ����Ƿ�.
		// �����Ͱ� �ƿ� ���� ���� tail�� �����Ƿ� addFirst �޼��带 ����Ѵ�.
		if (size == 0) {
			addFirst(input);
		} else {

			// tail: ���� �ڿ� �ִ� ���
			// ���� tail ����� ���� ��尡 ���� ������ ����̴�.
			tail.next = newNode;

			// ���� �߰��� ����� ���� ���� �߰� �ϱ� ������ �� ������ ���� ����Ų��.
			newNode.prev = tail;

			// �׸��� tail�� ���� ���� ��尡 �ȴ�.
			tail = newNode;
			size++;

		}

	}

	// ���������θ� ���� API
	// �׽�Ʈ�� ���ؼ� public���� ����
	// public Node node(int index){}
	// ���������θ� ���Ǿ�� �ϹǷ� public�� �����Ѵ�.
	// node �޼���: head���� �޿� ã�� ��
	Node node(int index) {

		// ��ü ũ��� ã������ �ϴ� ��ġ�� �Ǻ�
		// head�������� ã��
		if (index < size / 2) {
			// head�� ���� ã�ƾ� �ȴ�.
			Node x = head;

			for (int i = 0; i < index; i++) {

				x = x.next;

			}
			return x;

			// tail���� ã��
		} else {

			Node x = tail;

			for (int i = size - 1; i > index; i--) {

				x = x.prev;

			}
			return x;
		}

		// �� ��°
		// x = x.next;

		// ����°
		// x = x.next;

	}

	// k: �߰��Ϸ��� �ϴ� ����� ����Ʈ���� index��
	// add: �߰��� ��带 ���� = ���� ��带 �˾ƾ� �ȴ�. �׷��� ���Ե� ��尡 ���� ��带 ����ų�� �ִ�.
	public void add(int k, Object input) {
		// �����Ͱ� �ƹ��͵� ���� ��
		if (k == 0) {

			addFirst(input);

		} else {

			// ���Ե� ��� ��ġ�� ���� ���
			Node temp1 = node(k - 1);
			// ���Ե� ����� ���� ���
			Node temp2 = temp1.next;
			// ���ο� ��� �߰�
			Node newNode = new Node(input);

			// ���ο� ����� ���� ����� ������ ���ο� ���� ����
			temp1.next = newNode;

			// ���ο� ����� ���� ��带 ���� ��ġ�� ���� ����
			newNode.next = temp2;

			// temp2�� ���� ��
			if (temp2 != null) {

				// ���� �߰��� ����� ���� ��尡 ���ο� ��带 ����Ű���� ����
				temp2.prev = newNode;

			}

			// ���ο� ����� ���� ���� ���� ��带 ����Ű�� ����
			newNode.prev = temp1;

			size++;

			// ������ ��尡 �� ������ ����� ��
			if (newNode.next == null) {

				tail = newNode;

			}

		}
	}

	// ����Ʈ�� ������ �ִ� ������ ���
	public String toString() {

		// ����Ʈ�� �����Ͱ� ���� ��.
		if (head == null) {
			return "[]";
		}

		Node temp = head;
		String str = "[";

		while (temp.next != null) {
			// ������: ,
			str += temp.data + ",";
			temp = temp.next;

		}

		str += temp.data;

		return str + "]";
	}

	// ������ ���� �޼���
	// �����Ͱ� �����Ǹ� ���� �ִ� ������ ���� ��ȯ�Ѵ�.
	// removeFirst: ù ��° ��� �����ϴ� �޼���
	public Object removeFirst() {
		// head ���� temp�� �ִ´�.
		Node temp = head;
		// head�� ���� ��带 ����Ű�� �Ѵ�.
		head = head.next;

		// ������ ����� ������ �� ����
		Object returnData = temp.data;
		temp = null;

		if (head != null) {
			head.prev = null;
		}

		// ����Ʈ ������ ���ҽ�Ų��.
		size--;

		return returnData;
	}

	// k: index(�ε���)
	// remove: ����Ʈ�� �ε����� �ش��ϴ� ��带 �����ϴ� �޼���
	public Object remove(int k) {

		// ����Ʈ�� �ε��� 0�� ��.
		if (k == 0) {
			return removeFirst();
		}

		// ����Ʈ ������ ��, ���� ��带 �˾ƾ� �ȴ�. ���� ��忡�� next���� �ٲ���� �ϱ� �����̴�.
		// ���� = ��ũ�� �������ٴ� �ǹ�
		// ������ ����� ���� ���
		Node temp = node(k - 1);
		// ������ ���
		Node todoDeleted = temp.next;

		// temp�� ���� ��� = temp�� ��������� ���� ���
		temp.next = temp.next.next;

		// temp�� ���� ��尡 ���� ��
		if (temp.next != null) {

			temp.next.prev = temp;

		}

		Object returnData = todoDeleted.data;

		// ������ ��尡 ���� ������ ��� �϶�
		if (todoDeleted == tail) {
			tail = temp;
		}

		todoDeleted = null;
		// ������ ����
		size--;
		return returnData;

	}

	// removeLast: ����Ʈ�� �� ������ ��带 �����ϴ� �޼���
	public Object removeLast() {

		return remove(size - 1);
	}

	// size: ����Ʈ�� ���̸� ��ȯ�ϴ� �޼���
	public int size() {
		return size;
	}

	// get: ����Ʈ �ε����� �ش��ϴ� ����� ������ ���� ��ȯ�ϴ� �޼���
	// k: ����Ʈ index
	public Object get(int k) {
		Node temp = node(k);

		return temp.data;
	}

	// indexOf: �����Ͱ� ����Ʈ������ ��ġ�� ��ȯ�ϴ� �޼���
	public Object indexOf(Object data) {
		Node temp = head;
		int index = 0;

		// ���� temp�� ���� ���ڷ� �����ͷ� ���� �������� ���� ���� �ʴٸ� �ݺ�
		while (temp.data != data) {
			
			temp = temp.next;
			index++;
			
			// ������ ��忡 ���������� ���ڷ� ���� �����Ͱ� ���� ��.
			if (temp == null) {
				
				return -1;
				
			}
		}
		return index;
	}

	// listIterator: ListIterator ��ü�� �����ؼ� ��ȯ�ϴ� �޼���
	public ListIterator listIterator() {

		return new ListIterator();

	}// listIterator ����

	// ListIterator Ŭ����
	public class ListIterator {

		// next ����: ù��° ��Һ��� ������ ��ұ��� ���ʴ�� ����Ų��.
		private Node next;
		// lastReturned ����: ��ȯ�� ��
		private Node lastReturned;
		// nextIndex ����: next������ ����Ű�� �ִ� ����� �ε���
		private int nextIndex;

		// ������
		ListIterator() {
			next = head;
		}

		// next �޼���: ù��°�� ����� ���� ��ȯ�ǰ� �� ���� next�� ȣ������ ��, ���ϵ� ���� ����Ų��.
		// next �޼��尡 ȣ��� ������ ����Ʈ�� ���� ��ȯ�ȴ�.
		public Object next() {

			lastReturned = next;
			next = next.next;
			nextIndex++;

			return lastReturned.data;
		}

		// hasNext: ���� next ������ null���� �ȴ��� true �Ǵ� false�� ��ȯ�ϴ� �޼���
		public boolean hasNext() {
			return nextIndex < size();
		}

		// add: ��� ����
		public void add(Object input) {
			Node newNode = new Node(input);

			// �� ó���� ��尡 ���� �� ��.next�� ������ ����߿��� �� ó���� ����Ų��.
			// lastReturned�� null �����̴�.
			if (lastReturned == null) {

				head = newNode;
				newNode.next = next;

				// �߰��� ����
			} else {

				lastReturned.next = newNode;
				newNode.prev = lastReturned;

				if (next != null) {

					newNode.next = next;
					next.prev = newNode;

				} else {

					tail = newNode;

				}

			}

			lastReturned = newNode;
			nextIndex++;
			size++;
		}

		// ����
		// lastReturned�� ���� ���� �Ѵ�.
		// remove: ��� ���� = ������ �����ϴ� ���� �ǹ��Ѵ�.
		public void remove() {

			// next�� �ѹ��� ȣ�� ���� �ʾ��� �� = �ƹ��� ��Ҹ� �������� ���� ���� = next�� ù��° ��带 ����ų ��
			if (nextIndex == 0) { // lastReturned == null �� ���� ����

				throw new IllegalStateException();

			}

			// lastReturned�� ���� ���
			Node n = lastReturned.next;

			// lastReturned�� ���� ���
			Node p = lastReturned.prev;

			//���� ù ��° ��� ������ 
			if (p == null) {
				
				head = n;
				head.prev = null;
				lastReturned = null;
				
			} else {
				
				p.next = next;
				lastReturned.prev = null;
				
			}
			
			//�߰� ��� ������
			if (n == null) {
				
				tail = p;
				tail.next = null;
				
			} else {
				
				n.prev = p;
				
			}

			//������ ��� ������
			if (next == null) {
				
				lastReturned = tail;
			
			} else {

				lastReturned = next.prev;
			}
			
			size--;
			nextIndex--;

		}

		// previous �޼���: ���� ��� Ž���ϴ� �޼���
		public Object previous() {

			// next�� Ž���� ��� ���� ����
			if (next == null) {

				lastReturned = next = tail;

			} else {
				lastReturned = next = next.prev;
			}

			nextIndex--;

			return lastReturned.data;
		}

		// previous�� ȣ�� �ص� �Ǵ°�. ���� ��尡 �ִ°�.
		// hasPrevious �޼���: nextIndex�� ���ؼ� �����ȴ�.
		public boolean hasPrevious() {
			return nextIndex > 0;
		}

	}// ListIterator ����

}// LinkedList ����