package io_ex;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

//try-with-resources ���� ����: �ڵ� close() 
public class TryWithResources_IO_01 {

	public static void main(String[] args) {

		try (
		//IO ��ü ����
		//DataOutputStream: �پ��� Ÿ���� ������ �� �ִ� ��ü
		//OutputStream�� �޾Ƶ��δ�.
		DataOutputStream out = new DataOutputStream(new FileOutputStream("data.txt"));
		) {
			
			//4byte ���� ����
			out.writeInt(100);
			//1byte �Ҹ� ����
			out.writeBoolean(true);
			//8byte ���� ����
			out.writeDouble(50.5);

		} catch (Exception e) {

		}

	}

}