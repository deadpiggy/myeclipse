package com.hyh.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Recevie implements Runnable {

	private Socket socket;

	public Recevie(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader reader;
		try {
			 reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = null;
			while(true) {
				msg = reader.readLine();
				if (msg != null) {
					System.out.println(msg);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
