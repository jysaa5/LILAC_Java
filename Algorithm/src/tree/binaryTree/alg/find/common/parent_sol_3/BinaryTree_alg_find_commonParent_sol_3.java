package tree.binaryTree.alg.find.common.parent_sol_3;

import java.util.HashMap;

// ����: ���� Ʈ������ �־��� �� ���� ����� ù ��° ����� �θ� ��带 ã���ÿ�. (��, �ٸ� �ڷᱸ���� ��� ����)
// Solution 3: �θ� ��带 �� �� ���� ���

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

// Solution 3
// 1. ��Ʈ�������� �������鼭 ã�� ��� p, q�� ã�´�.
// 2. ��Ʈ�� ���� ���� Ʈ���� �ִ��� ������ ���� Ʈ���� �ִ��� Ȯ��
// 3. �������鼭 Ȯ��.
// t: ���� Ʈ���� ����
// �ð� ���⵵: O(log n)^2 = O(n)

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
			
		}
		
		return ancestorHepler(root, p, q);
		
	}// commonAncestor �޼��� ����
	
	
	// ancestorHepler �޼��� 
	Node ancestorHepler(Node root, Node p, Node q) {
		
		if(root == null || root == p || root == q) {
			return root;
		}
		
		boolean pIsOnLeft = covers(root.left, p);
		boolean qIsOnLeft = covers(root.left, q);
		
		// ���� �ٸ� ���⿡ �ִٸ� �׶� �������� ���� ���� �θ��̴�.
		if(pIsOnLeft != qIsOnLeft) {
			return root;
		}
		
		// ������ ���� ���� ���� ���� ��, ���ʿ� �ִ��� �����ʿ� �ִ��� Ȯ��
		Node childSide = pIsOnLeft? root.left : root.right;
		
		return ancestorHepler(childSide, p, q);
	}// ancestorHepler �޼��� ����

	
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

// BinaryTree_alg_find_commonParent_sol_3 Ŭ����
public class BinaryTree_alg_find_commonParent_sol_3 {

	// main �޼���
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		Tree.Node fa = t.commonAncestor(2, 8);
		System.out.println( "The first common ancestor is " + fa.data);
		
	}// main �޼��� ����
	
}// BinaryTree_alg_find_commonParent_sol_3 Ŭ���� ����