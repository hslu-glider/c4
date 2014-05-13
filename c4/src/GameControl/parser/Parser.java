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
import java.net.InetAddress;

/**
 *
 * @author ninux
 */
public class Parser implements Iparser {
    private Client client;
    private Server server;
    private UDP udp;
    
    public Parser () throws IOException{

    }
    
    @Override
    public InetAddress searchPlayer(){
        InetAddress addr = null;
        return addr;
    }

    @Override
    public void waitForPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean connectToPlayer(InetAddress adr) {
        
        return true;
    }

    @Override
    public int sendMove(int row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

// new String()
// .getBytes()