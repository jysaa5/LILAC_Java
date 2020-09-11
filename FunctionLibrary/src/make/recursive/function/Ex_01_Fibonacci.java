package make.recursive.function;

//�Ǻ���ġ ����
// 1,     1,    2,  3, 5, 13, 21, 34
// 0��°, 1��° , 2��° ...
// n >= 0
public class Ex_01_Fibonacci {
	
	//1.solution
	//����Լ��� �̿��Ѵ�.
	//���ɻ� ������ �ִ�.
	public int Fibonacci(int n) {
		if(n <= 1) {
			return 1;
		}else {
			return Fibonacci(n-1) + Fibonacci(n-2);
		}
	}
	
	
	//2.solution
	//���� ���α׷��� ����� �̿��Ѵ�.
	public int dynamicFibonacci(int n) {
		//���� ���α׷���
		int last1, last2, result = 0;
		
		if(n <=1) {
			return 1;
		}
		
		last1 = 1;
		last2 = 1;
		
		for(int i=1; i<n; i++) {
			result = last1 + last2;
			last1 = last2;
			last2 = result;
		}
		
		return result;
		
	}
	
	
	
	public static void main(String[] args) {
		
		Ex_01_Fibonacci rf = new Ex_01_Fibonacci();
		
		System.out.println(rf.Fibonacci(1));
		System.out.println(rf.dynamicFibonacci(1));
	}
	

}
