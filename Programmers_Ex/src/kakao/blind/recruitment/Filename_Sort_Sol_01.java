package kakao.blind.recruitment;

import java.util.Arrays;
import java.util.Comparator;

// ����: ���ϸ� ����
/*
���ϸ� ����
�� ������ �ڵ� �׽�Ʈ�� �� ������ �����̶�� �⳪�� ����ε� ��ä�� ������ ����� īī���� �Ի��� ������ ���� ����� ���� ������ �ð� �Ǿ���.
����� �������� ���α׷��� ���� ������ ��� ��� �־�, �̸� ������ ���ĵ� ���� ����� ���Ⱑ �����ߴ�. 
������ �̸� ������ �����ϸ� ���߿� ������� ver-10.zip�� ver-9.zip���� ���� ǥ�õǱ� �����̴�.
���� ��ȣ �ܿ��� ���ڰ� ���Ե� ���� ����� ���� �鿡�� �����ϱ� �����ߴ�. 
������ ���� ����� [img12.png, img10.png, img2.png, img1.png]�� ���, 
�Ϲ����� ������ [img1.png, img10.png, img12.png, img2.png] ���� ������, 
���� ������ ���ĵ� [img1.png, img2.png, img10.png, img12.png"] ���� �ξ� �ڿ�������.
������ �ܼ��� ���� �ڵ� ���� �ƴ�, ���ϸ� ���Ե� ���ڸ� �ݿ��� ���� ����� ����� ���� ���α׷��� �����ϱ�� �ߴ�.
�ҽ� ���� ����ҿ� ����� ���ϸ��� 100 ���� �̳���, ���� ��ҹ���, ����, ����(" ), ��ħǥ(.), ���� ��ȣ(-")������ �̷���� �ִ�.
���ϸ��� �����ڷ� �����ϸ�, ���ڸ� �ϳ� �̻� �����ϰ� �ִ�.
���ϸ��� ũ�� HEAD, NUMBER, TAIL�� �� �κ����� �����ȴ�.
HEAD�� ���ڰ� �ƴ� ���ڷ� �̷���� ������, �ּ��� �� ���� �̻��̴�.
NUMBER�� �� ���ڿ��� �ִ� �ټ� ���� ������ ���ӵ� ���ڷ� �̷���� ������, ���ʿ� 0�� �� �� �ִ�. 
0���� 99999 ������ ���ڷ�, 00000�̳� 0101 � �����ϴ�.
TAIL�� �� ������ �κ�����, ���⿡�� ���ڰ� �ٽ� ��Ÿ�� ���� ������, �ƹ� ���ڵ� ���� �� �ִ�.

���ϸ�	HEAD	NUMBER	TAIL
foo9.txt	foo	9	.txt
foo010bar020.zip	foo	010	bar020.zip
F-15	F-	15	(�� ���ڿ�)
���ϸ��� �� �κ����� ���� ��, ���� ���ؿ� ���� ���ϸ��� �����Ѵ�.

���ϸ��� �켱 HEAD �κ��� �������� ���� ������ �����Ѵ�. 
�̶�, ���ڿ� �� �� ��ҹ��� ������ ���� �ʴ´�. 
MUZI�� muzi, MuZi�� ���� �ÿ� ���� ������ ��޵ȴ�.
���ϸ��� HEAD �κ��� ��ҹ��� ���� �ܿ��� ���� ���, NUMBER�� ���� ������ �����Ѵ�. 
9 < 10 < 0011 < 012 < 13 < 014 ������ ���ĵȴ�. 
���� ���� 0�� ���õǸ�, 012�� 12�� ���� �ÿ� ���� ���� ������ ó���ȴ�.
�� ������ HEAD �κа�, NUMBER�� ���ڵ� ���� ���, ���� �Է¿� �־��� ������ �����Ѵ�. 
MUZI01.zip�� muzi1.png�� �Է����� ������, ���� �Ŀ��� �Է� �� �־��� �� ������ ������ �ٲ��� �� �ȴ�.
������ ���� ���ϸ� ���� ���α׷��� �����϶�.

�Է� ����
�Է����� �迭 files�� �־�����.
files�� 1000 �� ������ ���ϸ��� �����ϴ� ���ڿ� �迭�̴�.
�� ���ϸ��� 100 ���� ���� ���̷�, ���� ��ҹ���, ����, ����(" ), ��ħǥ(.), ���� ��ȣ(-")������ �̷���� �ִ�. ���ϸ��� �����ڷ� �����ϸ�, ���ڸ� �ϳ� �̻� �����ϰ� �ִ�.
�ߺ��� ���ϸ��� ������, ��ҹ��ڳ� ���� �պκ��� 0 ���̰� �ִ� ���� �Բ� �־��� �� �ִ�. (muzi1.txt, MUZI1.txt, muzi001.txt, muzi1.TXT�� �Բ� �Է����� �־��� �� �ִ�.)

��� ����
�� ���ؿ� ���� ���ĵ� �迭�� ����Ѵ�.

����� ����
�Է�: [img12.png, img10.png, img02.png, img1.png, IMG01.GIF, img2.JPG]
���: [img1.png, IMG01.GIF, img02.png, img2.JPG, img10.png, img12.png]

�Է�: [F-5 Freedom Fighter, B-50 Superfortress, A-10 Thunderbolt II, F-14 Tomcat]
���: [A-10 Thunderbolt II, B-50 Superfortress, F-5 Freedom Fighter, F-14 Tomcat]
*/
/*
1. ���� ���
- ���� ���� ����
2. �ַ��
- Arrays ���, Comparator ���
3. �ð����⵵
4. ��ü ���� 
*/
class Filename_Sort_Solution_01 {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
        	@Override
        	public int compare(String f1, String f2) {
        		
        		// header�� �߶󳻱�
        		String header1 = f1.split("[0-9]")[0];
        		String header2 = f2.split("[0-9]")[0];
        		
        		// header�� ��� �ҹ��ڷ� ����� ��
        		int result = header1.toLowerCase().compareTo(header2.toLowerCase());
        		
        		// header�� ���� ��� ���ڸ� ���Ѵ�.
        		if(result == 0) {
        			result = findNum(f1, header1) - findNum(f2, header2);
        		}
        		return result;
        	}
        	
        });
        
        
        return files;
    }
    
    // ���� ��
    private int findNum(String str, String header) {
    	// header �κ� �������� ��ü
    	str = str.replace(header, "");
    	String result = "";
    	
    	// char �迭�� ��ȯ �� ���ڸ� result�� �ֱ�
    	for(char c : str.toCharArray()) {
    		if(Character.isDigit(c) && result.length() < 6) {
    			result += c;
    		}else {
    			break;
    		}
    	}
    	// Integer�� ��ȯ
    	return Integer.valueOf(result);
    }
    
}
public class Filename_Sort_Sol_01 {
	
	public static void main(String[] args) {
		Filename_Sort_Solution_01 sol = new Filename_Sort_Solution_01();
        //String[] str = {"img12.png", "img10.png", "img02.png" ,"img1.png" ,"IMG01.GI", "img2.JPG"};
		String[] str = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		//String[] str  = {"MUZI01.zip", "muzi1.png"};
		//String[] str = {"muzi1.png", "MUZI01.zip"};
		
		for (String s : sol.solution(str)) {
			System.out.println(s);
		};
	}
	

}
