/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udptime;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studenti
 */
public class gestoreClient {
    int port = 2000;
		//indirizzo del server
		InetAddress serverAddress;
		//socket UDP
		DatagramSocket dSocket;
		//Datagramma UDP con la richiesta da inviare al server
		DatagramPacket outPacket;
		//Datagramma UDP di risposta ricevuto dal server
		DatagramPacket inPacket;
		
		//buffer per i dati da inviare
		byte[] buffer = new byte[256];
		//messaggio di richiesta
		String message="RICHIESTA DATA E ORA";
		//messaggio di risposta
		String response;

                
                public void scrivi() throws IOException {
        try {
            serverAddress = InetAddress.getLocalHost();
            
            System.out.println("Indirizzo del server trovato!");
            dSocket = new DatagramSocket();
            
            //si prepara il datagramma con i dati da inviare
            outPacket = new DatagramPacket(message.getBytes(), message.length(), serverAddress, port);
            
            //si inviano i dati
            dSocket.send(outPacket);
        } catch (SocketException ex) {
            Logger.getLogger(gestoreClient.class.getName()).log(Level.SEVERE, null, ex);
        }
                }
                public String leggi() {
        try {
            inPacket = new DatagramPacket(buffer, buffer.length);
            
            //si accetta il datagramma di risposta
            dSocket.receive(inPacket);
            
            //si estrae il messaggio
            response = new String(inPacket.getData(), 0, inPacket.getLength());
            
        } catch (IOException ex) {
            Logger.getLogger(gestoreClient.class.getName()).log(Level.SEVERE, null, ex);
        }
         return response;
                }
                public void chiudi() {
                    dSocket.close();
                }
                        
}

