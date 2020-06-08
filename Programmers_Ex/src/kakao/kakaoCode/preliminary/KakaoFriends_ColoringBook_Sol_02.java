package kakao.kakaoCode.preliminary;

import java.util.ArrayList;
import java.util.Collections;

// ����: īī�������� �÷�����
/*
���� ����
īī�� ������ �÷�����
���ǻ��� �������� ����ġ�� �׿����� �÷����Ͽ� �� ��ȭ�� �׷��޶�� ��Ź�Ͽ� ���� ���� �׸��� �޾Ҵ�. 
���� ���� �׸��� ���̵� ������ �÷����Ͽ� �ְ� �;��� ����ġ�� ������ ������ ��ĥ�ϱⰡ ��ٷο� ��������ٴ� ����� �߰��ϰ� �׸��� ���̵��� ������ ���� �����Ͽ���. 
(�����̶� �����¿�� ����� ���� ������ ������ �ǹ��Ѵ�.)
�׸��� �� ���� ������ �ִ����� ���� ū ������ ���̴� ������ ����ϴ� ���α׷��� �ۼ��غ���.
alt text
���� �׸��� �� 12�� �������� �̷���� ������, ���� ���� ������ ����ġ�� �󱼸����� ���̴� 120�̴�.
�Է� ����
�Է��� �׸��� ũ�⸦ ��Ÿ���� m�� n, �׸��� �׸��� ��Ÿ���� m �� n ũ���� 2���� �迭 picture�� �־�����. 
���������� �Ʒ��� ����.
1 <= m, n <= 100
picture�� ���Ҵ� 0 �̻� 2^31 - 1 ������ ������ ���̴�.
picture�� ���� �� ���� 0�� ���� ��ĥ���� �ʴ� ������ ���Ѵ�.
��� ����
���� Ÿ���� ���Ұ� �� ���� ���� �迭�̴�. �׸��� �� ���� ������ �ִ����� ���� ū ������ �� ĭ���� �̷���� �ִ����� �����Ѵ�.
���� �����
m |	n	| picture                                                                              |	answer
6 |	4	|[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]  |	[4, 5]
������ ���� ����
������ �־��� �׸��� �� 4���� �������� �����Ǿ� ������, ���� ���� ������ �������� ������ ��� 1�� �����Ǿ� ������ �����¿�� �̾������� �����Ƿ� �ٸ� �����̴�. 
���� ���� ������ ���� �� 1�� �����ϴ� �������� �� 5ĭ�̴�.
*/


// �ַ��: BFS
/*
1. ����: �����¿�� ����� ���� ������ ���� -> ���� ��ġ���� ���� �¿�� ������ �� �ִ�. -> �׷���
2. �����迭: �׷����� Ǯ��� �ϴ� �ܼ��� �ش�.

*/

class KakaoFriends_ColoringBook_Solution_02{
	// ����
	int span = 0;
	
	
	// m: ����, n: ���� 
	// picture: �׸�
	public int[] solution(int m, int n, int[][] picture) {
		
		// ������ ����
		int numberOfArea = 0;
		// ���� ū ������ ũ��
		int maxSizeOfOneArea = 0;
		// ������ ������� �ƴ��� �����ϴ� �迭
		boolean[][] pathBool = new boolean[m][n];
		
		// ���������� �����ϴ� ��� ����Ʈ
		ArrayList<Integer> answerList = new ArrayList<>();
		
		// ��ȯ�� �迭
		int[] answer = new int[2];
		
		
		// picture ũ�� ��ŭ ���� for
		for(int i=0; i<m; i++) {
			
			for(int j=0; j<n; j++) {
				
				// ���� ��Ŀ� ���� 0���� Ŭ��
				if(picture[i][j]>0) {
					
					findPath(i,j,picture,pathBool);
					
					// ������ 0���� Ŭ��.
					if(span > 0) {
						answerList.add(span);
						span = 0;
					}
					
				}
				
			}
			
		}

		// ���� ������ ����
		numberOfArea = answerList.size();
		
		// ������ ������ 0�� ��.
		if(numberOfArea == 0) {
			return new int[] {0,0};
		}
		
		// ���� ������ ������������ ����
		Collections.sort(answerList, Collections.reverseOrder());
		maxSizeOfOneArea = answerList.get(0);
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		
		return answer;
		
	}
	
	
	// findPath: ��θ� ã�� �޼���
	public void findPath(int m, int n, int[][] picture, boolean[][] pathBool) {
		
		// �̹� ���İ� ����� ���
		if(pathBool[m][n] == true) {
			return;
		}
		
		// �̹����� �� = ������ ����
		long su = picture[m][n];
		
		// ������ �迭�� ���� ����(��)
		int column = picture[0].length;
		
		// ������ �迭�� ���� ����(��)
		int row = picture.length;
		
		pathBool[m][n] = true;
		span ++;
		
		// ������ �̵�
		if((n+1 < column) && (pathBool[m][n+1] == false && su == picture[m][n+1])) {
			// ����Լ� ȣ��
			findPath(m, n+1, picture, pathBool);
		}
		
		
		// ���� �̵�
		if((n-1>=0)&& (pathBool[m][n-1] == false && su == picture[m][n-1])) {
			// ����Լ� ȣ��
			findPath(m, n-1, picture, pathBool);
			
		}
		
		
		// �������� �̵�
		if((m-1>=0)&& (pathBool[m-1][n] == false && su == picture[m-1][n])) {
			// ����Լ� ȣ��
			findPath(m-1, n, picture, pathBool);
		}
		
		
		// �Ʒ��� �̵�
		if((m+1<row)&&(pathBool[m+1][n]==false && su == picture[m+1][n])) {
			// ����Լ� ȣ��
			findPath(m+1, n, picture, pathBool);
		}
		
		
		
	}
	
}


public class KakaoFriends_ColoringBook_Sol_02 {
	
	public static void main(String[] args) {
		
		//int m = 4;
		int m = 6;
		int n = 4;
		
//		int[][] picture = {
//				{1,1,1,1},
//				{1,4,1,1},
//				{1,3,2,1},
//				{1,1,1,1}
//		};
		
		int[][] picture = {
				{1,1,1,0},
				{1,2,2,0},
				{1,0,0,1},
				{0,0,0,1},
				{0,0,0,3},
				{0,0,0,3}
		};
		
		KakaoFriends_ColoringBook_Solution_02 sol = new KakaoFriends_ColoringBook_Solution_02();
		
		int[] result = sol.solution(m, n, picture);
		
		for(int i : result ) {
			
			
			System.out.println(i);			
		}
		
	}
	
	

}
