package thread_ex;

public class MusicBoxExam_s {
	
	//�� ���� �޼��尡 �� ����ǰ� ���� �� ���� �޼��尡 �����.
	public static void main(String[] args) {
		MusicBox_s box = new MusicBox_s();
		
		MusicPlayer_s kang = new MusicPlayer_s(1, box);
		MusicPlayer_s kim = new MusicPlayer_s(2, box);
		MusicPlayer_s lee = new MusicPlayer_s(3, box);
		
		kang.start();
		kim.start();
		lee.start();
	}

}
