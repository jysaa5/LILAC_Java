package tree.binarySearchTree.ex.balance;

// ����: �־��� ���� Ʈ���� Balance�� �´��� Ȯ���ϴ� �Լ��� �����Ͻÿ�.
// (���⼭ Balance�� �´ٴ� �ǹ̴� � ����� ���� ���� Ʈ���� ���̰� 1�ʰ� ���̰� ���� �ʴ� ���� ����)

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
 *-> Balance�� �´�. ���̰� �ٸ� ���� Ʈ���� ������ 1�̻� ���̰� ���� �ʴ´�.
 * */

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
 *                 \
 *                (10)
 *           
 *-> Balance�� ���� �ʴ�. 8���� ���� ���� Child�� 0�� 2�̹Ƿ�.               
 * */          

/*
 *       (4)
 *      /   \
 *     /     \
 *    /       \
 *   (1)       (7)
 *   / \     /     \
 * (0) (2)  (5)    (8)
 *       \    \   /    \
 *       (3) (6) (11) (9)
 *                      \
 *                      (10)
 *           
 *-> Balance�� �´�. ���� ����� ���� �� �ٱ⸦ ���� Balance�� �Ǵ��Ҷ�, 2�� Child�� 8�� Child�� 1�� ���̸� ����.      
 * */       

// Solution 1 : ���� �ϳ��� ���鼭 �ڽ� ��带 ��� ȣ���ϰ�, ���� Ʈ���� ���̸� �����ϴ� �Լ��� ���� ���� ���� 
// Ʈ���� ���̸� ���ϴٰ� �� ���� ���� Ʈ�� ���̰� 1�ʰ��� �߻��ϸ� false�� ��ȯ�Ѵ�.
// ������: �� �� ��尡 ȣ��� ������, getHeight �޼��尡 �ش� ��忡������ �������� ���� Ʈ�� ������ ����
// ���鼭 ���̸� ���µ�, ��尡 ȣ�� �� ������ �Ź� �ٽ� ���� ���̸� ����.
// �ð� ���⵵: O(n log n)


// Tree Ŭ����
class Tree_01{
	// Node Ŭ����
	class Node{
		int data;
		Node left;
		Node right;
		
		// ������
		Node(int data){
			this.data = data;
		}
	}
	
	Node root;
	
	// ������
	Tree_01(int size){
		root = makeBST(0, size-1);
		// unbalanced �����
		root.right.right.right.right = new Node(10);
	}
	
	// ����Ʈ���� ����� �޼���
	Node makeBST(int start, int end) {
		if(start > end) {
			return null;
		}
		
		int mid = (start+end)/2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid-1);
		node.right = makeBST(mid + 1, end);
		return node;
		
	}//makeBST �޼��� ����

	
	// isBalanced �޼���
	// ����� �ּҸ� ���ڷ� �޴´�.
	boolean isBalanced(Node root) {
	
		// ������ ��带 ������ true�� ��ȯ
		if(root == null) {
			return true;
		}
		
		// ���� Ʈ�� ���� ���� ��
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		
		// 1�ʰ� ���̰� ����
		if(Math.abs(heightDiff)>1) {
			return false;
		
		}else {
		
			// ���ʰ� �������� ��� balanced �� �� true ��ȯ
			return isBalanced(root.left) && isBalanced(root.right);
		
		}
		
	}// isBalanced �޼��� ����
	
	
	// getHeight �޼��� 
	// ����� �ּҸ� ���ڷ� �޴´�.
	int getHeight(Node root) {
		
		// ���� �� ������ ��尡 ������ ��, �������� 1�� ����.
		if(root == null) {
			return -1;
		}
		
		// ��ȯ�� ������ 1�� ���Ѵ�.
		return Math.max(getHeight(root.left), getHeight(root.right)) +1;
	
	}// getHeight �޼��� ����
	
	
}// Tree Ŭ���� ����


// BinarySearchTree_Balance_Sol_1 Ŭ����
public class BinarySearchTree_Balance_Sol_1 {
	
	// main �޼���
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		// balanced �� ���
		System.out.println(t.isBalanced(t.root));
		
		
	}// main �޼��� ����

}// BinarySearchTree_Balance_Sol_1 Ŭ���� ����