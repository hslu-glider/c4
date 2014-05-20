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

package GameControl;

import java.net.InetAddress;
import java.util.ArrayList;

/**
 *
 * @author ninux
 */
public interface Communication {
	
	/**
	 * Set a disk at a specified row.
	 * @param row
	 * @return 
	 */
	public int setDisk(int row);
	
	/**
	 * Looks after online players and returns an ArrayList fo them. 
	 * @return 
	 */
	public InetAddress findPlayers();
	
	/**
	 * Wait for TCP connection of a remote player.
	 * @return 
	 */
	public boolean waitForNetworkPlayer();
	
	/**
	 * Opens an TCP connection to the given player.
	 * @param player
	 * @return 
	 */
	public int startGame(InetAddress player);
	
	/**
	 * Set the mode of the Game (local or remote).
	 * @param mode 
	 */
	public void setMode(int mode);
	
	
}
