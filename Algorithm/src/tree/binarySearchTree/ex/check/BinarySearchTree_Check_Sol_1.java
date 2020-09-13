package tree.binarySearchTree.ex.check;

// ����: �־��� Ʈ���� �����˻�Ʈ�� ������ Ȯ���ϴ� �Լ��� �����Ͻÿ�.
// Solution 1: inorder(L, root, R) -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
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
		
	}// Node Ŭ���� ����
	
	Node root;
	int size;
	
	// ������
	Tree_01(int size){
		
		this.size = size;
		root = makeBST(0, size - 1 ); 
		
		// 9�� ��忡 �������� 10�� ��� �߰�
		root.right.right.right.left = new Node(10);
		this.size ++;
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
	
	
	
}// Tree Ŭ���� ����


// BinarySearchTree_Check_Sol_1 Ŭ����
public class BinarySearchTree_Check_Sol_1 {

	// main �޼���
	public static void main(String[] args) {
		
		Tree_01 t = new Tree_01(10);
		
		System.out.println("Solution 1 - using inorder: "+t.isValidateBST1());
		
	}// main �޼��� ����
	
	
}// BinarySearchTree_Check_Sol_1 Ŭ���� ����
