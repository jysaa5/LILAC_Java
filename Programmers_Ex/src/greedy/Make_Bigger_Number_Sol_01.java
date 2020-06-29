package greedy;
//����: ū �� �����

/*
���� ����
� ���ڿ��� k���� ���� �������� �� ���� �� �ִ� ���� ū ���ڸ� ���Ϸ� �մϴ�.
���� ���, ���� 1924���� �� �� ���� �����ϸ� [19, 12, 14, 92, 94, 24] �� ���� �� �ֽ��ϴ�. �� �� ���� ū ���ڴ� 94 �Դϴ�.
���ڿ� �������� ���� number�� ������ ���� ���� k�� solution �Լ��� �Ű������� �־����ϴ�. 
number���� k ���� ���� �������� �� ���� �� �ִ� �� �� ���� ū ���ڸ� ���ڿ� ���·� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

���� ����
number�� 1�ڸ� �̻�, 1,000,000�ڸ� ������ �����Դϴ�.
k�� 1 �̻� number�� �ڸ��� �̸��� �ڿ����Դϴ�.

����� ��
number     | k | return
1924       | 2 | 94
1231234    | 3 | 3234
4177252841 | 4 |775841

*/
/*
�ַ��: 
- k���� ��������, n = length - k ��� �ϰ� n���� �����ϴ� ������ �ٲ۴�.
- ������ �� �ִ� ������ ������ ���� ������ ���� �����ؾ� �� ������ ���ų� ���� ���ڰ� ���� �־�� �Ѵ�.
- �ð� ������ ���� stringBuilder�� ����Ѵ�.


*/

class Make_Max_Number_Solution_01 {
 public String solution(String number, int k) {
 	
     String answer = "";
     
     StringBuilder sb = new StringBuilder();
     
     // �̾ƾ��� ����
     int cnt = number.length() - k;
     
     int left = 0;
     int right = number.length() - cnt;
     int max = -1;
     int idx = 0;
     
     // �� ���� ������ �ݺ�
     while(cnt > 0) {
    	 
    	 max = -1;
    	 
    	 for(int j=left; j<=right; ++j) {
    		 // ���� -> ����
    		 int num = number.charAt(j) - '0';
    		 
    		 if(num>max) {
    			 idx = j;
    			 max = num;
    		 }
    	 }
    	 
    	 sb.append(number.charAt(idx));
    	 left = idx +1;
    	 right = number.length() - --cnt;
     }
     
     answer = sb.toString();

     return answer;
 }
}


public class Make_Bigger_Number_Sol_01 {
	
	public static void main(String[] args) {
		
		String number = "1924";
		
		int k = 2; 
		
		Make_Max_Number_Solution_01 sol = new Make_Max_Number_Solution_01();
		
		System.out.println(sol.solution(number, k));
		
		
	}

}

