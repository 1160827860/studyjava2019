package com.darksouls.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * �ַ���һ��Ҫˢ�²���д��
 * @author ������
 *
 */
public class FileWriteStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		try (FileWriter w = new FileWriter(file);){
			w.write("�ַ�д��\r\n�����ǻ���");
			w.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
