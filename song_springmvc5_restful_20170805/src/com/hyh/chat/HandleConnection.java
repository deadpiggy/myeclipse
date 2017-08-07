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
		connectToClient();
	}

	private void connectToClient() {
		PrintWriter writer;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// true : 自动清空缓存区数据
			writer = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				String msg = reader.readLine();
				if (msg.equals("88")) {
					this.socket.close();
				}
				System.out.println("recevie message: " + msg);
				// 把数据发送给所有连接到服务器端的客户端
				sendClient(msg);
			}
		} catch (Exception e) {
			System.out.println("已经下线.........");
		}
	}

	public void sendClient(String msg) {
		PrintWriter writer;
		try {
			for (Socket s : sockets) {
				if( s != this.socket ) {
					writer = new PrintWriter(s.getOutputStream(), true);
					writer.println(msg);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
