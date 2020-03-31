package com.violetCheese.codeUp_1091_1099;

import java.util.Scanner;

public class CodeUp_basics_1098 {

	// ���� �޼���
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//���� ����
		int h = sc.nextInt();
		//���� ����
		int w = sc.nextInt();
		sc.nextLine();
		//������ ����
		int n = sc.nextInt();
		sc.nextLine();

		//����
		int l = 0;
		//����
		int d = 0;
		//��ǥ
		int x = 0;
		int y = 0;

		//������ ����
		int[][] grid = new int[h][w];

		//������ �ʱ�ȭ
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				grid[i][j] = 0;
			}
		}

		//����, ����, ��ǥ �Է� �ޱ�
		for (int k = 0; k < n; k++) {
			l = sc.nextInt();
			d = sc.nextInt();
			
			//�������� ��� ���� �ݴ��̴�. �׸��� (1,1) ���� ������. �׷��Ƿ� ��� ���� �ݴ�� ����� �ϸ�, ���� ��ǥ���� -1�� �ؾ� 2���迭�� index�� �´�.
			y = sc.nextInt() - 1; 
			x = sc.nextInt() - 1;

			//������ ���� �϶�
			if (d == 0) {
				for (int m = 0; m < l; m++) {
					grid[y][x + m] = 1;
				}

			//������ �����϶�
			} else if (d == 1) {

				for (int o = 0; o < l; o++) {
					grid[y + o][x] = 1;
				}

			}
			//���� ���� ���
			sc.nextLine();
		}
		
         //������ ���
		for (int p = 0; p < h; p++) {
			for (int q = 0; q < w; q++) {
				System.out.print(grid[p][q] + " ");
			}
			System.out.println();
		}

		sc.close();
	}// ���� �޼���

}// CodeUp_basics_1098 Ŭ���� ��
