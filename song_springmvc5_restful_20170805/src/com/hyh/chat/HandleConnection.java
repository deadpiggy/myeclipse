package com.hyh.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class HandleConnection implements Runnable {

	private Socket socket;
	private List<Socket> sockets;

	public HandleConnection(Socket socket, List<Socket> sockets) {
		this.socket = socket;
		this.sockets = sockets;
	}

	@Override
	public void run() {
		PrintWriter write;
		BufferedReader read;
		try {
			read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 自动清空缓存
			write = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				String msg = read.readLine();
				if (msg.equals("88")) {
					this.socket.close();
				}
				System.out.println("recevie message : " + msg);
				// 把数据发送给所有连服务器的客户端
				sendClient(msg);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendClient(String msg) {
		PrintWriter write;
		for (Socket s : sockets) {
			try {
				write = new PrintWriter(s.getOutputStream(), true);
				write.println(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
