package imp.list.array.list_02;

// Array (�迭)
// PHP -> Dynamic
// Java -> fixed

// ArrayList: �˻� �ð� = O(1)
// �迭���� �� ���� �迭 ���� 2�� ū ũ��� �ø���. 
// ������ �ִ� �����͸� �ٽ� �����ϴ� �۾� = Doubling, ���� �ð� = O(n)
// �Է� �ð� = O(1)

class ArrayList{
	// �迭�� �� ������
	private Object[] data;
	// �迭�� ũ��
	private int size;
	// ���� �����͸� �߰��� ��ġ�� ����ϴ� ����
	private int index;
	
	// ������
	public ArrayList() {
		this.size = 1;
		this.data = new Object[this.size];
		this.index = 0;
	}
	
	// add �޼��� 
	public void add(Object obj) {
		
		System.out.println("index: "+this.index+", size: "+ this.size +", data size:"+this.data.length);
		
		// �迭���� �� á�� ��
		if(this.index == this.size -1) {
			doubling();
		}
		
		// ������ ���� ��
		data[this.index] = obj;
		this.index++;
		
	}// add �޼��� ����
	
	
	// doubling �޼���
	private void doubling() {
		// ������ 2��� �ø���
		this.size = this.size*2;
		
		Object[] newData = new Object[this.size];
		
		// ���� �迭���� ���鼭 ���� ���̱�
		for(int i = 0; i<data.length; i++) {
			
			newData[i] = data[i];
		
		}
		
		this.data = newData;
		System.out.println("*** index: "+this.index+", size: "+ this.size +", data size:"+this.data.length);
	}// doubling �޼��� ����
	
	
	// get �޼���: �ε��� ��ȣ�� ������ �����͸� �������� �޼��� 
	public Object get(int i) throws Exception{
		
		// �ε����� �迭���� ���� ���� ��
		if(i > this.index-1) {
			throw new Exception("ArrayIndexOutOfBound");
		}else if(i < 0) {
			throw new Exception("Negative Value");
		}
		
		return this.data[i];
		
	}// get �޼��� ����
	
	
	public void remove(int i) throws Exception{
		
		if(i>this.index-1) {
			throw new Exception("ArrayIndexOutOfBound");
		}else if(i<0) {
			throw new Exception("Negative Value");
		}
		
		System.out.println("data removed: "+ this.data[i]);
		// �ڿ� �ִ� �����͸� ������ ����Ʈ
		for(int x = i; x <this.data.length-1; x++) {
			data[x] = data[x+1];
		}
		this.index --;
	}
	
}// ArrayList Ŭ���� 


// ArrayList_01 Ŭ����
public class ArrayList_01 {
	
	// main �޼���
	public static void main(String[] args) throws Exception{
		ArrayList al = new ArrayList();
		al.add("0");
		al.add("1");
		al.add("2");
		al.add("3");
		al.add("4");
		al.add("5");
		al.add("6");
		al.add("7");
		al.add("8");
		al.add("9");
		System.out.println(al.get(5));
		al.remove(5);
		System.out.println(al.get(5));
	}// ArrayList_01 �޼��� ����

}// ArrayList_01 Ŭ���� ����