package tree.binaryTree.alg.array;

// ����: ������ �Ǿ� �ְ�, ������ �����θ� �̷���� �迭�� �ִ�. �� �迭�� �����˻�Ʈ���� �����Ͻÿ�.
// �迭: 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
// Solution: ��� ȣ��

// Tree Ŭ����: Ʈ�� Ŭ����
class Tree {
	class Node {
		
		// ������
		int data;
		// ���� ���
		Node left;
		// ������ ���
		Node right;
		
		// ������
		Node(int data){
			
			this.data = data;
		
		}
		
	}// Node Ŭ���� ����
	
	// ��Ʈ ���
	Node root;
	
	// makeTree �޼���: �迭 ������ �޾Ƽ� Ʈ���� ����� ���� �����ϴ� ���
	public void makeTree(int[] a) {
		
		// ��� ȣ�⿡ �ʿ��� ���ڵ��� ó������ �ִ� ����
		// ��� ȣ���� ������, ���� ���� �ִ� ��Ʈ ����� �ּҸ� ����
		root = makeTreeR(a, 0, a.length-1);
		
	}
	
	// ����Լ�
	// a: �迭 ����, start: ���� �ε���, end: ������ �ε���
	public Node makeTreeR(int[] a, int start, int end) {
		
		// ������ �κ��� ����� ����ؾ� �Ѵ�. �׷��� ������ ���� ������ ����.
		if(start > end) {
			return null;
		}
		
		// �߰���
		int mid = (start+end)/2;
		// �߰������� ��� ����
		Node node = new Node(a[mid]);
		
		// ��� ȣ��
		node.left = makeTreeR(a, start, mid-1);
		node.right = makeTreeR(a, mid+1, end);
		
		return node;
	}
	
	
	// searchBTree: ���� �˻��� �� �޼��� 
	// n: �˻��� ������ ���
	// find: ã�� ��
	public void searchBTree(Node n, int find) {
		
		// ã�� ���� ���� ������ ũ�� ��
		if(find < n.data) {
			
			System.out.println("Data is smaller than "+ n.data);
			searchBTree(n.left, find);
		
		}else if(find > n.data) {
			
			System.out.println("Data is bigger than "+ n.data);
			searchBTree(n.right, find);
			
		}else {
			
			System.out.println("Data found!");
		
		}
		
	}
	
	
}// Tree Ŭ���� ����

/*
 *       (4)
 *      /  \
 *     /    \
 *    /      \
 *   (1)     (7)
 *   / \    /  \
 * (0) (2) (5) (8)
 *       \   \   \
 *       (3) (6) (9)
 *       
 * */

//BinaryTree_alg_array_Imp Ŭ����
public class BinaryTree_Array {
	
	public static void main(String[] args) {
		
		// �迭 �� ����
		int[] a = new int[10];
	
		// �迭�� ���� �ֱ�
		for(int i=0; i<a.length; i++) {
			a[i] = i;
		}
	
		// Ʈ�� ����
		Tree t = new Tree();
		t.makeTree(a);
		t.searchBTree(t.root, 2);
	}

	
}//BinaryTree_alg_array_Imp Ŭ���� ����