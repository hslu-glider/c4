/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameControl.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author ninux
 */
public class UDP {
	
	DatagramSocket socket;
	
	public UDP () throws SocketException {
		socket = new DatagramSocket(6699);
	}
	
	public void send (DatagramPacket packet) throws IOException {
		socket.send(packet);
	}
	
	public DatagramPacket getPacket () throws IOException {
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
		socket.receive(packet);
		return packet;
	}
	
}
