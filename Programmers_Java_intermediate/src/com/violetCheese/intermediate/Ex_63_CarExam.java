package com.violetCheese.intermediate;

import java.util.*;

public class Ex_63_CarExam {
	public static void main(String[] args) {
		// Car��ü�� ���� cars�� �ֽ��ϴ�.
		List<Ex_62_Car> cars = new ArrayList<>();
		cars.add(new Ex_62_Car("������", 2, 800, 3));
		cars.add(new Ex_62_Car("������", 12, 1500, 8));
		cars.add(new Ex_62_Car("�߰���", 5, 2200, 0));
		cars.add(new Ex_62_Car("�����", 5, 3500, 1));

		printCarCheaperThan(cars, 2000);
	}

	public static void printCarCheaperThan(List<Ex_62_Car> cars, int price) {
		for (Ex_62_Car car : cars) {
			if (car.price < price) {
				System.out.println(car);
			}
		}
	}
}
