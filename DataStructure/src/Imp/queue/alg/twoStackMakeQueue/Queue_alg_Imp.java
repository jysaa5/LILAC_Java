package Imp.queue.alg.twoStackMakeQueue;

import java.util.Stack;

//����: �� ���� Stack(����)���� �ϳ��� Queue(ť)�� �����϶�.
//Ǯ��: 
//1. New Stack, Old Stack �����
//2. add �� ���� New�� �ִ´�.
//3. peek, remove�� �� ���� New�� �ִ� ���� old�� �ű� �Ŀ� �����Ѵ�.

class MyQueue<T> {
	
	//���� ��ü ����
	Stack<T> stackNewest, stackOldest;

	// ������
	MyQueue() {
		
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();

	}

	// size �޼���: ������ ��ü ������ ��ȯ �ϴ� �޼���
	public int size() {
	
		return stackNewest.size() + stackOldest.size();
	
	}// size ����

	
	//add �޼���: ���� ������ �߰� 
	public void add(T value) {
		
		stackNewest.push(value);

	}//add �޼��� ����

	
	//shiftStacks �޼���: stackOldest�� ��� ���� ���� ����Ǿ�� �Ѵ�.
	private void shiftStacks() {
		if(stackOldest.isEmpty()) {
			
			//stackNewest�� ��� �����Ͱ� �� ������ �ݺ�
			while(!stackNewest.isEmpty()) {
				//stackNewest�� �ִ� �����͸� ����� stackOldest�� �ִ´�.
				stackOldest.push(stackNewest.pop());
			}
			
		}
	
	}//shiftStacks �޼��� ����
	
	//peek �޼���: ������ �� ���� �ִ� �� ������ ���� ���
	public T peek() {
		
		shiftStacks();
		return stackOldest.peek();
	
	}//peek �޼��� ����
	
	
	//remove �޼���: ������ �� ���� �ִ� �� ������ ��ȯ�ϰ� ����� ���
	public T remove() {
		
		shiftStacks();
		return stackOldest.pop();
	
	}//remove �޼��� ����
	
	
}//MyQueue Ŭ���� ����

//Queue_alg_Imp Ŭ���� 
public class Queue_alg_Imp {

	// main �޼���: ���� �Լ�
	public static void main(String[] args) {

		MyQueue<Integer> q = new MyQueue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		
		
	}// main �޼��� ����
	
}//Queue_alg_Imp ����
