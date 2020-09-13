package operation.bit;
/*
1. ��Ʈ ����(Bit Operation)
1) Digital Storage
- � �����͵� ��ǻ�Ϳ� ����� ���� ���� �� 0�� 1�� ����ȴ�.
- HDD, CD

2) Integer(����)
- 4bytes = 32 bits
- int i = 8
|0|0|0|0|0|0|0|0|0|...0|0|0|0|0|1|0|0|0|
- 4bytes = 32 bits = 2^32 ��
- �ִ밪= (2^32) -1 = unsigned
- signed = -(2^31) ~ (2^31) -1

3) logical right shift: >>>
- ��ȣ�� ������� ��� ��Ʈ�� right shift�ϰ� �� �κ��� 0���� ����

4) arithmetic right shift: >>
- ��ȣ�� ����ְ� ��� ��Ʈ�� right shift�ϰ� �� �κ��� 1�� ����

5) clear Left Bits
1 0 0 0 = 1 << 3
0 1 1 1 = 1 0 0 0 - 1 
-> not�� �ϸ� �տ� �ִ� ��Ʈ�鵵 �� ���ϹǷ� 1�� ���� ���̴�.

6) clear Right Bits
1111...1111 = -1
1111...0000 = -1 << (3+1) 
-> i��°���� �����ʿ� �ִ� ��Ʈ�� 0���� �����ؾ� �ϹǷ� i+1 ��ŭ ����Ʈ �ؾ� �ȴ�.

7) update Bit (��Ʈ�� ������Ʈ)
int num = 169;
int i = 3;
boolean val = true;

  x x x x x x x
& 1 1 1 0 1 1 1
---------------------
  x x x 0 x x x
| 0 0 0 y 0 0 0 
----------------------
  x x x y x x x
 
*/
public class Bit_Operation {
	
	// i��° �ڸ��� 1���� 0���� �Ǻ�
	static boolean getBit(int num, int i) {
		
		return (num&(1<<i)) != 0;
	
	}
	
	
	// i��° �ڸ��� 1�� ����
	static int setBit(int num, int i) {
		return num | (1<<i);
	}
	
	
	// i��° �ڸ��� 0���� ����
	static int clearBit(int num, int i) {
		return num & ~(1<<i);
	}
	
	
	// i��°�� ���ʿ� �ִ� ��Ʈ���� 0���� ����
	static int clearLeftBits(int num, int i) {
		return num & ((1<<i)-1);
	}
	
	
	// i��°�� �����ʿ� �ִ� ��Ʈ���� 0���� ����
	static int clearRightBits(int num, int i) {
		return num & (-1<<(i+1));
	}
	
	
	// num: ����
	// i: �ε���
	// val: � ������ ��������
	static int updateBit(int num, int i, boolean val) {
		
		return((num & ~(1<<i)) | ((val? 1:0)<<i));
		
	}
	
	
	public static void main(String[] args) {
		// 1 0 0 1
		System.out.println(getBit(9,3));
		
		// 0 1 0 1
		System.out.println(getBit(5,3));
		
		// 0 1 0 1 -> 1 1 0 1
		System.out.println(setBit(5,3));
		
		// 1 0 0 1 -> 0 0 0 1
		System.out.println(clearBit(9,3));
		
		// 10101001 -> 00000001
		System.out.println(clearLeftBits(169,3));
		
		// 10101001 -> 10100000
		System.out.println(clearRightBits(169,3));
		
		// 10101001 -> 10100001
		System.out.println(updateBit(169,3,false));
		
	}

}
