package chapter09.regular.expression;

// Pattern, Matcher�� ���� ��Ű��
import java.util.regex.*;

// p.505
public class RegularExpression_01 {

	public static void main(String[] args) {

		String[] data = { "bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count", "data",
				"disc", "�����" };

		// c�� �����ϴ� �ҹ��ڿ��ܾ�
		// ���Խ��� �Ű������� PatternŬ������ static �޼����� Pattern compile(String regex)�� ȣ���Ͽ� Pattern �ν��Ͻ��� ��´�.  
		Pattern p = Pattern.compile("c[a-z]*");


		for (int i = 0; i < data.length; i++) {
			// ���Խ����� ���� ����� �Ű����� PatternŬ������ Matcher matcher(CharSequence input)�� ȣ���ؼ� Matcher�ν��Ͻ��� ��´�.
			Matcher m = p.matcher(data[i]);

			// Matcher �ν��Ͻ��� boolean matches()�� ȣ���ؼ� ���ԽĿ� �����ϴ��� Ȯ���Ѵ�. 
			if (m.matches()) {
				System.out.print(data[i] + ",");
			}
		}

	}

}
