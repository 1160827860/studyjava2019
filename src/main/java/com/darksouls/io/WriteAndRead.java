package com.darksouls.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * ����д�뻻������ַ�
 * @author ������
 *
 */
public class WriteAndRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		try(FileWriter w = new FileWriter(file,true)) {
			for(int i = 1; i <= 9;i++ ) {
				for(int j = 1;j <= i;j++) {
					w.write(i + " * "+ j + " = "+ i*j );
				}
			w.write("\r\n");
			}
			w.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(FileReader r = new FileReader(file)){
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
