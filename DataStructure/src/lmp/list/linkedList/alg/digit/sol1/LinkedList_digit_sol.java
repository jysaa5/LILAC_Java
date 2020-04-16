package lmp.list.linkedList.alg.digit.sol1;

//����: � ���ڸ� �ڸ������� Linked List�� ��Ҵ�.�׷��� 1�� �ڸ����� header�� ������ �Ųٷ� ��Ҵ�. 
//�̷����� LinkedList �� ���� �޾Ƽ� �ջ��ϰ� ���� ������ Linked List�� ��Ƽ� ��ȯ�϶�.
// 419 = 9 -> 1 -> 4
// 346 = 6 -> 4 -> 3
// ��: 765 = 5 -> 6 -> 7
//solution: ���ȣ��

//L1:        9 -> 1 -> 4 -> null
//L2:        6 -> 4 -> 3 -> null
//C(carry):  0    1    0    0
//R(Result): 5 -> 6 -> 7
//header : 5

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
	
	
	// sumLists: Linked List Digit �ջ� �˰��� �޼���
	// l1: LinkedList�� �ǿ�����1, l2: LinkedList�� �ǿ�����2
	// carry: �޾ƿø�
	static Node sumLists(Node l1, Node l2, int carry) {

		if (l1 == null && l2 == null && carry == 0) {
			
			return null;
		
		}

		// ����� ���
		Node result = new Node();

		// �ջ��� �����
		int value = carry;

		if (l1 != null) {
			
			value += l1.data;
		
		}

		if (l2 != null) {
			
			value += l2.data;
		
		}

		//carry�Ǵ� ���� �����ϰ� ����
		result.data = value % 10;

		if (l1 != null || l2 != null) {
			
			Node next = sumLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
		
			//�� �ڸ��� ����� ����
			result.next = next;
		
		}

		return result;

	}

}// LinkedList ����

//LinkedList_digit_sol Ŭ����
public class LinkedList_digit_sol {

	public static void main(String[] args) {

		LinkedList l1 = new LinkedList();
		l1.append(9);
		l1.append(1);
		l1.append(4);
		l1.retrieve();
		
		LinkedList l2 = new LinkedList();
		l2.append(6);
		l2.append(4);
		l2.append(3);
		l2.retrieve();
		
		
		LinkedList.Node n = LinkedList.sumLists(l1.get(1), l2.get(1), 0);
		while(n.next !=null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);
		

	}// main ����


}// LinkedList_digit_sol ����
