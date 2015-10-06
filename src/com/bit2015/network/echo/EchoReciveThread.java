package com.bit2015.network.echo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class EchoReciveThread extends Thread {
	
	private Socket socket = null;
	
	
	public EchoReciveThread( Socket socket) {
		this.socket = socket;
	}

	//run 구현
	@Override
	public void run() {
		// TODO Auto-generated method stub
		InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		 System.out.println(
				 "[서버] 연결됨from : " + 
				inetSocketAddress.getHostName() +
				" : " + 
				inetSocketAddress.getPort());
		 OutputStream os = null;
		 InputStream is = null;
		 
		 BufferedReader reader = null;
		 PrintWriter printWriter = null;
		
		 try {
			 
			 
			  reader = 
			  new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			  printWriter = new PrintWriter(socket.getOutputStream());
			  
			  while (true) {
				  
				 String data = reader.readLine();
				 if(data == null){
					 break;
				 }
			     System.out.println("[서버] 데이터 수신:" + data);
								 
				 printWriter.println(data);
				 printWriter.flush();
			 }
			 //스트림 닫기
			reader.close();
			is.close();
			printWriter.close();
			 } catch (Exception e) {
			System.out.println("[서버] 오류" + e);
			// TODO: handle exception
		}
	}
	
	
	
	
	

}
