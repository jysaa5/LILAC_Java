package stringBuffer_ex;

public class StringBuffer_01 {
	
	public static void main(String[] args) {
		
		//StringBuffer ����
		StringBuffer sb1 = new StringBuffer(); 
		
		//�߰�
		sb1.append("hello");
		
		//�߰�
		sb1.append(" ");
		
		//�߰�
		sb1.append("world");
		
		//toString(): String ������ ��ȯ ���� �� �ִ�.
		String str = sb1.toString();
		//���
		System.out.println(str);
		
		StringBuffer sb2 = new StringBuffer();
		//sb2�� �ڱ� �ڽ��� this�� ��ȯ�Ǿ sb3�� ���� ���̴�.
		StringBuffer sb3 = sb2.append("hello");
		
		//���� ���� ��ü�̴�.
		if(sb2==sb3) {
			System.out.println("sb2 == sb3");
		}
		
		//Method Chaining�� �̿��� ���
		String str2 = new StringBuffer().append("hello").append(" ").append("world").toString();
		
		System.out.println(str2);
		
	}

}
