package com.bit2015.network.echo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	private static final int PORT = 10001;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		
		try{
			serverSocket = new ServerSocket();
			 
			 //바인딩
			 InetAddress inetAddress = InetAddress.getLocalHost(); //로컬 호스트를 얻어내는 구문
			 String hostAddress = inetAddress.getHostAddress();
			 serverSocket.bind( new InetSocketAddress( hostAddress , PORT));//소켓에 ip와 포트를 붙혀준다는 의미
			 System.out.println("[서버] 바인딩" + hostAddress + ":" + PORT);
			 
			 
	
			 //연결요청 개시
			 while(true){
			 System.out.println( "[서버] 연결 기다림");
			 Socket socket = serverSocket.accept();// 서버 블락킹
			 
			 Thread thread = new EchoReciveThread(socket);
			 thread.start();
			 }
			 
		} catch (IOException e) {
			System.out.println("[서버] 에러:" + e);
		} finally {
			if(serverSocket != null && serverSocket.isClosed() == false){
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
