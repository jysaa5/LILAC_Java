package chapter05.array;

// p.207
public class StringArray_01 {
	
	public static void main(String[] args) {
		String[] names = {"Kim", "Park", "Yi"};
		
		for(int i=0; i<names.length; i++) {
			System.out.println("names["+"]:"+names[i]);
		}
		
		// �迭 names�� �� ��° ��Ҹ� tmp�� ����
		String tmp = names[2];
		
		System.out.println("tmp:"+tmp);
		// �迭 names�� ù ��° ��Ҹ� "Yu"�� ����
		names[0] = "Yu";
		
		// ���� for��
		for(String str: names) {
			System.out.println(str);
		}
	}
}
