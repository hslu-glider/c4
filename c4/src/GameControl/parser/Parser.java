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

package GameControl.parser;

import GameControl.network.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 *
 * @author ninux
 */
public class Parser implements Iparser {
    private static final int CLIENT = 1;
    private static final int SERVER = 2;
    private int con;
    
    private Client client;
    private Server server;
    
    public Parser () throws IOException{

    }
    
    @Override
    public InetAddress searchPlayer() throws Exception{
        InetAddress addr = InetAddress.getByName("192.168.1.110");  //Broadcastadresse
        String data = "C4:Request";
        UDP udp = new UDP();
        DatagramPacket packet = new DatagramPacket(data.getBytes(), data.getBytes().length, addr, 6699);
        udp.send(packet);
        packet = udp.getPacket();
        if(new String(packet.getData(),0,10).compareTo("C4:Waiting") == 0){
            return packet.getAddress();
        }
        return null;
    }

    @Override
    public boolean waitForPlayer() throws Exception{
        DatagramPacket packet;
        UDP udp = new UDP();
        con = SERVER;
        server = new Server();
        packet = udp.getPacket();
        if(new String(packet.getData(),0,10).compareTo("C4:Request") == 0){
            String data = "C4:Waiting";
            packet = new DatagramPacket(data.getBytes(), data.getBytes().length, packet.getAddress(), packet.getPort());
            udp.send(packet);
            server.connectPlayer();
            if(server.getMessage().compareTo("C4:Connection:Request") == 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public int connectToPlayer(InetAddress adr) throws Exception{
        String message;
        con = CLIENT;
        client = new Client(6699, adr);
        client.sendMessage("C4:Connection:Request");
        message = client.getMessage();
        return message.charAt(8) - 48; 
    }

    @Override
    public int sendMove(int row) throws Exception{
        String message;
        if(con == CLIENT){
            client.sendMessage("C4:Move:" + row);
            message = client.getMessage();
            return message.charAt(8) - 48; 
        }
        else if(con == SERVER){
            server.sendMessage("C4:Move:" + row);
            message = server.getMessage();
            return message.charAt(8) - 48; 
        }
        return -1;
    }
}