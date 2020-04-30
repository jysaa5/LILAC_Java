package tree.binaryTree.alg.find.common.parent_sol_1;

import java.util.HashMap;

// ����: ���� Ʈ������ �־��� �� ���� ����� ù ��° ����� �θ� ��带 ã���ÿ�. (��, �ٸ� �ڷᱸ���� ��� ����)
// Solution 1: ���� ���߼� Ǯ��

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

// Solution 1 
// 1. ��Ʈ���� �� ��� ���̸� ����. 
// 2. �� ��� ���� ���̸� �����. �� ��尡 ��� ����ŭ ���� �ö󰣴�.
// 3. �� ĭ�� ���� �ö󰡸鼭 ���� �и� Ȯ��
// �ð� ���⵵: O (d)
// d: Ʈ���� ����

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
		
		// ���� ����
		int diff = depth(p) - depth(q);
		
		// first: ª�� ��, second: �� ��
		Node first = diff > 0? q : p;
		Node second = diff > 0? p : q;
		
		// goUpBy �޼��带 �̿��ؼ� first�� second ����� ���̸� ���� �����.
		second = goUpBy(second, Math.abs(diff));
		
		// �� ��带 �ö󰡸鼭 ���� �θ� ��带 ã�´�.
		while(first != second && first != null && second != null) {
			first = first.parent;
			second = second.parent;
					
		}
		
		return first == null || second == null ? null : first;
		
	}// commonAncestor �޼��� ����
	
	
	// goUpBy �޼���: �� ����� ���� ���� ��ŭ �� ���� �÷��� �� ����� ���̸� �����ش�.
	Node goUpBy(Node node, int diff) {
		
		// diff ���� ��ŭ ��带 ���� �÷� ������.
		while(diff > 0 && node != null) {
			node = node.parent;
			diff --;
		}
		
		return node;
		
	}// goUpBy �޼��� ����
	
	
	// depth: ��忡������ ��Ʈ(root)���� ���� ���ϴ� �޼���
	int depth(Node node) {
		int depth = 0;
		
		while(node != null) {
			node = node.parent;
			depth++;
		}
		
		return depth;
	
	}// depth �޼��� ����
	
	
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


public class BinaryTree_alg_find_commonParent_sol_1 {

	// main �޼���
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		Tree.Node fa = t.commonAncestor(3, 5);
		System.out.println( "The first common ancestor is " + fa.data);
		
	}// main �޼���
	
}