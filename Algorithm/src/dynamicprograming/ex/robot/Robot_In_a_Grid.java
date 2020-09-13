package dynamicprograming.ex.robot;

import java.util.ArrayList;

/*
�˰���: Dynamic Programming
����: Robot In a Grid
A robot is sitting on the upper left corner of a grid. The robot can only move in two directions, right and down.
Certain cells are "off limits" such that the robot cannot step on them.
Design and algorithm to find a path for the robot from the top left to the bottom right.

= �׸���(�ٵ��� ���� ��) �ȿ� �κ�Ʈ�� �ִµ�, �� ���� ��ܿ� �ִ�. �����ʰ� �Ʒ������θ� ������ �� �ִ�. (�� 2���� ���⸸ ����)
� ĭ�� �κ�Ʈ�� �� ����. �� �κ��� ���� ��ܿ��� ���� �ϴܱ��� ���� ��θ� ã�´�.

 |�κ�  |    |    |    |
 |    |    |    | x  |
 | x  | x  |    |    | 
 |    |    |    |goal|

-> x�� �� ���� ĭ�̴�. 
-> Goal�������� �����ؼ� �κ��� �ִ� �� ���� ���� ���� ã���� ��ȯ�ϸ鼭 ���� ã�� ������ ��� ���� �� �� �ִ�.
-> ��, �������� �����̸� �ȴ�.
-> �ִ� ��� X 
-> Goal�� �������� ������ ���� �� ���� ���� ������ ���� ���� ���� �� �� ���� ���̸� �� ���� ĭ�̶�� �Ǵ��Ѵ�.
-> �κ��� �ִ� ���� ã���� �� ������ ��θ� Goal���� ��θ� ����ϰ� ��ȯ�Ѵ�. 
*/

// ��θ� ��ȯ�Ϸ���, �� �����ϴ� ����Ʈ���� ��� ����Ʈ�� ������ �Ѵ�.
// Point Ŭ����
class Point{
	
	// x, y ����Ʈ
	int row, col;
	
	// ������ 
	Point(int row, int col){
		this.row = row;
		this.col = col;
	}
	
}// Point Ŭ���� ����

// Solution Ŭ����
class Solution{
	// grid false = �ƹ� �͵� ���� ĭ
	// grid true = blocked
	public ArrayList<Point> findPath(boolean[][] grid){
		
		if(grid == null || grid.length == 0) {
			return null;
		}
		
		// ��� ����
		ArrayList<Point>path = new ArrayList<Point>();
		
		// ����Լ� ȣ��
		if(findPath(grid, grid.length-1, grid[0].length-1, path)) {
			return path;
		}else {
			return null;
		}
	
	}// findPath �޼��� ����
	
	
	// findPath �޼���: ����Լ� -> grid, ���� ��ġ, ������ ���
	private boolean findPath(boolean[][]grid, int row, int col, ArrayList<Point>path) {
		
		// �ش� ����Ʈ�� grid �ȿ� ���ų� blocked �Ǿ� �ִ� ��ǥ�� ���
		if(!isInRange(grid,row,col)|| grid [row][col]) {
			return false;
		}
		
		// ���� ���������� �κ��� �ִ� ������ ��� ã��
		// ����, �������� ���� ��츦 �� ������ �� ã�� �״��� �������� �� ã��
		if((row == 0 && col ==0) || findPath(grid, row, col-1, path)|| findPath(grid, row-1, col,path)) {
			Point p = new Point(row, col);
			// path �߰�
			path.add(p);
			return true;
		}
		return false;
	}
	
	// isInRange �޼���: �׸��� �ȿ� ����Ʈ�� �ִ� ���� üũ�ϴ� �޼���
	private boolean isInRange(boolean[][] grid, int row, int col) {
		return row >= 0 && row <= grid.length -1 && col >= 0 && col <= grid[row].length - 1;
	}
	
}// Solution Ŭ���� ����


// Robot_In_a_Grid Ŭ����
public class Robot_In_a_Grid {
	
	// main �޼���
	public static void main(String[] args) {
	
		// �׸���
		boolean[][] grid = {
				{false, false, false, false},
				{false, false, false, true},
				{true, true, false, false},
				{false, false, false, false}
		};
		
		Solution sol = new Solution();
		
		ArrayList<Point> path = sol.findPath(grid);
		
		if(path != null) {
			for(Point p:path) {
				System.out.print(p.row+""+p.col+"->");
			}
		}
		
	}// main �޼��� ����

}// Robot_In_a_Grid Ŭ���� ���� 