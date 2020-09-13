package tree.binarySearchTree.ex.check;

// ����: �־��� Ʈ���� �����˻�Ʈ�� ������ Ȯ���ϴ� �Լ��� �����Ͻÿ�.
// Solution 1 : inorder(L, root, R) -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
// Ʈ���� inorder�� ��ȸ �� ����, �迭�濡 ���� ��´�. �׸��� �迭 ���� ������ ascending(���� ����)���� Ȯ���Ѵ�.
// ���� ���⵵: O(n) -> �迭��ŭ�� ������ �ʿ��ϴ�.
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
 *               /
 *             (10)
 *             
 * -> ��Ģ���� ��߳���. 10����尡 9�� ��庸�� ũ�� �����ʿ� �־�� �ϱ� �����̴�.
 * */


// Solution 2: ���� ��带 �����ϴ� ������ �����ϰ� �������� ���� ��常 ���ϴ� ������� Ǯ���Ѵ�.

// Tree Ŭ����
class Tree_02{
	
	// Node Ŭ����
	class Node{
		
		int data;
		Node left;
		Node right;
		
		// ������
		Node(int data){
			
			this.data = data;
		}
		
	}// Node Ŭ���� ����
	
	Node root;
	int size;
	
	// ������
	Tree_02(int size){
		
		this.size = size;
		root = makeBST(0, size - 1 ); 
		
		// 9�� ��忡 �������� 10�� ��� �߰�
		//root.right.right.right.left = new Node(10);
		//this.size ++;
		
		
	}
	
	
	// makeBST �޼���: ����Ʈ���� ����� ���
	Node makeBST(int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		int mid = (start+end)/2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid - 1);
		node.right = makeBST(mid+1, end);
		
		return node;
		
	}// makeBST �޼��� ����
	
	
	// isValidateBST1 �޼���
	// Solution1: inorder ��ȸ�� �����Ͽ� ���� �˻� Ʈ���� Ȯ���ϴ� �޼��� 
	boolean isValidateBST1() {
		
		// ��� ������ŭ �迭�� ���� �� ����
		int[] array = new int[size];
		
		// inorder �޼��� ȣ��: root ���, �迭�� 
		inorder(root, array);
		
		// �������� �������� Ȯ���ϴ� �κ�
		for(int i=1; i< array.length; i++) {
			if(array[i]<array[i-1]) {
				return false;
			}
		}
		return true;
	}// isValidateBST1 �޼��� ����
	
	// �� ��° ����� ��带 ��Ҵ��� ����ϰ� �ִ� ���� ����
	int index = 0;
	
	
	// inorder �޼���
	void inorder(Node root, int[] array) {
		
		// ��尡 null�� �ƴҶ����� �ݺ�
		if(root != null) {
			// ����� ���� ���� Ʈ�� ȣ��
			inorder(root.left, array);
			// �迭 �濡 ����
			array[index] = root.data;
			// �迭 �ε��� 1 ����
			index ++;
			
			// ����� ������ ���� Ʈ�� ȣ��
			inorder(root.right, array);
		
		}
		
	}// inorder �޼��� ����
	
	
	// Solution2 
	// �ٷ� ���� ��忡 �־��� ���� �����ϴ� ���� ��ü�� �ּҸ� �ѱ�� Ŭ���� Ÿ������ ����
	Integer last_printed = null;
	
	// isValidateBST2 �޼���: ���� ���� ȣ�� �Ǹ�, root ���� ���� �˻� Ʈ������ Ȯ��.
	boolean isValidataBST2() {
		
		return isValidateBST2(root);
	}// isValidateBST2 �޼��� ����
	
	
	// isValidateBST2 �޼���: Integer�� ������ �����ؼ�, ���� ��带 ��� �� ���� ���� ���Ͽ� ���� �˻� Ʈ������ Ȯ��.
	boolean isValidateBST2(Node n) {
		
		// ��尡 null �� ��. ����� �������� ������ ��.
		if(n == null) {
			return true;
		}
		
		// ����� ���� ���� Ʈ������ ���ĵ��� ���� ���� ������ ��
		if(!isValidateBST2(n.left)) {
			return false;
		}
		
		// �ٷ� ���� ����� ���� ���� ���� ��
		if (last_printed != null && n.data < last_printed ) {
			return false;
		}
		
		// ���� �����͸� ������ �Ҵ��Ѵ�.
		last_printed = n.data;
		
		// ����� ������ ���� Ʈ������ ���ĵ��� ���� ���� ������ ��
		if(!isValidateBST2(n.right)) {
			return false;
		}
		
		return true;
	}//isValidateBST2 �޼��� ����
	
	
	
}// Tree Ŭ���� ����


// BinarySearchTree_Check_Sol_2 Ŭ����
public class BinarySearchTree_Check_Sol_2 {

	// main �޼���
	public static void main(String[] args) {
		
		Tree_02 t = new Tree_02(10);
		
		System.out.println("Solution 1 - using inorder: "+t.isValidateBST1());
		
		System.out.println("Solution 2 - without array: " + t.isValidataBST2());
		
	}// main �޼��� ����
	
	
}// BinarySearchTree_Check_Sol_2 Ŭ���� ����
