package com.bit2015.network.time;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class TimeClient {
	private static final String SERVER_IP= "192.168.1.89";
	private static final int SERVER_PORT = 10001;
	private static final int BUFFER_SIZE = 1024;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in, "euc-kr");
		DatagramSocket datagramSocket = null;
		
		try {
			datagramSocket = new DatagramSocket();
		
			while(true){
		         
		         System.out.println(">>");
		         String message = scanner.nextLine();
		         if(message.equals("quit")){
		            break;
		         }
		         byte[] data = message.getBytes();  //메세지를 보내려면 일단 바이트로 바꿔주고
		      
		         DatagramPacket sendPacket = 
		            new DatagramPacket(data, data.length,new InetSocketAddress(SERVER_IP,SERVER_PORT));//실제 데이터를 넣고 받는사람 주소작성
		         
		            datagramSocket.send(sendPacket);
		            
		            DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE],BUFFER_SIZE);
		            datagramSocket.receive(receivePacket);
		            
		            message =
		                    new String(receivePacket.getData(), 0, receivePacket.getLength(),"UTF-8");
		                    System.out.println("UDP-echo-client: "+message);
			}
		} catch (IOException e) {
			log("error " + e);
		}finally{
			datagramSocket.close();
			scanner.close();
		}
		//System.out.println( data + ":" + data.length);

	}
	public static void log(String log){
	      System.out.println("[UDP-echo-Client] "+log);
	   }

}

