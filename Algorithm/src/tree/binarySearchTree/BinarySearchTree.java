package tree.binarySearchTree;

/*
     (1)
               ��         ��
   (2)  (3)
          ��     ��
 (4) (5)
 
 Inorder (Left, Root, Right): 4 2 5 1 3
 Preorder (Root, Left, Right): 1 2 4 5 3
 Postorder (Left, Right, Root): 4 5 2 3 1
*/

//Ʈ�� ��� �����
class Node {
	//���� Ʈ��
	//������
	int data;
	//���� child ���
	Node left;
	//������ child ���
	Node right;

}//Node Ŭ���� ����

//Ʈ�� Ŭ����
class Tree{
	
	//Ʈ�� ��Ʈ
	public Node root;
	
	//setRoot: ��Ʈ ����
	public void setRoot(Node node) {
		this.root = node;
		
	}//setRoot �޼��� ����
	
	//getRoot: ��Ʈ ��������
	public Node getRoot() {
		return root;
	
	}//getRoot �޼��� ����
	
	
	//��带 ����� �Լ�
	public Node makeNode(Node left, int data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}//makeNode ����
	
	
	//inorder ��ȸ: Left, Root, Right
	public void inorder(Node node) {
		
		if(node!=null) {
			//left child
			inorder(node.left);
			//��Ʈ
			System.out.println(node.data);
			//right child
			inorder(node.right);
			
		}
		
	}//inorder ����
	
	//preorder ��ȸ: Root, Left, Right
	public void preorder(Node node) {
		
		if(node !=null ) {
			//root
			System.out.println(node.data);
			//left child
			preorder(node.left);
			//right child
			preorder(node.right);
		}
	}//preorder ����
	
	
	//postorder ��ȸ: Left, Right, Root
	public void postorder (Node node) {
		
		if(node != null) {
			//left child
			postorder(node.left);
			postorder(node.right);
			System.out.println(node.data);
		}
	}
}//Tree Ŭ���� ����


// BinarySearchTree Ŭ����
public class BinarySearchTree {
	
	//main �޼���
	public static void main(String[] args) {
		Tree t = new Tree();
		Node n4 = t.makeNode(null, 4, null);
		Node n5 = t.makeNode(null, 5, null);
		Node n2 = t.makeNode(n4, 2, n5);
		Node n3 = t.makeNode(null, 3, null);
		Node n1 = t.makeNode(n2, 1, n3);
		t.setRoot(n1);
		//t.inorder(t.getRoot());
		//t.preorder(t.getRoot());
		t.postorder(t.getRoot());
		
	}// main �޼��� ����
	
}// BinarySearchTree Ŭ���� ����