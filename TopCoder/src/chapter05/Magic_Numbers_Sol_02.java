package chapter05;

// p.181
// ����: ������ ����

class NumberMagicEasy_02{
	public int theNumber(String answer) {
	
		// ī�忡 ���ڰ� ������ Y, ���ڰ� ������ N
		String[] c = {
				"YYYYYYYYNNNNNNNN",
				"YYYYNNNNYYYYNNNN",
				"YYNNYYNNYYNNYYNN",
				"YNYNYNYNYNYNYNYN"
		};
		
		for(int i=0; i<=15; i++) {
			String temp = "";
			for(int j=0; j<4; j++) {
				temp += c[j].charAt(i);
				if(answer.equals(temp)) {
					return i+1;
				}
			}
		}
		return 0;
		
	}
}

public class Magic_Numbers_Sol_02 {
	
	public static void main(String[] args) {
		NumberMagicEasy_02 sol = new NumberMagicEasy_02();
		//String answer = "YNYY";
		//String answer = "YNNN";
		//String answer = "YYYY";
		String answer = "NYNY";
		System.out.println(sol.theNumber(answer));
	}

}
