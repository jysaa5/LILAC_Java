package tree.binarySearchTree.alg.find.path_sol_2;

import java.util.ArrayList;

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
 * 1. ��Ʈ���� �����ؼ� �迭�濡 �߰�              
 * |4| | | | |
 * 
 * 2. ���� 5�� �ִ��� �˻�. ������ ���� ��带 �߰����ش�.
 * 
 * 3. ��Ʈ ���� ���� �߰��ϰ� �տ� ��忡 �����ش�.
 * |5|1| | | |
 * 
 * 3. ���� 5�� �ִ��� �˻�. �ִ�. ���� ��带 �߰����ش�.
 * -> ã�� ����� �� = 1
 * 
 * 4. ��� 0�� �߰��Ѵ�. �տ� ���鿡�� �����ش�. ���� 5�� �ִ��� �˻�.
 * |5|1|0| | |
 * -> ã�� ����� �� = 2
 * 
 * 5. ���� ��尡 �����Ƿ� ���� �ö󰡸鼭 ��ȯ�Ѵ�. ������ ��带 �����ϰ� ������ ��� �� ��ŭ �տ� ��尪���� ����.
 * |5|1| | | |
 * 
 * 6. ���1�� ������ ����� 2�� �߰����ְ� �տ� ���鿡�� ���Ѵ�. ���� 5�� �ִ��� �˻�.
 * |7|3|2| | |
 *  -> ã�� ����� �� = 2
 *  
 * 7. ���� ���� ����.��� 3�� �߰����ְ� �տ� ���鿡�� ���Ѵ�. ���� 5�� �ִ��� �˻�.
 * |10|6|5|3| |
 * -> ã�� ����� �� = 3
 * 
 * 8. ���� ��尡 �����Ƿ� ��� 3�� �������ְ� �տ� ���鿡�Լ� ���3�� ���ش�. ���� �ö󰡸鼭 ��ȯ.
 * |7|3|2| | |
 * -> ã�� ����� �� = 3
 * 
 * 9. ��� 2�� �������ְ� �տ� ���鿡�Լ� ��� 2�� ���ش�.
 * |5|1| | | |
 * -> ã�� ����� �� = 3
 *
 * 10. ��� 1�� �������ְ� �տ� ���鿡�Լ� ��� 1�� ���ش�.
 * |4| | | | |
 * -> ã�� ����� �� = 3
 * 
 * 11. ��� 4�� ������ ����� 7��带 �߰����ְ� �տ� ���鿡�� ��� 7�� �����ش�. ���� 5�� �ִ��� �˻�.
 * |11|7| | | |
 * -> ã�� ����� �� = 3
 * 
 * 12. ��� 5�� �߰����ְ� �տ� ���鿡�� ��� 5�� �����ش�. ���� 5�� �ִ��� �˻�
 * |16|12|5| | |
 * -> ã�� ����� �� = 4
 * 
 * 13. ��� 6�� �߰����ְ� �տ� ���鿡�� ��� 6�� �����ش�. ���� 5�� �ִ��� �˻�
 * |22|18|11|6 | |
 * -> ã�� ����� �� = 4
 * 
 * 14. ���� ��尡 �����Ƿ� ���� �ö󰡸鼭 ��ȯ�Ѵ�. ��� 6�� �������ְ� �տ� ���鿡�� ��� 6�� ���ش�.
 * |16|12|5| | |
 * -> ã�� ����� �� = 4 
 * 
 * 15. ���� ��尡 �����Ƿ� ���� �ö󰡸鼭 ��ȯ�Ѵ�. ��� 5�� �������ְ� �տ� ���鿡�� ��� 5�� ���ش�.
 * |11|7| | | |
 * -> ã�� ����� �� = 4 
 * 
 * 16. ���7�� ������ ����� ��� 8�� ����. ��� 8�� �߰��ϰ� �տ� ���鿡�� ��� 8�� �����ش�. ���� 5�� �ִ��� �˻�
 * |19|15|8| | |
 * -> ã�� ����� �� = 4 
 * 
 * 17. ���� ���� ����. ��� 9�� �߰��ϰ� �տ� ���鿡�� ��� 9�� �����ش�. ���� 5�� �ִ��� �˻�
 * |28|24|17|9| |
 * -> ã�� ����� �� = 4 
 * 
 * 18. ���� ��尡 �����Ƿ� ���� �ö󰡸鼭 ��ȯ�ϸ鼭 �迭�� �ִ� ���� �� ���� ���ְ� ã�� ����� ���� ��ȯ�ϰ� �����Ѵ�.
 */

// �ð����⵵: O(nd)
// d: Ʈ���� ����
// Solution 2: �߰� ����(�迭)�� ����Ͽ� Ǯ���Ѵ�.

// Tree Ŭ����
class Tree{
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
	Tree(int size){
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
		// �迭 ����
		ArrayList<Integer> array = new ArrayList<Integer>();
		// ����Լ� ȣ��
		return countPathsWithSum(root, targetSum, array);

	}// countPathsWithSum �޼��� ����
	
	// root: ó���� ���, targetSum: ����� �ջ� ��, array: �ӽ� �����
	int countPathsWithSum(Node root, int targetSum, ArrayList<Integer> array) {
		
		// Ʈ�� ���� ���� ��.
		if(root == null) {
			return 0;
		}
		
		// �� ����� ������ ������ ����
		int totalPaths = 0;
		// ��忡 �����ϸ� �迭�濡 ���� ����� ���� �����ش�. �迭�� �� ���� ���ο� ������ �߰�
		addValue(array, root.data);
		
		// �迭�濡�� ã���ϴ� �ջ� ����� ���� �˻��Ѵ�.
		totalPaths = countPaths(array, targetSum);
		
		// ����
		totalPaths += countPathsWithSum(root.left, targetSum, array);
		
		// ������
		totalPaths += countPathsWithSum(root.right, targetSum, array);
		
		// ���ƿͼ� �θ𿡰� ����� ���� ���� ��ȯ�ϱ� ����, �迭�濡�� ���� ���� �����ϰ� �ռ� ���鿡�Լ� ���ִ� �޼��� 
		removeLast(array);
		
		return totalPaths;
		
	}// countPathsWithSum �޼��� ����
	
	// addValue �޼���: �迭�濡�� ���� ��带 �ռ� ���鿡�� �����ְ� �ǳ��� ���� ��� �߰�.
	void addValue(ArrayList<Integer> array, int value) {
		
		for(int i=0; i<array.size(); i++) {
			array.set(i, array.get(i) + value);
		}
		
		array.add(value);
		
	}// addValue �޼��� ����
	
	
	// countPaths �޼���: �迭���� ���鼭 �ش��ϴ� ��� �ջ� ���� ã�� �޼���
	int countPaths(ArrayList<Integer>array, int targetSum) {
		
		int totalPaths = 0;
		
		for(int i=0; i<array.size(); i++) {
			if(array.get(i) == targetSum) {
				totalPaths ++;
			}
		}
		return totalPaths;
		
	}// countPaths �޼��� ����
	
	
	// removeLast �޼���: �߰��� ��尡 ������ ���� ��带 �迭�濡�� �����ϰ� �ռ� ���鿡�Լ� ���� ��� ���� ���ش�.
	void removeLast(ArrayList<Integer>array) {
		
		int value = array.remove(array.size()-1);
		
		for(int i=0; i<array.size(); i++) {
			
			array.set(i, array.get(i)-value);
		}
		
	}// removeLast �޼��� ����
	
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
// BinarySearchTree_Find_Path_Sol_2 Ŭ����
public class BinarySearchTree_Find_Path_Sol_2 {

	
	// main �޼���
	public static void main(String[] args) {
		
		Tree tree = new Tree(10);
		System.out.println(tree.countPathsWithSum(5));
		
		
	}// main �޼��� ����
	
	
}// BinarySearchTree_Find_Path_Sol_2 Ŭ���� ����
