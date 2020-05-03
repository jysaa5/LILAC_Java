package Imp.list.linkedList.alg.deleteNode;

//�ܹ��� Linked List���� �߰��� �ִ� ��带 �����Ͻÿ�. ��, ����� ù��° ��尡 ������� �𸣰�,
//���� ������ ��常 ���� �ִ�.
class LinkedList {

	// header ���
	Node header;

	// Node Ŭ����
	static class Node {

		int data;

		Node next = null;

	}// Node ����

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

	
	// deleteNode �޼���: ó���� ������ ���� ���� �� ����.
	boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false;
		}
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;

		return true;

	}// deleteNode ����

}// LinkedList ����


//LinkedList_deleteNode_sol Ŭ����
public class LinkedList_deleteNode_sol {

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		
		ll.deleteNode(ll.get(2));
		ll.retrieve();


	}// main ����

}// LinkedList_deleteNode_sol ����
