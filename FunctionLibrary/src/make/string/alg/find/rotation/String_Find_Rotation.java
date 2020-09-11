package make.string.alg.find.rotation;

// ����: isSubstring() �̶�� �Լ��� �ִ�. �� �Լ��� � ���ڿ� �ȿ� �ٸ� ���ڿ��� ���ԵǾ� �ִ� Ȯ�����ִ� �Լ��̴�.
// �� ���� ���ڿ��� �־�����, isSubstring() �Լ��� �� 1�� ����ؼ� �� ���� ���ڿ��� ȸ���� ���ڿ����� Ȯ���ϴ� �ڵ带 �ۼ��϶�.
// "String" -> "String"
//          -> "tringS"
//          -> "ingStr"
// Solution:
// "String" -> "ingStr" + "ingStr" -> ��
//          -> "ingStringStr" 
// isSubstring("ingStringStr", "String") ���� �ؼ�, ���� ���ڿ��� ���ԵǾ� �ִ��� Ȯ���Ѵ�.

// String_Find_Rotation Ŭ����
public class String_Find_Rotation {
	
	// isRotation �޼���
	private static boolean isRotation(String s1, String s2) {
		
		// �� ���ڿ��� ���̰� �ٸ��� ȸ���� ���ڿ��� �ƴϴ�.
		if(s1.length() != s2.length())
		{
			return false;
		}
		
		return isSubstring(s1+s1, s2);
	
	}
	
	
	private static boolean isSubstring(String s1, String s2) {
		// ���ڿ��� ���ԵǾ� �ִ� �� Ȯ��
		return s1.contains(s2);
	}
	
	
	
	// main �޼���
	public static void main(String[] args) {
		System.out.println(isRotation("string", "ringst"));
		System.out.println(isRotation("string", "ingstr"));
		System.out.println(isRotation("string", "ingstn"));
		System.out.println(isRotation("string", "ringstr"));
	}// main �޼��� ����

}// String_Find_Rotation Ŭ���� ����
