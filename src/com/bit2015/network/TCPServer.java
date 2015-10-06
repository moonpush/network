package com.bit2015.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	
	private static final int PORT = 10001;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		
		try{
			 //서버소켓 생성!!
			 serverSocket = new ServerSocket();
			 
			 //바인딩
			 InetAddress inetAddress = InetAddress.getLocalHost(); //로컬 호스트를 얻어내는 구문
			 String hostAddress = inetAddress.getHostAddress();
			 serverSocket.bind( new InetSocketAddress( hostAddress , PORT));//소켓에 ip와 포트를 붙혀준다는 의미
			 System.out.println("[서버] 바인딩" + hostAddress + ":" + PORT);
			 
			 

			 //연결요청 개시
			 System.out.println( "[서버] 연결 기다림");
			 Socket socket = serverSocket.accept();// 서버 블락킹
			 
			 
			 
			 //데이터 읽고쓰기
			 InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			 System.out.println(
					 "[서버] 연결됨from : " + 
					inetSocketAddress.getHostName() +
					" : " + 
					inetSocketAddress.getPort());
			 //데이터 쓰기
			// OutputStream os = socket.getOutputStream();
			// String data = "hello World";
			// os.write(data.getBytes("UTF-8"));
			// os.flush();
			 //데이터 읽기
			 OutputStream os = null;
			 InputStream is = null;
			 try {
				  os = socket.getOutputStream();
				  is = socket.getInputStream();
				 while (true) {
					 byte[] buffer = new byte[128];
					 int readByteCount = is.read(buffer);
					 if(readByteCount < 0){ //클라이언트가 정상적으로 종료
						
						 System.out.println("[서버] 클라이언트로 부터 연결 끊김");
						 break;
					 }
					 String data = new String(buffer, 0, readByteCount, "UTF-8");
					 System.out.println("[서버] 데이터 수신:" + data);
					 
					 os.write(data.getBytes("UTF-8"));
					 os.flush();
				 }
				 //스트림 닫기
				 is.close();
				 } catch (Exception e) {
				System.out.println("[서버] 오류" + e);
				// TODO: handle exception
			}
			 
			
			 //스트림 닫기
			 is.close();
			 os.close();
			 socket.close();
			 
			 //데이터 소켓 닫기
			
			 
			 
			 
	
		} catch(IOException e) {
			e.printStackTrace();
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
