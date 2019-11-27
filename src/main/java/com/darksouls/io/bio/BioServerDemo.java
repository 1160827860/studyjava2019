package com.darksouls.io.bio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 和BioSocket是一套
 * @author 李正阳
 *
 */
public class BioServerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket server = new ServerSocket(8888);
			Socket client = server.accept();
			PrintWriter pw = new PrintWriter(client.getOutputStream());
			pw.println("HELLO WORLD!");
			pw.close();
			client.close();
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
