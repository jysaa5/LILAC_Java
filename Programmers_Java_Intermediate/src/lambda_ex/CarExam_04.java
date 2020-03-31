package lambda_ex;

import java.util.ArrayList;
import java.util.List;

public class CarExam_04 {
	  public static void main(String[] args){
	        //Car��ü�� ���� cars�� �ֽ��ϴ�.
	        List<Car> cars = new ArrayList<>();
	        cars.add( new Car("������",2,800,3) );
	        cars.add( new Car("������",12,1500,8) );
	        cars.add( new Car("�߰���",5,2200,0) );
	        cars.add( new Car("�����",5,3500,1) );
	        
	        CarExam_04 carExam = new CarExam_04();
	        carExam.printCar(cars, 
	            //�������̽� CheckCar�� test�޼ҵ忡 �����ϴ� ���ٸ� ����ϴ�.
	            (Car car) -> { return car.capacity >= 4 && car.price < 2500; }
	        );
	    }
	    
	    public void printCar(List<Car> cars, CheckCar tester){
	        for(Car car : cars){
	            if (tester.test(car)) {
	                System.out.println(car);
	            }
	        }
	    }
	    
	    interface CheckCar{
	        boolean test(Car car);
	    }  
}
