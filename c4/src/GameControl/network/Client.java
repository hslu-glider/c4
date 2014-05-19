/*
* C4 - Connect Four
* Copyright (C) 2014 by Ervin Mazlagic, Jan Vonmoos, Alain Studhalter,
* Michael Müller, Lukas Luthiger
*
* This program is free software; you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation; either version 2 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License along
* with this program; if not, write to the Free Software Foundation, Inc.,
* 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*/

package GameControl.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author ninux
 */
public class Client implements Runnable {
	
	/**
	 * Constants for the client
	 */
	final static int PORT_DEFAULT = 6699;
	final static String HOST_DEFAULT = "127.0.0.1";
	
	private int port = PORT_DEFAULT;
	private String host = HOST_DEFAULT;
	
	private boolean connected = false;
	
	private String received;
	
	private Socket client;
	
	private PrintWriter outStream;
	private BufferedReader inStream;
	
	/**
	 * Create TCP client at default port to localhost.
	 * @throws IOException 
	 */
	public Client () throws IOException {
		this.port = port;
		this.host = host;
		
		client = new Socket(host, port);
	}
	
	/**
	 * Create a TCP client
	 * @param port
	 * @param host
	 * @throws IOException 
	 */
	public Client(int port, InetAddress host) throws IOException {
		this.port = port;
		//this.host = host;
		
		client = new Socket(host, port);
		outStream = new PrintWriter(client.getOutputStream());
		inStream = new BufferedReader(
			new InputStreamReader(client.getInputStream()));
		connected = true;
		Thread t = new Thread();
		//t.start();
	} 
	
	public void sendMessage(String message){
		outStream.println(message);
                outStream.flush();
	}
	
	public void closeConnection() throws IOException {
		client.close();
	}
	
	public String getMessage() throws IOException{
            String message;
            while((message = inStream.readLine()) == null){}
            return message;//return received;
	}
        
	@Override
	public void run() {
		while(connected) {
			try {
                            String temp;
                            if((temp = inStream.readLine()) != null){
                                received = temp;
                            }	
			} catch (Exception ex){
				
			} 
		}
	}
	
	
}
