package matrix.alg.rotate.image;

// ����: 2���� �迭�� ���� �˰���(Matrix)
// ����, ���� = N pixel, N pixel -> 2���� �迭�� ����Ǿ� �ִ�.
// N * N �ȼ� �̹����� 2���� �迭�� ����Ǿ� �ִ�.
/*     
 *  _ _ _ _ 
 * |_|_|_|_|
 * |_|_|_|_|
 * |_|_|_|_|
 * |_|_|_|_|
 * 
 * */
// Rotate 90 degree = �̹����� 90�� ȸ���Ѵ�.
// In place = ������ �ڷ� ������ ������� �ʴ´�. 

// ������ �����ϰ� ����� ���ؼ� Layer ������� �Ѵ�.
// �� �ٱ��� �� �پ� ���� �������� Layer�� �����Ѵ�.

//
/* 1 = �Ķ���, 2 = �ʷϻ�, 3 = �����, 4 = ������
 *  _ _ _ _           _ _ _ _ 
 * |1|1|1|2|         |4|4|4|1|
 * |4|_|_|2|   < -   |3|_|_|1| 
 * |4|_|_|2|         |3|_|_|1|
 * |4|3|3|3|         |3|2|2|2|
 * 
 * 4���� �迭 �����͸� ���� ���� ���ָ� �ϳ��� ���̾ ȸ���� �ȴ�.
 * 1. ������ �� �� �����Ѵ�.
 * 2. ������ ������ �����迭�� (�� �տ� �迭)ù��° �迭�� �ִ´�.
 * 3. �� �ڸ��� �Ķ��� ù��° �迭�� �ű��.
 * 4. �Ķ��� ù��° �迭�� �ִ� ���� �ʷϻ� ���� ù��° �迭�� �ִ´�.
 * 5. �ʷϻ��� ù��° �迭�� �ִ� ���� ����� ���� ù��° �迭�� �ִ´�.
 * 6. �ӽ� ������ �־��� ���� �迭�� ��� �ִ� ����� ���� ù��° �迭�� �ִ� ���� �ִ´�.
 * 7. �����迭 2��° �浵 2~6�� �ݺ��Ѵ�.
 * 8. ���� �迭 3��° �浵 2~6�� �ݺ��Ѵ�.
 * 
 * |00|01|02|03|04|
 * |10|11|12|13|14|
 * |20|21|22|23|24|
 * |30|31|32|33|34|
 * |40|41|42|43|44|
 * 
 * tmp = 00
 * 00 = 04
 * 04 = 44
 * 44 = 40
 * 40 = tmp
 * -> �̷������� n-1 �� �����ϸ� �ȴ�.
 * 
 * tmp = 11
 * 11 = 13
 * 13 = 33
 * 33 = 31
 * 31 = tmp
 * 
 * ù��° layer: s(����) = 0, e(��) = 4
 * �ι�° layer: s(����) = 1, e(��) = 3
 * ���̾ �������� ���ö�����, s(������)++ = �������� �����Ѵ�. e(����)-- = ������ �����Ѵ�.
 * 
 * layer�� ������, ���������� �������� ������ ������. 
 * s = 1, e = 3
 * Loop: 
 * i = s to i = e
 * i = 1, 2, 3 (11, 12, 13 / 11, 21, 31 / 13, 23, 33 �� ��)
 * j = e to j = s (31, 32, 33 �� ��)
 * j = 3, 2, 1 
 * 
 * �� ��° layer �� ���� �ִ� ��: Top[s][i] -> (11, 12, 13)
 * �� ��° layer �� �����ʿ� �ִ� ��: Right[i][e] -> (13, 23, 33)
 * �� ��° layer �� �ؿ� �ִ� ��: Bottom[e][j] -> (33, 32, 31)
 * �� ��° layer �� ���ʿ� �ִ� ��: Left[j][s] -> (31, 21, 11)
 * 
 * tmp = Top
 * Top = Right
 * Right = Bottom
 * Bottom = Left
 * Left = tmp
 * 
 * tmp = [s][i]
 * [s][i] = [i][e]
 * [i][e] = [e][j]
 * [e][j] = [j][s]
 * [j][s] = tmp
 * 
 * ù��°, �ι�° layer�� ��Ģ�� �����غ���,
 * 
 * Loop: s = 0, e = 4
 * s++, e--
 * Loop: i = s -> e
 *       j = e -> s
 * 
 * tmp = [s][i]
 * [s][i] = [i][e]
 * [i][e] = [e][j]
 * [e][j] = [j][s]
 * [j][s] = tmp
 * 
 * 
 * -> swapping�Ѵ�.
 * 
 * */

// Rotate_Matrix_Image Ŭ����
public class Rotate_Matrix_Image {
	
	
	// roateImage �޼���: �̹��� ȸ���ϴ� �޼��� 
	private static int[][] rotateImage(int[][] image){
		
		int tmp;
		
		for(int s = 0, e = image.length-1; s<e; s++, e--) {
			for(int i=s, j=e; i<e; i++, j--) {
				tmp = image[s][i];
				image[s][i] = image[i][e];
				image[i][e] = image[e][j];
				image[e][j] = image[j][s];
				image[j][s] = tmp;
			}
		}
		
		return image;
		
	}// rotateImage �޼��� ����
	
	
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
		
		int[][] image = {
				{1, 0, 0, 0, 1},
				{0, 1, 0, 1, 0},
				{0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0}
		};
		
		printImage(image);	
		rotateImage(image);
		printImage(image);	
		rotateImage(image);
		printImage(image);	
		rotateImage(image);
		printImage(image);	
		rotateImage(image);
		printImage(image);	
		
	}// main �޼��� ����
	
}// Rotate_Matrix_Image Ŭ����
