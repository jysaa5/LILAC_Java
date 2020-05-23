package tree.binarySearchTree.alg.find.nextNode;

// ����: ���� �˻� Ʈ������ �־��� ����� ������带 ã�� �Լ��� �����Ͻÿ�.
// (��, ��������� ������ inorder traverse�� �԰���.)
// inorder: L, root, R

// Solution: inorder ��ȸ�� �̿��Ͽ� ������ ��尡 ���� ���� ���� ���� �����Ͽ� ��, �Ʒ����� ã�� �޼��带 �����Ͽ���.

class Tree{
	
	class Node{
		int data;
		Node left;
		Node right;
		// �θ� ���
		Node parent;
		
		//������
		Node (int data){
			this.data = data;
		}
	}
	
	Node root;
	
	//������
	Tree (int size){
		root = makeBST(0, size-1, null);
	}
	
	// makeBST �޼���: ���� �˻� Ʈ���� ����� �޼���
	Node makeBST(int start, int end, Node parent) {
		
		if(start > end ) {
			return null;
		}
		
		// ��� ���� ����
		int mid = (start + end)/2;
		
		// ��� ���ڷ� ��� ����
		Node node = new Node(mid);
		
		// ����� ������ ���� �˻� Ʈ���� �����
		node.left = makeBST(start, mid-1, node);
		// ����� �������� ���� �˻� Ʈ���� �����
		node.right = makeBST(mid+1, end, node);
		// ����� �θ� ����
		node.parent = parent;
		
		return node;
		
	}// makeBST �޼��� ����
	
	
	// ���� ��带 ã�� �޼���
	// findNext �޼���
	void findNext(Node node) {
		
		// ����� �����ʿ� ��尡 ���� ���: ���� �ö󰡼� ã�ƾ� �ȴ�.
		if(node.right == null ) {
			// �θ� ���� ���� ��带 ���ڷ� �ѱ��.
			System.out.println(findAbove(node.parent, node).data + " is " + node.data + "'s next");
		
			// ����� �����ʿ� ��尡 �ִ� ���: �Ʒ����� ã�ƾ� �ȴ�.
		}else {
			System.out.println(findBelow(node.right).data + " is " + node.data + " 's next");
		}
		
	}// findNext �޼��� ����
	
	
	// ������ ã�� ���
	// findAbove �޼���
	Node findAbove(Node root, Node child) {
		
		// null exception ó��
		if(root == null) {
			return null;
		}
		
		// �θ��� ���� ��尡 ���� ����� �� �θ� ��带 ��ȯ
		if(root.left == child) {
			return root;
		}
		
		// �ݺ� ȣ��
		// �θ��� �θ��, �θ� ���ڷ� ��ȯ
		return findAbove(root.parent, root);
	
	}// findAbove �޼��� ����
	
	
	// �ؿ��� ã�� ���
	// findBelow �޼���
	Node findBelow(Node root) {
		
		// ���ʿ� �� �̻� �ڽ��� ���� �� �ش� ��尡 ã�� ����̴�.
		if(root.left == null) {
			return root;
		}
		
		// �ݺ� ȣ��
		// ���� ����� ���� ��带 ���ڷ� ��ȯ
		return findBelow(root.left);
		
	}// findBelow �޼��� ����
	
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

// BinarySearchTree_NextNode_Find Ŭ���� 
public class BinarySearchTree_NextNode_Find {
	
	// main �޼���
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		
		t.findNext(t.root.left.right.right);
		t.findNext(t.root.left);
		t.findNext(t.root);
		t.findNext(t.root.left.left);
		t.findNext(t.root.right.left.right);
		
		
	}// main �޼��� ����

}// BinarySearchTree_NextNode_Find Ŭ���� ����
