package com.violetCheese.basicJava;

//���ٽ�
public class Ex_59_Lambda_02 {

	public static void main(String[] args) {
		
		//���ٽ�
		new Thread(()-> {
				for (int i = 0; i < 10; i++) {
					System.out.println("hello");
				}
		}).start();

	}

}
