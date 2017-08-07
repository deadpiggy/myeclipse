package com.hyh.chat;

import java.net.Socket;

public class SocketClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8888);
			System.out.println("成功连接服务器..........");
			System.out.println( socket.getPort() + ", 欢迎进入聊天室....." );
			// 启动线程
			new Thread(new Send(socket)).start();
			new Thread(new Recevie(socket)).start();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
