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
import static java.lang.Integer.parseInt;
import java.net.Socket;

/**
 *
 * @author ninux
 */
public class Client {
	
	/**
	 * Constants for the client
	 */
	final static int PORT_DEFAULT = 6699;
	final static String HOST_DEFAULT = "127.0.0.1";
	
	private int port = PORT_DEFAULT;
	private String host = HOST_DEFAULT;
	private Socket client;
	
	/**
	 * Create a TCP-Client
	 * @param port
	 * @param host
	 * @throws IOException 
	 */
	public Client(int port, String host) throws IOException {
		this.port = port;
		this.host = host;
		try {
			Socket client = new Socket(host, port);
		} catch (IOException ex){
			throw new IOException(ex.getMessage());
		} finally {
			client.close();
		}
	}
	
	public void closeConnection() throws IOException {
		client.close();
	}
	
}
