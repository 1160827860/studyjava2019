package com.darksouls.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * ���̴��ڿ���̨���
 * @author ������
 *
 */
public class BufferedStreamDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * ���ֽ���ת��Ϊ�ַ�����Ҫ����ΪBufferedReader������ʱ��ֻ�����ַ���
		 * ����System.in�������ֽ���
		 */
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String str = br.readLine();
			
			
			while(str != null) {
				System.out.println(str);
				str = br.readLine();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
