package tree.binarySearchTree.alg.find.common.parent_sol_2;

import java.util.HashMap;

// ����: ���� Ʈ������ �־��� �� ���� ����� ù ��° ����� �θ� ��带 ã���ÿ�. (��, �ٸ� �ڷᱸ���� ��� ����)
// Solution 2: ���� ��� �˻�

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

// Solution 2
// 1. �� ����� �θ����� ���� �ٸ� ���� ���� Ʈ���� ���� ã�� ��尡 �ִ��� �����.
// 2. ���ٸ� �� ���� �θ� ����� �θ𿡰� �����. 
// t: ���� Ʈ���� ����
// �ð� ���⵵: O(t), �־��� ���: O(n) -> ��Ʈ�� ���� �и��� ���, ���� Ȯ��

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
	
	
	// covers �޼���: ���ڷ� ���� ��尡 ��Ʈ�� �ڼ����� Ȯ���ϴ� �޼���
	boolean covers(Node root, Node node) {
		
		if(root == null) {
			return false;
		}
		
		if(root == node) {
			return true;
		}
		
		return covers(root.left, node) || covers(root.right, node);
		
	}// covers �޼��� ����
	
	
	
	
	// commonAncestor �޼���: ���� �θ� ã�� �޼���
	Node commonAncestor(int d1, int d2) {
		
		Node p = getNode(d1);
		Node q = getNode(d2);
		
		// ���� ���� root���� p�� q�� �ִ� �� ���� ���� Ȯ��
		if (!covers(root, p)|| !covers(root, q)) {
			
			return null;
			
			// q�� p�� �ڼ����� Ȯ��
		}else if(covers(p, q)) {
			
			return p;
		
			// p�� q�� �ڼ����� Ȯ��
		}else if(covers(q, p)) {
			return q;
		}
		
		// ���� ��尡 ���� �ڽ��̸� �θ��� ������ �ڽĵ��� �������� 
		// ���� ��尡 ������ �ڽ��̸� �θ��� ���� �ڽ��� �����´�.
		Node sibling = getSibling(p);
		
		// �θ� ���
		Node parent = p.parent;
		
		// ������ �� ĭ�� �ö󰡸鼭 ã������ ��尡 �θ��� �ݴ��� ��忡 �ִ��� Ȯ���ϱ�.
		while(!covers(sibling, q)) {
			sibling = getSibling(parent);
			parent = parent.parent;
		}
		
		return parent;
		
		
	}// commonAncestor �޼��� ����
	
	
	// getSibling �޼���: �θ� ��带 �޾Ƽ� ���� ���� �ڽ����� ������ �ڽ������� ���� �ݴ��� ���� ��带 ������.
	Node getSibling(Node node) {
		
		if(node == null || node.parent == null) {
			
			return null;
		
		}
		
		Node parent = node.parent;
		
		return parent.left == node ? parent.right : parent.left;
		
				
	}// getSibling �޼��� ����
	
	
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

// BinarySearchTree_Find_CommonParent_Sol_2 Ŭ����
public class BinarySearchTree_Find_CommonParent_Sol_2 {

	// main �޼���
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		Tree.Node fa = t.commonAncestor(0, 3);
		System.out.println( "The first common ancestor is " + fa.data);
		
	}// main �޼��� ����
	
}// BinarySearchTree_Find_CommonParent_Sol_2 Ŭ���� ����