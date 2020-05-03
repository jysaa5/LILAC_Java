package tree.binaryTree.alg.find.common.parent_sol_5;

import java.util.HashMap;

// ����: ���� Ʈ������ �־��� �� ���� ����� ù ��° ����� �θ� ��带 ã���ÿ�. (��, �ٸ� �ڷᱸ���� ��� ����)
// Solution 5: ��Ȯ�� ��� �������� : Ʈ���� ���� ��带 ã�� ��. -> �̹��� ���� ������ ���� Ȯ���� ã�Ҵ��� �� ã�Ҵ��� �����ͷ�
// ǥ���ϱ�

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

	
	// Result Ŭ����: ��� ���� ��ü
	class Result{
		// ��� ����
		Node node;
		// ã�Ҵ��� ����
		boolean isAncestor;
	
		// ������
		Result (Node n, boolean isAnc){
			node = n;
			isAncestor = isAnc;
		}
	}
	
	
	
	// commonAncestor �޼���: ���� �θ� ã�� �޼���
	Node commonAncestor(int d1, int d2) {
		
		Node p = getNode(d1);
		Node q = getNode(d2);
		
		Result r =  commonAncestor(root, p, q);
		
		if(r.isAncestor) {
			return r.node;
		}
		return null;
	}// commonAncestor �޼��� ����
	
	// commonAncestor �޼���: ��� ȣ��
	Result commonAncestor (Node root, Node p, Node q) {
		
		// Ʈ���� ���ĸ� ������ ���� �� (�� ������ ���� ���� ��)
		if(root == null ) {
			return new Result(null, false);
		}
		
		// p�� q�� root�� �� ������ �ش� ��尡 ���� ��尡 �ȴ�.
		if(root == p && root == q) {
			return new Result(root, true);
		}
		
		// ��Ʈ�� ���� �˻�
		Result rx = commonAncestor(root.left, p , q);
		
		// ���ʿ��� ���� �θ� ã�� ���
		if(rx.isAncestor) {
			return rx;
		}
		
		// ��Ʈ�� ������ �˻�
		Result ry = commonAncestor(root.right, p, q);
		
		// �����ʿ��� ���� �θ� ã�� ���
		if(ry.isAncestor) {
			return ry;
		}
		
		// ã�� ��带 ��� ã�� ��� = ���� ��尡 ���� �θ�
		if(rx.node != null && ry.node !=null) {
			return new Result(root, true);
			
			// ���� ��尡 ã�� ����� ���: ã�� ��尡 ���� �и��ϼ��� �ִ� ���ɼ��� �ִ�.
		}else if (root == p || root == q) {
			boolean isAncestor = rx.node !=null || ry.node != null;
			return new Result(root, isAncestor);
			
			// ����, ������ ���� �߿��� �� ���� �ݵ�� null�� ��
		}else {
			
			return new Result(rx.node !=null ? rx.node: ry.node, false);
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

// BinaryTree_Find_CommonParent_Sol_5 Ŭ����
public class BinaryTree_Find_CommonParent_Sol_5 {

	// main �޼���
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		Tree.Node fa = t.commonAncestor(0, 8);
		System.out.println( "The first common ancestor is " + fa.data);
		
	}// main �޼��� ����
	
}// BinaryTree_Find_CommonParent_Sol_5 Ŭ���� ����