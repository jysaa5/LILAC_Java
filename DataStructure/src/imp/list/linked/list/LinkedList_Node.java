package imp.list.linked.list;

//�ܹ��� ���� ����Ʈ
//Node Ŭ����: ���� ����
class Node{
	
	//������: ������ Object�� �ִ´�.
	int data;
	//���� ��带 ���� �־�� �ǹǷ� �����Ѵ�. �ʱⰪ = null
	Node next = null;
	
	//������
	Node(int d){
		
		this.data = d;
	}

	//append �޼���: ��� ����
	void append(int d) {
		//���ο� ��� ����
		Node end = new Node(d);
		
		//������ ����
		Node point = this;
		
		//���� ��忡�� ���� ��� ��: �� ������ ��� �� ã��
		while (point.next != null) {
			point = point.next;
		}
		
		//���ο� ��� �߰�
		point.next = end;
		
	}//append ����
	
	//delete �޼���: ��� ����
	//head: ���� ù ��° ������� �˷��ش�.
	//ù ��° head�� �������� ���ϵ��� �Ѵ�.
	//head�� ���� ����Ʈ�� ��ǥ�ϴ� ù��° ����̱� ������ ������ �Ǹ�, �ٸ� ��ü�� ������ head�� ���� �Ǹ� ������ �ȴ�.
	void delete(int d) {
		
		//������ ����
		Node point = this;
		
		//���� ��忡�� ���� ��� ��: �� ������ ��� ������ �ݺ�
		while(point.next != null){
			
			//���� ��忡�� ���� ��� �����Ͱ� ������ ������� �Ǵ�
			if (point.next.data == d) {
				
				//���� ��忡�� ����Ű�� ���� ��带 �� ���� ���� ���� �ٲ۴�.
				point.next = point.next.next;
	
			}else {
				// ���� ã�� ���ؼ� ���� ���� �̵�
				point = point.next;
			}
		}
		
	}//delete ����
	
	//retrieve �޼���: ����Ʈ�� �ִ� �����͸� ó������ ������ �� �����ִ� �޼���
	void retrieve() {
		//point ����
		Node point = this;
		
		//������ ��� �� �ܰ���� �ݺ�
		while (point.next !=null ) {
			System.out.print(point.data + "->");
			// ���� ���� �̵�
			point = point.next;
		}
		//�� ������ ��� ���
		System.out.println(point.data);
		
	}//retrieve ����

}//Node ����

//LinkedList_Node: �ܹ��� ����Ʈ
public class LinkedList_Node {
	
	//main �޼���
	public static void main(String[] args) {
		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.retrieve();
		head.delete(2);
		head.delete(3);
		head.retrieve();
		
	}//main ����

}// LinkedList_Node ����

