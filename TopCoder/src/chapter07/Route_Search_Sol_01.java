package chapter07;

// p. 210
// ����: ��� Ž��
// �ַ��: ��͸� ����� ���̿켱 Ž��
public class Route_Search_Sol_01 {
	final static int h=5;
	final static int w=4;
	
	static int dfs(int nowh, int noww) {
		if(nowh>h || noww>w) {
			return 0;
		}
		
		if(nowh==h && noww==w) {
			return 1;
		}
		
		return dfs(nowh+1, noww)+dfs(nowh, noww+1);
	}
	
	public static void main(String[] args) {
		System.out.println(dfs(0,0));
	}
}
