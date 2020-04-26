package tree.binaryTree.alg.list;

import java.util.ArrayList;
import java.util.LinkedList;

// ����: ����Ʈ���� ������ �� �������� LinkedList�� ��� �˰����� �����Ͻÿ�.
// (���� ���, 5���� ���̸� ������ Ʈ����� 5���� LinkedList�� ������ �Ѵ�.)

// Solution1: �Լ��� ȣ��� ������, ���� ����� ������ �� ��°���� �Լ��� ���ڷ� �޴´�. ù ��° ������ 0���� 1�� ����.
// �� ������ ȣ�� �޾��� ��, �� ��° LinkedList�� ���� �Ǵ����� �Լ��� ���ڷ� �޾Ƽ� �˰� �ֱ� ������
// �׳� LinkedList�� �ش� ��带 �߰��ϸ� �ȴ�.
// �ð����⵵: O(n)
// �������⵵: O(n) + O(log n) -> ���ȣ���� �� �� ��ȯ�� �Լ��� �������� ����Ѵ�. ( O(log n)��ŭ ���� ��� )
// ��� ������ŭ ��� ȣ���� �Ѵ�. ��� ������ŭ ������ ����. 

// Solution2: root�� LinkedList�� �߰��Ѵ�. �ٸ� LinkedList�� �����ؼ� �� �ڽ��� ��带 �߰��Ѵ�.
// �� �������� �� ���ο� LinkedList�� �����ؼ� ���� �͵��� �ڽ� ������ �߰��Ѵ�. 
// �ð����⵵: O(n)
// �������⵵: O(n) 
//��� ������ŭ ��� ȣ���� �Ѵ�. ��� ������ŭ ������ ����. 

// Tree Ŭ����
class Tree{
	class Node{
		int data;
		Node left;
		Node right;
		
		// ������ 
		Node(int data){
			this.data = data;
		}// ������ ����

	}// Node Ŭ���� 
	
	Node root;
	
	//������
	Tree (int size){
		root = makeBST(0, size-1);
		
	}
	
	
	//makeBST �޼���: ���� Ʈ�� ����� �ִ� �޼��� 
	Node makeBST(int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		int mid = (start+end)/2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid-1);
		node.right = makeBST(mid+1, end);
		return node;
		
	}//makeBST �޼��� ����
	
	
	// Solution1 
	// �ʱⰪ ���� �޼���
	ArrayList<LinkedList<Node>> BSTtoList(){
		// ��������� �� �迭�� ���� �� ����
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		
		// ��� ȣ��: ����Ʈ���� ��Ʈ, ��� ���� ���� �迭��, ���� 0
		BSTtoList(root, lists, 0);
		return lists;
		
	}// BSTtoList �޼��� ����
	
	// ����Լ�
	// ��Ʈ, ������ �迭, ������ ���ڷ� ����.
	void BSTtoList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
		
		if(root == null) {
			return;
		}
		
		// ����Ʈ ����
		LinkedList <Node> list = null;
		
		// ���ο� ������ ��带 ó�� ȣ���� ��, �ش� ������ ����Ʈ�� �迭�濡 �������� �����Ƿ� ���ο� ��� ����
		// �迭�濡 �߰�
		if(lists.size() == level) {
			list = new LinkedList<Node>();
			lists.add(list);
			
		}else {
			// �ش� ������ �̹� ����Ʈ�� �ִ� ���, ������ ����Ʈ�� �ּҸ� ����
			list = lists.get(level);
		}
		
		// �ش� ����Ʈ�� ��� �߰�
		list.add(root);
		
		//��� ȣ��
		BSTtoList(root.left, lists, level+1);
		BSTtoList(root.right, lists, level+1);
		
		
	}//BSTtoList �޼��� ����
	
	
	// Solution2
	// BFS ���� ���
	ArrayList<LinkedList<Node>> BSTtoList2(){
		// ��� ���� ���� �迭 ��
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		// LinkedList ���� �� ����
		// ���� ������ ��带 ���� ����Ʈ ����
		LinkedList<Node> current = new LinkedList<Node>();
	
		// �ʱⰪ���� ��Ʈ ��� ���
		if(root != null) {
			current.add(root);
		}
		
		// ���� ������ ������ �ִ� ���� �ݺ�
		while(current.size()>0) {
			// ù ��° ������ ����濡 �߰�
			result.add(current);
			// ù ��° ������ �θ� ������ ����
			LinkedList<Node> parents = current;
			// ���� ������ ���� �����Ѵ�.
			current = new LinkedList<Node>();
			
			for(Node parent:parents) {
				if(parent.left != null) {
					current.add(parent.left);
				}
				
				if(parent.right != null) {
					current.add(parent.right);
				}
			}
			
		}
		// ��� �ڽĵ��� �߰��ϸ� ��� �� ��ȯ
		return result;
	
	}//BSTtoList2 �޼��� ����
	
	
	// ��� ��� �޼���
	void printList(ArrayList<LinkedList <Node>> arr) {
		for(LinkedList <Node> list: arr) {
			for(Node node: list) {
				System.out.print(node.data +" ");
			}
			System.out.println();
		}
	}//printList �޼��� ����
	
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
 * */

// BinaryTree_alg_list_Imp Ŭ����
public class BinaryTree_alg_list_Imp {
	
	public static void main(String[] args) {
		Tree t = new Tree(10);
		
		// Solution 1: ��� ȣ���� �̿��� ���
		//t.printList(t.BSTtoList());
		
		// Solution 2: �θ� ������ �ڽ� ��带 �����ϴ� ���
		t.printList(t.BSTtoList2());
		
	}//main �޼��� ����

	
}// BinaryTree_alg_list_Imp Ŭ���� ����
