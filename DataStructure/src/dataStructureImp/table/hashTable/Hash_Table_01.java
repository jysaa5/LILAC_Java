package dataStructureImp.table.hashTable;

import java.util.LinkedList;

//1. HashTable ����
class HashTable {

	// 2. HashTable�� ������ �����͸� ��´�.
	class Node {
		// �˻���: Ű
		String key;
		// �˻� ���
		String value;

		// ������ ����
		public Node(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		// value�� �����´�. = get �Լ�
		String value() {
			return value;
		}

		// value�� �����Ѵ�. = set �Լ�
		void value(String value) {
			this.value = value;
		}

	}//Node ����

	// �����͸� ������ ����Ʈ�� �迭�� ���� -> �迭�� ����� �������� Ÿ���� LinkedList�� �����.
	LinkedList<Node>[] data;

	//�ؽ� ���̺��� ����� ���� �迭���� �󸶸�ŭ ������ ���� ������ �̸� ����
	HashTable(int size) {
		this.data = new LinkedList[size];
	}

	//�⺻������ �߿��� �Լ�
	//1.�ؽ� �˰��� �Լ�
	//�ؽ� �˰����� ���� �ִ� �Լ�: Ű�� �޾Ƽ� �ؽ��ڵ带 ��ȯ�Ѵ�.
	int getHashCode(String key) {
		int hashcode = 0;
		//Ű ���� �ƽ�Ű�ڵ带 �����ͼ� �����ϴ� �ؽ� �˰���
		for(char c: key.toCharArray()) {
			hashcode += c;
		}
		return hashcode;
		
	}//getHashCode ����
	
	//2.hashcode�� �޾Ƽ� �迭 ���� index�� ���� �Լ�
	int convertToIndex(int hashcode) {
		
		return hashcode % data.length;
	
	}//convertToIndex ����
	
	
	//3. �˻� ��, index�� �迭 ���� ã�� ���Ŀ� �迭 �� �ȿ� ��尡 ������ ���� �� ��, �˻� Ű�� �ش� ��带 ã�ƿ��� �Լ�
	Node searchkey(LinkedList<Node> list, String key) {
		//�迭 ���� null�϶�
		if(list ==null) {
			return null;
		}
		//�迭 ���� ����.
		for(Node node: list) {
			//key���� ���ϸ鼭 node�� ã�´�.
			if(node.key.equals(key)) {
				return node;
			}
			
		}
		return null;
	}//searchkey ����
	
	//4.�����͸� �޾Ƽ� �����ϴ� �Լ�
	void put(String key, String value) {
		//�ؽ� �ڵ�
		int hashcode = getHashCode(key);
		//�迭 �� ��ȣ
		int index = convertToIndex(hashcode);
		
		//���
		System.out.println(key +", hashcode("+ hashcode +"), index(" + index+")");
		
		//�迭 �� ��ȣ�� �̿��ؼ� ������ �ִ� �����͸� �����´�.
		LinkedList<Node> list = data[index];
		
		//�迭�� null�� ��.
		if(list == null) {
			list= new LinkedList<Node>();
			data[index] = list;
		}
		
		//�迭�濡 �ش� Ű�� ��带 �����´�. 
		Node node = searchkey(list, key);
		
		//��尡 null�̸� �����Ͱ� ���ٴ� ���̴�.
		if(node == null) {
			//�޾ƿ� ������ ������ ��� ��ü�� �����Ѵ�.
			list.addLast(new Node(key, value));
		}else {
			
			//��尡 null�� �ƴ� ��쿡�� �ش� ������ ������ؼ� �ߺ�Ű ó��
			node.value(value);
			
		}
		
	}//put ����
	
	
	//5.Ű�� ������ �����͸� �������� �Լ�
	String get(String key) {
		
		int hashcode = getHashCode(key);
		int index = convertToIndex(hashcode);
		LinkedList<Node> list = data[index];
		
		Node node = searchkey(list, key);
		
		return node == null? "Not found": node.value();
		
	}//get ����
	
}//HashTable ����

//Hash_Table_01 Ŭ����
public class Hash_Table_01 {
	
	//main �޼���
	public static void main(String[] args) {
		HashTable h = new HashTable(3);
		
		h.put("sung", "She is pretty");
		h.put("jin", "She is a model");
		h.put("hee", "She is an angel");
		h.put("min", "She is cute");
		
		//����� 
		h.put("sung", "She is beautiful");
		
		System.out.println(h.get("sung"));
		System.out.println(h.get("jin"));
		System.out.println(h.get("hee"));
		System.out.println(h.get("min"));
		
		//���� ������ ȣ��
		System.out.println(h.get("jae"));
		
	}//main ����

}//Hash_Table_01 ����
