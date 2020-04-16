package lmp.list.linkedList.alg.search.sol3;

//����: �ܹ��� LinkedList�� ������ K��° ��带 ã�� �˰����� ����.
//���3: ������ 2�� ���
//�������⵵: O(1), �ð����⵵: O(n)
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
	
	
	//kthToLast: �ڿ������� k��° ������ ã�� �޼���
	//k: �ڿ������� k��°
	Node kthToLast(Node first, int k) {
		Node p1 = first;
		Node p2 = first;
		
		for(int i=0; i<k; i++) {
			if(p1 == null) {
				return null;
			}
			p1 = p1.next;
		}
		
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
		
	}//kthToLast ����
	

}// LinkedList ����


	
//LinkedList_search_back_sol Ŭ����
public class LinkedList_search_back_sol {

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		int k = 1;

		LinkedList.Node found = ll.kthToLast(ll.header, k);
		System.out.println(found.data);
		


	}//main ����

}//LinkedList_search_back_sol ����
