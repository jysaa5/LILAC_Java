package com.violetCheese.intermediate;

import java.util.ArrayList;
import java.util.List;

public class Ex_66_CarExam {
	  public static void main(String[] args){
	        //Car��ü�� ���� cars�� �ֽ��ϴ�.
	        List<Ex_62_Car> cars = new ArrayList<>();
	        cars.add( new Ex_62_Car("������",2,800,3) );
	        cars.add( new Ex_62_Car("������",12,1500,8) );
	        cars.add( new Ex_62_Car("�߰���",5,2200,0) );
	        cars.add( new Ex_62_Car("�����",5,3500,1) );
	        
	        Ex_66_CarExam carExam = new Ex_66_CarExam();
	        carExam.printCar(cars, 
	            //�������̽� CheckCar�� test�޼ҵ忡 �����ϴ� ���ٸ� ����ϴ�.
	            (Ex_62_Car car) -> { return car.capacity >= 4 && car.price < 2500; }
	        );
	    }
	    
	    public void printCar(List<Ex_62_Car> cars, CheckCar tester){
	        for(Ex_62_Car car : cars){
	            if (tester.test(car)) {
	                System.out.println(car);
	            }
	        }
	    }
	    
	    interface CheckCar{
	        boolean test(Ex_62_Car car);
	    }  
}
