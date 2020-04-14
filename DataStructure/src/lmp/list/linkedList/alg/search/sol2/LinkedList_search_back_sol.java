package lmp.list.linkedList.alg.search.sol2;

//count�� �ּҸ� �����ϱ� ���� Ŭ���� ����
	class Reference{
		public int count = 0;
	}

//�ܹ��� LinkedList�� ������ K��° ��带 ã�� �˰����� ����.
//���2: ��� ȣ��
//�������⵵: O(n), �ð����⵵: O(n)
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

	
	//removeDups: �ߺ��� �����ϴ� �޼���
	void removeDups() {
		
		Node n = header;

		while (n != null && n.next != null) {
			
			Node r = n;

			// ������ ��尪���� ���� �ʴ´�.
			while (r.next != null) {

				if (n.data == r.next.data) {

					r.next = r.next.next;

				} else {
				
					r = r.next;
		
				}
			
			}

			n = n.next;
		
		}
		
	}//removeDups ����
	
	

	
	
	
	//kthToLast: �ڿ������� k��° ������ ã�� �޼���
	//k: �ڿ������� k��°
	Node kthToLast(Node n, int k, Reference r) {
		
		if (n == null) {
	
			return null;
		}

		Node found = kthToLast(n.next, k, r);
		r.count ++;
		
		if(r.count == k) {

			return n;
		}
	
		return found;
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
		int k = 4;

		Reference r = new Reference();
		LinkedList.Node found = ll.kthToLast(ll.header, k, r);
		System.out.println(found.data);
		


	}//main ����

}//LinkedList_search_back_sol ����
