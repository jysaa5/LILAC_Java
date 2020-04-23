package graph.dfs;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;


// DFS: Depth-First Search
// inorder, preorder, postorder ��ȸ ������� DFS�� ���Ѵ�.
// �ϳ��� child ��� �м� -> �� ���� child ��� �̷� ������ ���̷� �İ� ���.
// ������ ���� ���̷� �İ� ��� �ö���鼭 �ٽ� �İ��� �ϴ� ���̴�.
// stack�� �̿��ؼ� �����Ѵ�.
// solution: ����Լ��� ������ �����ϴ�.

//Queue Ŭ����
class Queue<T> {

	// Node Ŭ����
	class Node<T> {

		// ������
		private T data;
		// ���� ���
		private Node<T> next;

		// ������
		public Node(T data) {
			this.data = data;
		}

	}// Node Ŭ���� ����

	// ť�� �հ� ���� �ּҸ� �˰� �־�� �Ѵ�.
	// �� ó�� ���
	private Node<T> first;

	// �� ������ ���
	private Node<T> last;

	// enqueue �޼���: ������ �߰��ϴ� ���
	public void enqueue(T item) {
	
		// ��� ����
		Node<T> t = new Node<T>(item);

		// ������ ��尡 ���� ��
		if (last != null) {
		
			last.next = t;
	
		}

		// �߰��� ��尡 �� ������ ���
		last = t;

		// ť�� ������� ��
		if (first == null) {
		
			first = last;
		
		}

	}// enqueue �޼��� ����

	
	//dequeue �޼���: ť�� �ִ� �����͸� �����ϴ� ���
	public T dequeue() {
		
		// ť�� ��� ���� ��
		if (first == null) {
		
			throw new NoSuchElementException();
		
		}

		// ������ �ӽ� ����
		T data = first.data;
		
		// �� ó�� ����� ���� ��忡 �ִ� ���� �� ó������ �����.
		first = first.next;

		//ť�� ��� ���� ��
		if (first == null) {
		
			last = null;
		
		}
		
		return data;

	}// dequeue �޼��� ����

	
	// peek �޼���: ť�� �ִ� �� ���� ���
	public T peek() {
		
		//ť�� ��� ���� ��
		if (first == null) {
		
			throw new NoSuchElementException();
		
		}
	
		return first.data;
	
	}// peek �޼��� ����

	
	//isEmpty �޼���
	public boolean isEmpty() {
	
		return first == null;

	}// isEmpty �޼��� ����

}// Queue Ŭ���� ����


// Graph Ŭ����
class Graph{
	
	// Node Ŭ����
	class Node{
		
		//�����ʹ� ������
		int data;
		
		//������ ���� ���Ḯ��Ʈ�� ����
		LinkedList<Node> adjacent;
		
		//�湮�ߴ��� ǥ���ϴ� ��ŷ
		boolean marked;
		
		//������
		Node (int data){
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
		
	}// Node Ŭ���� ����

	//��� ���� �迭 
	Node [] nodes;
	
	//�׷����� ���� ������ = �ڵ��� ���Ǹ� ���ؼ�.
	//������
	Graph(int size){
		nodes = new Node[size];
		
		for(int i=0; i< size; i++) {
		
			nodes[i] = new Node(i);
		
		}
		
	}
	
	//addEdge �޼���: �� ����� ���踦 �����ϴ� �Լ�
	void addEdge(int i1, int i2) {
		//������ == �ε����� ���� ������ ����.
		
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		
		//������ ��尡 �ִ��� Ȯ���ϰ� ������ �߰����ֱ�.
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
		
	}//addEdge �޼��� ����
	
	
	// dfs �޼���: ��� 0���� DFS
	void dfs() {
		
		dfs(0);
		
	}//dfs �޼��� ����
	
	// dfs �޼���: ���� �ε����� �޾Ƽ� DFS ��ȸ ����� ����ϴ� �޼���
	void dfs(int index) {
		
		Node root = nodes[index];
		
		//���� ����
		Stack<Node> stack = new Stack<Node>();
		//���ÿ� ������ �ֱ�
		stack.push(root);
		//���ÿ� ���ٰ� ǥ��
		root.marked = true;
		
		while(!stack.isEmpty()) {
			
			Node r = stack.pop();
			
			for(Node n : r.adjacent) {
			
				if(n.marked == false) {
				
					n.marked = true;
					
					stack.push(n);
				}
			}
			
			visit(r);
		}
	
	}//dfs �޼��� ����
	
	
	// visit �޼���: ������ ��� �޼���
	void visit(Node n) {
	
		System.out.print(n.data + " ");

	}// visit ����
	

	
	// dfsR �޼���: ���ȣ���� �̿��� DFS
	void dfsR(Node r) {
		if(r == null) {
			return;
		}
		
		r.marked = true;
		
		visit(r);
		
		for(Node n : r.adjacent) {
			
			if(n.marked == false) {
			
				dfsR(n);
		
			}
			
		}
		
	}//dfsR �޼��� ����
	
	
	// dfsR: �ش� �ε��� ������ DFS -> ���ȣ�� ������� 
	void dfsR(int index) {
		
		Node r = nodes[index];
		
		dfsR(r);
	
	}// dfsR �޼��� ����
	
	
	// dfsR: 0 �ε��� ������ DFS -> ���ȣ�� ������� 
	void dfsR() {
		
		dfsR(0);
		
	}// dfsR �޼��� ����
	
	
}// Graph Ŭ���� ����

/*
 *   0
 *  /
 * 1 -- 3    7
 * |  / | \ /
 * | /  |  5
 * 2 -- 4   \
 *           6 - 8
 *
 *-----------------
 * DFS(0)
 * 0 1 3 5 7 6 8 4 2
 * 
 * BFS(0)
 * 0 1 2 3 4 5 6 7 8
 * 
 * DFS(0) - Recursive
 * 0 1 2 4 3 5 6 8 7 
 *------------------
 *
 * DFS(3)
 * 3 5 7 6 8 4 2 1 0
 * 
 * BFS(3)
 * 3 1 2 4 5 0 6 7 8
 * 
 * DFS(3) - Recursive
 * 3 1 0 2 4 5 6 8 7 
 *------------------
 * 
 * */

//DepthFirstSearch Ŭ����
public class DepthFirstSearch {
	
	//main �޼���
	public static void main(String[] args) {
		
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		g.dfs();
		
	}//main �޼��� ����

}//DepthFirstSearch Ŭ���� ����
