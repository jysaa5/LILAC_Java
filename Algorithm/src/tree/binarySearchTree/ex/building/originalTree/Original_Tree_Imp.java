package tree.binarySearchTree.ex.building.originalTree;

// ����: ��ȸ����� ����Ʈ�� �����ϱ� (Building tree from traversal results)
/*
- Binary Tree Traversals: preorder, inorder, postorder
- preorder: root, left, right -> ����
- inorder: left, root, right -> �Ʒ��� ���� �� ��ȸ
- postorder: left, right, root -> �������� ���� �� ��ȸ 
 
- �׳� preorder �Ǵ� inorder �Ǵ� postorder �� ���� ��ȸ ������� ���� Ʈ���� ������ �� ����.
- preorder�� inorder�� ���� �迭�� Ʈ���� ������ �� �ִ�.
- postorder�� inorder�� ���� �迭�� Ʈ���� ������ �� �ִ�.
- preorder�� postorder�� ������ ���� Ʈ���� ���� �� �� ����. -> full binary tree ���� 


      (4)
    /     \
   (2)    (6)
  /   \   /  \
 (1) (3) (5) (7)

- preorder: 4|2|1|3|6|5|7|
- inorder:  1|2|3|4|5|6|7|

- postorder: 1|3|2|5|7|6|4|
- inorder:   1|2|3|4|5|6|7|



 */

// Ʈ�� Ŭ����
class Tree{
	// ��� Ŭ����
	class Node{
		
		int data;
		Node left, right;
		
		//������
		Node(int data){
			
			this.data = data;
		}	
	}// Node Ŭ���� ����
	
	
	// Ʈ���� ù ��° ��Ʈ ��� ����
	Node root;
	
	// �迭���� ������ �о��� �� ����
	static int pIndex = 0;
	
	// buildTreeByInPre �޼���: Inorder, preorder ��ȸ�� ������ �޼��� ���� Ʈ�� ����� �޼���
	public void buildTreeByInPre(int in[], int pre[]) {
		// �ʱ�ȭ
		pIndex = 0;
		
		// ����Լ� ȣ��: �迭 �� ó������ ������.
		root = buildTreeByInPre(in, pre, 0, in.length-1);
		
	}// buildTreeByInPre �޼��� ����
	
	
	// buildTreeByInPre �޼���: inorder �迭, preorder �迭, inorder���� ó���� start�� end �ε���
	private Node buildTreeByInPre(int in[], int pre[], int start, int end) {
		
		// start�� end �����Ͱ� ���� ����ĥ ��
		if(start>end) {
			return null;
		}
		
		// preorder ��ȸ�� ����� 0���� �迭���� �����ͼ� ��带 ���� -> Ʈ���� ���� ���
		Node node = new Node(pre[pIndex++]);
		
		// start�� end�� ���� ��, ����Ʈ���� ��尡 1���� �ִ� ���̴�.
		if(start == end) {
			return node;
		}
		
		// inorder ��ȸ ������� �迭�� �� ��ȣ
		int mid = search(in, start, end, node.data);
		// ���� ����Ʈ��
		node.left = buildTreeByInPre(in, pre, start, mid-1);
		// ������ ����Ʈ��
		node.right = buildTreeByInPre(in, pre, mid+1, end);
		
		return node;
		
	}// buildTreeByInPre �޼��� ����
	
	
	// buildTreeByInPost �޼���: inorder�� postorder ��ȸ�� ������ �޼��� ���� Ʈ�� ����� �޼���
	public void buildTreeByInPost(int in[], int post[]) {
		
		// postorder������ ��Ʈ�� �� �������� �ִ�. 
		pIndex = post.length-1;
		
		// ����Լ�
		root = buildTreeByInPost(in, post, 0, in.length-1);
		
	}// buildTreeByInPost �޼��� ����
	
	
	// buildTreeByInPost �޼���: inorder �迭, postorder �迭, inorder���� ó���� start�� end �ε���
	private Node buildTreeByInPost(int in[], int post[], int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		Node node = new Node(post[pIndex--]);
		
		if(start == end) {
			return node;
		}
		
		// ���� �ȿ� �ִ� ������ ������ ������
		int mid = search(in, start, end, node.data);
		// ������ ���� Ʈ�� ��� ���� -> �迭 �ڿ��� ������ ���� ������ ������ ���� ã�´�. postorder: left, right, root
		node.right = buildTreeByInPost(in, post, mid+1, end);
		// ���� ���� Ʈ�� ���
		node.left = buildTreeByInPost(in, post, start, mid-1);
		return node;
		
	}// buildTreeByInPost �޼��� ����
	
	
	// search �޼���
	private int search(int arr[], int start, int end, int value) {
		int i;
		for(i=start; i<=end; i++) {
			if(arr[i] == value) {
				return i;
			}
		}
		return i;
	}// search �޼��� ����

	
	// printInorder �޼���: Ʈ���� ����� ����� �´��� inorder�� ����ϴ� �޼���
	void printInorder(Node node) {
		if(node == null) {
			return;
		}
		
		printInorder(node.left);
		System.out.print(node.data +  " ");
		printInorder(node.right);
	}// printInorder �޼��� ����
	
}// tree Ŭ���� ����


// Original_Tree_Imp Ŭ����
public class Original_Tree_Imp {
	
	// main �޼��� 
	public static void main(String[] args) {
		
		Tree tree = new Tree();
		int[] pre = {4,2,1,3,6,5,7};
		int[] in = {1,2,3,4,5,6,7};
		int[] post = {1,3,2,5,7,6,4};
		
		tree.buildTreeByInPre(in, pre);
		tree.printInorder(tree.root);
		System.out.println(" ");
		
		tree.buildTreeByInPost(in, post);
		tree.printInorder(tree.root);
		
	}// main �޼��� ����
	
}// Original_Tree_Imp Ŭ���� ����
