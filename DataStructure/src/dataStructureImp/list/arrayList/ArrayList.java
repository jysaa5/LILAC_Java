package dataStructureImp.list.arrayList;

//ArrayList: ��� ����Ʈ Ŭ����
public class ArrayList {

	//Object ������ Ÿ���� �迭 ����
	//���� java�� collection framework�� arraylist�� ũ��� ���������� �ʴ�.
	private Object[] elementData = new Object[100];
	
	//�������� ����, ������
	private int size = 0;

	//�� �������� ������ �߰�
	public boolean addLast(Object element) {
		elementData [size] = element; 
		size++;
		return true; 
	}
	
	
}//ArrayList ����

