package lmp.list.linkedList.alg.digit.sol2;

//����: � ���ڸ� �ڸ������� Linked List�� ��Ҵ�.�׷��� ���� ���� �ڸ����� header�� ������ ��Ҵ�. 
//�̷����� LinkedList �� ���� �޾Ƽ� �ջ��ϰ� ���� ������ Linked List�� ��Ƽ� ��ȯ�϶�.
// 419 = 4 -> 1 -> 9
// 34  =      3 -> 4
// ���ڵ��� ���̸� ����ؼ� �ڸ����� ������ �κп� 0�� ä���.
// 419 = 4 -> 1 -> 9
// 34  = 0 -> 3 -> 4
// �ڿ������� ����Ѵ�.
// ������� carry�� ����ؾ� �Ѵ�. �հ� ����� ������ ��带 ���� �� ����.
// �׷��Ƿ� carry�� ��尡 �ִ� ��ü�� �����.
//solution: ���ȣ��

//L1:        4 -> 1 -> 9 -> null
//L2:        0 -> 3 -> 4 -> null

//��ü
//�ʱ�ȭ
//�ջ� ���: 0
//C(carry): 0
//R(Result): null

//�ջ� ���: 3
//C(carry): 1
//R(Result): 3 -> null

//�ջ� ���: 5
//C(carry): 0
//R(Result): 5 -> 3 -> null

//�ջ� ���: 4
//C(carry): 0
//R(Result): 4 -> 5 -> 3 -> null

//��� ����� ���� �Ŀ��� carry���� 0 �ʰ��϶��� �� ���� �ջ��� �Ѵ�.�� �� R �տ� �߰��Ѵ�.

class LinkedList {

	// header ���
	Node header;

	// Node Ŭ����
	static class Node {

		int data;

		Node next = null;

		// ������
		public Node() {

		}

		// ������
		public Node(int data) {

			this.data = data;

		}

	}// Node ����

	
	// Storage Ŭ����: ���꿡 �ʿ��� carry�� result�� ���� �ִ� Ŭ���� ����
	static class Storage {

		int carry = 0;
		
		//����� ���� ���
		Node result = null;

	}// Storage ����

	// ������
	LinkedList() {

		header = new Node();

	}

	
	// append �޼���: ��� ����
	void append(int d) {
		// ���ο� ��� ����
		Node end = new Node();

		end.data = d;

		// ������ ����
		Node point = header;

		// ���� ��忡�� ���� ��� ��: �� ������ ��� �� ã��
		while (point.next != null) {
			point = point.next;
		}

		// ���ο� ��� �߰�
		point.next = end;

	}// append ����

	
	// delete �޼���: ��� ����
	// head: ���� ù ��° ������� �˷��ش�.
	// ù ��° head �� ������ �����ϴ�. head�� �����ͷ� ������ �ʰ� �����뵵�θ� ���δ�.
	void delete(int d) {

		// ������ ����
		Node point = header;

		// ���� ��忡�� ���� ��� ��: �� ������ ��� ������ �ݺ�
		while (point.next != null) {

			// ���� ��忡�� ���� ��� �����Ͱ� ������ ������� �Ǵ�
			if (point.next.data == d) {

				// ���� ��忡�� ����Ű�� ���� ��带 �� ���� ���� ���� �ٲ۴�.
				point.next = point.next.next;

			} else {

				// ���� ã�� ���ؼ� ���� ���� �̵�
				point = point.next;

			}
		}

	}// delete ����

	
	// retrieve �޼���: ����Ʈ�� �ִ� �����͸� ó������ ������ �� �����ִ� �޼���
	void retrieve() {

		// point ����
		Node point = header.next;

		// ������ ��� �� �ܰ���� �ݺ�
		while (point.next != null) {

			System.out.print(point.data + "->");

			// ���� ���� �̵�
			point = point.next;

		}

		// �� ������ ��� ���
		System.out.println(point.data);

	}// retrieve ����

	
	// get �޼���
	Node get(int i) {
		Node n = header;
		for (int j = 0; j < i; j++) {
			n = n.next;
		}
		return n;
	}// get ����

	
	// sumLists: Linked List Digit �ջ� �˰��� �޼���
	// l1: LinkedList�� �ǿ�����1, l2: LinkedList�� �ǿ�����2
	// carry: �޾ƿø�
	static Node sumLists(Node l1, Node l2, int carry) {

		//ù��° LinkedList�� ����
		int len1 = getListLength(l1);
		//�ι�° LinkedList�� ����
		int len2 = getListLength(l2);

		//����Ʈ ���̰� ���̰� ���� 0�� �տ� ���δ�.
		if (len1 < len2) {
			
			l1 = LPadList(l2, len2 - len1);
			
		} else {
			
			l2 = LPadList(l2, len1 - len2);
			
		}

		//���� ����
		Storage storage = addLists(l1, l2);

		//������ ��� ���� �Ŀ��� carry�� 0�� �ƴҶ�, carry�� ��� ��� �տ� ���δ�.
		if(storage.carry != 0) {
			
			storage.result =insertBefore(storage.result, storage.carry);

		}
		
		return storage.result;
	}// sumLists ����
	
	
	//addLists: ������ �ϴ� �޼���
	static Storage addLists(Node l1, Node l2) {
		
		//LinkedList �� ������ ����.
		if (l1 == null && l2 == null) {
			
			Storage storage = new Storage();
			
			return storage;
		}
		
		Storage storage = addLists(l1.next, l2.next);
		
		//��ü ���� �� ����
		int value = storage.carry + l1.data + l2.data;
		
		//����� ����
		int data = value % 10;
		
		//��� ��忡 ��� �߰��ϱ�
		storage.result = insertBefore(storage.result, data);
		
		//ĳ���� ����
		storage.carry = value / 10;
		
		
		return storage;

	}//addLists ����

	
	// getListLength: LinkedList�� ũ�⸦ ����ϴ� �޼���
	static int getListLength(Node l) {

		int total = 0;

		// ��带 ���鼭 ���� ���� ����
		while (l != null) {

			total++;

			l = l.next;
		}

		return total;

	}// getListLength ����

	
	// insertBefore �޼���: ��� ��� �տ� ���ο� ��带 �߰��ϴ� �޼���
	static Node insertBefore(Node node, int data) {

		//�޾ƿ� ������ ������ ���ο� ��� ����
		Node before = new Node(data);

		if (node != null) {

			//����� Linked List �տ� �ֱ�
			before.next = node;

		}
		return before;
	}//insertBefore ����

	
	// LPadList �޼���: 0���� ä��� �޼���
	static Node LPadList(Node l, int length) {
		
		Node head = l;
		
		//head �տ� 0�� ���̴� �κ�
		for (int i = 0; i < length; i++) {
		
			head = insertBefore(head, 0);
		
		}
		
		return head;
		
	}//LPadList ����

}// LinkedList ����


//LinkedList_digit_sol Ŭ����
public class LinkedList_digit_sol {

	//main �޼���: ���� ���� �Լ�
	public static void main(String[] args) {

		LinkedList l1 = new LinkedList();
		l1.append(9);
		l1.append(1);
		l1.retrieve();

		LinkedList l2 = new LinkedList();
		l2.append(1);
		l2.append(1);
		l2.retrieve();

		LinkedList.Node n = LinkedList.sumLists(l1.get(1), l2.get(1), 0);
		while (n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);

	}// main ����

}// LinkedList_digit_sol ����
