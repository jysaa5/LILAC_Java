package tree.binarySearchTree.ex.check.subTree;


// ����: ũ�Ⱑ �ſ� ū �� ���� ����Ʈ�� T1�� T2�� �ִ�. T1�� T2���� ū ��, T2�� T1�� ����Ʈ�������� Ȯ���ϴ� �˰����� �����Ͻÿ�.
// T2�� ��Ʈ����� ���� T1�� �����ϰ� �� ��带 �������� �ٱ⸦ �߶���� ��, T2�� ���� ������ ������ ����Ʈ���� �����Ѵ�.

// Solution: inorder / preorder / postorder �� ��ȸ ��� �߿� �� ���� ���� = preorder 
// root�� ���� Ȯ���ϱ� �����̴�.
/*
 * T1:  
 *         4
 *       /  \
 *      /    \
 *     /      \
 *     1       7
 *    / \     / \
 *   /   \   /   \
 *   0    2  5    8
 *         \  \    \
 *          3  6    9     
 * 
 * T2:
 *        7
 *       /  \
 *      /    \
 *     5      8
 *      \      \
 *       6      9
 * 
 * -> T2�� T1�� ����Ʈ���̴�.
 *       
 *       
 * */

// Tree Ŭ����
class Tree{
	
	// Node Ŭ����
	class Node{
		int data;
		Node left;
		Node right;
		
		// ������
		Node (int data){
			this.data = data;
		}
	}
	
	Node root;
	
	
	// makeBST �޼���: ���� �˻� Ʈ���� ����� �޼���
	Node makeBST(int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		int mid = (start + end)/2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid-1);
		node.right = makeBST(mid+1, end);
		return node;
		
	}// makeBST �޼��� ����
	
	
	// containsTree �޼���: �� ���� Ʈ���� �޾Ƽ� t2�� t1�� ���� Ʈ������ Ȯ���ϴ� �޼���
	boolean containsTree(Node t1, Node t2) {
		
		if (t2 == null) {
			return true;
		}
		// ����Լ� ȣ��
		return subTree(t1, t2);
		
	}// containsTree �޼��� ����
	
	
	// subTree �޼���: t1�� preorder ��ȸ �ϸ鼭 t2�� ��Ʈ ���� ���� ���� ã�� �޼���
	boolean subTree(Node t1, Node t2) {
		
		if(t1 == null) {
			return false;
			
			// ã���� ��
		}else if(t1.data == t2.data && matchTree(t1,t2)) {
			return true;
		}
		
		// �� ã���� ��.
		return subTree(t1.left, t2)|| subTree(t1.right, t2);	
	}// subTree �޼��� ����
	
	
	// matchTree �޼���: �� ���� Ʈ���� ��ȸ�ϸ鼭 ��� ����� ���� ��ġ�ϴ��� Ȯ��
	boolean matchTree(Node t1, Node t2) {
	
		if(t1 == null && t2 == null) {
			return true;
		}else if(t1 == null || t2 == null) {
			return false;
			
			// ������ Ȯ��
		}else if(t1.data != t2.data) {
			return false;
		}else {
			return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
		}
		
	}// matchTree �޼��� ����
	
	
}// Tree Ŭ���� ����

//BinarySearchTree_Check_SubTree Ŭ����
public class BinarySearchTree_Check_SubTree {

	
	// main �޼���
	public static void main(String[] args) {
		
		Tree t1 = new Tree();
		Tree t2 = new Tree();
		boolean result;
		
		/*
		 * t1:
		 *         4
		 *       /  \
		 *      /    \
		 *     /      \
		 *     1       7
		 *    / \     / \
		 *   /   \   /   \
		 *   0    2  5    8
		 *         \  \    \
		 *          3  6    9   
		 *  
		 * t2:
		 *      7      
		 *     / \
		 *    /   \
		 *    5    8
		 *     \    \
		 *      6    9 
		 * 
		 * */
		
		t1.root = t1.makeBST(0, 9);
		t2.root = t2.makeBST(5, 9);
		result = t1.containsTree(t1.root, t2.root);
		System.out.println(result);
		
		/*
		 * 
		 * t2: 
		 *   
		 *     8
		 *    / \
		 *   7   9
		 *  
		 * */
		
		t2.root = t2.makeBST(7, 9);
		result = t1.containsTree(t1.root, t2.root);
		System.out.println(result);
		
	}// main �޼��� ����
	
}// BinarySearchTree_Check_SubTree Ŭ���� ����