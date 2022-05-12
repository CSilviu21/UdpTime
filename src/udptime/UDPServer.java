/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udptime;

/**
 *
 * @author Monica Ciuchetti
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class UDPServer{

	public static void main(String[] args) throws IOException {
		
		gestoreServer server= new gestoreServer(2000);
                while(true){
                    server.leggi();
                    server.scrivi();
                }
		
	}

}