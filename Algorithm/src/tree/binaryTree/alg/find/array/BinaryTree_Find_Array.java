package tree.binaryTree.alg.find.array;

import java.util.ArrayList;
import java.util.LinkedList;

// ����: �迭�� ���� ���ʺ��� �ϳ��� �����鼭 �����˻�Ʈ���� �������.
// �־��� �����˻�Ʈ���� ���� �� �ִ� ��� �迭�� ã�� �˰����� �����Ͻÿ�. (��, Ʈ���� �ߺ����� ����.)

/* �迭: |2|0|1|3|4|
 *    
 *     2
 *    / \
 *   0   3
 *    \   \
 *     1   4
 * 
 * �迭: |2|0|3|1|4|
 * 
 *     2
 *    / \
 *   0   3
 *    \   \
 *     1   4
 * 
 * -> ������ Ʈ���� ������ �迭�� 6������ �ִ�.
 * 
 * �迭: |2|4|0|1|3|
 * 
 *     2
 *    / \
 *   0   4
 *    \  /
 *    1  3   
 * 
 * -> �ٸ� Ʈ���� ���´�.
 * 
 * solution: root = 2, left = 0 -> 1, right = 3 -> 4
 * �� ������ ���Ѿ� ������ Ʈ���� ���´�.
 * 
 * ------
 * 2
 * ------
 * 2�� �迭�� �ؿ� ���������� 2������ ������ ������� �迭�� �ִ´�.
 * 
 * ---------
 * 0 1
 * ---------
 * 3 4
 * ---------
 * 
 * -> ������ ���� ������ �Ʒ��� ����.
 * 
 * |2|0|1|3|4|
 * 
 * |2|0|3|1|4|
 * 
 * |2|0|3|4|1|
 * 
 * |2|3|0|1|4|
 * 
 * |2|3|0|4|1|
 * 
 * |2|3|4|0|1|
 * 
 * */

// Tree Ŭ����
class Tree{
	
	// Node Ŭ����
	static class Node{
		int data;
		Node left;
		Node right;
		
		// ������
		Node (int data){
			this.data  = data;
		}
		
	}// Node Ŭ����
	
	Node root;
	
	// ������
	Tree (int size){
		root = makeBST(0, size-1);
	}
	
	// makeBST �޼���: ���� �˻� Ʈ���� ����� �޼���
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
	
}// Tree Ŭ���� ����


// BinaryTree_Find_Array Ŭ����
public class BinaryTree_Find_Array {

	// allSequences �޼���: Ʈ���� ����� ��� �迭�� �������� �޼���
	static ArrayList<LinkedList<Integer>> allSequences(Tree.Node node){
		
		// ��� ���� ���� 
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		
		// ��尡 null �϶�
		if(node == null) {

			result.add(new LinkedList<Integer>());			
			return result;
		
		}
		
		// �� ó�� root�� ���� ��.
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		// ��Ʈ �߰�
		prefix.add(node.data);
	
		// ���� �˻� Ʈ�� �� �ؿ��� ���� ���������ο� ���� ��带 �����;��Ѵ�.
		// ����, ������ ���� Ʈ���� ��� ȣ���Ѵ�. 
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
		
		
		// ���ʰ� ������ ���� Ʈ���� ������ ��� �����´�.
		for(LinkedList<Integer> left: leftSeq) {
			for(LinkedList<Integer> right : rightSeq) {
				
				// ��� ����� ���� ���� �� ���� �� ����
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				// ����� ���� ����� �޼��� 
				weaveLists(left, right, weaved, prefix);
				// ����� ����
				result.addAll(weaved);
			}
		}
		return result;
	
	}// allSequences �޼��� ����
	
	
	// weaveLists �޼���: ����� ���� ������ִ� �Լ�
	// first: ù ��° ������, second: �� ��° ������, results: ��� ����, prefix: ���� ���
	static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		
		// �� ������ �� �ϳ��� ���� -> ��� ��ȯ
		if(first.size() == 0 || second.size() == 0) {
			
			// ����� �� �� �� ����
			LinkedList<Integer> result = new LinkedList<Integer>();
			
			for(int data : prefix) { 
				result.add(data);
			}
			
			result.addAll(first);
			result.addAll(second);
			
			// ����� �� ������ �����ϴ� ���� ����
			results.add(result);
			
			return;
		}
		
		// ù ��° ������
		// ù ��° ���
		// ù ��° ���������� �տ� �κ� ��� ���� �迭�� �ڿ� ���̱�
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		
		// �� �ٸ� ����� �� Ȯ��
		weaveLists(first, second, results, prefix);
		
		// ���� ������� �ٽ� ������ ���� �����
		prefix.removeLast();
		first.addFirst(headFirst);
		
		
		// �� ��° ������
		// �� ��° ���
		// �� ��° ���������� �տ� �κ� ��� ���� �迭�� �ڿ� ���̱�
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		// �� �ٸ� ����� �� Ȯ��
		weaveLists(first, second, results, prefix);
		
		// ���� ������� �ٽ� ������ ���� �����
		prefix.removeLast();
		second.addFirst(headSecond);
		
	}// weaveLists �޼��� ����
	
	
	// main �޼��� 
	public static void main(String[] args) {
		
		Tree t = new Tree(3);
		ArrayList<LinkedList<Integer>> result = allSequences(t.root);
		
		for(LinkedList<Integer> l : result) {
			
			for(int data : l) {
				System.out.print(data);
			}
			
			System.out.println();
		}
		
	}// main �޼��� ����
	
}// BinaryTree_Find_Array Ŭ���� ����
