
package GameControl;

import GameControl.parser.*;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ninux
 */
public class Control implements Communication {
	
	private Parser parser;
	
	private static int LOCAL = 1;
	private static int REMOTE = 2;
	
	private int opponent = LOCAL;
	
	public Control() throws IOException{
		parser = new Parser();
	}

	@Override
	public int setDisk(int row) {
		try {
			return parser.sendMove(row);
		} catch (Exception ex) {
			
		}
		return -1;
	}

	@Override
	public InetAddress findPlayers() {
		try {
			InetAddress temp = parser.searchPlayer();
			while(temp == null){
				temp = parser.searchPlayer();
			}
			return temp;
		} catch (Exception ex) {
			
		}
		return null;
	}

	@Override
	public int startGame(InetAddress player) {
		try {
			return parser.connectToPlayer(player);
		} catch (Exception ex) {
			
		}
		return -1;
	}

	@Override
	public boolean waitForNetworkPlayer() {
		try {
			return parser.waitForPlayer();
		} catch (Exception ex) {
			
		}
		return false;
	}

	@Override
	public void setMode(int mode) {
		if(mode >= 1 && mode <= 2){
			opponent = mode;
		}
		else {
			opponent = LOCAL;
		}
	}
	
}
