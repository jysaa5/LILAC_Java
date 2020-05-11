package imp.string.alg.find.one.edit;

// ����: �� ���� ���ڿ� ��������� �ִ�. ���ڸ� �� �� �����ϴ� ���. ���ڸ� �� �� �����ϴ� ���. �׸��� �ϳ��� ���ڸ� ��ü�� �� �ִ� �����
// �ִ�. �־��� �� ���� ���ڿ��� ��������� �� �ѹ��� �̿��� ���(�Ǵ� �ѹ��� �̿����� ���� ���)������ �˾Ƴ��� �Լ��� �����Ͻÿ�.
// insert(����): ple -> pale
// remove(����): pale -> pale
// replace(��ü): pale -> bale

// insert, remove: short�� long���� ���ڸ� ���� �����ϰ� long�� short���� 1���� �� ������ insert�� remove ����� ���� ��.
// replace: flag ������ �� �� �ΰ�, �����Ǳ��� ���ڿ��� ���� �� ���ڿ��� ���ؼ� �ٸ��� flag�� true�� �����ؼ�(�ʱ⿡�� false) ��ȯ.


// String_Find_One_Edit Ŭ����
public class String_Find_One_Edit {
	
	// isOneAway �޼���: String�� �ѹ� ���� �Ǿ��ų� Ȥ�� �� ���� ������ �ȵǾ����� Ȯ���ϴ� �޼���
	private static boolean isOneAway(String s1, String s2) {
		
		String ss, ls;
		
		if(s1.length() < s2.length()) {
			ss = s1;
			ls = s2;
		}else {
			ss = s2;
			ls = s1;
		}
		
		// 1�� �̻� ���̳��� �� ���� ������ ���� �ƴϹǷ� false ��ȯ
		if(ls.length() - ss.length() > 1) {
			return false;
		}
		
		boolean flag = false;
		
		// ��ü
		for(int i = 0, j = 0; i <ss.length(); i++, j++) {
		
			if(ss.charAt(i) != ls.charAt(j)) {
				if(flag) {
					return false;
				}
				flag = true;
				
				// �����̳� ������ �Ͼ�� ���ڿ��� ���̰� �ٸ���
				if(ss.length() != ls.length()) {
					j++;
				}
				
			}
			
		}
		
		return true;
		
	}// isOneAway �޼��� ����
	
	
	// main �޼���
	public static void main(String[] args) {
		
		System.out.println(isOneAway("pal", "pal"));
		System.out.println(isOneAway("pal", "pale"));
		System.out.println(isOneAway("pale", "pal"));
		System.out.println(isOneAway("pale", "bale"));
		
		System.out.println(isOneAway("pal", "pales"));
		System.out.println(isOneAway("pale", "pel"));
		System.out.println(isOneAway("pale", "bake"));
	}// main �޼��� ����

}//String_Find_One_Edit Ŭ���� ����