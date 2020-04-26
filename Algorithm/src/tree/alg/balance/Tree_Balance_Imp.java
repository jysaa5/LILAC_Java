package tree.alg.balance;

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

// Solution: ���� �ϳ��� ���鼭 �ڽ� ��带 ��� ȣ���ϰ�, ���� Ʈ���� ���̸� �����ϴ� �Լ��� ���� ���� ���� 
// Ʈ���� ���̸� ���ϴٰ� �� ���� ���� Ʈ�� ���̰� 1�ʰ��� �߻��ϸ� false�� ��ȯ�Ѵ�.

class Tree{
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
	Tree(int size){
		root = makeBST(0, size-1);
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
	boolean isBalanced(Node root) {
	
		if(root == null) {
			return true;
		}
		
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		
		if(Math.abs(heightDiff)>1) {
			return false;
		}else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
		
	}// isBalanced �޼��� ����
	
	
	// getHeight �޼��� 
	int getHeight(Node root) {
		
		if(root == null) {
			return -1;
		}
		
		return Math.max(getHeight(root.left), getHeight(root.right)) +1;
	}// getHeight �޼��� ����
	
	

}


// Tree_Balance_Imp Ŭ����
public class Tree_Balance_Imp {
	
	// main �޼���
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		System.out.println(t.isBalanced(t.root));
		
		
	}// main �޼��� ����

}// Tree_Balance_Imp Ŭ���� ����