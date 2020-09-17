package chapter06;

// p. 196
// ����: ��귮 - log�� ����ϴ� ���
// �ð����⵵: O(log n)

public class Bitcount_Sol_01 {
	
	 static int bitcount(int n) {
		 int ret = 0;
		 while(n>0) {
			 if(n%2==1) {
				 ret ++;
			 }
			 n/=2;
		 }
		 return ret;
	 }
	 
	 
	 public static void main(String[] args) {
		 System.out.println(bitcount(1000));
	 }

}
