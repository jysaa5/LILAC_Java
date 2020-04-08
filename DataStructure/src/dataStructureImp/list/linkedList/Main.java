package dataStructureImp.list.linkedList;

//Main: ���� Ŭ����
public class Main {
	
	public static void main(String[] args) {
	
		LinkedList numbers = new LinkedList();
		
		//�� ó���� ��忡 ��� �߰�
		//numbers.addFirst(30);
		//numbers.addFirst(20);
		//numbers.addFirst(10);
		
		//�� �������� ��� �߰�
		//numbers.addLast(10);
		//numbers.addLast(20);
		//numbers.addLast(30);
		//numbers.addFirst(5);
		//numbers.add(1, 15);
		
		//node �ε��� 0���� ��ȯ�ȴ�.
		//System.out.println(numbers.node(0));
		//System.out.println(numbers.node(1));
		//System.out.println(numbers.node(2));
		
		//index: 1 , data: 15 -> 20�� �ڷ� �з��� 10�� 20���̿� 15�� ����.
		//numbers.add(1, 15);
		//numbers.add(2, 25);
		
		//toString
		//System.out.println(numbers);
		
		//������ ������ ���� 
		//numbers.removeFirst();
		//System.out.println(numbers.removeFirst());
		//System.out.println(numbers);
	
		//LinkedList: remove, removeLast
		//numbers.addLast(5);
		//numbers.addLast(10);
		//numbers.addLast(15);
		//numbers.addLast(20);
		//numbers.addLast(30);
		//System.out.println(numbers);
		//Ư�� ������ ����
		//������ 5�� �����Ѵ�.
		//System.out.println(numbers.remove(2));
		//System.out.println(numbers);
		//System.out.println(numbers.removeLast());
		
		//LinkedList: size, get
		//numbers.addLast(10);
		//numbers.addLast(20);
		//numbers.addLast(30);
		//System.out.println(numbers);
		//System.out.println(numbers.size());
		//����� �ε����� ���� ��ȯ�Ѵ�.
		//System.out.println(numbers.get(0));
		
		//LinkedList: indexOf
		//indexOf: ��ȸ��� �޼���
		//System.out.println(numbers.indexOf(5));
		
		//LinkedList: Iterator next
		//numbers.addLast(10);
		//numbers.addLast(20);
		//numbers.addLast(30);
		//LinkedList.ListIterator i = numbers.listIterator();
		//System.out.println(i.next());
		//System.out.println(i.next());
		//System.out.println(i.next());
		
		
		//LinkedList: Iterator hasNext
		//numbers.addLast(10);
		//numbers.addLast(20);
		///numbers.addLast(30);
		//LinkedList.ListIterator i = numbers.listIterator();
		//System.out.println(i.next());
		//System.out.println(i.next());
		//true ��ȯ
		//System.out.println(i.hasNext());
		//System.out.println(i.next());
		//false ��ȯ
		//System.out.println(i.hasNext());
		
		//while(i.hasNext()) {
		//	System.out.println(i.next());
		//}
		
		//LinkedList: Iterator add
		//numbers.addLast(10);
		//numbers.addLast(20);
		//numbers.addLast(30);
		//LinkedList.ListIterator i = numbers.listIterator();
		//next�� �� ó�� ��带 ����Ű�� �ֱ� ������ �� ó���� ��尡 �߰� �ȴ�.
		//i.add(5);
		//i.next();
		//lastReturned�� ����Ű�� ���� next�� ����Ű�� ��� ���̿� ���Եȴ�.
		//i.add(15);
		//System.out.println(numbers);
		
		//LinkedList: Iterator remove
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		LinkedList.ListIterator i = numbers.listIterator();
		//next�� �� ó�� ��带 ����Ű�� �ְ� lastReturned�� �ƹ��͵� ����Ű�� �ʱ� ������
		//������ ���� �����Ƿ� �����ϸ� ������ �߻��Ѵ�.
		//add�� ���� lastReturned �ڸ��� ��带 �����ϴ� ���̴�.
		//remove�� ���� lastReturned �ڸ��� ��带 �����Ѵ�.
		i.remove();
		
	}
	

}
