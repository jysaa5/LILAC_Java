package lmp.list.linkedList.alg.removeDuplicate;

//LinkedList Ŭ����: Node ������ ���� ����Ʈ�� ������ ���̴�. 
class LinkedList{
	
	//header ���
	Node header;

	//Node Ŭ����
	static class Node {

		int data;
		
		Node next = null;

	}//Node ����

	//������
	LinkedList() {
		
		header = new Node();

	}

	
	//append �޼���: ��� ����
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

	}//append ����

	
	//delete �޼���: ��� ����
	//head: ���� ù ��° ������� �˷��ش�.
	//ù ��° head �� ������ �����ϴ�. head�� �����ͷ� ������ �ʰ� �����뵵�θ� ���δ�.
	void delete(int d) {

		//������ ����
		Node point = header;

		//���� ��忡�� ���� ��� ��: �� ������ ��� ������ �ݺ�
		while (point.next != null) {

			//���� ��忡�� ���� ��� �����Ͱ� ������ ������� �Ǵ�
			if (point.next.data == d) {

				//���� ��忡�� ����Ű�� ���� ��带 �� ���� ���� ���� �ٲ۴�.
				point.next = point.next.next;

			} else {
			
				//���� ã�� ���ؼ� ���� ���� �̵�
				point = point.next;
		
			}
		
		}
		
	}//delete ����

	
	//retrieve �޼���: ����Ʈ�� �ִ� �����͸� ó������ ������ �� �����ִ� �޼���
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
		
	}//retrieve ����
	
	
	//removeDups: �ߺ��� �����ϴ� �޼���
	void removeDups() {
		
		Node n = header;
		
		while (n != null && n.next !=null) {
		
			Node r = n;
			
			//������ ��尪���� ���� �ʴ´�.
			while(r.next != null) {
				
				if (n.data == r.next.data) {
					
					r.next = r.next.next;
				
				}else {
			
					r = r.next;
			
				}
				
			}
			
			n = n.next;
		
		}
		
	}//removeDups ����

}//LinkedList ����


//LinkedList_LinkedListNode Ŭ����
public class LinkedList_LinkedListNode_remove_duplicate {
	
	//main �޼���: ���� �޼���
	public static void main(String[] args) {
	
		LinkedList ll = new LinkedList();
//		ll.append(2);
//		ll.append(1);
//		ll.append(2);
//		ll.append(3);
//		ll.append(4);
//		ll.append(4);
//		ll.append(2);
//		ll.retrieve();
//		ll.removeDups();
//		ll.retrieve();
		
		ll.append(2);
		ll.append(2);
		ll.retrieve();
		ll.removeDups();
		ll.retrieve();
	
	}//main ����

}//LinkedList_LinkedListNode ����
