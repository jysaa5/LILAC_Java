package tree.binarySearchTree.ex.find.path;

import java.util.HashMap;

// ����: �־��� ����Ʈ���� �ִ�. ����Ʈ���� ��忡�� �������� ����Ǿ��ִ�. (���� ���� ����) ����� ����� �ջ��� Ư�� ���ڰ� �Ǵ�
// ����� ������ ã���ÿ�. ����� ���۰� ������ ���� �� �� ������ ������ ������ �Ʒ��θ� �ջ��� �Ǿ�� �Ѵ�.

/*
 *      (4)
 *      /  \
 *     /    \
 *    /      \
 *   (1)     (7)
 *   / \    /  \
 * (0) (2) (5) (8)
 *       \   \   \
 *       (3) (6) (9)
 * 
 * -> ��: 6�� ����� ��� = 1 + 2 + 3 , 6
 * -> �� 2��
 *
 *
 * <�ջ��� ���� 5�� ��� ã��>
 *
 *       (4) 
 *      /   \
 *     /     \
 *    /       \
 *   (-2)      (2)  
 *   /  \     /   \
 * (1)  (8) (-1) (-3) 
 *        \    \     \
 *        (-4) (3)   (7) 
 *                     \
 *                     (-4)
 *          
 */

// Solution 3: Hash���� ����Ͽ� Ǯ���غ���.
// �ð����⵵: O(n)
// Tree Ŭ����
class Tree_03{
	class Node{
		int data;
		Node left;
		Node right;
		
		//������
		Node(int data){
			this.data = data;
		}
		
	}
	
	Node root;
	
	//������
	Tree_03(int size){
		this.root = makeBST(0,size-1);
	}
	
	
	// makeBST: ���� �˻� Ʈ���� ����� �޼���
	Node makeBST(int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		int mid = (start+end)/2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid-1);
		node.right = makeBST(mid+1, end);
		return node;
		
	}// makeBST �޼��� ����
	
	
	// countPathsWithSum �޼���: �ջ� ���� ������ ��Ʈ�� �������� ��θ� Ž���ϴ� ����Լ� ȣ��
	int countPathsWithSum(int targetSum) {
		
		// �ؽø� ����
		// ����� ���� key�� ���
		HashMap<Integer, Integer> hashTable = new HashMap<Integer, Integer>();

		// �ʱⰪ���� ������� 0�� �ִ´�.
		hashTable.put(0, 1);
		
		return countPathsWithSum(root, targetSum, 0, hashTable);

	}// countPathsWithSum �޼��� ����
	
	
	// countPathsWithSum �޼���: �˻��� ���, ã�� �ջ갪, ���� �ջ갪, �ؽ����̺�
	int countPathsWithSum(Node node, int targetSum, int currSum, HashMap<Integer, Integer> hashTable) {
		
		// Ʈ���� ���� �������� ��.
		if(node == null) {
			return 0;
		}
		
		// ���� �ջ갪
		currSum += node.data;
		// ���� ������ ���ϴ� �ջ� ���� ���� ���� �� 
		int sum = currSum - targetSum;
		// sum���� �ش��ϴ� Ű�� = ��� ���� �ִ��� ã�´�.
		int totalPaths = hashTable.getOrDefault(sum, 0);
		// �ؽø��� ���� ���� 1�� �߰��Ѵ�. �� ���ڿ� ��尡 1�� ������ �����Ѵ�.
		incrementHashTable(hashTable, currSum, 1);
		
		totalPaths += countPathsWithSum(node.left, targetSum, currSum, hashTable);
		totalPaths += countPathsWithSum(node.right, targetSum, currSum, hashTable);
		
		// ���� �ջ� ���� ������ key���� value�� �����Ѵ�.
		// �ؽøʿ��� ���� ��� ���� value ���� 1�� ����� �ȴ�.
		incrementHashTable(hashTable, currSum, -1);
		
		return totalPaths;
		
	}// countPathsWithSum �޼��� ����
	
	
	// incrementHashTable �޼���: key�� val�� �ؽ����̺��� ������Ʈ ���ִ� �޼���
	void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int val) {
		
		int newCount = hashTable.getOrDefault(key, 0) + val;
		if(newCount == 0) {
			// �ؽøʿ��� Ű�� ����
			hashTable.remove(key);
		}else {
			// �ؽøʿ��� Ű�� value ������Ʈ(������ �������� ���Ӱ� �߰�)
			hashTable.put(key, newCount);
		}
	}
	
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
// BinarySearchTree_Find_Path_Sol_3 Ŭ����
public class BinarySearchTree_Find_Path_Sol_3 {

	
	// main �޼���
	public static void main(String[] args) {
		
		Tree_03 tree = new Tree_03(10);
		System.out.println(tree.countPathsWithSum(3));
		
		
	}// main �޼��� ����
	
	
}// BinarySearchTree_Find_Path_Sol_3 Ŭ���� ����
