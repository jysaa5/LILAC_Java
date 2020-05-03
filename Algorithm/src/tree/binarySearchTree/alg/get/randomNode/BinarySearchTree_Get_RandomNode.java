package tree.binarySearchTree.alg.get.randomNode;

import java.util.Random;

// ����: ���� �˻� Ʈ������ ������ ��带 �������� �˰����� �����Ͻÿ�.
// ��, ��� ��忡 ������ Ȯ���� ������ ��带 �����;� �ϸ�, �ʿ��� ��� ��忡 �߰� ������ �����ص� �ȴ�.

// Solution 1: Ʈ���� ��� ��ȸ�ؼ� ��带 �迭�� ��´�. �� ���� �������� �迭 �ε����� �̴´�.
// -> ������: ������ ���� ����ؾ� �ǰ� Ʈ�� ��ü�� ���� ������ �ð����⵵�� ��ȿ�������� �þ��.

// Solution 2: ������ �������� �����ؼ� �� �ٱ� �߿��� ���� �������� ���� ���
// -> ������: Ʈ�� balance�� ���� ������ ª�� �κ��� ���� Ȯ���� ����.

// Solution 3: ��� ��ü ���� �ȿ��� ���� ���ڸ� �� �� �����ͼ� ��Ʈ���� ī��Ʈ�ϸ鼭 ��ȸ�ϴٰ� �ش� ���ڿ� �����ϸ� ��ȯ.
// inorder�� ��ȸ�Ѵ�. �ε����� 0���� �����Ѵ�.
// ��忡 ���� �ڱ� �ؿ� �ִ� ����� ������ �����Ѵ�.�ڱ� �ڽ� ������ �����̴�.

/*     
 *     (4) -> 10��
 *    /   \
 *  (0)   (5)    -> 4�� / 5��
 *    \      \
 *    (1)    (7)  -> 3�� / 4��   
 *      \    /  \
 *      (2) (6) (8)  -> 2�� / 1�� / 2��
 *        \       \
 *        (3)     (9) -> 1�� / 1��
 * 
 * -> 7�� �ε��� = 8��° ��� ã��
 * -> ��Ʈ���� ���� ���(0)�� ������ 4�̹Ƿ� 7���� �۴�. 4�� ������ �ƴϹǷ� ��Ʈ�� ���ܵȴ�.
 * -> 7 - 5  = 2 (ã�� �ε������� ���ܵǴ� ���� ����)
 * -> ������ ���(5)���� ������ ��� ���� 0���� ���� �ʰ� ������ �ʱ� ������ ������ ���(7)�� ����.
 * -> 2 - 1 = 1 (ã�� �ε������� ���ܵǴ� ���� ����)
 * -> ã�� �ε��� ������ 1�ε�, ���� ��� 7�� ���� ����� �������� ���� �ʰ� ���� ������ ���� ��带 ����Ų��.
 * 
 * (ã�� �ε����� ���� < ���� ����� ����  -> ���� ���)
 * (ã�� �ε����� ���� = ���� ����� ���� -> ��Ʈ ���)
 * (ã�� �ε����� ���� > ���� ����� ���� -> ������ ���)
 * 
 * */

class Tree{
	class Node{
		int data;
		Node left;
		Node right;
		int size = 0;
	
		// ������
		Node (int data){
			this.data = data;
			this.size = 1;
		}
		
		// insert �޼���: Ʈ���� ��带 ����
		void insert(int data) {
			
			if(data <= this.data) {
				
				if(left == null) {
				
					left = new Node(data);
				
				}else {
				
					left.insert(data);
			
				}
			
			}else {
			
				if(right == null) {
				
					right = new Node(data);
				
				}else {
				
					right.insert(data);
				
				}
			}
			
			size++;
	
		}// insert �޼��� ����
		
		
		// size �޼���: size ��ȯ �޼���
		int size() {
			
			return size;
			
		}// size �޼��� ���� 
		
		
		// find �޼���: ������ ��带 ã�� �޼���
		Node find(int data) {
			
			if(data == this.data) {
			
				return this;
			
			}else if(data < this.data) {
			
				return left != null ? left.find(data) : null;
			
			}else if(data > this.data) {
				
				return right != null ? right.find(data) : null;
			
			}else {
			
				return null;
			
			}
			
		}// find �޼��� ����

		
		// getItNode �޼���: �ε����� ���ڷ� ������ ��带 ��ȯ�ϴ� �޼���
		Node getIthNode(int i) {
			
			int leftSize = left == null ? 0 : left.size();
			
			if(i < leftSize) {
				
				return left.getIthNode(i);
			
			}else if (i == leftSize) {
			
				return this;
			
			}else {
			
				return right.getIthNode(i - (leftSize+1));
			
			}
			
		}// getIthNode �޼��� ���� 		
	}// Node Ŭ����
	
	Node root;
	
	// size �޼���: ���� Ʈ���� ����� ��ȯ�ϴ� �޼���
	int size() {
		return root == null ? 0 : root.size();
	}// size �޼��� ����
	
	
	// insert �޼���: ���� ���ڷ� �޾Ƽ� ��� �߰�
	void insert(int data) {
		
		if(root == null) {
			root = new Node(data);
		}else {
			root.insert(data);
		}
		
	}// insert �޼��� ����
	
	
	// getRandomNode �޼���: ������ ��带 �������� �޼���
	Node getRandomNode() {
		if(root == null) {
			return null;
		}
		Random random = new Random();
		int i = random.nextInt(size());
		return root.getIthNode(i);
	}// getRandomNode �޼��� ����
	
}// Tree Ŭ���� ����


// BinarySearchTree_Get_RandomNode Ŭ����
public class BinarySearchTree_Get_RandomNode {

	// main �޼���
	public static void main(String[] args) {
		
		Tree t = new Tree();
		t.insert(4);
		t.insert(0);
		t.insert(1);
		t.insert(2);
		t.insert(5);
		t.insert(7);
		t.insert(8);
		t.insert(3);
		t.insert(6);
		t.insert(9);
		System.out.println(t.getRandomNode().data);
		
		
	}// main �޼��� ����
	
}// BinarySearchTree_Get_RandomNode Ŭ���� ����