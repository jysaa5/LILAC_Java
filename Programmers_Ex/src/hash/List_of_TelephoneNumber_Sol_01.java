package hash;

// ����: ��ȭ��ȣ ���
/*
��ȭ��ȣ ���
���� ����
��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��, �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 �ִ��� Ȯ���Ϸ� �մϴ�.
��ȭ��ȣ�� ������ ���� ���, ������ ��ȭ��ȣ�� �������� ��ȭ��ȣ�� ���λ��Դϴ�.

������ : 119
���ؿ� : 97 674 223
������ : 11 9552 4421
��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book �� solution �Լ��� �Ű������� �־��� ��,
 � ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
phone_book�� ���̴� 1 �̻� 1,000,000 �����Դϴ�.
�� ��ȭ��ȣ�� ���̴� 1 �̻� 20 �����Դϴ�.

����� ����
phone_book                  | return
[119, 97674223, 1195524421] | false
[123,456,789]	            | true
[12,123,1235,567,88]	    | false

����� �� ����
����� �� #1
�տ��� ������ ���� �����ϴ�.

����� �� #2
�� ��ȣ�� �ٸ� ��ȣ�� ���λ��� ��찡 �����Ƿ�, ���� true�Դϴ�.

����� �� #3
ù ��° ��ȭ��ȣ, ��12���� �� ��° ��ȭ��ȣ ��123���� ���λ��Դϴ�. ���� ���� false�Դϴ�.
*/
// �ַ��:

class List_of_TelephoneNumber_Solution_01 {
	
    public boolean solution(String[] phone_book) {
    	
        boolean answer = true;
        
        String str1 = "";
        String str2 = "";
        
        for(int i=0; i<phone_book.length; i++) {
        	str1 = phone_book[i];
        	
        	for(int j=0; j<phone_book.length; j++) {
        		str2 = phone_book[j];
        		
        		if(str2.indexOf(str1)== 0 && !str2.equals(str1)) {
        			answer = false;
        			return answer;
        		};
        	}
        	
        }
        
        return answer;
    }
}

public class List_of_TelephoneNumber_Sol_01 {
	
	public static void main(String[] args) {
		
		//String[] phone_book = {"119", "97674223", "1195524421"};
		String[] phone_book = {"123", "456", "789"};
		
		List_of_TelephoneNumber_Solution_01 sol = new List_of_TelephoneNumber_Solution_01();
		
		System.out.println(sol.solution(phone_book));
	}

}
