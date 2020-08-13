package chapter09.regular.expression;

import java.util.regex.*;

//p.508
public class RegularExpression_03 {

	public static void main(String[] args) {
		String source = "HP:011-1111-1111, HOME:02-999-9999 ";
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);

		int i = 0;

		// find()�� ��ġ�ϴ� ������ ������ false�� ��ȯ�Ѵ�. 
		while (m.find()) {
			System.out.println(++i + ": " + m.group() + " -> " + m.group(1) + ", " + m.group(2) + ", " + m.group(3));
		}

	}

}
