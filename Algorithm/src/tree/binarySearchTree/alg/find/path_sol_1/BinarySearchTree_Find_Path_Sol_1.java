package tree.binarySearchTree.alg.find.path_sol_1;


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
 * <����: ��Ʈ 4�������� �ջ����� 6�� �Ǵ� ��� ã��>
 *
 *       (4) -> 4
 *      /   \
 *     /     \
 *    /       \
 *   (-2)      (2)   -> 2, 6(ã��: 1�� ���� ��ȯ)
 *   /  \     /   \
 * (1)  (8) (-1) (-3)  -> 3, 10, 5, 3
 *        \    \     \
 *        (-4) (3)   (7) -> 6(ã��: 1�� ���� ��ȯ), 8, 10
 *                     \
 *                     (-4) -> 6
 * -> ���� �� ã���� ���� 0�� ��ȯ
 * -> ����� ����: 3�� 
 * -> ��Ʈ���� ��ü�� ���� O(n) �̰� ���� ��忡���� ���ʳ���� ���� Ʈ���� Ȯ���ϹǷ� O(nlogn)�̴�. 
 * -> �� �ʸ� ��� �Ǿ� �ִ� Ʈ���� ��� �־��� �ð����⵵�� O(n^2) �̴�.
 */
// �� ��忡�� ���� Ʈ�������� ���� �ջ��Ѵ�. 
// �ð����⵵: �ּ� = O(n log n), �־� = O (n^2)

// Solution 1: �� ����� ���� Ʈ���� ���鼭 ����� �ջ��� ã�´�.

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
		
		return countPathsWithSum(root, targetSum);

	}// countPathsWithSum �޼��� ����
	
	
	int countPathsWithSum(Node root, int targetSum) {
		
		if(root == null){
			return 0;
		}
		
		// �����带 �������� ����� ������ ���� �Լ��� ȣ��
		int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
		// ����
		int pathsOnLeft = countPathsWithSum(root.left, targetSum);
		// ������
		int pathsOnRight = countPathsWithSum(root.right, targetSum);
		
		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}// countPathsWithSum �޼��� ����
	
	
	// countPathsWithSumFromNode �޼���: Ư�� ��带 ���������� ����� ������ ã�� �޼���
	int countPathsWithSumFromNode(Node node, int targetSum, int currSum) {
		
		if(node == null) {
			return 0;
		}
		
		currSum += node.data;
		int totalPaths = 0;
		if(currSum == targetSum) {
			totalPaths++;
		}
		
		totalPaths += countPathsWithSumFromNode(node.left, targetSum, currSum);
		totalPaths += countPathsWithSumFromNode(node.right, targetSum, currSum);
		
		return totalPaths;
		
	}// countPathsWithSumFromNode �޼��� ����
	
	
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
// BinarySearchTree_Find_Path_Sol_1 Ŭ����
public class BinarySearchTree_Find_Path_Sol_1 {

	
	// main �޼���
	public static void main(String[] args) {
		
		Tree tree = new Tree(10);
		System.out.println(tree.countPathsWithSum(3));
		
		
	}// main �޼��� ����
	
	
}// BinarySearchTree_Find_Path_Sol_1 Ŭ���� ����
