package com.violetCheese.intermediate;

public class Ex_52_MusicBoxExam_s {
	
	//�� ���� �޼��尡 �� ����ǰ� ���� �� ���� �޼��尡 �����.
	public static void main(String[] args) {
		Ex_50_MusicBox_s box = new Ex_50_MusicBox_s();
		
		Ex_51_MusicPlayer_s kang = new Ex_51_MusicPlayer_s(1, box);
		Ex_51_MusicPlayer_s kim = new Ex_51_MusicPlayer_s(2, box);
		Ex_51_MusicPlayer_s lee = new Ex_51_MusicPlayer_s(3, box);
		
		kang.start();
		kim.start();
		lee.start();
	}

}
