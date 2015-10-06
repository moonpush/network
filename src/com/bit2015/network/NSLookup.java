package com.bit2015.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		
		
		try {
			Scanner sc = new Scanner(System.in);  
			while( true ){
			System.out.print( ">" ); // 커서모양
			String host = sc.nextLine();
			if("exit".equals(host)==true){ //exit 입력시 종료
				break;
			}
			InetAddress[] inetAddresses =
					 InetAddress.getAllByName( host );
			for( int i = 0; i < inetAddresses.length; i++) {
				System.out.println(
						inetAddresses[ i ].getHostName() + 
						" : " + 
						inetAddresses[ i ].getHostAddress());
				}
			}
			
			sc.close();
		} catch (UnknownHostException e) {
			System.out.println( "IP를 가져올 수 없습니다.");
			//e.printStackTrace();
		}

	}

}
