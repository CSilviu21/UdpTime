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
import java.net.UnknownHostException;

public class UDPClient {

	public static void main(String[] args) throws IOException {
		
		gestoreClient client = new gestoreClient();
                client.scrivi();
             String str = client.leggi();
             System.out.println(str);
                client.chiudi();
                
                
	}

}
