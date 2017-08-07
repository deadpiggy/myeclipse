package com.hyh.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Send implements Runnable {

	private Socket socket;

	public Send(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer;
		try {
			writer = new PrintWriter(socket.getOutputStream(), true);
			String msg;
			while ((msg = input.readLine()) != null) {
//			String msg = input.readLine();
//			while (msg.equals(null)) {
				writer.println(msg);
				if (msg.equals("88")) {
					System.exit(0);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
