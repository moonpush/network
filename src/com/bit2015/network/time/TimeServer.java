package com.bit2015.network.time;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

public class TimeServer {
	
	private static final int PORT = 10001;
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {

		DatagramSocket datagramSocket = null;
		try {
			
			datagramSocket = new DatagramSocket(PORT);
			log("packet 수신대기");
			while(true){
				DatagramPacket receivePacket =
						new DatagramPacket (new byte[BUFFER_SIZE], BUFFER_SIZE);
				datagramSocket.receive(receivePacket);
				
				
				String message =
				new String(receivePacket.getData(),0,receivePacket.getLength(),"UTF-8");
				log("Packet 수신 : "+message);
				
				
			}
			
			
		} catch (Exception e) {
		}
		
		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss a" );

		String data = format.format( new Date() );
				//System.out.println(data);
				
	}

}
