package kakao.kakaoCode.preliminary;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

// ��ǥ�� ������ Point Ŭ����
class Point{
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Solution {
	
	public int BFS(boolean[][] visited, int[][] picture, Point start) {
		
		Queue<Point> queue = new LinkedList<>();
		int[] dx = {-1, 1, 0 , 0};
		int[] dy = {0, 0, 1, -1};
		int area = 1;
		int nx;
		int ny;
		
		visited[start.x][start.y] = true;
		// queue�� �߰�
		queue.offer(start);

		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for(int i=0; i<4; i++) {
				nx = dx[i] + cur.x;
				ny = dy[i] + cur.y;
				
				if(0 <= nx && nx <picture.length && 0 <= ny && ny < picture[0].length) {
					
					if(!visited[nx][ny] && picture[nx][ny] != 0 && picture[cur.x][cur.y] == picture[nx][ny]) {
						visited[nx][ny] = true;
						queue.offer(new Point(nx, ny));
						area++;
					}
					
				}
				
			}
			
		}
		
		return area;
	}

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
        	Arrays.fill(visited[i], false);
        }
        
        for(int x=0; x<m; x++) {
        	for(int y=0; y<n; y++) {
        		
        		if(visited[x][y] || picture[x][y] == 0) {
        			continue;
        		}
        		answer[1] = Math.max(answer[1], BFS(visited, picture, new Point(x,y)));
        		answer[0]++;
        	}
        }
        
     
        
        
        
        return answer;
    }
}

public class KakaoFriends_ColoringBook_Sol_01 {
	public static void main(String[] arghs){
		
		int[][] picture = {{1, 1, 1, 0},
				           {1, 2, 2, 0}, 
				           {1, 0, 0, 1}, 
				           {0, 0, 0, 1}, 
				           {0, 0, 0, 3}, 
				           {0, 0, 0, 3}};
		
		int m = 6;
		int n = 4;
		Solution sol = new Solution();
		
		for(int i : sol.solution(m, n, picture)) {
			System.out.print(i+" ");
		}
		
		
	}
}