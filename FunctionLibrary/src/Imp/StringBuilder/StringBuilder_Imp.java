package Imp.StringBuilder;

// ����: �ڹ��� StringBuilder�� ���� �˾ƺ��� �����ϱ�.
// Solution: 

// String: ���ڿ� ���� �� ��, ������ ���ڵ� �� ���ľ� �Ѵ�. -> �ð����⵵ = O(xn^2)


/*
 * String joinWords(String[] words){
 *  
 *   String sentence = "";
 *   for(String w: words){
 *     sentence = sentence + w;
 *   }
 * }
 * 
 * �ð����⵵: O(x+2x+3x+..+nx) = O(x(1+2+3+..+n)) = O(xn^2)
 *
 * 
 * String joinWords(String[] words){
 *  StringBuilder sb = new StringBuilder();
 *   for(String w: words){
 *    sb.append(w);
 *   }
 *   return sb.toString();
 * }
 * 
 * �ӵ��� �����鿡�� String���� �� ����.
 * 
 * StringBuilder: �񵿱�(Asynchronous)
 * StringBuffer: ����(Synchronized)ȭ ����
 * -> StringBuilder���ٴ� StringBuffer �ӵ��� ������.
 *    ��Ƽ������ȯ��(thread safe)�̶�� ����ȭ�� �����ϱ� ���� StringBuffer�� ����ؾ� �ȴ�.
 * */

// StringBuilder Ŭ����
class StringBuilder{
	
	// ���ڿ��� ������ char�迭 ����
	private char[] value;
	// �迭���� ũ��
	private int size;
	// �迭���� �ε��� = �� ��ȣ
	private int index;
	
	// ������
	StringBuilder(){
		// �迭���� ũ��
		size = 1;
		// ũ�⸸ŭ �迭�� �����Ѵ�.
		value = new char[size];
		// �����Ǿ��� ��, �ε��� �ʱ�ȭ
		index = 0;
	}
	
	
	// append �޼���: ���ڿ��� �߰��ϴ� �Լ�
	// str: �߰��� ���ڿ�
	public void append(String str) {
		
		if(str == null) {
			str = "null";
		}
		
		// ������ ����
		int len = str.length();
		// �迭���� ���ڿ��� ���� �� �ִ� �� Ȯ�� -> �����ϸ� �ø���.
		ensureCapacity(len);
		
		for(int i=0; i<str.length(); i++) {
			// �� ���ھ� ����
			value[index] = str.charAt(i);
			index++;
		}
		System.out.println(size+", "+index);
	}// append �޼��� ����
	
	
	// ensureCapacity �޼���: �迭���� �˳����� ������ �迭���� ũ�⸦ �÷��ִ� �޼���
	private void ensureCapacity(int len) {
		
		// ���� �迭���� �ε��� + ���ڿ��� ���� > �迭 ������
		if(index + len > size) {
			// ũ�⸦ 2��� ����
			size = (size+len)*2;
			
			// ���ο� �迭�� ����
			char[] newValue = new char[size];
		
			// ���ο� �迭���� ���� �迭���� ���ڿ� ����
			for(int i=0; i<value.length; i++) {
				newValue[i] = value[i];
			}
			// value�� newValue�� �ִ´�.
			value = newValue;
			System.out.println("*** "+size+", "+index);
		
		}
		
	}// ensureCapacity �޼��� ����
	
	
	// toString �޼���: append�� ���� ���ڿ�(String)���� ��ȯ�ϴ� �޼���
	public String toString() {
		return new String(value, 0, index);
	}
	
	
}// StringBuilder Ŭ����



// StringBuilder_Imp Ŭ����
public class StringBuilder_Imp {

	// main �޼���
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("sung");
		sb.append(" is");
		sb.append(" pretty");
		System.out.println(sb.toString());
	}// main �޼��� ����
	
}// StringBuilder_Imp Ŭ���� ����
