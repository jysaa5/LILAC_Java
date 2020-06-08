package kakao.blind.recruitment;
//����: ���ڿ� ����
/*
���� ����
������ ó�� �������� �ǰ� ���� ����ġ�� ���ڿ��� �����ϴ� ����� ���� ���θ� �ϰ� �ֽ��ϴ�. 
�ֱٿ� �뷮�� ������ ó���� ���� ������ ��ս� ���� ����� ���� ���θ� �ϰ� �ִµ�,
���ڿ����� ���� ���� �����ؼ� ��Ÿ���� ���� �� ������ ������ �ݺ��Ǵ� ������ ǥ���Ͽ� �� ª�� ���ڿ��� �ٿ��� ǥ���ϴ� �˰����� �����ϰ� �ֽ��ϴ�.
������ ���� aabbaccc�� ��� 2a2ba3c(���ڰ� �ݺ����� �ʾ� �ѹ��� ��Ÿ�� ��� 1�� ������)�� ���� ǥ���� �� �ִµ�, �̷��� ����� �ݺ��Ǵ� ���ڰ� ���� ��� ������� ���ٴ� ������ �ֽ��ϴ�.
���� ���, abcabcdede�� ���� ���ڿ��� ���� ������� �ʽ��ϴ�. ����ġ�� �̷��� ������ �ذ��ϱ� ���� ���ڿ��� 1�� �̻��� ������ �߶� �����Ͽ� �� ª�� ���ڿ��� ǥ���� �� �ִ��� ����� ã�ƺ����� �մϴ�.
���� ���, ababcdcdababcdcd�� ��� ���ڸ� 1�� ������ �ڸ��� ���� ������� ������, 2�� ������ �߶� �����Ѵٸ� 2ab2cd2ab2cd�� ǥ���� �� �ֽ��ϴ�.
�ٸ� ������� 8�� ������ �߶� �����Ѵٸ� 2ababcdcd�� ǥ���� �� ������, �̶��� ���� ª�� �����Ͽ� ǥ���� �� �ִ� ����Դϴ�.
�ٸ� ����, abcabcdede�� ���� ���, ���ڸ� 2�� ������ �߶� �����ϸ� abcabc2de�� ������, 3�� ������ �ڸ��ٸ� 2abcdede�� �Ǿ� 3�� ������ ���� ª�� ���� ����� �˴ϴ�. 
�̶� 3�� ������ �ڸ��� �������� ���� ���ڿ��� �״�� �ٿ��ָ� �˴ϴ�.
������ ���ڿ� s�� �Ű������� �־��� ��, ���� ������ ������� 1�� �̻� ������ ���ڿ��� �߶� �����Ͽ� ǥ���� ���ڿ� �� ���� ª�� ���� ���̸� return �ϵ��� solution �Լ��� �ϼ����ּ���.
���ѻ���
s�� ���̴� 1 �̻� 1,000 �����Դϴ�.
s�� ���ĺ� �ҹ��ڷθ� �̷���� �ֽ��ϴ�.
����� ��
s                          | result
"aabbaccc"                 |    7
"ababcdcdababcdcd"	       |    9 
"abcabcdede"	           |    8
"abcabcabcabcdededededede" |    14
"xababcdcdababcdcd"	       |    17
����� ���� ���� ����
����� �� #1
���ڿ��� 1�� ������ �߶� �������� �� ���� ª���ϴ�.
����� �� #2
���ڿ��� 8�� ������ �߶� �������� �� ���� ª���ϴ�.
����� �� #3
���ڿ��� 3�� ������ �߶� �������� �� ���� ª���ϴ�.
����� �� #4
���ڿ��� 2�� ������ �ڸ��� abcabcabcabc6de �� �˴ϴ�.
���ڿ��� 3�� ������ �ڸ��� 4abcdededededede �� �˴ϴ�.
���ڿ��� 4�� ������ �ڸ��� abcabcabcabc3dede �� �˴ϴ�.
���ڿ��� 6�� ������ �ڸ� ��� 2abcabc2dedede�� �Ǹ�, �̶��� ���̰� 14�� ���� ª���ϴ�.
����� �� #5
���ڿ��� ���� �պ��� ������ ���̸�ŭ �߶�� �մϴ�.
���� �־��� ���ڿ��� x / ababcdcd / ababcdcd �� �ڸ��� ���� �Ұ��� �մϴ�.
�� ��� ��� ���ڿ��� �߶� ������� �����Ƿ� ���� ª�� ���̴� 17�� �˴ϴ�.
*/

//�ַ��: ����Լ� ���


class String_Compression_Solution_02 {
	
	   public int solution(String s) {
	        int answer = 0;

	        for(int i=1; i<=(s.length()/2)+1; i++){
	        	
	            int result = getSplitedLength(s, i, 1).length();
	        
	            answer = i==1 ? result : (answer>result?result:answer);
	        
	        }

	        return answer;
	    }

	   // s: ������ ���ڿ� 
	   // n: �ڸ��� ���� 
	   // repeat: �ݺ�Ƚ��
	   // getSplitedLength �޼���: ���ڿ� ����
	    public String getSplitedLength(String s, int n, int repeat){
	        
	    	// �ڸ��� ������ ������ ���ڿ� ���̺��� ����� ��.
	    	if(s.length() < n) {
	    		return s;
	    	}
	    	
	    	String result = "";
	    	// ���ڿ� �ڸ���
	        String preString = s.substring(0, n);
	        String postString = s.substring(n, s.length());

	        // ����ġ -> ������� [�ݺ�Ƚ�� + �ݺ�����] ����
	        // ó�� �ڸ� ���ڿ��� �ڿ� �κ��� ���ۺκ��� ��ġ���� ������.
	        if(!postString.startsWith(preString)){
	        
	        	// �ݺ��� �ȵɶ�: �߸� ���ڿ��� �� ���� ���� ��: �ݺ�Ƚ�� ���� ����
	        	if(repeat ==1) {
	        		return result += preString + getSplitedLength(postString, n, 1);
	        	}
	        	// �ݺ� Ƚ���� ���ڿ��� ��ȯ + �ڸ� ���ڿ� + �� �κ� ����Լ� ȣ��
	        	return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
	        }

	        // ó�� �ڸ� ���ڿ��� �ڿ� �κа� ���� �κ��� ��ġ�� ��, ����Լ� ȣ�� 
	        return result += getSplitedLength(postString, n, repeat+1);
	    }
}

public class String_Compression_Sol_02 {
	public static void main(String[] args) {
		//String s = "aabbaccc";
		//String s = "ababcdcdababcdcd";	     
		String s = "abcabcdede";           
		//String s = "abcabcabcabcdededededede";
		//String s = "xababcdcdababcdcd";
		
		String_Compression_Solution_02 sol = new String_Compression_Solution_02();
		System.out.println(sol.solution(s));
	}

}
