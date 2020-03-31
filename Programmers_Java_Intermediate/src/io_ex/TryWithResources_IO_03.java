package io_ex;

import java.io.DataInputStream;
import java.io.FileInputStream;

//data.dat�κ��� ���� �о�鿩 ȭ�鿡 ����ϴ� Ŭ����
//���� �� ���� �츮 ������ �ؼ��� �ȵ����� InputStream�� ����ϸ� ���� �� �ִ�.
public class TryWithResources_IO_03 {

	public static void main(String[] args) {
		
		try (
				//������ �б�                                                             //���Ϸκ��� �б�
				DataInputStream in = new DataInputStream(new FileInputStream("data.txt"));) {

			// ����� ������ �о�� �ȴ�.
			int i = in.readInt();
			boolean b = in.readBoolean();
			double d = in.readDouble();

			System.out.println(i);
			System.out.println(b);
			System.out.println(d);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
