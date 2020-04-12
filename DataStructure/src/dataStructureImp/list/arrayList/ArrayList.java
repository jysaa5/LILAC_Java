package dataStructureImp.list.arrayList;

//ArrayList: ��� ����Ʈ Ŭ����
public class ArrayList {

	//Object ������ Ÿ���� �迭 ����
	//���� java�� collection framework�� arraylist�� ũ��� ���������� �ʴ�.
	private Object[] elementData = new Object[100];
	
	//�������� ����, ������
	private int size = 0;

	//addLast �޼���: �� �������� ������ �߰�
	public boolean addLast(Object element) {
	
		elementData [size] = element; 
		size++;
		return true; 
	
	}//addLast ����
	
	
	//add �޼���: �߰��� ������ �߰�
	//�߰� �ϰ��� �ϴ� �ε��� ��ġ�� �κп� ������ ��������, �� ��ġ ������ �ִ� �����͵��� ��� �ڷ� �� ĭ��
	//�о�� �Ǳ� ������, ���� ���� ����. -> ArrayList�� ����
	//index: ������ ��ġ, element: ������ ������
	//Linked List���� ������.
	public boolean add(int index, Object element) {
		
		for(int i = size - 1; i >= index; i--) {
			
			elementData[i+1] = elementData[i];
			
		}
		
		//������ ����
		elementData[index] = element;
		//����Ʈ ������ ����
		size ++;
		return true;
	}
	
	//addFirst �޼���: ����Ʈ�� �� ó���� �����͸� �߰��ϴ� �޼���
	public boolean addFirst(Object element) {
	
		return add(0, element);
		
	}//addFirst ����
	
	
	//toString �޼���
	public String toString() {
		
		String str = "[";
		
		for(int i=0; i<size; i++) {
			
			str += elementData[i];
			
			if(i < size-1) {
			str += ",";
			}
		
		}
		
		return str + "]";
	
	}


	//remove �޼���: ������ ����
	//������ ���� ��ȯ
	//�����͸� ������ ������ ������ ��ܾ� �ȴ�.
	//Linked List���� ������.
	public Object remove(int index) {
		
		Object removed = elementData[index];
		
		for(int i= index+1; i <= size-1 ; i++) {
			
			elementData[i-1] = elementData[i];
		
		}
		
		size--;
		elementData[size] = null;
	
		return removed;
	}//remove ����
	
	
	public Object removeFirst() {
		return remove(0);
	}
	
	
	public Object removeLast() {
		return remove(size-1);
	}
	
	
	//get �޼���: elementData �迭���� ��ȸ
	//ArrayList�� ����: ��ȸ �ӵ��� ������.
	public Object get(int index) {
		return elementData[index];
	}
	
	//�ܺο��� size���� �������� ���ϵ��� �޼���� ����.
	//size �޼���: ����Ʈ�� ũ�⸦ ��ȯ�ϴ� �޼���
	public int size() {
		return size;
	}


	//indexOf �޼���: ���ڷ� ���� �����Ͱ� ��� ��ġ�� �ִ��� index�� ��ȯ�ϴ� �޼���
	public int indexOf(Object o) {
		
		for(int i=0; i<size; i++) {
		
			if(o.equals(elementData[i])) {
				return i;
			}
	
		}
		
		return -1;
	}//indexOf ����
	
	
	public ListIterator listIterator() {
		
		return new ListIterator();
	}
	
	//ListIterator Ŭ����
	public class ListIterator{
		
		//next�޼��忡�� ���̴� �ε��� ������ ������ ȣ��� �������� index���� ���� �ִ�.
		private int nextIndex = 0;
		
		//next �޼���
		public Object next() {
//			Object returnData = elementData[nextIndex];
//			nextIndex ++;
//			return returnData;
			
			//���� nextIndex ���� ��ȯ �ǰ� ���� ���� �Ѵ�.
			return elementData[nextIndex++];
		
		}//next ����
		
		//hasNext �޼���
		public boolean hasNext() {
			
			return nextIndex < size;
		
		}//hasNext ����
		
	
		public Object previous() {
			return elementData[--nextIndex];
		}
		
		public boolean hasPrevious() {
			return nextIndex > 0;
		}
		
		public void add(Object element) {
			ArrayList.this.add(nextIndex++, element);
		}
		
		//remove �޼���
		//next() �޼��带 �� ���̶� ȣ���ϰ� ������ ������ ������ �����ϴ�.
		public void remove() {
			ArrayList.this.remove(nextIndex-1);
			nextIndex --;
		}
	
	
	}//ListIterator Ŭ����
	
	
	
}//ArrayList ����

