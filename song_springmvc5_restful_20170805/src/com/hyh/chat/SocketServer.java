package com.hyh.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {

	private static final int PORT = 8888;
	private ServerSocket ss;
	private List<Socket> sockets;

	/*
	 * 初始化服务器
	 */
	public SocketServer() {
		try {
			ss = new ServerSocket(PORT);
			System.out.println("----------------server successful----------------");
			sockets = new ArrayList<>();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * 启动服务器
	 */
	public void start() {
		try {
			while (true) {
				Socket socket = ss.accept();
				System.out.println("有一个客户端连接进来，端口号是: " + socket.getPort());
				// 保存Socket对象
				sockets.add(socket);
				// 启动线程
				new Thread(new HandleConnection(socket, sockets)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new SocketServer().start();
	}

}
