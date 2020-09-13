package matrix.change.zeroToOne;

// ����: (Matrix) 2���� �迭 �ȿ��� 0�� �߰��ϸ� �ش� ��� ���� ��� 0���� ��ŷ�ϴ� �˰���
/* 
 * |1|1|1|1|      |1|1|0|1|
 * |1|1|1|1|  ->  |1|1|0|1| 
 * |1|1|0|1|      |0|0|0|0|
 * |1|1|1|1|      |1|1|0|1|
 * 
 * 1. 0�� ã�´�.
 * 2. 0���� ���õ� ������ 0���� ǥ�õ� �κ��� 0���� ǥ���Ѵ�.
 * 3. ������ ǥ���ص� ���� �����ϰ� ��� ���� 0���� �����Ѵ�.
 * 4. ������ ���� �ִ� ���� ���� 0���� �����Ѵ�.
 * 5. ������ ���� �ִ� ���� 0���� �����Ѵ�.
 * 
 * -> ������ ��������� ������� �ʴ´�.
 * 
 * */

// Change_Matrix_Zero_to_One Ŭ����
public class Change_Matrix_Zero_to_One {

	
	// setZeroToAllZero �޼���
	private static void setZeroToAllZero(int[][] matrix) {
		// 0 �� �� �ִ� ��ġ�� �����ϴ� ����, ��� ��
		int fc = -1;
		int fr = -1;
		
		// �� ���� �ݺ�
		for(int row = 0; row < matrix.length; row++) {
			//�� ���� �ݺ�
			for(int col = 0; col < matrix[row].length; col++) {
				
				// ��Ʈ�������� 0�� ã���� ��
				if(matrix[row][col] == 0) {
				
					// ó���� ã�� 0�� ��
					if(fc == -1) {
					
						fc = col;
						fr = row;
				}
					
					//�ش� ���� ���� 0���� ǥ���Ѵ�.
					matrix[fr][col] = 0;
					matrix[row][fc] = 0;
				
				}
			}
			
		}
		// 0�� �ϳ��� �� ã���� ��.
		if(fc == -1) {
			return;
		}
		
		// ���� ���鼭 0���� �����Ѵ�.
		for(int col = 0; col < matrix[0].length; col++) {
			
			// ������ ����ִ� ���� ���� 0���� �����Ѵ�.
			if(matrix[fr][col] == 0 && col != fc) {
				setColsToZero(col, matrix);
			}
			
		}
		
		// ���� ���鼭 0���� �����Ѵ�.
		for(int row = 0; row < matrix.length; row++) {
			if(matrix[row][fc] == 0) {
				setRowsToZero(row, matrix);
			}
		}
		
		// ������ �ִ� ���� 0���� �����Ѵ�.
		setColsToZero(fc,matrix);
		
	}// setZeroToAllZero �޼��� ����
	
	
	// setColsToZero �޼���
	private static void setColsToZero(int col, int[][] matrix) {
		
		for(int row = 0; row < matrix.length; row++) {
			matrix[row][col] = 0;
		}
		
	}// setColsToZero �޼��� ����
	
	
	// setRowsToZero �޼���
	private static void setRowsToZero(int row, int[][] matrix) {
	
		for(int col = 0; col<matrix[row].length; col++) {
			matrix[row][col] = 0;
		}
		
		
	}// setRowsToZero �޼��� ����
	
	

	// printImage �޼���: �̹��� ȸ�� ���
	private static void printImage(int[][] image) {
		
		//�� * ��
		for(int i=0; i<image.length; i++) {
			
			for(int j=0; j<image[i].length; j++) {
				System.out.print(image[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}// printImage �޼��� ����
	
	
	// main �޼���
	public static void main(String[] args) {
		
		int[][] matrix = {
				{1, 1, 1, 1},
				{1, 0, 1, 1},
				{1, 1, 1, 0},
				{1, 0, 1, 1}
		};
		
		printImage(matrix);
		setZeroToAllZero(matrix);
		printImage(matrix);
		
	}// main �޼��� ����
	
	
	
}// Change_Matrix_Zero_to_One Ŭ����
