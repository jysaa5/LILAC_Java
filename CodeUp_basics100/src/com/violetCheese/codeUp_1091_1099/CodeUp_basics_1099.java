package com.violetCheese.codeUp_1091_1099;

import java.util.Scanner;

public class CodeUp_basics_1099 {

	// ���� �޼���
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//�� �྿ �Է� ���� ��ü ����
		int[] road = new int[10];
		//������ 2�� �迭 ����
		int[][] antHome = new int[10][10];
		
		//�� �ε��� ���� ����
		int flag = 1;
		
		// 2�� ������ ���� �Ǵ� ���� ���� ��Ű�� ����
		int end = 0;

		//�Է� ��� ����
		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < 10; j++) {

				road[j] = sc.nextInt();
				antHome[i][j] = road[j];
			}
			sc.nextLine();
		}

		//������ ��� ǥ��
		for (int k = 1; k < 10; k++) {
			
			//��� ǥ�� ���� �б���
			if (end != 1) {
				
				//�� �ݺ���: ù��° ���� 1���� ������.
				for (int l = flag; l < 10; l++) 
				{
					//0�̸� 9�� ����
					if (antHome[k][l] == 0) {
						
						antHome[k][l] = 9;
					
				    //2�̸� 9�� ����
					} else if (antHome[k][l] == 2) {
						antHome[k][l] = 9;
						end = 1; //���̸� �������� ���� ���� �ٲٱ�
						break; //�� for�ݺ����� ������.
						
					} else {
						flag = l - 1; //1�� ������ �׶��� ���� index���� �� �� index�� ������. �ֳ��ϸ� ���� ��ΰ� �ٷ� ������ �־����Ƿ�.
						break; //for �ݺ��� ������. (��� ���� �ݺ����� �ʰ� �� ���� ������ �Ѿ�� ���ؼ�)
					}
				}
			} else {
				break; //end == 1�̸� for�� �ݺ��� ������
			}
		}
		
		//���� ��� ���
		for (int m = 0; m < 10; m++) {

			for (int n = 0; n < 10; n++) {
				System.out.print(antHome[m][n] + " ");
			}
			System.out.println("");
		}

		sc.close();
	}// ���� �޼���

}// CodeUp_basics_1099 Ŭ���� ��
