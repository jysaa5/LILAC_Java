package chapter09.regular.expression;

import java.util.regex.*;

public class RegularExpression_04 {
	
	public static void main(String[] args) {
		
		String source = "A broken hand works, but not a broken heart.";
		String pattern = "broken";
		StringBuffer sb = new StringBuffer();
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		System.out.println("source:"+source);
		
		int i = 0;
		
		// ���ڿ� source���� "broken"�� ã�� �� ó������ appendReplacement �޼��尡 ȣ��Ǹ� source�� ���ۺ��� broken�� ã�� ��ġ������ ���뿡 drunken�� ���ؼ� �����Ѵ�.
		// sb = "A drunken"
		// ù ��°�� �߰ߵ� ��ġ�� ���������� �ٽ� �˻��� �����Ͽ� �� ��° broken�� ã�� �ȴ�. �ٽ� appendReplacement�� ȣ��.
		// sb = "A drunken hand works, but not a drunken"
		while(m.find()) {
			System.out.println(++i + "��° ��Ī:" + m.start() + "~"+ m.end());
			
			//broken�� drunken���� ġȯ�Ͽ� sb�� �����Ѵ�.
			m.appendReplacement(sb, "drunken");
		}
		
		// sb = "A drunken hand works, but not a drunken heart."
		// appendTail �޼��尡 ȣ��Ǹ� ������ ġȯ�� ������ �κ��� sb�� �����δ�.
		m.appendTail(sb);
		System.out.println("Replacement count :"+i);
		System.out.println("result:"+sb.toString());
	}

}
