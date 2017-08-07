package com.hyh.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Send implements Runnable{

	private Socket socket;
	
	public Send( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		try {
			String msg = in.readLine();
			PrintWriter writer = new PrintWriter( socket.getOutputStream() );
			while( msg != null ) {
				writer.println( msg );
				if( msg.equals( "88" ) ) {
					System.exit(0);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
