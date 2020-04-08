package dataStructureImp.list.linkedList;

//Main: 실행 클래스
public class Main {
	
	public static void main(String[] args) {
	
		LinkedList numbers = new LinkedList();
		
		//맨 처음에 노드에 노드 추가
		//numbers.addFirst(30);
		//numbers.addFirst(20);
		//numbers.addFirst(10);
		
		//맨 마지막에 노드 추가
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addFirst(5);
		numbers.add(1, 15);
		
		//node 인덱스 0번이 반환된다.
		//System.out.println(numbers.node(0));
		//System.out.println(numbers.node(1));
		//System.out.println(numbers.node(2));
		
		//index: 1 , data: 15 -> 20이 뒤로 밀려서 10과 20사이에 15가 들어간다.
		//numbers.add(1, 15);
		//numbers.add(2, 25);
		
		//toString
		System.out.println(numbers);
	
	}

}
