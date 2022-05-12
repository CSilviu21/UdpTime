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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studenti
 */
public class gestoreServer {
    
    DatagramSocket dSocket;
		//datagramma UDP ricevuto dal client
		DatagramPacket inPacket;
		//datagramma UDP di risposta da inviare
		DatagramPacket outPacket;
		//Buffer per il contenuto del segmento da ricevere
		byte[] buffer= new byte[256];
		//Testo dei messaggi in I/O
		String messageIn, messageOut;
		//Data e ora correnti
		Date d;
                InetAddress clientAddress;
                int clientPort;
    
    public gestoreServer(int porta){
        try {
            dSocket = new DatagramSocket(porta);
        } catch (SocketException ex) {
            Logger.getLogger(gestoreServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String leggi(){
        try {
            inPacket = new DatagramPacket(buffer, buffer.length);
            
            //si ricevono i byte dal client e si blocca finchè arrivano i pacchetti
            dSocket.receive(inPacket);
            
            //si recupera l'indirizzo IP e la porta UDP del client
            InetAddress clientAddress = inPacket.getAddress();
            int clientPort = inPacket.getPort();
            
            //si stampa a video il messaggio ricevuto dal client
            messageIn = new String(inPacket.getData(), 0, inPacket.getLength());
        } catch (IOException ex) {
            Logger.getLogger(gestoreServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return messageIn;
    }
    
    public void scrivi() throws IOException{
        d = new Date();
				//si crea il messaggio del server in uscita associandolo alla connessione aperta con il client
				messageOut = d.toString();
				
				//si crea un datagramma UDP in cui trasportare il messaggio di lunghezza length
				outPacket = new DatagramPacket(messageOut.getBytes(), messageOut.length(), clientAddress , clientPort);
				//si invia il messaggio al client
				dSocket.send(outPacket);
    }
    
    
    
    
    
}
