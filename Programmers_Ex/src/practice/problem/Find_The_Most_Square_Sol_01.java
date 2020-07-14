package practice.problem;

// ����: ���� ū ���簢�� ã��
/*
���� ����
1�� 0�� ä���� ǥ(board)�� �ֽ��ϴ�. ǥ 1ĭ�� 1 x 1 �� ���簢������ �̷���� �ֽ��ϴ�. 
ǥ���� 1�� �̷���� ���� ū ���簢���� ã�� ���̸� return �ϴ� solution �Լ��� �ϼ��� �ּ���. 
(��, ���簢���̶� �࿡ ������ ���簢���� ���մϴ�.)

���� ���

1	2	3	4
0	1	1	1
1	1	1	1
1	1	1	1
0	0	1	0
�� �ִٸ� ���� ū ���簢����

1	2	3	4
0	1	1	1
1	1	1	1
1	1	1	1
0	0	1	0
�� �Ǹ� ���̴� 9�� �ǹǷ� 9�� ��ȯ�� �ָ� �˴ϴ�.

���ѻ���
ǥ(board)�� 2���� �迭�� �־����ϴ�.
ǥ(board)�� ��(row)�� ũ�� : 1,000 ������ �ڿ���
ǥ(board)�� ��(column)�� ũ�� : 1,000 ������ �ڿ���
ǥ(board)�� ���� 1�Ǵ� 0���θ� �̷���� �ֽ��ϴ�.

����� ��
board                                     |	answer
[[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]] |	9
[[0,0,1,1],[1,1,1,1]]	                  | 4

����� �� ����
����� �� #1
���� ���ÿ� �����ϴ�.

����� �� #2
| 0 | 0 | 1 | 1 |
| 1 | 1 | 1 | 1 |
�� ���� ū ���簢���� ���̴� 4�� �ǹǷ� 4�� return�մϴ�.
*/
// �ַ��:


class Find_The_Most_Square_Solution_01{
    public int solution(int [][]board)
    {
    	// �����ϴܺ��� ��������ϴµ�, ���̰� 1�ΰ�쿡�� �˻� �� �� �ֵ��� ũ�Ⱑ1�� ū �迭�� ���� �����.
    			int[][] newBoard = new int[board.length+1][board[0].length+1];
    			
    			for ( int i = 0 ; i < board.length; i++ ) {
    				for ( int j = 0 ; j < board[0].length; j++ ) {
    					newBoard[i+1][j+1] = board[i][j];
    				}
    			}
    			
    			int max = 0;
    			
    			// ��� board�� Ȯ���Ѵ�.
    			for ( int i = 1 ; i < newBoard.length; i ++ ) {
    				for ( int j = 1 ; j < newBoard[i].length; j++ ) {

    					// 2x2 �簢���� �����ϴ��� �������� ���簢���� �Ǵ� ��쿡�� ���� ���̸� ����ذ���.

    					// �����ϴ��� ������ ������ ������ ��ǥ�� ���� ���ϱ������� ������ board���� ����� �������ϱ� �����̴�.

    					// ���� ���̴� 2x2 ���簢���� �����ϴ� ������ �ּڰ��̴�.
    					if ( newBoard[i][j] >= 1 ) {
    						
    						//����
    						int left = newBoard[i-1][j];
    						//���
    						int up = newBoard[i][j-1];
    						//�������(�밢��)
    						int leftDiagonal = newBoard[i-1][j-1];

    						int min = Math.min(left, up);
    						min = Math.min(min, leftDiagonal);

    						newBoard[i][j] = min+1;

    						max = Math.max(max, min+1);
    					}
    				}
    			}

    			return (int)Math.pow(max, 2);
    }
}

public class Find_The_Most_Square_Sol_01 {
	
	public static void main(String[] args) {
		Find_The_Most_Square_Solution_01 sol = new Find_The_Most_Square_Solution_01();
		
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		
		System.out.println(sol.solution(board));
		
		
	}

}
