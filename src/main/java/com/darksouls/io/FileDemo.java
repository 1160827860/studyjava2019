package com.darksouls.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * ���ļ��Ĳ���
 * @author ������
 *
 */
public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		if(file.exists()) {
			System.out.println("����");
		}else {
			System.out.println("������");
		}
		System.out.println(file.canRead()? "��":"����");
		/**
		 * �ַ�����д�뻺������
		 */
		try (FileWriter w = new FileWriter(file);){
			w.write("�ַ�д��\r\n�����ǻ���\n�����ǵ�����");
			w.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
