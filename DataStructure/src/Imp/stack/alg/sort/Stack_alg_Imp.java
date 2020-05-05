package Imp.stack.alg.sort;

import java.util.Stack;

// ����: Stack�� �����ϴ� �Լ��� ����ÿ�. �� �ϳ��� Stack�� �߰��� ����� �� �ְ�
// Array(�迭) ���� �ٸ� ������ ������ ����� �� ����.
// s1: ������ �Ǿ� ���� ���� Stack
// s2: �׳� ��� �ִ� Stack
// Solution: �� ������ ���� ���� �Ǿ ������������ ����

//Stack_alg_Imp Ŭ����
public class Stack_alg_Imp {

	//sort �޼���: stack s1�� �� �������� ������������ �����ϴ� �޼���
	private static void sort(Stack<Integer> s1) {

		//s2: ����ִ� ���� ����
		Stack<Integer> s2 = new Stack<Integer>();

		//s1�� �������� �ݺ�
		while (!s1.isEmpty()) {
			
			//s1�� �� ���� �ִ� ���� ������
			int tmp = s1.pop();

			//s2�� ��� ���� �����鼭, �� ���� �ִ� ���� s1���� ���� �� ���� Ŭ �� �ݺ�
			while (!s2.isEmpty() && s2.peek() > tmp) {
			
				//s2�� �� ���� ���� ������ s1�� �ִ´�.
				s1.push(s2.pop());
			
			}
			
			//s2�� s1���� ���� ���� �ִ´�.
			s2.push(tmp);
		}

		//s2�� �������� �� ������ ������������ s1�� �ֱ�.
		while (!s2.isEmpty()) {
			
			//s2�� �ִ� ���� ������ s1�� �ֱ� = ���ĵ�.
			s1.push(s2.pop());
		
		}
	}

	//main �޼���: ���� �Լ�
	public static void main(String[] args) {
		
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(3);
		s1.push(5);
		s1.push(1);
		s1.push(6);
		
		//stack s1: 3 5 1 6 = �Ա�
		
		//����
		sort(s1);
		
		//stack s1: 6 5 3 1 = �Ա�
		
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());

		
	}//main �޼��� ����

}//Stack_alg_Imp Ŭ���� ����