package tree.binarySearchTree.alg.building.originalTree;

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
		
	}
	
	// Ʈ���� ù ��° ��Ʈ ��� ����
	Node root;
	
	// �迭���� ������ �о��� �� ����
	static int pIndex = 0;
	
	//Inorder, preorder ��ȸ�� ������ �޼��� ���� Ʈ�� ����� �޼���
	public void buildTreeByInPre(int in[], int pre[]) {
		pIndex = 0;
		
		// ����Լ�: �迭 �� ó������ ������.
		root = buildTreeByInPre(in, pre, 0, in.length-1);
		
	}// buildTreeByInPre �޼��� ����
	
	
	// inorder �迭, preorder �迭, inorder���� ó���� start�� end �ε���
	private Node buildTreeByInPre(int in[], int pre[], int start, int end) {
		
		// start�� end�� ���� ����ĥ ��
		if(start>end) {
			return null;
		}
		
		Node node = new Node(pre[pIndex++]);
		
		if(start == end) {
			return node;
		}
		
		
		int mid = search(in, start, end, node.data);
		node.left = buildTreeByInPre(in, pre, start, mid-1);
		node.right = buildTreeByInPre(in, pre, mid+1, end);
		
		return node;
	}
	
	
	// inorder�� postorder ��ȸ�� ������ �޼��� ���� Ʈ�� ����� �޼���
	public void buildTreeByInPost(int in[], int post[]) {
		
		// postorder������ ��Ʈ�� �� �������� �ִ�. 
		pIndex = post.length-1;
		
		// ����Լ�
		root = buildTreeByInPost(in, post, 0, in.length-1);
	}
	
	private Node buildTreeByInPost(int in[], int post[], int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		Node node = new Node(post[pIndex--]);
		
		if(start == end) {
			return node;
		}
		
		int mid = search(in, start, end, node.data);
		node.right = buildTreeByInPost(in, post, mid+1, end);
		node.left = buildTreeByInPost(in, post, start, mid-1);
		return node;
	}
	
	
	private int search(int arr[], int start, int end, int value) {
		int i;
		for(i=start; i<=end; i++) {
			if(arr[i] == value) {
				return i;
			}
		}
		return i;
	}

	
	void printInorder(Node node) {
		if(node == null) {
			return;
		}
		
		printInorder(node.left);
		System.out.print(node.data +  " ");
		printInorder(node.right);
	}
	
	
}

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
		
	}
}
