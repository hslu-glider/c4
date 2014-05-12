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
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ninux
 */
public class Server {
	
	/**
	 * Constants for the client
	 */
	final static int PORT_DEFAULT = 6699;
	
	int port = PORT_DEFAULT;
	ServerSocket socket;
	
	/**
	 * Create a TCP-Server.
	 * @param port
	 * @throws IOException 
	 */
	public Server(int port) throws IOException{
		
		try {
			ServerSocket socket = new ServerSocket(port);
		} catch (IOException ex) {
			
		} finally {
			socket.close();
		}
	}
	
	public boolean changePort(int port) throws IOException {
		try{
			socket.close();
			ServerSocket socket = new ServerSocket(port);
			return true;
		}catch (IOException ex){
			throw new IOException(ex.getMessage());
		} finally {
			return false;
		}
	}
	
	public boolean closeConnection() throws IOException{
		try{
			socket.close();
			return true;
		} catch (IOException ex){
			throw new IOException(ex.getMessage());
		} finally {
			return false;
		}
	}
	
}
