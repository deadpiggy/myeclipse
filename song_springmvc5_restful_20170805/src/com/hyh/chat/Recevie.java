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
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = read.readLine();
			if (msg != null) {
				System.out.println(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
