package tree.binaryTree.alg.find.common.parent_sol_4;

import java.util.HashMap;

// ����: ���� Ʈ������ �־��� �� ���� ����� ù ��° ����� �θ� ��带 ã���ÿ�. (��, �ٸ� �ڷᱸ���� ��� ����)
// Solution 4: ����ȭ ��Ű�� -> postorder�� ��� ������ �� ������ ���鼭 ��ȯ���� ���ʰ� ������ ��带 ���� ���� �Ǵ�.

/*
 *            (4)
 *          /      \
 *         /        \
 *        /          \
 *       (1)         (7)
 *      /   \       /   \
 *     /     \     /     \
 *    /       \   /       \
 *   (0)     (2) (5)      (8)
 *  /  \       \    \        \
 * /    \       \    \        \ 
 *(13)  (12)    (3)   (6)     (9)
 *      /  \      \
 *    (15) (14)  (10)
 *
 *
 * */

// postorder : L, R, root

// Tree Ŭ����
class Tree{
	
	// Node Ŭ����
	static class Node{
		
		int data;
		Node left;
		Node right;
		Node parent;
		
		// ������
		Node (int data){
			this.data = data;
		}
	}// Node Ŭ����
	
	
	Node root;
	
	HashMap<Integer, Node> rootMap;
	
	// Tree ������
	Tree (int size){
		rootMap = new HashMap<Integer, Node>();
		root = makeBST(0, size-1, null);
				
	}
	
	
	// makeBST �޼���: ���� �˻� Ʈ��
	Node makeBST(int start, int end, Node parent) {
		
		if(start > end) {
			return null;
		}
		
		int mid = (start + end) / 2;
		
		Node node = new Node(mid);
		node.left = makeBST(start, mid-1, node);
		node.right = makeBST(mid+1, end, node);
		node.parent = parent;
		// ������ ��带 ã�ƿ� �� �ְ� �ؽøʿ� ��� �߰�
		rootMap.put(mid, node);
		return node;
		
	}// makeBST �޼��� ����
	
	
	// getNode �޼���
	Node getNode(int data) {
		
		// �ؽ� �ʿ��� get���� ��帣 �����´�.
		return rootMap.get(data);
	
	}// getNode �޼��� ����

	
	// commonAncestor �޼���: ���� �θ� ã�� �޼���
	Node commonAncestor(int d1, int d2) {
		
		Node p = getNode(d1);
		Node q = getNode(d2);
		
		return commonAncestor(root, p, q);
		
	}// commonAncestor �޼��� ����
	
	// commonAncestor �޼���: ��� ȣ��
	Node commonAncestor (Node root, Node p, Node q) {
		
		// Ʈ���� ���ĸ� ������ ���� �� (�� ������ ���� ���� ��)
		if(root == null ) {
			return null;
		}
		
		// p�� q�� root�� �� ������ �ش� ��尡 ���� ��尡 �ȴ�.
		if(root == p && root == q) {
			return root;
		}
		
		// ��Ʈ�� ���� �˻�
		Node x = commonAncestor(root.left, p , q);
		
		// ���ʿ��� ���� �θ� ã�� ���
		if(x != null && x != p && x != q) {
			return x;
		}
		
		// ��Ʈ�� ������ �˻�
		Node y = commonAncestor(root.right, p, q);
		
		// �����ʿ��� ���� �θ� ã�� ���
		if(y != null && y !=p && y != q) {
			return y;
		}
		
		// ã�� ��带 ��� ã�� ��� = ���� ��尡 ���� �θ�
		if(x != null && y !=null) {
			return root;
			
			// ���� ��尡 ã�� ����� ���
		}else if (root == p || root == q) {
			return root;
		}else {
			// null�� �ƴ� ��带 ��ȯ�Ѵ�.
			return x == null ? y : x;
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
 *
 * */

// BinaryTree_Find_CommonParent_Sol_4 Ŭ����
public class BinaryTree_Find_CommonParent_Sol_4 {

	// main �޼���
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		Tree.Node fa = t.commonAncestor(5, 8);
		System.out.println( "The first common ancestor is " + fa.data);
		
	}// main �޼��� ����
	
}// BinaryTree_Find_CommonParent_Sol_4 Ŭ���� ����