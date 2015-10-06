package com.bit2015.chat;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ChatServer {
	
	private static final int PORT = 10001;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<PrintWriter> listPrintWriters = new ArrayList<PrintWriter>();
		ServerSocket serverSocket = null;
		
		try {
			//1.서버소켓 생성
			serverSocket = new ServerSocket();
			
			//2.바인딩
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostAddress = inetAddress.getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("연결기다림" + hostAddress + ":" + PORT);
			
			//3.연결요청 기다림
			while(true) {
			Socket socket = serverSocket.accept();
			
			Thread thread = new ChatServerProcessThread(socket, listPrintWriters);
			thread.start();			
			}
		} catch (IOException e) {
			log("error : " + e);
		} finally {
			if(serverSocket != null && serverSocket.isClosed() == false){
				try{
					serverSocket.close();
				} catch(IOException e) {
					log("error : " + e);
				}
			}
		}

	}
	
	public static void log(String log) {
		System.out.println("[chat-server]" + log);
	}

}
