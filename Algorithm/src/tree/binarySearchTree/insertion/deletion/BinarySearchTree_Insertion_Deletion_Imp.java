package tree.binarySearchTree.insertion.deletion;

// ����: BST(Binary Search Tree)�� insertion / deletion ����

// BinarySearchTree Ŭ����
class BinarySearchTree{
	
	// Node Ŭ����
	class Node{
		int data;
		Node left, right;
		
		//������
		public Node(int data) {
			this.data = data;
		}
	}// Node Ŭ���� ����
	
	Node root;
	
	// search �޼���: �˻� ���
	public Node search(Node root, int key) {
		
		if(root==null || root.data == key) {
			return root;
		}
		
		
		if(root.data > key) {
			return search (root.left, key);
		}
		
		return search(root.right, key);
		
	}// search �޼��� ����
	
	
	// insert �޼���: ���� ���
	public void insert(int data) {
		// ����Լ� ȣ��
		root = insert(root, data);
		
	}// insert �޼��� ����
	
	
	// insert �޼��� 
	private Node insert(Node root, int data) {
		
		// leaf ��忡 �������� �� �Ǵ� root ��尡 null�϶�.
		if(root == null) {
			root = new Node(data);
			return root;
		}
		
		// root �����Ϳ� ������ ������ ��
		if(data < root.data) {
			root.left = insert(root.left, data);
			
			// root �����Ϳ� ������ ������ ��
		}else if(data > root.data) {
			root.right = insert(root.right, data);
		}
		
		return root;
	}// insert �޼��� ����
	
	
	public void delete(int data) {
		root = delete(root, data);
	}
	
	private Node delete(Node root, int data) {
		
		if(root == null) {
			return root;
		}
		
		
		if(data < root.data) {
			root.left = delete(root.left, data);
		}else if(data > root.data) {
			root.right = delete(root.right, data);
		
		// ������ �����͸� ã���� ��.
		}else {
			// �ڽ� ��尡 �� ���� ��: �θ𿡰� null�� ��ȯ
			if(root.left == null && root.right == null) {
				return null;
			}
			
			// ���� ��� �Ǵ� ������ ��� �ڽ��� 1���� ���� ��: �ڽ��� ���� �ø��� �ȴ�.
			else if(root.left == null) {
				return root.right;
			}
			
			else if(root.right == null) {
				return root.left;
			}
			
			root.data = findMin(root.right);
			root.right = delete(root.right, root.data);
			
		}
		return root;
	}
	
	// findMin: ������ ���� Ʈ������ ���� ���� ��带 ã�� �޼���
	int findMin(Node root) {
		int min = root.data;
		
		while(root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		
		return min;
	}// findMin �޼��� ����
	
	
	public void inorder() {
		inorder(root);
		System.out.println("");
	}
	
	
	private void inorder(Node root) {
		
		if(root != null) {
			inorder(root.left);
			
			System.out.print(root.data + " ");
			
			inorder(root.right);
		}
		
	}

}// BinarySearchTree Ŭ���� ����

// BinarySearchTree_Insertion_Deletion_Imp Ŭ����
public class BinarySearchTree_Insertion_Deletion_Imp {
	
	
	// main �޼���
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		/*     4
		 *    /  \
		 *   2    6
		 *  / \  / \
		 * 1  3  5  7
		 * 
		 * */
		
		tree.insert(4);
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(6);
		tree.insert(5);
		tree.insert(7);
		
		tree.inorder();
		//tree.delete(7);
		tree.delete(5);
		tree.delete(6);
		tree.delete(2);
		tree.inorder();
		
	}// main �޼��� ����
	
}// BinarySearchTree_Insertion_Deletion_Imp Ŭ���� ����
