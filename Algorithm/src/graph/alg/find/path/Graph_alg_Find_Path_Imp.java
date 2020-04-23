package graph.alg.find.path;

import java.util.LinkedList;

// ����: �׷������� �� ������ ��� ã��
// Solution: BFS ��� ���

// Graph: �׷��� Ŭ����
class Graph {

	// Node: ��� Ŭ����
	class Node {

		// ������
		int data;
		// ��ŷ
		boolean marked;
		// ������ ���
		LinkedList<Node> adjacent;

		// ������
		Node(int data) {
			this.data = data;
			this.marked = false;
			this.adjacent = new LinkedList<Node>();
		}
	}

	// ��带 ������ �迭�� ����
	Node[] nodes;

	// ������
	Graph(int size) {
		nodes = new Node[size];

		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}

	}

	// addEdge �޼���: ����(����) �߰��ϴ� ���
	void addEdge(int i1, int i2) {

		// ������ ���
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];

		// ������ ��尡 �ִ��� Ȯ���ϰ� ������ �߰����ֱ�.
		// contains: ����Ʈ�ȿ� �����Ͱ� ���� �ϴ��� Ȯ���ϴ� �޼���
		// n1�� ������ ����߿� n2�� ���� ��
		if (!n1.adjacent.contains(n2)) {
			// n1�� ������ ��忡 n2�� �߰�
			n1.adjacent.add(n2);
		}

		// n2�� ������ ����߿� n1�� ���� ��
		if (!n2.adjacent.contains(n1)) {
			// n2�� ������ ��忡 n1�� �߰�
			n2.adjacent.add(n1);
		}

	}// addEdge �޼��� ����

	// initMarks �޼���: ��� ��带 ó���� ��ŷ�� �ʱ�ȭ�ϴ� ���
	void initMarks() {

		//��� ��� ��ŷ�� false�� �ʱ�ȭ
		for (Node n : nodes) {
			
			n.marked = false;
		
		}

	}// initMarks �޼��� ����

	
	// search �޼���: ��� �ε����� ���ڷ� ������ ��� ���� ��ȯ�ϴ� ���
	boolean search(int i1, int i2) {

		return search(nodes[i1], nodes[i2]);

	}// search �޼��� ����

	
	// search �޼���: start�� end�� ��ΰ� �����ϴ� �� Ȯ���ϴ� �޼���: BFS ���
	boolean search(Node start, Node end) {

		initMarks();
		
		// ť�� ����
		LinkedList<Node> q = new LinkedList<Node>();
		// ���� ��带 ť�� �߰��Ѵ�.
		q.add(start);

		// ť�� �������� �ݺ�
		while (!q.isEmpty()) {
			
			// ť���� �����͸� ������
			Node root = q.removeFirst();

			// ���� �����Ͱ� end�� ��
			if (root == end) {
				return true;
			}

			// ���� ����� �ڽ� ��带 ���鼭 ť�� �߰��Ѵ�.
			for (Node n : root.adjacent) {
				
				if (n.marked == false) {
				
					n.marked = true;
					q.add(n);
				
				}
			}
		}
		
		// ��ȯ���� ���ߴٸ�, ��ΰ� ���� ���̹Ƿ� ���������� false�� ��ȯ�Ѵ�.
		return false;
		
	}//search �޼��� ����

}

/*
 *   0
 *  /
 * 1 -- 3    7
 * |  / | \ /
 * | /  |  5
 * 2 -- 4   \
 *           6 - 8
 * */



public class Graph_alg_Find_Path_Imp {
	
	public static void main(String[] args) {
		
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		//g.addEdge(1, 3);
		//g.addEdge(2, 4);
		//g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		
		System.out.println(g.search(1, 8));
		
	}

}
